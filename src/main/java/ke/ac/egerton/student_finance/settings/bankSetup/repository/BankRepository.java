package ke.ac.egerton.student_finance.settings.bankSetup.repository;

import ke.ac.egerton.student_finance.settings.bankSetup.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

    Bank findTopByCode(String code);
}
