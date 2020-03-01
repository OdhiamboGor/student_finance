package ke.ac.egerton.student_finance.settings.accountsSetup.repository;

import ke.ac.egerton.student_finance.settings.accountsSetup.models.AccountSet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountSetRepository extends JpaRepository<AccountSet, Long> {
    AccountSet findByCode(String account);
}
