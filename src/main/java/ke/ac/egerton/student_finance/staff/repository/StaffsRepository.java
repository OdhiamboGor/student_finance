package ke.ac.egerton.student_finance.staff.repository;

import ke.ac.egerton.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffsRepository extends JpaRepository<Staff, Long> {

    Staff findByPayrollId(String payrollId);

}
