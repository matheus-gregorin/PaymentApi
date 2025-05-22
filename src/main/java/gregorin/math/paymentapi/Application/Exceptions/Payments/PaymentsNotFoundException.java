package gregorin.math.paymentapi.Application.Exceptions.Payments;

public class PaymentsNotFoundException extends RuntimeException {
    public PaymentsNotFoundException(String message) {
        super(message);
    }
}
