package ke.ac.egerton.student_finance.settings.payment.services;

import ke.ac.egerton.student_finance.settings.payment.models.PaymentGateway;
import ke.ac.egerton.student_finance.settings.payment.repository.PaymentGatewayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaymentGatewayServiceImpl implements PaymentGatewayService{

    @Autowired
    PaymentGatewayRepository paymentGatewayRepository;

    @Override
    public PaymentGateway savePaymentGateway(PaymentGateway paymentGateway) {
        return paymentGatewayRepository.save(paymentGateway);
    }

    @Override
    public PaymentGateway updatePaymentGateway(PaymentGateway paymentGateway) {
        return null;
    }

    @Override
    public List<PaymentGateway> getAllPaymentGateway() {
        return this.paymentGatewayRepository.findAll();
    }

    @Override
    public PaymentGateway getPaymentGatewayById(long id) {
        return null;
    }

    @Override
    public PaymentGateway getPaymentGatewayByCode(String code) {
        return null;
    }

    @Override
    public void deletePaymentGateway(long id) {

    }
}
