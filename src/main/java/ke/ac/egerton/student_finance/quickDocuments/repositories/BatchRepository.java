package ke.ac.egerton.student_finance.quickDocuments.repositories;

import ke.ac.egerton.student_finance.quickDocuments.models.Batches;
import ke.ac.egerton.student_finance.receipting.models.ReceiptBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchRepository extends JpaRepository<Batches, Long> {

    @Query(value="select * from SFINVBT u where u.POSTED = '0' ORDER BY u.BATCHDATE DESC" , nativeQuery = true)
    List<Batches> findByPostFalse();
}
