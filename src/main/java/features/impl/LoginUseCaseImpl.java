package features.impl;

import entities.User;
import features.usecase.LoginUseCase;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class LoginUseCaseImpl implements LoginUseCase {
    Session session;
    public LoginUseCaseImpl(Session session) {
        this.session = session;
    }

    @Override
    public User login() {
        session.beginTransaction();
        User output = null;
        outer:while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Username: ");
            String username = input.nextLine();
            System.out.println("Password: ");
            String password = input.nextLine();
            String hql = "from User u where u.userName=:userName and u.password=:password";
            Query query = session.createQuery(hql);
            query.setParameter("userName", username);
            query.setParameter("password", password);
            List<User> result = query.list();
            System.out.println(result);
            if (result.size() == 0) {
                System.out.println("wrong username or password!");
                while(true) {
                    System.out.println(
                            "what would you like to do?\n" +
                            "1:Try again\n" +
                            "2:Exit");
                    String decision = input.nextLine();
                    if (decision.equals("1")) continue outer;
                    else if (decision.equals("2"))break outer;
                    else System.out.println("Invalid number!");
                }
            }else{
                System.out.println("Login done successfully!");
                output=result.get(0);
                break;
            }

        }
        // ----------------------------
        // transaction commit
        session.getTransaction().commit();
//        session.close();
        return output;
    }
}
