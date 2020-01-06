package features.impl.admin;

import config.crud.CrudArticle;
import config.crud.CrudTag;
import entities.Article;
import entities.Tag;
import features.GetNewEntity;
import features.usecase.admin.AssignSomeTagUseCase;

import java.util.Scanner;

public class AssignSomeTagImpl implements AssignSomeTagUseCase {
    @Override
    public void assign() {
        Scanner input = new Scanner(System.in);
//        Article article=null;
        String id;
//        long articleId=0;
        boolean status = true;
        outer:
        while (true) {
            Article article = GetNewEntity.getNewArticle("Enter an article id to add some tag:");
            System.out.println("------------------------------------");
            Tag tag;
            status=true;
            long tagId;
            inner:
            while (true) {

                tag = GetNewEntity.getNewTag("Enter a tag id to assign in the article: ");
                article.getTags().add(tag);
                CrudArticle.getInstance().save(article);
                System.out.println("Would you like to assign another tag in the article?\n" +
                        "1: Yes\n" +
                        "2: No");
                while (true) {
                    String dec = input.next();
                    if (dec.equals("1")) continue inner;
                    else if (dec.equals("2")) break inner;
                    else System.out.println("invalid number!");
                }
            } // end of inner while loop
            System.out.println("Would you like to select another article to assign some tag?\n" +
                    "1: Yes\n" +
                    "2: No");
            while (true) {
                String dec = input.next();
                if (dec.equals("1")) continue outer;
                else if (dec.equals("2")) break outer;
                else System.out.println("invalid number!");
            }
        }//end of outer while loop
    }
}
