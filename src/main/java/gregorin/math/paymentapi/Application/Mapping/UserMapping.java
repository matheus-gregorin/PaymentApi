package gregorin.math.paymentapi.Application.Mapping;

import gregorin.math.paymentapi.Domain.Entities.UserEntity;
import gregorin.math.paymentapi.Infrastructure.Models.UserModel;

public class UserMapping {
    public static UserEntity mapToEntity (UserModel userModel)
    {
        return new UserEntity(
            userModel.getUuid(),
                userModel.getName(),
                    userModel.getEmail(),
                        userModel.getCreated_at(),
                            userModel.getUpdated_at()
        );
    }

}
