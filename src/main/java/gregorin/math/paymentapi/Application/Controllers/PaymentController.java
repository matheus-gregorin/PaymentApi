package gregorin.math.paymentapi.Application.Controllers;

import gregorin.math.paymentapi.Domain.Entities.UserEntity;
import gregorin.math.paymentapi.Domain.Repositories.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
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
    public ResponseEntity<?> getUser(@PathVariable String name)
    {
        try{
            Optional<UserEntity> user = this.userRepository.findByName(name);
            if(user.isPresent()){
                return ResponseEntity.ok(user);
            }
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("success", "false");
            error.put("error", "User not found");
            System.out.println("Log do erro: ");
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }
}
