package gregorin.math.paymentapi.Application.UseCases;

import gregorin.math.paymentapi.Domain.Entities.UserEntity;
import gregorin.math.paymentapi.Domain.Repositories.UserRepositoryInterface;
import org.springframework.stereotype.Service;

@Service
public class GetUserUseCase {

    // @Autowired
    // @Qualifier("mysql")
    private final UserRepositoryInterface userRepository;

    public GetUserUseCase(UserRepositoryInterface userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity getByName (String name) {
        return this.userRepository.findByName(name);
    }
}
