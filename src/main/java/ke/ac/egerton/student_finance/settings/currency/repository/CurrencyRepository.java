package ke.ac.egerton.student_finance.settings.currency.repository;

import ke.ac.egerton.student_finance.settings.currency.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Currency findByCode(String code);
}
