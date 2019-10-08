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

@Controller
@RequestMapping("/draft")
public class DraftController {

    private final ArticleDao articleDao;
    private final CategoryDao categoryDao;
    private final AuthorDao authorDao;

    public DraftController(ArticleDao articleDao, CategoryDao categoryDao, AuthorDao authorDao) {
        this.articleDao = articleDao;
        this.categoryDao = categoryDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/showAll")
    public String showAll(Model model) {
        List<Article> articles = articleDao.findDrafts();
        model.addAttribute("articles", articles);
        return "showAllDraftArticles";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Article article = new Article();
        article.setDraft(true);
        model.addAttribute("article", article);
        return "addArticle";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute @Validated({DraftValidationGroup.class}) Article article, BindingResult result) {
        if (!article.isDraft()) {
            return "forward:/article/add";
        }
        if (result.hasErrors()) {
            return "addArticle";
        }
        article.setAuthor(null);
        articleDao.save(article);
        return "redirect:showAll";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Article article = articleDao.findWithCategories(id);
        model.addAttribute("article", article);
        return "addArticle";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute @Validated({DraftValidationGroup.class}) Article article, BindingResult result) {
        if (!article.isDraft()) {
            return "forward:/article/edit/" + id;
        }
        if (result.hasErrors()) {
            return "addArticle";
        }
        article.setAuthor(null);
        articleDao.update(article);
        return "redirect:../showAll";
    }

    @GetMapping("/confirmDelete/{id}")
    public String confirmDelete(@PathVariable Long id, Model model) {
        model.addAttribute("articleId", id);
        return "confirmDeleteDraft";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        articleDao.delete(id);
        return "redirect:../showAll";
    }

    @ModelAttribute("categories")
    public List<Category> fetchAllCategory() {
        return categoryDao.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> fetchAllAuthors() {
        return authorDao.findAll();
    }


}
