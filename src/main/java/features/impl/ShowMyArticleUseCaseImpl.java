package features.impl;

import entities.Article;
import entities.User;
import features.usecase.ShowUserArticleUseCase;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ShowMyArticleUseCaseImpl implements ShowUserArticleUseCase {
    Session session;
    User user;

    public ShowMyArticleUseCaseImpl(Session session, User user) {
        this.session = session;
        this.user = user;
    }

    @Override
    public void showMyArticle() {
        String username = user.getUserName();
        String hql = "from Article a where a.user.userName=:userName";

        Query query = session.createQuery(hql);
        query.setParameter("userName", username);
        List<Article> result = query.list();
        result.stream().forEach(System.out::println);
    }
}
