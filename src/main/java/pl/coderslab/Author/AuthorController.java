package pl.coderslab.Author;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Article.Article;
import pl.coderslab.Article.ArticleDao;

import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorDao authorDao;
    private final ArticleDao articleDao;
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorDao authorDao, ArticleDao articleDao, AuthorRepository authorRepository) {
        this.authorDao = authorDao;
        this.articleDao = articleDao;
        this.authorRepository = authorRepository;
    }


    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("author", new Author());
        return "addAuthor";
    }

    @PostMapping("/add")
    public String processAdd(@ModelAttribute @Validated Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "addAuthor";
        }
        authorRepository.save(author);
        return "redirect:showAll";
    }

    @GetMapping("/showAll")
    public String showAll(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "showAllAuthors";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Author author = authorRepository.findAllById(id);
        model.addAttribute("author", author);
        return "addAuthor";
    }

    @PostMapping("/edit/{id}")
    public String processEdit(@PathVariable  Long id, @ModelAttribute @Validated Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "addAuthor";
        }
        authorRepository.save(author);
        return "redirect:../showAll";
    }

    @GetMapping("confirmDelete/{id}")
    public String confirmDelete(@PathVariable Long id, Model model){
        model.addAttribute("authorId", id);
        return "confirmDeleteAuthor";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        List<Article> articles = articleDao.findAll();
        for (Article article : articles) {
            if (article.getAuthor().getId() == authorDao.find(id).getId()) {
                return "deleteAuthorWarning";
            }
        }
        authorRepository.deleteById(id);
        return "redirect:../showAll";
    }
}
