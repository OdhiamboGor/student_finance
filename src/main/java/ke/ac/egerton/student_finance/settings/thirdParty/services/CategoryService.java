package ke.ac.egerton.student_finance.settings.thirdParty.services;

import ke.ac.egerton.student_finance.settings.thirdParty.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    Category saveCategory(Category category);

    Category updateCategory(Category category);

    List< Category > getAllCategory();

    Category getCategoryById(long id);

    Category getCategoryByCode(String code);

    void deleteCategory(Long id);
}
