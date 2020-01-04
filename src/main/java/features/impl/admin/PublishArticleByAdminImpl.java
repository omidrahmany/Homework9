package features.impl.admin;

import config.HibernateUtil;
import config.crud.CrudArticle;
import entities.Article;
import entities.User;
import features.usecase.admin.PublishArticleByAdminUseCase;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class PublishArticleByAdminImpl implements PublishArticleByAdminUseCase {

    @Override
    public void publishArticle() {
        Scanner input = new Scanner(System.in);
//        HibernateUtil.getSession().beginTransaction();
        String hql = "from Article u where u.isPublished=false";
        Query query = HibernateUtil.getSession().createQuery(hql);
        List<Article> result = query.list();
        result.forEach(System.out::println);
        System.out.println("Enter article id to publish:");
        long articleId = input.nextLong();
        Article article = CrudArticle.getInstance().findById(articleId);
        article.setPublished(true);
        CrudArticle.getInstance().update(article);
//    HibernateUtil.getSession().getTransaction().commit();
    }
}
