package pl.coderslab.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }


    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("author", new Author());
        return "addAuthor";
    }

    @PostMapping("/add")
    public String processAdd(@ModelAttribute Author author) {
        authorDao.save(author);
        return "redirect:showAll";
    }

    @GetMapping("/showAll")
    public String showAll(Model model) {
        model.addAttribute("authors", authorDao.findAll());
        return "showAllAuthors";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Author author = authorDao.find(id);
        model.addAttribute("author", author);
        return "addAuthor";
    }

    @PostMapping("/edit/{id}")
    public String processEdit(@ModelAttribute Author author, Long id) {
        authorDao.update(author);
        return "redirect:../showAll";
    }

    @GetMapping("confirmDelete/{id}")
    public String confirmDelete(@PathVariable Long id, Model model){
        model.addAttribute("authorId", id);
        return "confirmAuthorDelete";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        authorDao.delete(id);
        return "redirect:../showAll";
    }
}
