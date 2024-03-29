package pl.coderslab.Category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Article.Article;
import pl.coderslab.Article.ArticleDao;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryDao categoryDao;
    private final ArticleDao articleDao;
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryDao categoryDao, ArticleDao articleDao, CategoryRepository categoryRepository) {
        this.categoryDao = categoryDao;
        this.articleDao = articleDao;
        this.categoryRepository = categoryRepository;
    }


    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("category", new Category());
        return "addCategory";
    }

    @PostMapping("/add")
    public String addProcess(@ModelAttribute @Validated Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "addCategory";
        }
        categoryRepository.save(category);
        return "redirect:showAll";
    }

    @GetMapping("/showAll")
    public String showAll(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "showAllCategories";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Category category = categoryRepository.findAllById(id);
        model.addAttribute("category", category);
        return "addCategory";
    }

    @PostMapping("/edit/{id}")
    public String processEdit(@ModelAttribute @Validated Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "addCategory";
        }
        categoryRepository.save(category);
        return "redirect:../showAll";
    }

    @GetMapping("/confirmDelete/{id}")
    public String confirmDelete(@PathVariable Long id, Model model) {
        model.addAttribute("categoryId", id);
        return "confirmDeleteCategory";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        List<Article> articles = articleDao.findAll();
        for (Article article : articles) {
            List<Category> categories = article.getCategories();
            boolean check = categories.stream().
                    map(Category::getId).anyMatch(o -> o.equals(categoryDao.find(id).getId()));
            if (check) {
                return "deleteCategoryWarning";
            }
        }
        categoryRepository.deleteById(id);
        return "redirect:../showAll";
    }
}
