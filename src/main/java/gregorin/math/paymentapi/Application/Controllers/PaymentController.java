package gregorin.math.paymentapi.Application.Controllers;

import gregorin.math.paymentapi.Domain.Entities.UserEntity;
import gregorin.math.paymentapi.Domain.Repositories.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("payments")
public class PaymentController {

    @Autowired
    private final UserRepositoryInterface userRepository;

    public PaymentController(UserRepositoryInterface userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public Optional<UserEntity> getUser()
    {
        return this.userRepository.findByName("Maria Souza");
    }
}
