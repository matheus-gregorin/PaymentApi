package gregorin.math.paymentapi.Domain.Dtos.Requests.Payments;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public class CreatePaymentRequestDto {

    @Pattern(regexp = "^.*[^0-9].*$", message = "User uuid not is numeric")
    @NotBlank(message = "User uuid is mandatory")
    private String user_uuid;

    @Positive(message = "Payment values can not is negative or zero")
    @NotNull(message = "Payment value is mandatory")
    private Float payment_value;

    @NotNull(message = "Paid is mandatory")
    private Boolean paid;

    @NotNull(message = "Maturity is mandatory")
    private LocalDateTime maturity;

    public String getUser_uuid() {
        return user_uuid;
    }

    public void setUser_uuid(String user_uuid) {
        this.user_uuid = user_uuid;
    }

    public Float getPayment_value() {
        return payment_value;
    }

    public void setPayment_value(Float payment_value) {
        this.payment_value = payment_value;
    }

    public LocalDateTime getMaturity() {
        return maturity;
    }

    public void setMaturity(LocalDateTime maturity) {
        this.maturity = maturity;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
}
