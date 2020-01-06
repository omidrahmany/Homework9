package features.impl.admin;

import config.HibernateUtil;
import config.crud.CrudArticle;
import entities.Article;
import features.GetNewEntity;
import features.usecase.admin.PublishingArticleStatusByAdminUseCase;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class PublishingArticleStatusByAdminImpl implements PublishingArticleStatusByAdminUseCase {

    @Override
    public void publishOrNotArticle() {
        Scanner input = new Scanner(System.in);
        String hql;
        String dec;

        while (true) {

            System.out.println("1: Publish some article\n" +
                    "2: Don't publish some article\n" +
                    "3: Exit");
             dec = input.next();
            if (dec.equals("1")) {
                hql = "from Article u where u.isPublished=false";
                break;
            } else if (dec.equals("2")) {
                hql = "from Article u where u.isPublished=true";
                break;
            } else System.out.println("invalid number!");
        }
        Query query = HibernateUtil.getSession().createQuery(hql);
        List<Article> resultList = query.list();
        Article article = GetNewEntity.getNewArticle("Enter article id:",resultList);

        if (dec.equals("1")) article.setPublished(true);
        else if(dec.equals("2")) article.setPublished(false);

        CrudArticle.getInstance().update(article);
        System.out.println("The action is done successfully.");
    }
}
