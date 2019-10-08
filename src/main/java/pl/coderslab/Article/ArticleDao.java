package pl.coderslab.Article;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.Author.Author;
import pl.coderslab.common.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArticleDao extends GenericDao<Article> {

    @PersistenceContext
    EntityManager entityManager;

    public ArticleDao() {
        super(Article.class);
    }

    @Transactional
    public List<Article> findLastFive() {
        Query query = entityManager.createQuery("select b from Article b order by b.createdOn desc");
        List<Article> articles= query.setMaxResults(5).getResultList();
        return articles;
    }

    @Transactional
    public List<Article> findDrafts() {
        Query query = entityManager.createQuery("select  b from Article b where b.draft = true");
        List<Article> articles = query.getResultList();
        return articles;
    }

    @Transactional
    public Article findWithCategories(Long id) {
        Article article = entityManager.find(Article.class, id);
        Hibernate.initialize(article.getCategories());
        return article;
    }

    @Transactional
    public List<Article> findAllNoneDraft() {
        Query query = entityManager.createQuery("select b from Article b where b.draft = false");
        List<Article> articles = query.getResultList();
        return articles;

    }


}
