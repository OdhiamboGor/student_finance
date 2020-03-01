package ke.ac.egerton.student_finance.settings.payment.repository;

import ke.ac.egerton.student_finance.settings.payment.models.PayeeGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayeeGroupRepository extends JpaRepository<PayeeGroup, Long> {
    PayeeGroup findByCode(String payee);
}
