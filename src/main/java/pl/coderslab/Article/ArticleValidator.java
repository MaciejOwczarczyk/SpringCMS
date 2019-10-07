package pl.coderslab.Article;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ArticleValidator implements ConstraintValidator<ContentLength, String> {

    @Override
    public void initialize(ContentLength constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.length() > 10;
    }
}
