package gregorin.math.paymentapi.Application.UseCases.Payments;

import gregorin.math.paymentapi.Application.Mapping.PaymentMapping;
import gregorin.math.paymentapi.Domain.Dtos.Responses.Payments.GetPaymentResponseDto;
import gregorin.math.paymentapi.Domain.Entities.PaymentEntity;
import gregorin.math.paymentapi.Domain.Entities.UserEntity;
import gregorin.math.paymentapi.Domain.Repositories.PaymentRepositoryInterface;
import gregorin.math.paymentapi.Domain.Repositories.UserRepositoryInterface;
import org.springframework.stereotype.Component;

@Component
public class CreatePaymentsUseCase {


    private PaymentRepositoryInterface paymentRepositoryInterface;
    private UserRepositoryInterface userRepositoryInterface;

    public CreatePaymentsUseCase(
            PaymentRepositoryInterface paymentRepositoryInterface,
            UserRepositoryInterface userRepositoryInterface
    )
    {
        this.paymentRepositoryInterface = paymentRepositoryInterface;
        this.userRepositoryInterface = userRepositoryInterface;
    }

    public GetPaymentResponseDto create(PaymentEntity payment, String userUuid)
    {
        // Se o usuário não for encontrado
        // Vai disparar uma exception (UserNotFoundException)
        // Onde a controller está preparada para captura-la e tratar a resposta
        UserEntity user = this.userRepositoryInterface.findByUuid(userUuid);
        payment.setUser(user);

        PaymentEntity paymentResponse = this.paymentRepositoryInterface.create(PaymentMapping.mapUserEntityToModel(payment));

        return PaymentMapping.mapEntityToResponseDto(paymentResponse);
    }
}
