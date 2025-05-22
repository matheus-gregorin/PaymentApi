package gregorin.math.paymentapi.Domain.Repositories;

import gregorin.math.paymentapi.Domain.Entities.PaymentEntity;

import java.util.List;

public interface PaymentRepositoryInterface {
    List<PaymentEntity> findAll();
}
