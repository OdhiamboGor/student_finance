package ke.ac.egerton.student_finance.settings.coreSetup.repository;

import ke.ac.egerton.student_finance.settings.coreSetup.models.Installment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstallmentRepository extends JpaRepository<Installment, Long> {
}
