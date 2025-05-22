package gregorin.math.paymentapi.Application.Exceptions.Users;

public class UserRequestNotHasEmailException extends RuntimeException {
    public UserRequestNotHasEmailException(String message) {
        super(message);
    }
}
