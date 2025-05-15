package gregorin.math.paymentapi.Application.Mapping;

import gregorin.math.paymentapi.Domain.Dtos.Requests.CreateUserRequestDto;
import gregorin.math.paymentapi.Domain.Dtos.Responses.GetUserResponseDto;
import gregorin.math.paymentapi.Domain.Entities.UserEntity;
import gregorin.math.paymentapi.Infrastructure.Models.UserModel;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserMapping {
    public static UserEntity mapModelToEntity (UserModel userModel)
    {
        return new UserEntity(
            userModel.getUuid(),
                userModel.getName(),
                    userModel.getEmail(),
                        userModel.getPassword(),
                            userModel.getCreated_at(),
                                userModel.getUpdated_at()
        );
    }

    public static GetUserResponseDto mapEntityToResponseDto (UserEntity user)
    {
        return new GetUserResponseDto(
                user.getUuid(),
                    user.getName(),
                        user.getEmail(),
                            user.getCreated_at(),
                                user.getUpdated_at()
        );
    }

    public static UserEntity mapGenericToEntity (CreateUserRequestDto request)
    {
        return new UserEntity(
                UUID.randomUUID().toString().replace("-", ""),
                    request.getName(),
                        request.getEmail(),
                            request.getPassword(),
                                LocalDateTime.now(),
                                    LocalDateTime.now()
        );
    }

}
