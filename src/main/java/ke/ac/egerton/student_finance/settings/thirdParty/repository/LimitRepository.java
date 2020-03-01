package ke.ac.egerton.student_finance.settings.thirdParty.repository;

import ke.ac.egerton.student_finance.settings.thirdParty.models.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LimitRepository extends JpaRepository<Limit, Long> {


}
