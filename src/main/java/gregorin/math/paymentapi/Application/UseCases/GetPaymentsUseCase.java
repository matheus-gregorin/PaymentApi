package gregorin.math.paymentapi.Application.UseCases;

import gregorin.math.paymentapi.Domain.Entities.PaymentEntity;
import gregorin.math.paymentapi.Domain.Repositories.PaymentRepositoryInterface;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetPaymentsUseCase {

    private PaymentRepositoryInterface paymentrepository;

    public GetPaymentsUseCase(PaymentRepositoryInterface paymentrepository) {
        this.paymentrepository = paymentrepository;
    }

    public List<PaymentEntity> findAll() {
        return this.paymentrepository.findAll();
    }
}
