package ke.ac.egerton.student_finance.student.repository;

import ke.ac.egerton.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepository extends JpaRepository<Student, Long> {
    Student findByAccountNumber(String accountNumber);

    @Query(value = "select * from ACSTUDENTS a where a.OPTF9 = :category", nativeQuery = true)
    List<Student> findOptF9(String category);
}
