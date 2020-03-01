package ke.ac.egerton.student_finance.settings.thirdParty.repository;

import ke.ac.egerton.models.Staff;
import ke.ac.egerton.models.Student;
import ke.ac.egerton.models.dao.StaffFilter;
import ke.ac.egerton.models.dao.academic.filters.Filterable;
import ke.ac.egerton.student_finance.filters.ThirdPartyFilter;
import ke.ac.egerton.student_finance.settings.thirdParty.models.ThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThirdPartyRepository extends JpaRepository<ThirdParty, Long>, Filterable<ThirdPartyFilter, ThirdParty> {
    ThirdParty findByCode (String entryNo);

    ThirdParty findTopByCodeIgnoreCase(String var1);

    List<ThirdParty> findByCategory(String category);
}
