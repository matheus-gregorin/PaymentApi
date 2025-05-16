package gregorin.math.paymentapi.Application.Exceptions;

public class UserEmailExistsException extends RuntimeException {
    public UserEmailExistsException(String message) {
        super(message);
    }
}
