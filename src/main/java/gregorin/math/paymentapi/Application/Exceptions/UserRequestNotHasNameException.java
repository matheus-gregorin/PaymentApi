package gregorin.math.paymentapi.Application.Exceptions;

public class UserRequestNotHasNameException extends RuntimeException {
    public UserRequestNotHasNameException(String message) {
        super(message);
    }
}
