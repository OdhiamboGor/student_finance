package ke.ac.egerton.student_finance.settings.coreSetup.repository;

import ke.ac.egerton.student_finance.receipting.models.Receipt;
import ke.ac.egerton.student_finance.settings.coreSetup.models.StudentRestriction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRestrictionRepository extends JpaRepository<StudentRestriction, Long> {

    @Query(value="SELECT * from SFRESTRICT ORDER " , nativeQuery = true)
    StudentRestriction findByCode();

    //@Query(value = "select distinct on (s.code) s.* from SFRESTRICT s order by s.code", nativeQuery = true)
    //public List<StudentRestriction> getRestrictions();

    @Query(value = "SELECT * FROM SFRESTRICT  ORDER BY TRANSCODE", nativeQuery = true)
    List <StudentRestriction> findByRestrictions();
}
