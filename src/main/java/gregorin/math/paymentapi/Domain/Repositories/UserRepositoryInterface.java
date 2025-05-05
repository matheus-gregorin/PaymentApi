package gregorin.math.paymentapi.Domain.Repositories;

import gregorin.math.paymentapi.Domain.Entities.UserEntity;

import java.util.Optional;

public interface UserRepositoryInterface {
    Optional<UserEntity> findByName (String name);
}
