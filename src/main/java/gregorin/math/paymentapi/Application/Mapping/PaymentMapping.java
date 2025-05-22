package gregorin.math.paymentapi.Application.Mapping;

import gregorin.math.paymentapi.Domain.Dtos.Responses.Payments.GetPaymentResponseDto;
import gregorin.math.paymentapi.Domain.Entities.PaymentEntity;
import gregorin.math.paymentapi.Infrastructure.Models.PaymentModel;

public class PaymentMapping {
    public static PaymentEntity mapModelToEntity (PaymentModel paymentModel)
    {
        return new PaymentEntity(
                paymentModel.getUuid(),
                UserMapping.mapModelToEntity(paymentModel.getUser()),
                paymentModel.getValuePayment(),
                paymentModel.getPaid(),
                paymentModel.getMaturity(),
                paymentModel.getCreatedAt(),
                paymentModel.getUpdatedAt()
        );
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
}
