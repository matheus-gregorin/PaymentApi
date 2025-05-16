package gregorin.math.paymentapi.Application.UseCases;

import gregorin.math.paymentapi.Application.Exceptions.UserRequestNotHasNameException;
import gregorin.math.paymentapi.Domain.Entities.UserEntity;
import gregorin.math.paymentapi.Domain.Repositories.UserRepositoryInterface;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class GetUserUseCase {

    // @Autowired
    // @Qualifier("mysql")
    private final UserRepositoryInterface userRepository;

    public GetUserUseCase(UserRepositoryInterface userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity getByName (String name) {
        if(name.isEmpty()) {
            throw new UserRequestNotHasNameException("Name parameter is null");
        }
        return this.userRepository.findByName(name);
    }
}
