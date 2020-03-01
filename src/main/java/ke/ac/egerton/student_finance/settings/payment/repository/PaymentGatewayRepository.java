package ke.ac.egerton.student_finance.settings.payment.repository;

import ke.ac.egerton.student_finance.settings.payment.models.PaymentGateway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentGatewayRepository extends JpaRepository<PaymentGateway,Long> {
    PaymentGateway findByCode(String code);
    PaymentGateway findTopById(Long id);
}
