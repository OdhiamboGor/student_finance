package ke.ac.egerton.student_finance.settings.accountsSetup.repository;

import ke.ac.egerton.student_finance.settings.accountsSetup.models.GlAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlAccountRepository extends JpaRepository<GlAccount, Long> {
}
