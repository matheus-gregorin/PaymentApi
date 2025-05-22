package gregorin.math.paymentapi.Application.Configurations;

import gregorin.math.paymentapi.Application.Repositories.MysqlPaymentRepository;
import gregorin.math.paymentapi.Application.Repositories.MysqlUserRepository;
import gregorin.math.paymentapi.Domain.Repositories.PaymentRepositoryInterface;
import gregorin.math.paymentapi.Domain.Repositories.UserRepositoryInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbPaymentConfiguration {
    @Bean(name = "mysqlPayment")
    public PaymentRepositoryInterface mysqlPayment()
    {
        return new MysqlPaymentRepository();
    }
}
