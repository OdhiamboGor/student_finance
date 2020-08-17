package ke.ac.egerton.student_finance.invoicing.repositories;

import ke.ac.egerton.models.dao.academic.filters.Filterable;
import ke.ac.egerton.student_finance.filters.VerifyDocumentsFilter;
import ke.ac.egerton.student_finance.invoicing.models.VerifyDocuments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VerifyDocumentsRepository extends JpaRepository<VerifyDocuments, String>, Filterable<VerifyDocumentsFilter, VerifyDocuments> {
    @Query(value = "select * from SFOBL where DOCSTATUS = 0", nativeQuery = true )
    List<VerifyDocuments> findTopByDocumentStatus();

    VerifyDocuments findByDocumentNumber(String documentNumber);

}
