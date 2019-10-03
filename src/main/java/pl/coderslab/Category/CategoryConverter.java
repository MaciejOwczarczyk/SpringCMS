package pl.coderslab.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class CategoryConverter implements Converter<String, Category> {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category convert(String s) {
        Long id = Long.parseLong(s);
        return categoryDao.find(id);
    }
}
