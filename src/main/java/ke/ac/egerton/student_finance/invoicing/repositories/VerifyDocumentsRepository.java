package ke.ac.egerton.student_finance.invoicing.repositories;

import ke.ac.egerton.models.Student;
import ke.ac.egerton.models.dao.academic.filters.Filterable;
import ke.ac.egerton.student_finance.filters.VerifyDocumentsFilter;
import ke.ac.egerton.student_finance.invoicing.models.VerifyDocuments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerifyDocumentsRepository extends JpaRepository<VerifyDocuments, Long>, Filterable<VerifyDocumentsFilter, VerifyDocuments> {
    Student findTopByDocumentNumberIgnoreCase(String var1);

}
