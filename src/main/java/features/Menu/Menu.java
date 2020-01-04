package features.Menu;

import entities.User;
import features.impl.admin.PublishArticleByAdminImpl;
import features.impl.admin.AddNewCategoryImpl;
import features.impl.admin.AddNewTagImpl;
import features.impl.writer.AddNewArticleImpl;
import features.impl.writer.ChangePasswordUseCaseImpl;

import java.util.Scanner;

public class Menu {
    User user;

    public Menu(User user) {
        this.user = user;
    }

    public void Show() {
        String dec;
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------------------");
        if (user.getRoles().size() == 1) {

            //  admin menu
            if (user.getRoles().get(0).getTitle().equals("admin")) {
                System.out.println("\t********** Admin Menu **********");
                while (true) {
                    System.out.println(
                                    "\t+-------------------------------+\n"+
                                    "\t|1: Publish user's article      |\n" +
                                    "\t|2: Don't publish user's article|\n" +
                                    "\t|3: Remove article              |\n" +
                                    "\t|4: Add new category            |\n" +
                                    "\t|5: Add new tag                 |\n" +
                                    "\t|6: Show all articles           |\n" +
                                    "\t|7: Change user's role          |\n"+
                                    "\t|8: Exit                        |\n"+
                                    "\t+-------------------------------+\n"
                    );
                     dec = scanner.next();
                    if (dec.equals("1")) {
                        new PublishArticleByAdminImpl().publishArticle();
                    }else if (dec.equals("2")) {

                    }else if (dec.equals("3")) {

                    }else if (dec.equals("4")) {
                        new AddNewCategoryImpl().addNewCategory();
                    }else if (dec.equals("5")) {
                        new AddNewTagImpl().addNewTag();
                    }else if (dec.equals("6")) {

                    }else if (dec.equals("7")) {

                    }else return;

                }
                // writer menu
            } else {
                while (true) {
                    System.out.println(
                                    "\t+----------------------+\n" +
                                    "\t|1: Add new article    |\n" +
                                    "\t|2: Edit my article    |\n" +
                                    "\t|3: Show my article(s) |\n" +
                                    "\t|4: Change the password|\n" +
                                    "\t|5: Logout             |\n" +
                                    "\t+----------------------+\n"
                    );
                    dec = scanner.next();
                    if (dec.equals("1")) {
                        new AddNewArticleImpl(user).addNewArticle();
                    }else if(dec.equals("2")){

                    }else if(dec.equals("3")){

                    }else if(dec.equals("4")){
                        new ChangePasswordUseCaseImpl(user).changeMyPassword();
                    }else if(dec.equals("5")){
                        user = null;
                        return;
                    }

                }
            }
            //  admin and writer menu
        } else {

        }

    }// end of show method
}
