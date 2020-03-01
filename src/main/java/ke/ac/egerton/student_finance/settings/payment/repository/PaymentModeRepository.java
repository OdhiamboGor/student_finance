package ke.ac.egerton.student_finance.settings.payment.repository;

import ke.ac.egerton.student_finance.settings.payment.models.PaymentMode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentModeRepository extends JpaRepository<PaymentMode, Long> {
    PaymentMode findByCode(String mode);
    PaymentMode findById(Long id);
}
