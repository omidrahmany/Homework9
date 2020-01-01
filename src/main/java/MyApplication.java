import config.HibernateUtil;
import config.crud.CrudUser;
import config.crud.CrudRoles;
import entities.Article;
import entities.Role;
import entities.User;
import features.impl.*;
import org.hibernate.Session;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MyApplication {
    public static void main(String[] args) {
        // Creating Roles
//        Role adminRole = new Role();
//        adminRole.setTitle("admin");
//
//        Role writerRole = new Role();
//        writerRole.setTitle("writer");
//
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

            System.out.println("What would you like to do?\n" +
                    "1: Sign up\n" +
                    "2: Login\n" +
                    "3: Show All Articles\n" +
                    "4: Exit");
            String decision = scanner.nextLine();
            if (decision.equals("1")) {
                System.out.println("Welcome to Sign up.");
                new SignUpUseCaseImpl().signUp();
            }
            /*else if (decision.equals("2")) {
                System.out.println("Welcome to Login\n" +""
                        "Please select your role\n" +
                        "1: admin\n" +
                        "2: writer"
                        );


                // return user who is login
                User result = new LoginUseCaseImpl(session).login();

                if (result != null) {
                    while (true) {
                        System.out.println("What would you like to do?\n" +
                                "1: add new article\n" +
                                "2: Show my article(s)\n" +
                                "3: Edit my article(s)\n" +
                                "4: Change password\n" +
                                "5: Logout"
                        );
                        decision = scanner.nextLine();
                        if (decision.equals("1")) {
                            System.out.println("adding new article.");
                            new AddNewArticleUseCaseImpl(result, session).addNewArticle();
                        } else if (decision.equals("2")) {
                            new ShowMyArticleUseCaseImpl(session, result).showMyArticle();
                        } else if (decision.equals("3")) {
                            new EditArticleUseCaseImpl(session,result).edit();

                        } else if (decision.equals("4")) {
                            new ChangePasswordUseCaseImpl(session, result).changeMyPassword();

                        } else if (decision.equals("5")) {
                            result = null;
                            break;
                        } else System.out.println("Invalid Number");


                    }
                }
            }
            else if (decision.equals("3")) {
                session.beginTransaction();
                Query<Article> query = session
                        .createQuery("from Article article where article.isPublished=true", Article.class);

                List<Article> articles = query.list();
                articles.forEach(System.out::println);
                session.getTransaction().commit();
            } */
            else if (decision.equals("4")){
                break;
            }
            else System.out.println("Invalid Number!");
        }
    }// End of main
}
