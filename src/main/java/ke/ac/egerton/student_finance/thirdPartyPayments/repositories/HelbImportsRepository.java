package ke.ac.egerton.student_finance.thirdPartyPayments.repositories;

import ke.ac.egerton.student_finance.thirdPartyPayments.models.HelbImports;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelbImportsRepository extends CrudRepository <HelbImports, Long> {
}
