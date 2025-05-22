package gregorin.math.paymentapi.Application.Exceptions.Users;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
