package features.Menu;

import config.crud.CrudArticle;
import entities.User;
import features.impl.admin.*;
import features.impl.writer.AddNewArticleImpl;
import features.impl.writer.ChangePasswordUseCaseImpl;
import features.impl.writer.EditArticleUseCaseImpl;

import java.util.Scanner;

public class Menu {
   private User user;

    public Menu(User user) {
        this.user = user;
    }

    public void show() {
        String dec;
        Scanner scanner = new Scanner(System.in);
        outer:while(true) {
            System.out.println("------------------------------");
            if (user.getRoles().size() == 1) {

                //  admin menu
                if (user.getRoles().get(0).getTitle().equals("admin")) {
                    System.out.println("\t************ Admin Menu ************");
                    while (true) {
                        System.out.println(
                                "\t+-------------------------------------+\n" +
                                        "\t|1: Publish (or don't) user's articles|\n" +
                                        "\t|2: Remove some article               |\n" +
                                        "\t|3: Add new category                  |\n" +
                                        "\t|4: Show all articles                 |\n" +
                                        "\t|5: Change user's role                |\n" +
                                        "\t|6: Add new tag                       |\n" +
                                        "\t|7: Assign some tag in some article   |\n" +
                                        "\t|8: Logout                            |\n" +
                                        "\t+-------------------------------------+\n"
                        );
                        dec = scanner.next();
                        if (dec.equals("1")) {
                            new PublishingArticleStatusByAdminImpl().publishOrNotArticle();
                        } else if (dec.equals("2")) {
                            new RemoveArticleImpl().remove();
                        } else if (dec.equals("3")) {
                            new AddNewCategoryImpl().addNewCategory();
                        } else if (dec.equals("4")) {
                            CrudArticle.getInstance().findAll().forEach(System.out::println);
                        } else if (dec.equals("5")) {
                            new ChangeRoleImpl().changeRole();
                            continue outer;
                        } else if (dec.equals("6")) {
                            new AddNewTagImpl().addNewTag();
                        } else if (dec.equals("7")) {
                            new AssignSomeTagImpl().assign();
                        } else if (dec.equals("8")) {
                            break outer;
                        } else System.out.println("invalid number");
                        ;

                    }
                    // writer menu
                } else {
                    while (true) {
                        System.out.println("\t******** Writer Menu ********");
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
                        } else if (dec.equals("2")) {
                            new EditArticleUseCaseImpl(user).edit();
                        } else if (dec.equals("3")) {
                            CrudArticle.
                                    getInstance().
                                    findAll().
                                    stream().
                                    filter(e -> e.getUser().getUserName().equals(user.getUserName())).
                                    forEach(System.out::println);
                        } else if (dec.equals("4")) {
                            new ChangePasswordUseCaseImpl(user).changeMyPassword();
                        } else if (dec.equals("5")) {
                            break outer;
                        }

                    }
                }
                //  admin and writer menu
            } else {
                while (true) {
                    System.out.println("\t********** Admin & Writer Menu **********");

                    System.out.println(
                            "\t+--------------------------------------+\n" +
                                    "\t|1:  Publish (or don't) user's articles|\n" +
                                    "\t|2:  Remove some article               |\n" +
                                    "\t|3:  Add new category                  |\n" +
                                    "\t|4:  Show all articles                 |\n" +
                                    "\t|5:  Change user's role                |\n" +
                                    "\t|6:  Add new tag                       |\n" +
                                    "\t|7:  Assign some tag in some article   |\n" +
                                    "\t|8:  Add new article                   |\n" +
                                    "\t|9:  Edit my article                   |\n" +
                                    "\t|10: Show my article(s)                |\n" +
                                    "\t|11: Change the password               |\n" +
                                    "\t|12: Logout                            |\n" +
                                    "\t+--------------------------------------+\n"
                    );
                    dec = scanner.next();
                    if (dec.equals("1")) {
                        new PublishingArticleStatusByAdminImpl().publishOrNotArticle();
                    } else if (dec.equals("2")) {
                        new RemoveArticleImpl().remove();
                    } else if (dec.equals("3")) {
                        new AddNewCategoryImpl().addNewCategory();
                    } else if (dec.equals("4")) {
                        CrudArticle.getInstance().findAll().forEach(System.out::println);
                    } else if (dec.equals("5")) {
                        new ChangeRoleImpl().changeRole();
//                        this.show();
                        continue outer;
                    } else if (dec.equals("6")) {
                        new AddNewTagImpl().addNewTag();
                    } else if (dec.equals("7")) {
                        new AssignSomeTagImpl().assign();
                    } else if (dec.equals("8")) {
                        new AddNewArticleImpl(user).addNewArticle();
                    } else if (dec.equals("9")) {
                        new EditArticleUseCaseImpl(user).edit();
                    } else if (dec.equals("10")) {
                        CrudArticle.
                                getInstance().
                                findAll().
                                stream().
                                filter(e -> e.getUser().getUserName().equals(user.getUserName())).
                                forEach(System.out::println);
                    } else if (dec.equals("11")) {
                        new ChangePasswordUseCaseImpl(user).changeMyPassword();
                    } else if (dec.equals("12")) {
                        break outer;
                    } else System.out.println("invalid number");


                }

            }
        }

    }// end of show method
}
