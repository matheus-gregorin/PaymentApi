package gregorin.math.paymentapi.Application.UseCases.Users;

import gregorin.math.paymentapi.Application.Exceptions.Users.UserRequestNotHasEmailException;
import gregorin.math.paymentapi.Domain.Entities.UserEntity;
import gregorin.math.paymentapi.Domain.Repositories.UserRepositoryInterface;
import org.springframework.stereotype.Component;

@Component
public class GetUserUseCase {

    // @Autowired
    // @Qualifier("mysql")
    private final UserRepositoryInterface userRepository;

    public GetUserUseCase(UserRepositoryInterface userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity getByEmail (String email) {
        if(email.isEmpty()) {
            throw new UserRequestNotHasEmailException("Email parameter is null");
        }
        return this.userRepository.findByEmail(email);
    }
}
