package features.impl;

import entities.Article;
import entities.User;
import features.usecase.EditArticleUseCase;
import org.hibernate.Session;

import java.util.Scanner;

public class EditArticleUseCaseImpl implements EditArticleUseCase {
    Session session;
    User user;

    public EditArticleUseCaseImpl(Session session, User user) {
        this.session = session;
        this.user = user;
    }

    @Override
    public void edit() {
        Scanner input = new Scanner(System.in);
        new ShowMyArticleUseCaseImpl(this.session,this.user).showMyArticle();
        System.out.println("Which article would you like to publish?\n" +
                "Enter its id");
        long id = input.nextLong();
        Article article = session.load(Article.class,id);
        article.setPublished(true);
        session.update(article);

//        user.setPassword(newPass);
//        session.update(user);
    }
}
