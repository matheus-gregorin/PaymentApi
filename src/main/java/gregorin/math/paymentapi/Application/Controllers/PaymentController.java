package gregorin.math.paymentapi.Application.Controllers;

import gregorin.math.paymentapi.Application.Responses.ApiResponse;
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

import java.util.*;

@RestController
@RequestMapping("payments")
public class PaymentController {

//    @Autowired
//    @Qualifier("mysql")
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
                return ApiResponse.success("User found", user);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            List<String> errors = new ArrayList<>();
            errors.add("User not found");
            return ApiResponse.error("User not found", errors);
        }
    }
}
