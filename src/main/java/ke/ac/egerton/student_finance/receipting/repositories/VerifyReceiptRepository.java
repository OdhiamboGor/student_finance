package ke.ac.egerton.student_finance.receipting.repositories;

import ke.ac.egerton.student_finance.receipting.models.VerifyReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VerifyReceiptRepository extends JpaRepository<VerifyReceipt, Long> {

    @Query(value="select * from SFRCHEADER u where u.BATCHID = :batchId AND u.POSTED = 0" , nativeQuery = true)
    List<VerifyReceipt> findAllByBatchId(@Param("batchId") String batchId);

    @Query(value="select sum(u.RCAMOUNT) from SFRCHEADER u where u.BATCHID = :batchId AND u.POSTED = 0" , nativeQuery = true)
    Float selectTotals(@Param("batchId") String batchId);

    VerifyReceipt findById(Long var);



}
