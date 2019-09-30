package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Article.Article;
import pl.coderslab.Article.ArticleDao;

import java.util.List;

@Controller
public class HomePageController {


    private final ArticleDao articleDao;

    public HomePageController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }


    @RequestMapping("/article")
    @ResponseBody
    public String lastFiveArticles() {
        List<Article> articles = articleDao.findLastFive();
        return articles.toString();
    }
}
