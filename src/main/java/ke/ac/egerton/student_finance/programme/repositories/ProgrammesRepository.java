package ke.ac.egerton.student_finance.programme.repositories;

import ke.ac.egerton.models.academic.Programme;
import ke.ac.egerton.models.dao.academic.filters.Filterable;
import ke.ac.egerton.models.dao.academic.filters.ProgrammeFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgrammesRepository extends JpaRepository<Programme, String>{


   //List <Programme> findAllOrderByCodeAsc();
}
