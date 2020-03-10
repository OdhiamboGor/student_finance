package ke.ac.egerton.student_finance.invoicing.repositories;

import ke.ac.egerton.student_finance.invoicing.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findBySemesterCodeAndCampusCodeAndProgrammeCodeAndAcademicYearAndChtCodeAndSegCode(String sesss, String campusCode,String program, String acYear, String cHort, String fseg);


    List<Invoice> findByAcademicYearAndCampusCodeAndSemesterCodeAndSegCodeAndApprovedFalseAndStatusIsNull(String acYear, String campusCode,String sesss,String segCode);

    Optional<Invoice> findById(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE SFINVC s SET s.STATUS =:status WHERE s.id =:id", nativeQuery = true)
    void updateInvoice(@Param("status") String status, @Param("id") long id);


    List<Invoice> Id(Long id);
}
