package pl.coderslab.Article;


import pl.coderslab.Author.Author;
import pl.coderslab.Category.Category;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(groups = {ArticleValidationGroup.class, DraftValidationGroup.class})
    @Size(max = 200, groups = {ArticleValidationGroup.class, DraftValidationGroup.class})
    private String title;

    @NotNull(groups = {ArticleValidationGroup.class})
    @OneToOne
    private Author author;

    @NotEmpty(groups = {ArticleValidationGroup.class})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Category> categories;

    @NotBlank(groups = {ArticleValidationGroup.class, DraftValidationGroup.class})
    @ContentLength(groups = {ArticleValidationGroup.class, DraftValidationGroup.class})
    private String content;

    private boolean draft;

    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;


    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedOn = LocalDateTime.now();
    }

    public boolean isDraft() {
        return draft;
    }

    public void setDraft(boolean draft) {
        this.draft = draft;
    }

    public Article() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String toString() {
        if (content.length() > 200 ){
            return title + "   " +  content.substring(0,200) + "  " + createdOn;
        }
        return title + "   " +  content.substring(0,2) + "  " + createdOn;
    }
}