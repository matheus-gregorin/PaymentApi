package gregorin.math.paymentapi.Application.Repositories;

import gregorin.math.paymentapi.Application.Mapping.UserMapping;
import gregorin.math.paymentapi.Domain.Entities.UserEntity;
import gregorin.math.paymentapi.Domain.Repositories.UserRepositoryInterface;
import gregorin.math.paymentapi.Infrastructure.Models.UserModel;
import gregorin.math.paymentapi.Infrastructure.Orm.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile("mysql")
public class MysqlUserRepository implements UserRepositoryInterface {

    @Autowired
    private JpaUserRepository jpaUserRepository;

    @Override
    public Optional<UserEntity> findByName(String name) {
        try {
            UserModel user = this.jpaUserRepository.findByName(name);
            return Optional.of(UserMapping.mapToEntity(user));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
