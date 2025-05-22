package gregorin.math.paymentapi.Application.Repositories;

import gregorin.math.paymentapi.Application.Exceptions.UserEmailExistsException;
import gregorin.math.paymentapi.Application.Exceptions.UserNotFoundException;
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
@Profile("mysqlUser")
public class MysqlUserRepository implements UserRepositoryInterface {

    @Autowired
    private JpaUserRepository jpaUserRepository;

    @Override
    public UserEntity createUser(UserModel user) {
        Boolean userSearch = this.validUserExists(user.getEmail());
        if(userSearch){
            throw new UserEmailExistsException("E-mail already in use");
        }
        UserModel userSave = this.jpaUserRepository.save(user);
        return UserMapping.mapModelToEntity(userSave);
    }

    @Override
    public UserEntity findByEmail(String email) {
        UserModel user = this.jpaUserRepository
                .findByEmail(email)
                .orElseThrow(
                        () -> new UserNotFoundException("User not found in database")
                );
        return UserMapping.mapModelToEntity(user);
    }

    public Boolean validUserExists(String email) {
        Optional<UserModel> user = this.jpaUserRepository.findByEmail(email);
        return user.isPresent();
    }
}