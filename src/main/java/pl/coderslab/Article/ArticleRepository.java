package pl.coderslab.Article;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findAllByDraft(Boolean draft);

    Article findAllByDraftAndId(Boolean draft, Long id);

    Article save(Article article);

    void deleteById(Long id);



}
