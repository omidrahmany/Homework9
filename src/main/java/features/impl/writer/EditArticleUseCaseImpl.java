package features.impl.writer;

import config.HibernateUtil;
import config.crud.CrudArticle;
import entities.Article;
import entities.User;
import features.GetNewEntity;
import features.usecase.writer.EditArticleUseCase;

import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class EditArticleUseCaseImpl implements EditArticleUseCase {
    private User user;

    public EditArticleUseCaseImpl(User user) {
        this.user = user;
    }

    @Override
    public void edit() {
        Article article;
        Scanner input = new Scanner(System.in);
        System.out.println("The articles following haven't been published yet.");
        outer:
        while (true) {
            String hql = "from Article a where a.isPublished=false and a.user.userName=:userName";
            Query query = HibernateUtil.getSession().createQuery(hql);
            query.setParameter("userName", this.user.getUserName());


            List<Article> list = query.getResultList();
            article = GetNewEntity.getNewArticle(
                    "Which article would you like to edit?\n" +
                            "Please enter its id.", list
            );
            System.out.println(article);
            inner:
            while (true) {
                while (true) {
                    System.out.println("0: Title\n1: Brief\n2: Content\n3: Exit");
                    String dec = input.next();
                    if (dec.equals("0")) {
                        System.out.println("Enter new title:");
                        String title = input.next();
                        article.setTitle(title);
                        break;
                    } else if (dec.equals("1")) {
                        System.out.println("Enter new brief:");
                        String brief = input.next();
                        article.setBrief(brief);
                        break;
                    } else if (dec.equals("2")) {
                        System.out.println("Enter new content:");
                        String content = input.next();
                        article.setContent(content);
                        break;
                    } else if (dec.equals("3")) break inner;
                    else System.out.println("invalid number\n" +
                                "please enter again.");
                }
                System.out.println("would you like to edit some sections of this article?\n1: Yes\n2: No");
                String str = input.next();
                while(true) {
                    if (str.equals("1")) {
                        System.out.println(article);
                        continue inner;
                    }
                    else if (str.equals("2")) break inner;
                    else System.out.println("Invalid number!\nPlease try again...");
                }

            }// inner loop
            CrudArticle.getInstance().update(article);
            System.out.println("would you like to edit another article?\n1: Yes\n2: No");
            String str = input.next();
            while(true) {
                if (str.equals("1")) {
//                    System.out.println(article);
                    continue outer;
                }
                else if (str.equals("2")) break outer;
                else System.out.println("Invalid number!\nPlease try again...");
            }

        }// outer loop

    }
}
