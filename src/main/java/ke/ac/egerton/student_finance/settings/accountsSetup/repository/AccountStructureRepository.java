package ke.ac.egerton.student_finance.settings.accountsSetup.repository;

import ke.ac.egerton.student_finance.settings.accountsSetup.models.AccountStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountStructureRepository extends JpaRepository<AccountStructure, Long> {
}
