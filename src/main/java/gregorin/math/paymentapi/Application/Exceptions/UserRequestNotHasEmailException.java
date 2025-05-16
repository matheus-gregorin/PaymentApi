package gregorin.math.paymentapi.Application.Exceptions;

public class UserRequestNotHasEmailException extends RuntimeException {
    public UserRequestNotHasEmailException(String message) {
        super(message);
    }
}
