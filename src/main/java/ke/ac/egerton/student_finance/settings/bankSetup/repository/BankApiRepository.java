package ke.ac.egerton.student_finance.settings.bankSetup.repository;

import ke.ac.egerton.student_finance.settings.bankSetup.models.BankApi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankApiRepository extends JpaRepository<BankApi, Long> {
}
