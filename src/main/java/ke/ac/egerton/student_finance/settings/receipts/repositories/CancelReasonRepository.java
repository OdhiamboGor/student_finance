package ke.ac.egerton.student_finance.settings.receipts.repositories;

import ke.ac.egerton.student_finance.settings.receipts.models.CancelReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancelReasonRepository extends JpaRepository<CancelReason, Long> {
}
