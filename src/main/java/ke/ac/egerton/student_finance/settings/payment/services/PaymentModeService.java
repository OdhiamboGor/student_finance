package ke.ac.egerton.student_finance.settings.payment.services;

import ke.ac.egerton.student_finance.settings.payment.models.PaymentMode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentModeService {

    PaymentMode savePaymentMode(PaymentMode paymentMode);

    PaymentMode updatePaymentMode(PaymentMode paymentMode);

    List<PaymentMode> getAllPaymentMode();

    PaymentMode getPaymentModeById(long id);

    PaymentMode getPaymentModeByCode(String code);

    void deletePaymentMode(long id);
}
