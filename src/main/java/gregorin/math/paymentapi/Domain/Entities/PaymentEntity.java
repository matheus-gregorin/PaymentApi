package gregorin.math.paymentapi.Domain.Entities;

import java.time.LocalDateTime;

public class PaymentEntity {

        private String uuid;
        private UserEntity user;
        private Float value_payment;
        private Boolean paid;
        private LocalDateTime maturity;
        private LocalDateTime created_at;
        private LocalDateTime updated_at;

    public PaymentEntity(
            String uuid,
            UserEntity user,
            Float value_payment,
            Boolean paid,
            LocalDateTime maturity,
            LocalDateTime created_at,
            LocalDateTime updated_at
    ) {
        this.uuid = uuid;
        this.user = user;
        this.value_payment = value_payment;
        this.paid = paid;
        this.maturity = maturity;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getUuid() {
        return uuid;
    }

        public void setUuid(String uuid) {
        this.uuid = uuid;
    }

        public UserEntity getUser() {
        return user;
    }

        public void setUser(UserEntity user) {
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
