package pl.coderslab.Author;

import org.springframework.stereotype.Repository;
import pl.coderslab.common.GenericDao;

import javax.transaction.Transactional;

@Repository
@Transactional
public class AuthorDao extends GenericDao<Author> {

    public AuthorDao() {
        super(Author.class);
    }
}
