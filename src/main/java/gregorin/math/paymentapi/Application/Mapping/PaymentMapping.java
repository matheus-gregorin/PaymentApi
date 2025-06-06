package gregorin.math.paymentapi.Application.Mapping;

import gregorin.math.paymentapi.Domain.Dtos.Requests.Payments.CreatePaymentRequestDto;
import gregorin.math.paymentapi.Domain.Dtos.Responses.Payments.GetPaymentResponseDto;
import gregorin.math.paymentapi.Domain.Entities.PaymentEntity;
import gregorin.math.paymentapi.Domain.Entities.UserEntity;
import gregorin.math.paymentapi.Infrastructure.Models.PaymentModel;
import gregorin.math.paymentapi.Infrastructure.Models.UserModel;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentMapping {
    public static PaymentEntity mapModelToEntity (PaymentModel paymentModel)
    {
        PaymentEntity payment = new PaymentEntity(
                paymentModel.getUuid(),
                    paymentModel.getValuePayment(),
                        paymentModel.getPaid(),
                            paymentModel.getMaturity(),
                                paymentModel.getCreatedAt(),
                                    paymentModel.getUpdatedAt()
        );

        UserEntity user = UserMapping.mapModelToEntity(paymentModel.getUser());
        payment.setUser(user);

        return payment;
    }

    public static GetPaymentResponseDto mapEntityToResponseDto (PaymentEntity payment)
    {
        return new GetPaymentResponseDto(
                    payment.getUuid(),
                        UserMapping.mapEntityToResponseDto(payment.getUser()),
                            payment.getValuePayment(),
                                payment.getPaid(),
                                    payment.getMaturity(),
                                        payment.getCreatedAt(),
                                            payment.getUpdatedAt()
        );
    }

    public static PaymentEntity mapCreatePaymentDtoToEntity (CreatePaymentRequestDto request)
    {

        return new PaymentEntity(
                UUID.randomUUID().toString(),
                    request.getPayment_value(),
                        request.getPaid(),
                            request.getMaturity(),
                                LocalDateTime.now(),
                                    LocalDateTime.now()
        );
    }

    public static PaymentModel mapUserEntityToModel (PaymentEntity payment)
    {
        PaymentModel paymentModel = new PaymentModel();
        paymentModel.setUuid(payment.getUuid());
        paymentModel.setUser(UserMapping.mapUserEntityToModel(payment.getUser()));
        paymentModel.setValuePayment(payment.getValuePayment());
        paymentModel.setPaid(payment.getPaid());
        paymentModel.setMaturity(payment.getMaturity());
        paymentModel.setCreatedAt(payment.getCreatedAt());
        paymentModel.setUpdatedAt(payment.getUpdatedAt());

        return paymentModel;
    }
}
