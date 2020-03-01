package ke.ac.egerton.student_finance.settings.feeSetup.repositories;

import ke.ac.egerton.student_finance.settings.feeSetup.models.ChargeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargeTypeRepository extends JpaRepository<ChargeType, Long> {
}
