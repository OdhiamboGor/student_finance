package ke.ac.egerton.student_finance.settings.receipts.repositories;

import ke.ac.egerton.student_finance.settings.receipts.models.ReceiptingCriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptingCriteriaRepository extends JpaRepository<ReceiptingCriteria, Long> {

    ReceiptingCriteria findByCode(String code);
}
