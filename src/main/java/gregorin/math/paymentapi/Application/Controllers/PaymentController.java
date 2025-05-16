package gregorin.math.paymentapi.Application.Controllers;

import gregorin.math.paymentapi.Application.Exceptions.UserEmailExistsException;
import gregorin.math.paymentapi.Application.Exceptions.UserNotFoundException;
import gregorin.math.paymentapi.Application.Exceptions.UserRequestNotHasNameException;
import gregorin.math.paymentapi.Application.Mapping.UserMapping;
import gregorin.math.paymentapi.Application.Responses.ApiResponse;
import gregorin.math.paymentapi.Application.UseCases.CreateUserUseCase;
import gregorin.math.paymentapi.Application.UseCases.GetUserUseCase;
import gregorin.math.paymentapi.Domain.Dtos.Requests.CreateUserRequestDto;
import gregorin.math.paymentapi.Domain.Entities.UserEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("payments")
public class PaymentController {

    private final CreateUserUseCase createUserUseCase;
    private final GetUserUseCase getUserUseCase;

    public PaymentController(
            GetUserUseCase getUserUseCase,
            CreateUserUseCase createUserUseCase
    )
    {
        this.getUserUseCase = getUserUseCase;
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody @Valid CreateUserRequestDto request) {
        try {
            UserEntity user = this.createUserUseCase.createUser(UserMapping.mapCreateUserDtoToEntity(request));
            return ApiResponse.success("User created", UserMapping.mapEntityToResponseDto(user));

        } catch (UserEmailExistsException e) {
            System.out.println("CREATE USER EMAIL ALREADY IN USE: " + e.getMessage());
            List<String> errors = new ArrayList<>();
            errors.add("Email already in use");
            return ApiResponse.error("Validation failed", 400, errors);

        } catch (Exception e) {
            System.out.println("CREATE USER EXCEPTION: " + e.getMessage());
            List<String> errors = new ArrayList<>();
            errors.add("Server error");
            return ApiResponse.error("User not created", 500, errors);
        }
    }

    @GetMapping("/get-user")
    public ResponseEntity<?> getUser(@RequestParam("name") String name) {
        try{
            UserEntity user = this.getUserUseCase.getByName(name);
            return ApiResponse.success("User found", UserMapping.mapEntityToResponseDto(user));

        } catch (UserNotFoundException e) {
            System.out.println("GET USER NOT FOUND: " + e.getMessage());
            return ResponseEntity.noContent().build();

        } catch (UserRequestNotHasNameException e) {
            System.out.println("GET USER REQUEST NOT HAS NAME: " + e.getMessage());
            List<String> errors = new ArrayList<>();
            errors.add("name is mandatory");
            return ApiResponse.error("Validation failed", 400, errors);

        } catch (Exception e) {
            System.out.println("GET USER EXCEPTION: " + e.getMessage());
            List<String> errors = new ArrayList<>();
            errors.add("Server error");
            return ApiResponse.error("User not found", 500, errors);

        }
    }
}
