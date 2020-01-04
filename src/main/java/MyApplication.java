import config.HibernateUtil;
import config.crud.CrudRoles;
import config.crud.CrudUser;
import entities.User;
import features.Menu.Menu;
import features.impl.LoginUseCaseImpl;
import features.impl.SignUpUseCaseImpl;

import java.util.Scanner;

public class MyApplication {
    public static void main(String[] args) {
        HibernateUtil.getSession().beginTransaction();
        HibernateUtil.getSession().getTransaction().commit();

        // Creating Roles
        /*Role adminRole = new Role();
        adminRole.setTitle("admin");

        Role writerRole = new Role();
        writerRole.setTitle("writer");*/

        CrudRoles crudRoles = CrudRoles.getInstance();
//        crudRoles.save(adminRole);
//        crudRoles.save(writerRole);


        CrudUser crudUser = CrudUser.getInstance();

        // Definition of admin user
        /*Session session = HibernateUtil.getSession();
        User admin = new User();
        admin.setUserName("admin");
        admin.setPassword("admin");
        session.beginTransaction();
        session.save(admin);
        session.getTransaction().commit();*/

        // set admin role to admin user
        /*User adminUser = crudUser.findById(1L);
        Role adminRole = crudRoles.findById(1L);
        adminUser.getRoles().add(adminRole);
        crudUser.save(adminUser);*/


        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println(
                    "\t+--------------------+\n" +
                    "\t|1: Sign up          |\n" +
                    "\t|2: Login            |\n" +
                    "\t|3: Show All Articles|\n" +
                    "\t|4: Exit             |\n"+
                    "\t+--------------------+\n"
            );
            String decision = scanner.nextLine();
            if (decision.equals("1")) {
                System.out.println("\tWelcome to Sign up.");
                new SignUpUseCaseImpl().signUp();
            } else if (decision.equals("2")) {
                System.out.println("\tWelcome to Login");

                // return user was login
                User user = new LoginUseCaseImpl().login();
                if (user != null) {
                    new Menu(user).Show();
                }
            } else if (decision.equals("3")) {

            } else if (decision.equals("4")) {
                break;
            } else System.out.println("\tInvalid Number!");
        }
    }// End of main
}


//                    while (true) {
//                        System.out.println("What would you like to do?\n" +
//                                "1: add new article\n" +
//                                "2: Show my article(s)\n" +
//                                "3: Edit my article(s)\n" +
//                                "4: Change password\n" +
//                                "5: Logout"
//                        );
//                        decision = scanner.nextLine();
//                        if (decision.equals("1")) {
//                            System.out.println("adding new article.");
//                            new AddNewArticleUseCaseImpl(result, session).addNewArticle();
//                        } else if (decision.equals("2")) {
//                            new ShowMyArticleUseCaseImpl(session, result).showMyArticle();
//                        } else if (decision.equals("3")) {
//                            new EditArticleUseCaseImpl(session, result).edit();
//
//                        } else if (decision.equals("4")) {
//                            new ChangePasswordUseCaseImpl(session, result).changeMyPassword();
//
//                        } else if (decision.equals("5")) {
//                            result = null;
//                            break;
//                        } else System.out.println("Invalid Number");
//
//
//                    }
//                }
//            } else if (decision.equals("3")) {
//                session.beginTransaction();
//                Query<Article> query = session
//                        .createQuery("from Article article where article.isPublished=true", Article.class);
//
//                List<Article> articles = query.list();
//                articles.forEach(System.out::println);
//                session.getTransaction().commit();
//           }


