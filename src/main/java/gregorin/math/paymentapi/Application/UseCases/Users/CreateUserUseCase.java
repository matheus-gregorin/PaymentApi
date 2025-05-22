package gregorin.math.paymentapi.Application.UseCases.Users;

import gregorin.math.paymentapi.Application.Mapping.UserMapping;
import gregorin.math.paymentapi.Domain.Entities.UserEntity;
import gregorin.math.paymentapi.Domain.Repositories.UserRepositoryInterface;
import org.springframework.stereotype.Component;

@Component
public class CreateUserUseCase {

    // @Autowired
    // @Qualifier("mysql")
    private final UserRepositoryInterface userRepository;

    public CreateUserUseCase(UserRepositoryInterface userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser (UserEntity user) {
        return this.userRepository.createUser(UserMapping.mapUserEntityToModel(user));
    }
}
