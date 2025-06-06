package gregorin.math.paymentapi.Application.Repositories;

import gregorin.math.paymentapi.Application.Exceptions.Payments.PaymentsNotFoundException;
import gregorin.math.paymentapi.Application.Mapping.PaymentMapping;
import gregorin.math.paymentapi.Application.Mapping.UserMapping;
import gregorin.math.paymentapi.Domain.Entities.PaymentEntity;
import gregorin.math.paymentapi.Domain.Repositories.PaymentRepositoryInterface;
import gregorin.math.paymentapi.Infrastructure.Models.PaymentModel;
import gregorin.math.paymentapi.Infrastructure.Models.UserModel;
import gregorin.math.paymentapi.Infrastructure.Orm.JpaPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("mysqlPayment")
public class MysqlPaymentRepository implements PaymentRepositoryInterface {

    @Autowired
    private JpaPaymentRepository jpaPaymentRepository;

    @Override
    public List<PaymentEntity> findAll() {
        List<PaymentModel> payments = this.jpaPaymentRepository.findAll();
        if(payments.isEmpty()){
            throw new PaymentsNotFoundException("Payments is empty");
        }
        List<PaymentEntity> paymentList = new ArrayList<>();
        for (PaymentModel payment : payments){
            paymentList.add(PaymentMapping.mapModelToEntity(payment));
        }
        return paymentList;
    }

    @Override
    public PaymentEntity create(PaymentModel payment) {
        PaymentModel paymentModel = this.jpaPaymentRepository.save(payment);
        return PaymentMapping.mapModelToEntity(paymentModel);
    }
}
