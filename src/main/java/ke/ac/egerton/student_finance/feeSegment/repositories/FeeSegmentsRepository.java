package ke.ac.egerton.student_finance.feeSegment.repositories;

import ke.ac.egerton.models.dao.academic.filters.Filterable;
import ke.ac.egerton.student_finance.feeSegment.models.FeeSegment;
import ke.ac.egerton.student_finance.filters.FeeSegmentFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeSegmentsRepository extends JpaRepository<FeeSegment, Long>,Filterable<FeeSegmentFilter, FeeSegment> {
}
