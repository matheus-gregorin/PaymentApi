package gregorin.math.paymentapi.Application.Mapping;

import gregorin.math.paymentapi.Domain.Entities.PaymentEntity;
import gregorin.math.paymentapi.Domain.Entities.UserEntity;
import gregorin.math.paymentapi.Infrastructure.Models.PaymentModel;
import gregorin.math.paymentapi.Infrastructure.Models.UserModel;

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
}
