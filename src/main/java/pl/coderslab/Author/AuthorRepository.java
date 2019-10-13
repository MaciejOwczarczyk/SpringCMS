package pl.coderslab.Author;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author save(Author author);
    Author findAllById(Long id);
    List<Author> findAll();
    void deleteById(Long id);
}
