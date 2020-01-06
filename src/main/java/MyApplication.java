import config.HibernateUtil;
import config.crud.CrudArticle;
import config.crud.CrudRoles;
import config.crud.CrudUser;
import entities.Article;
import entities.User;
import features.Menu.Menu;
import features.impl.LoginUseCaseImpl;
import features.impl.writer.SignUpUseCaseImpl;

import java.util.List;
import java.util.Scanner;

public class MyApplication {
    public static void main(String[] args) {
        HibernateUtil.getSession();

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
                            "\t|4: Exit             |\n" +
                            "\t+--------------------+\n"
            );
            String decision = scanner.nextLine();
            if (decision.equals("1")) {
                System.out.println("Welcome to Sign up.");
                new SignUpUseCaseImpl().signUp();
            } else if (decision.equals("2")) {
                System.out.println("Welcome to Login");

                // return user was login
                User user = new LoginUseCaseImpl().login();
                if (user != null) {
                    new Menu(user).show();
                }
            } else if (decision.equals("3")) {
                List<Article> articles = CrudArticle.getInstance().findAll();
                articles.
                        stream().
                        filter(e -> e.isPublished())
                        .forEach(System.out::println);
            } else if (decision.equals("4")) {
                break;
            } else System.out.println("Invalid Number!");
        }
    }// End of main
}