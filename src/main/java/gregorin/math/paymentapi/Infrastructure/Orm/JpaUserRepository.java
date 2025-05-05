package gregorin.math.paymentapi.Infrastructure.Orm;

import gregorin.math.paymentapi.Infrastructure.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaUserRepository extends JpaRepository<UserModel, String> {
    @Query("SELECT u FROM UserModel u WHERE u.name = :name")
    UserModel findByName(@Param("name") String name);
}