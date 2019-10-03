package pl.coderslab.Article;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.Author.Author;
import pl.coderslab.Author.AuthorDao;
import pl.coderslab.Category.Category;
import pl.coderslab.Category.CategoryDao;

import java.util.List;

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

}
