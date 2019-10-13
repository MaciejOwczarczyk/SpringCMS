package pl.coderslab.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category save(Category category);
    void deleteById(Long id);
    List<Category> findAll();
    Category findAllById(Long id);
}
