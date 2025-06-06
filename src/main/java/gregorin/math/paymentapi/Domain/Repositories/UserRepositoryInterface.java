package gregorin.math.paymentapi.Domain.Repositories;

import gregorin.math.paymentapi.Domain.Entities.UserEntity;
import gregorin.math.paymentapi.Infrastructure.Models.UserModel;

public interface UserRepositoryInterface {
    UserEntity createUser (UserModel user);
    UserEntity findByEmail (String email);
    UserEntity findByUuid (String uuid);
}
