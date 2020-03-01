package ke.ac.egerton.student_finance.settings.accountsSetup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ke.ac.egerton.student_finance.settings.accountsSetup.models.SegmentCode;

@Repository
public interface SegmentCodeRepository extends JpaRepository<SegmentCode, Long>{

    SegmentCode findByCode(String code);
}
