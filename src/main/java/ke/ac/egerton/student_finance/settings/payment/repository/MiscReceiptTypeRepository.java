package ke.ac.egerton.student_finance.settings.payment.repository;

import ke.ac.egerton.student_finance.settings.payment.models.MiscReceiptType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiscReceiptTypeRepository extends JpaRepository<MiscReceiptType, Long> {
}
