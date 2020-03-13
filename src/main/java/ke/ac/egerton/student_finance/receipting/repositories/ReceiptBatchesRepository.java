package ke.ac.egerton.student_finance.receipting.repositories;

import ke.ac.egerton.models.dao.academic.filters.Filterable;
import ke.ac.egerton.student_finance.filters.ReceiptBatchFilter;
import ke.ac.egerton.student_finance.receipting.models.ReceiptBatch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptBatchesRepository extends JpaRepository<ReceiptBatch, String>, Filterable<ReceiptBatchFilter, ReceiptBatch> {
   /* ReceiptBatch findTopByBatchId(String var1);
    ReceiptBatch findTopById(Long var1);*/
}
