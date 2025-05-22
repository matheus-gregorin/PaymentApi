package gregorin.math.paymentapi.Application.Controllers;

import gregorin.math.paymentapi.Application.Exceptions.Payments.PaymentsNotFoundException;
import gregorin.math.paymentapi.Application.Mapping.PaymentMapping;
import gregorin.math.paymentapi.Application.Responses.ApiResponse;
import gregorin.math.paymentapi.Application.UseCases.Payments.GetPaymentsUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("payments")
public class PaymentController {

    private GetPaymentsUseCase getPaymentsUseCase;

    public PaymentController(GetPaymentsUseCase getPaymentsUseCase) {
        this.getPaymentsUseCase = getPaymentsUseCase;
    }

    @GetMapping()
    public ResponseEntity<?> getPayments() {
        try {
            return ApiResponse.success("Payments found", this.getPaymentsUseCase.findAll());

        } catch (PaymentsNotFoundException e) {
            System.out.println("PAYMENTS NOT FOUND");
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
            List<String> errors = new ArrayList<>();
            errors.add("Server error");
            return ApiResponse.error("User not created", 500, errors);
        }
    }
}
