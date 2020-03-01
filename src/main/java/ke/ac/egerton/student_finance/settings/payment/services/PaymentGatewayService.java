package ke.ac.egerton.student_finance.settings.payment.services;

import ke.ac.egerton.student_finance.settings.payment.models.PaymentGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentGatewayService {

    PaymentGateway savePaymentGateway(PaymentGateway paymentGateway);

    PaymentGateway updatePaymentGateway(PaymentGateway paymentGateway);

    List<PaymentGateway> getAllPaymentGateway();

    PaymentGateway getPaymentGatewayById(long id);

    PaymentGateway getPaymentGatewayByCode(String code);

    void deletePaymentGateway(long id);
}
