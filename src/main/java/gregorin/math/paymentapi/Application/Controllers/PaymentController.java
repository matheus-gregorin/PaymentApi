package gregorin.math.paymentapi.Application.Controllers;

import gregorin.math.paymentapi.Application.Exceptions.PaymentsNotFoundException;
import gregorin.math.paymentapi.Application.UseCases.GetPaymentsUseCase;
import gregorin.math.paymentapi.Domain.Entities.PaymentEntity;
import gregorin.math.paymentapi.Domain.Repositories.PaymentRepositoryInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            return ResponseEntity.status(200).body(this.getPaymentsUseCase.findAll());

        } catch (PaymentsNotFoundException e) {
            System.out.println("PAYMENTS NOT FOUND");
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
