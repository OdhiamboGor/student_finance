package ke.ac.egerton.student_finance.settings.thirdParty.services;

import ke.ac.egerton.student_finance.settings.thirdParty.models.Category;
import ke.ac.egerton.student_finance.settings.thirdParty.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return null;
    }

    @Override
    public List<Category> getAllCategory() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(long id) {
        return this.categoryRepository.findOne(id);
    }

    @Override
    public Category getCategoryByCode(String code) {
        return null;
    }

    @Override
    public void deleteCategory(Long id) {

    }
}
