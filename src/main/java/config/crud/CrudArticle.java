package config.crud;

import entities.Article;

public class CrudArticle extends CrudOperation<Article, Long> {

    private static CrudArticle crudArticle;

    private CrudArticle() {
    }

    public static CrudArticle getInstance() {
        if (crudArticle == null)
            crudArticle = new CrudArticle();
        return crudArticle;
    }

    @Override
    protected Class<Article> getEntityClass() {
        return Article.class;
    }
}
