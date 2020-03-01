package ke.ac.egerton.student_finance.thirdPartyPayments.repositories;

import ke.ac.egerton.models.Student;
import ke.ac.egerton.student_finance.thirdPartyPayments.models.ImportPayments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImportPaymentsRepository extends JpaRepository<ImportPayments, Long> {
}
