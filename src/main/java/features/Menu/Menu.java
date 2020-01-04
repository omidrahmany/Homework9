package features.Menu;

import entities.User;
import features.impl.admin.PublishArticleByAdminImpl;

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
                        new PublishArticleByAdminImpl();
                    }else if (dec.equals("2")) {

                    }else if (dec.equals("3")) {

                    }else if (dec.equals("4")) {

                    }else if (dec.equals("5")) {

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
                    if (scanner.equals("1")) {

                    }else if(scanner.equals("2")){

                    }

                }
            }
            //  admin and writer menu
        } else {

        }

    }// end of show method
}
