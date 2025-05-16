package gregorin.math.paymentapi.Infrastructure.Models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class PaymentModel {

    @Id
    @Column(name = "uuid", nullable = false, updatable = false, unique = true)
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "user_uuid", nullable = false)
    private UserModel user;

    @Column(name = "value_payment")
    private Float value_payment;

    @Column(name = "paid", nullable = false)
    private Boolean paid;

    @Column(name = "maturity")
    private LocalDateTime maturity;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime created_at;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updated_at;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Float getValue_payment() {
        return value_payment;
    }

    public void setValue_payment(Float value_payment) {
        this.value_payment = value_payment;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public LocalDateTime getMaturity() {
        return maturity;
    }

    public void setMaturity(LocalDateTime maturity) {
        this.maturity = maturity;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
