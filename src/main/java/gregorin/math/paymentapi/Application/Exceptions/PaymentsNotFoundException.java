package gregorin.math.paymentapi.Application.Exceptions;

public class PaymentsNotFoundException extends RuntimeException {
    public PaymentsNotFoundException(String message) {
        super(message);
    }
}
