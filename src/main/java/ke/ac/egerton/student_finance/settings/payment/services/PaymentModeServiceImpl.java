package ke.ac.egerton.student_finance.settings.payment.services;

import ke.ac.egerton.student_finance.settings.payment.models.PaymentMode;
import ke.ac.egerton.student_finance.settings.payment.repository.PaymentModeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaymentModeServiceImpl implements PaymentModeService{

    @Autowired
    PaymentModeRepository paymentModeRepository;

    @Override
    public PaymentMode savePaymentMode(PaymentMode paymentMode) {
        return paymentModeRepository.save(paymentMode);
    }

    @Override
    public PaymentMode updatePaymentMode(PaymentMode paymentMode) {
        return null;
    }

    @Override
    public List<PaymentMode> getAllPaymentMode() {
        return this.paymentModeRepository.findAll();
    }

    @Override
    public PaymentMode getPaymentModeById(long id) {
        return this.paymentModeRepository.findOne(id);
    }

    @Override
    public PaymentMode getPaymentModeByCode(String code) {
        return null;
    }

    @Override
    public void deletePaymentMode(long id) {

    }
}
