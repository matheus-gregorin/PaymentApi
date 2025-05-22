package gregorin.math.paymentapi.Application.UseCases.Payments;

import gregorin.math.paymentapi.Application.Mapping.PaymentMapping;
import gregorin.math.paymentapi.Domain.Dtos.Responses.Payments.GetPaymentResponseDto;
import gregorin.math.paymentapi.Domain.Entities.PaymentEntity;
import gregorin.math.paymentapi.Domain.Repositories.PaymentRepositoryInterface;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetPaymentsUseCase {

    private PaymentRepositoryInterface paymentRepository;

    public GetPaymentsUseCase(PaymentRepositoryInterface paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<GetPaymentResponseDto> findAll() {
        List<PaymentEntity> payments = this.paymentRepository.findAll();

        List<GetPaymentResponseDto> paymentResponse = new ArrayList<>();
        for(PaymentEntity payment : payments){
            paymentResponse.add(PaymentMapping.mapEntityToResponseDto(payment));
        }

        return paymentResponse;
    }
}
