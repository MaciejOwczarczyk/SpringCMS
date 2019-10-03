package pl.coderslab.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public Author convert(String s) {
        Long id = Long.parseLong(s);
        return authorDao.find(id);
    }
}
