package ke.ac.egerton.student_finance.settings.thirdParty.repository;

import ke.ac.egerton.student_finance.settings.thirdParty.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByCode(String code);
}
