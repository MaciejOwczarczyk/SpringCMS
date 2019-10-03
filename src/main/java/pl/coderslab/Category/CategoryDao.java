package pl.coderslab.Category;

import org.springframework.stereotype.Repository;
import pl.coderslab.common.GenericDao;

import javax.transaction.Transactional;

@Repository
@Transactional
public class CategoryDao extends GenericDao<Category> {

    public CategoryDao() {
        super(Category.class);
    }
}
