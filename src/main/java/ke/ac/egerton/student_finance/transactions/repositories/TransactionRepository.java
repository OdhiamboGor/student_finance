package ke.ac.egerton.student_finance.transactions.repositories;

import ke.ac.egerton.models.dao.academic.filters.Filterable;
import ke.ac.egerton.student_finance.filters.TransactionFilter;
import ke.ac.egerton.student_finance.settings.thirdParty.models.ThirdParty;
import ke.ac.egerton.student_finance.transactions.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>, Filterable<TransactionFilter, Transaction> {

    Transaction findByEntryNo (String e);

    Transaction findTopByDocNoIgnoreCase(String var1);
}
