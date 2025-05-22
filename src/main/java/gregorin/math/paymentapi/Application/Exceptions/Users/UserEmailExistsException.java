package gregorin.math.paymentapi.Application.Exceptions.Users;

public class UserEmailExistsException extends RuntimeException {
    public UserEmailExistsException(String message) {
        super(message);
    }
}
