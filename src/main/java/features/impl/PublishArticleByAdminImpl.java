package features.impl;

import config.HibernateUtil;
import entities.Article;
import entities.User;
import features.usecase.PublishArticleByAdminUseCase;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class PublishArticleByAdminImpl implements PublishArticleByAdminUseCase {

    @Override
    public void publishArticle() {
        Scanner input = new Scanner(System.in);
        HibernateUtil.getSession().beginTransaction();
        String hql = "from Article u where u.isPublished=false";
        Query query = HibernateUtil.getSession().createQuery(hql);
        List<User> result = query.list();
        result.forEach(System.out::println);
        System.out.println("Enter article id to publish:");
        long articleId = input.nextLong();
        Article article = HibernateUtil.getSession().load(Article.class,articleId);
        System.out.println(article);
       HibernateUtil.getSession().getTransaction().commit();
    }
}
