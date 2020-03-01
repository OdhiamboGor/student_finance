package ke.ac.egerton.student_finance.settings.currency.repository;

import ke.ac.egerton.student_finance.settings.currency.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
}
