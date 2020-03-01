package ke.ac.egerton.student_finance.settings.period.repositories;

import ke.ac.egerton.student_finance.settings.period.models.SFPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SFPeriodRepository extends JpaRepository<SFPeriod, Long> {
}
