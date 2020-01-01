package features.impl;

import config.crud.CrudRoles;
import config.crud.CrudUser;
import entities.Role;
import entities.User;
import features.usecase.SignUpUseCase;
import org.hibernate.Session;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SignUpUseCaseImpl implements SignUpUseCase {
    @Override
    public void signUp() {

        // transaction start
        Scanner input = new Scanner(System.in);
        System.out.println("Username: ");
        String username = input.nextLine();
        System.out.println("National Code: ");
        String nationalCode = input.nextLine();
        String password = nationalCode;
        System.out.println("Birthday (Enter in  following format : yyyy.MM.dd)");

        String date=input.nextLine();
        SimpleDateFormat format=new SimpleDateFormat("yyyy.MM.dd", Locale.ENGLISH);
        Date birthday= null;
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
        Role writerRole =CrudRoles.getInstance().findById(2L);
        List<Role> roles = new ArrayList<>();
        roles.add(writerRole);
        user.setRoles(roles);
        crudUser.save(user);
        // ----------------------------
    }
}
