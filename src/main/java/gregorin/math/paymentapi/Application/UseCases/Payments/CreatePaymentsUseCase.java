package gregorin.math.paymentapi.Application.UseCases.Payments;

import gregorin.math.paymentapi.Domain.Entities.PaymentEntity;
import gregorin.math.paymentapi.Domain.Entities.UserEntity;
import gregorin.math.paymentapi.Domain.Repositories.PaymentRepositoryInterface;
import gregorin.math.paymentapi.Domain.Repositories.UserRepositoryInterface;
import org.springframework.stereotype.Component;

@Component
public class CreatePaymentsUseCase {


    private PaymentRepositoryInterface paymentRepository;
    private UserRepositoryInterface userRepositoryInterface;

    public CreatePaymentsUseCase(
            PaymentRepositoryInterface paymentRepository,
            UserRepositoryInterface userRepositoryInterface
    )
    {
        this.paymentRepository = paymentRepository;
        this.userRepositoryInterface = userRepositoryInterface;
    }

    public PaymentEntity create(PaymentEntity payment, String userUuid)
    {
        UserEntity user = this.userRepositoryInterface.findByUuid(userUuid);
        System.out.println(user.getName());
        return null;
    }
}
