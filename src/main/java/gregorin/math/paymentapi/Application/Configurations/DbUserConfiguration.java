package gregorin.math.paymentapi.Application.Configurations;

import gregorin.math.paymentapi.Application.Repositories.MysqlUserRepository;
import gregorin.math.paymentapi.Domain.Repositories.UserRepositoryInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbUserConfiguration {

    @Bean(name = "mysqlUser")
    public UserRepositoryInterface mysqlUser()
    {
        return new MysqlUserRepository();
    }
}
