package ke.ac.egerton.student_finance.settings.feeSetup.repositories;

import ke.ac.egerton.student_finance.settings.feeSetup.models.FeeStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeStructureRepository extends JpaRepository<FeeStructure, Long> {
}
