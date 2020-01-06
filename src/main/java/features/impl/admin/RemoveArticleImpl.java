package features.impl.admin;

import config.crud.CrudArticle;
import entities.Article;
import features.GetNewEntity;
import features.usecase.admin.RemoveArticleUseCase;

public class RemoveArticleImpl implements RemoveArticleUseCase {
    @Override
    public void remove() {

        Article article = GetNewEntity.getNewArticle("Enter article id to remove:");

        CrudArticle.getInstance().remove(article);
        System.out.println("the article is removed successfully.");
    }
}
