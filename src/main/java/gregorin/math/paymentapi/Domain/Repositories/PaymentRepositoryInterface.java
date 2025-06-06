package gregorin.math.paymentapi.Domain.Repositories;

import gregorin.math.paymentapi.Domain.Entities.PaymentEntity;
import gregorin.math.paymentapi.Infrastructure.Models.PaymentModel;

import java.util.List;

public interface PaymentRepositoryInterface {
    List<PaymentEntity> findAll();
    PaymentEntity create (PaymentModel payment);
}
