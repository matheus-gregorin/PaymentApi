package gregorin.math.paymentapi.Application.Controllers;

import gregorin.math.paymentapi.Infrastructure.Models.PaymentModel;
import gregorin.math.paymentapi.Infrastructure.Orm.JpaPaymentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("payments")
public class PaymentController {

    private JpaPaymentRepository jpaPaymentRepository;

    public PaymentController(JpaPaymentRepository jpaPaymentRepository) {
        this.jpaPaymentRepository = jpaPaymentRepository;
    }

    @GetMapping()
    public List<PaymentModel> getPayment() {
        return this.jpaPaymentRepository.findAll();
    }
}
