package gregorin.math.paymentapi.Application.Controllers;

import gregorin.math.paymentapi.Application.Exceptions.UserNotFoundException;
import gregorin.math.paymentapi.Application.Mapping.UserMapping;
import gregorin.math.paymentapi.Application.Responses.ApiResponse;
import gregorin.math.paymentapi.Application.UseCases.GetUserUseCase;
import gregorin.math.paymentapi.Domain.Dtos.Requests.GetUserRequestDto;
import gregorin.math.paymentapi.Domain.Entities.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("payments")
public class PaymentController {

    private final GetUserUseCase getUserUseCase;

    public PaymentController(GetUserUseCase getUserUseCase) {
        this.getUserUseCase = getUserUseCase;
    }

    @PostMapping("/create-user")
    public void createUser() {
        System.out.println();
    }

    @GetMapping("/get-user")
    public ResponseEntity<?> getUser(@RequestBody GetUserRequestDto request) {
        try{
            UserEntity user = this.getUserUseCase.getByName(request.getName());
            return ApiResponse.success("User found", UserMapping.mapEntityToResponseDto(user));

        } catch (UserNotFoundException e) {
            System.out.println("USER NOT FOUND: " + e.getMessage());
            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
            List<String> errors = new ArrayList<>();
            errors.add("Server error");
            return ApiResponse.error("User not found", 500, errors);

        }
    }
}
