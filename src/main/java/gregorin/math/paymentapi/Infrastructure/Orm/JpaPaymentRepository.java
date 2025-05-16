package gregorin.math.paymentapi.Infrastructure.Orm;

import gregorin.math.paymentapi.Infrastructure.Models.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPaymentRepository extends JpaRepository<PaymentModel, String> {
}
