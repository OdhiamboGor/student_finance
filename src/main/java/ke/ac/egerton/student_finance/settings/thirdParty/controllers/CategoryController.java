package ke.ac.egerton.student_finance.settings.thirdParty.controllers;

import ke.ac.egerton.student_finance.settings.thirdParty.models.Category;
import ke.ac.egerton.student_finance.settings.thirdParty.repository.CategoryRepository;
import ke.ac.egerton.student_finance.settings.thirdParty.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "settings/category")
public class CategoryController {

    //Autowired Repositories
    @Autowired
    CategoryRepository categoryRepository;

    //Autowired Services
    @Autowired
    CategoryService categoryService;

    @RequestMapping(path ="categoryList", method = RequestMethod.GET)
    public String categoryList(Model model){
        List<Category> category = categoryRepository.findAll();
        model.addAttribute("category", category);
        return "settings/thirdParty/category";
    }

    @RequestMapping(path = "addCategory", method = RequestMethod.GET)
    public String addCategory(){
        return "/settings/thirdParty/addCategory";
    }

    @RequestMapping(value = "addCategory", method = RequestMethod.POST)
    public String saveCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "/settings/category/addCategory";
        }
        model.addAttribute("category", new Category());

        categoryService.saveCategory(category);
        return "redirect:/settings/category/categoryList";
    }

    @RequestMapping(path="/editCategory/{id}", method = RequestMethod.GET)
    public String editCategory(@PathVariable("id") long id, Model model){
        Category category = categoryRepository.findOne(id);
        model.addAttribute("category", category);
        return "settings/thirdParty/editCategory";
    }

    @RequestMapping(path="editCategory/{id}", method = RequestMethod.POST)
    public String updateCategory(@PathVariable("id") long id, @Valid Category category, BindingResult result, Model model){

        if (result.hasErrors()) {
            category.setId(id);
            return "/settings/category/editCategory";
        }
        categoryService.saveCategory(category);
        return "redirect:/settings/category/categoryList";

    }
}
