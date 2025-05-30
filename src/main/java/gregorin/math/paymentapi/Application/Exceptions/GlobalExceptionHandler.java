package gregorin.math.paymentapi.Application.Exceptions;

import gregorin.math.paymentapi.Application.Responses.ApiResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus; // Importe o HttpStatus
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.converter.HttpMessageNotReadableException; // Importe esta exceção
import com.fasterxml.jackson.databind.exc.MismatchedInputException; // Para detalhar ainda mais
import java.time.format.DateTimeParseException; // Para pegar erros específicos de data/hora

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handler para erros de validação (@Valid, @NotBlank, @NotNull, etc.)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getDefaultMessage());
        }

        return ApiResponse.error("Validation failed", HttpStatus.BAD_REQUEST.value(), errors);
    }

    // Handler para erros de desserialização JSON (tipo de dado incorreto, formato de data, etc.)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        String customErrorMessage = "Erro no formato da requisição JSON.";
        List<String> details = new ArrayList<>();

        // Tenta pegar a causa raiz para uma mensagem mais específica
        if (ex.getCause() instanceof MismatchedInputException) {
            MismatchedInputException mie = (MismatchedInputException) ex.getCause();
            if (mie.getPath() != null && !mie.getPath().isEmpty()) {
                String fieldName = mie.getPath().get(mie.getPath().size() - 1).getFieldName();
                customErrorMessage = String.format("Campo '%s' com formato ou tipo de dado inválido.", fieldName);
                details.add(mie.getOriginalMessage());
            } else {
                details.add(mie.getOriginalMessage());
            }

            // Se for um erro de data/hora especificamente
            if (mie.getCause() instanceof DateTimeParseException) {
                DateTimeParseException dtpe = (DateTimeParseException) mie.getCause();
                customErrorMessage = String.format("Formato de data e hora inválido para o campo '%s'.", mie.getPath().get(mie.getPath().size() - 1).getFieldName());
                details.add("Formato esperado: YYYY-MM-DDTHH:MM:SS ou similar. Erro original: " + dtpe.getMessage());
            }

        } else {
            details.add(ex.getMessage());
        }

        // Opcional: Logar a exceção completa para depuração no servidor, mas não enviar ao cliente
        ex.printStackTrace();

        return ApiResponse.error(customErrorMessage, HttpStatus.BAD_REQUEST.value(), details);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAllExceptions(Exception ex) {
        // Logar a exceção completa para depuração no servidor
        ex.printStackTrace();
        return ApiResponse.error("Ocorreu um erro interno inesperado.", HttpStatus.INTERNAL_SERVER_ERROR.value(), null);
    }
}