package uz.pdp.libraryapp2.controller;


import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.libraryapp2.dao.CategoryDao;
import uz.pdp.libraryapp2.model.Category;

@Controller
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryDao categoryDao;


    @GetMapping
    public String getAllCategories(Model model) {

        model.addAttribute("categories", categoryDao.getAllCategoriesFromDb());
        return "category/view-category-form";
    }

    @GetMapping("/get-form")
    public String getCategoryForm() {
        return "category/add-category-form";
    }

    @SneakyThrows
    @PostMapping
    public String addNewCategory(Category category) {
        try {
            categoryDao.addNewCategory(category);
            return "redirect:/categories";

        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalAccessException("Something went wrong...");
        }


    }

    @GetMapping("/edit/{id}")
    public String getFormForEditCategory(@PathVariable Integer id, Model model) {

        Category categoryById = categoryDao.getCategoryById(id);
        model.addAttribute("muallif", categoryById);
        return "category/edit-category-form";

    }


    @PostMapping("/edit")
    public String editCategoryById(Category category) {
        try {
            categoryDao.editCategory(category);
            return "redirect:/categories";
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteCategoryById(@PathVariable Integer id) {
        try {
            categoryDao.deleteCategoryById(id);
            return "redirect:/categories";
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
