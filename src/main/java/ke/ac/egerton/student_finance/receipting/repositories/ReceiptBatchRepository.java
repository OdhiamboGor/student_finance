package ke.ac.egerton.student_finance.receipting.repositories;

import ke.ac.egerton.student_finance.receipting.models.ReceiptBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReceiptBatchRepository extends JpaRepository<ReceiptBatch, Long> {

    ReceiptBatch findByStaff(String userId);

    ReceiptBatch findByStaff_PayrollIdAndBatchDateAndStatus(String userId, Date batchDate, Boolean status);

    @Query(value="select * from SFRCBATCH u where u.RDPOST = '0' ORDER BY u.BATCHDATE DESC" , nativeQuery = true)
    List<ReceiptBatch> findByPostFalse();

    ReceiptBatch findByBatchId(String batchId);

}
