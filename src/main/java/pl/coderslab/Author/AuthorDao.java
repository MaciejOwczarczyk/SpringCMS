package pl.coderslab.Author;

import pl.coderslab.common.GenericDao;

public class AuthorDao extends GenericDao<Author> {

    public AuthorDao() {
        super(Author.class);
    }
}
