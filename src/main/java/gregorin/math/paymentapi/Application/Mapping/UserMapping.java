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

    public static UserEntity mapCreateUserDtoToEntity (CreateUserRequestDto request)
    {
        return new UserEntity(
                UUID.randomUUID().toString(),
                    request.getName(),
                        request.getEmail(),
                            request.getPassword(),
                                LocalDateTime.now(),
                                    LocalDateTime.now()
        );
    }

    public static UserModel mapUserEntityToModel (UserEntity user)
    {
        UserModel userModel = new UserModel();
            userModel.setUuid(user.getUuid());
                userModel.setName(user.getName());
                    userModel.setEmail(user.getEmail());
                        userModel.setPassword(user.getPassword());
                            userModel.setCreated_at(user.getCreated_at());
                                userModel.setUpdated_at(user.getUpdated_at());

                                return userModel;
    }

}
