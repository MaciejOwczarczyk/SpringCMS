package pl.coderslab.Article;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Author.Author;
import pl.coderslab.Author.AuthorDao;
import pl.coderslab.Category.Category;
import pl.coderslab.Category.CategoryDao;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;
    private final ArticleDao articleDao;


    public ArticleController(AuthorDao authorDao, CategoryDao categoryDao, ArticleDao articleDao) {
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
        this.articleDao = articleDao;
    }

    @ModelAttribute("categories")
    public List<Category> fetchAllCategory() {
        return categoryDao.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> fetchAllAuthors() {
        return authorDao.findAll();
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("article", new Article());
        return "addArticle";
    }

    @PostMapping("/add")
    public String addProcess(@ModelAttribute @Validated Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "addArticle";
        }
        article.prePersist();
        articleDao.save(article);
        return "redirect:showAll";
    }

    @GetMapping("/showAll")
    public String showAll(Model model) {
        List<Article> articles = articleDao.findAll();
        model.addAttribute("articles", articles);
        return "showAllArticles";
    }

    @GetMapping("/confirmDelete/{id}")
    public String confirmDelete(@PathVariable Long id, Model model) {
        model.addAttribute("articleId", id);
        return "confirmDeleteArticle";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        articleDao.delete(id);
        return "redirect:../showAll";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Article article = articleDao.find(id);
        model.addAttribute("article", article);
        return "addArticle";
    }

    @PostMapping("/edit/{id}")
    public String editProcess(@PathVariable Long id, @ModelAttribute @Validated Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "addArticle";
        }
        articleDao.update(article);
        return "redirect:../showAll";
    }

}
