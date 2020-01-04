package features.impl;

import config.HibernateUtil;
import config.crud.CrudRoles;
import config.crud.CrudUser;
import entities.Role;
import entities.User;
import features.usecase.SignUpUseCase;
import org.hibernate.query.Query;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SignUpUseCaseImpl implements SignUpUseCase {
    @Override
    public void signUp() {

        // transaction start
        Scanner input = new Scanner(System.in);
        String username;
        List<User> result;
        while(true) {
            System.out.println("Username: ");
            username = input.nextLine();
            String hql = "from User u where u.userName=:userName";
            Query query = HibernateUtil.getSession().createQuery(hql);
            query.setParameter("userName", username);
            result = query.list();
            if (result.size() > 0)
                System.out.println("Username "+username + " has been already created.\n" +
                        "please enter another username.");
            else break;
        }

        System.out.println("National Code: ");
        String nationalCode = input.nextLine();
        String password = nationalCode;
        System.out.println("Birthday (Enter in  following format : yyyy.MM.dd)");

        String date = input.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd", Locale.ENGLISH);
        Date birthday = null;
        try {
            birthday = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(birthday);
        //-----------------------------
        User user = new User(
                null,
                username,
                password,
                nationalCode,
                birthday,
                null,
                null);

        CrudUser crudUser = CrudUser.getInstance();
        Role writerRole = CrudRoles.getInstance().findById(2L);
        List<Role> roles = new ArrayList<>();
        roles.add(writerRole);
        user.setRoles(roles);
        crudUser.save(user);
        // ----------------------------
    }
}
