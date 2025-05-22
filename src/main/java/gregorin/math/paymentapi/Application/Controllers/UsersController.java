package gregorin.math.paymentapi.Application.Controllers;

import gregorin.math.paymentapi.Application.Exceptions.Users.UserEmailExistsException;
import gregorin.math.paymentapi.Application.Exceptions.Users.UserNotFoundException;
import gregorin.math.paymentapi.Application.Exceptions.Users.UserRequestNotHasEmailException;
import gregorin.math.paymentapi.Application.Mapping.UserMapping;
import gregorin.math.paymentapi.Application.Responses.ApiResponse;
import gregorin.math.paymentapi.Application.UseCases.Users.CreateUserUseCase;
import gregorin.math.paymentapi.Application.UseCases.Users.GetUserUseCase;
import gregorin.math.paymentapi.Domain.Dtos.Requests.Users.CreateUserRequestDto;
import gregorin.math.paymentapi.Domain.Entities.UserEntity;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("users")
public class UsersController {

    private final CreateUserUseCase createUserUseCase;
    private final GetUserUseCase getUserUseCase;

    public UsersController(
            GetUserUseCase getUserUseCase,
            CreateUserUseCase createUserUseCase
    )
    {
        this.getUserUseCase = getUserUseCase;
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping("/create")
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

    @GetMapping()
    public ResponseEntity<?> getUser(@RequestParam("name") String email) {
        try{
            UserEntity user = this.getUserUseCase.getByEmail(email);
            return ApiResponse.success("User found", UserMapping.mapEntityToResponseDto(user));

        } catch (UserNotFoundException e) {
            System.out.println("GET USER NOT FOUND: " + e.getMessage());
            return ResponseEntity.noContent().build();

        } catch (UserRequestNotHasEmailException e) {
            System.out.println("GET USER REQUEST NOT HAS EMAIL: " + e.getMessage());
            List<String> errors = new ArrayList<>();
            errors.add("email is mandatory");
            return ApiResponse.error("Validation failed", 400, errors);

        } catch (Exception e) {
            System.out.println("GET USER EXCEPTION: " + e.getMessage());
            List<String> errors = new ArrayList<>();
            errors.add("Server error");
            return ApiResponse.error("User not found", 500, errors);

        }
    }
}
