package ke.ac.egerton.student_finance.settings.receipts.repositories;

import ke.ac.egerton.student_finance.settings.receipts.models.ReversalReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReversalReasonRepository extends JpaRepository<ReversalReason, Long> {
}
