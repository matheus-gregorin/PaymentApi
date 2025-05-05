package gregorin.math.paymentapi.Application.Controllers;

import gregorin.math.paymentapi.Domain.Entities.UserEntity;
import gregorin.math.paymentapi.Domain.Repositories.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("payments")
public class PaymentController {

    @Autowired
    @Qualifier("mysql")
    private final UserRepositoryInterface userRepository;

    public PaymentController(UserRepositoryInterface userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{name}")
    public Object getUser(@PathVariable String name)
    {
        try{
            return this.userRepository.findByName(name);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Requisição inválida");
        }
    }
}
