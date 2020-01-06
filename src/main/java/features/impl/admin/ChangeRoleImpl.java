package features.impl.admin;

import config.crud.CrudRoles;
import config.crud.CrudUser;
import entities.User;
import features.GetNewEntity;
import features.usecase.admin.ChangeUsersRoleUseCase;

import java.util.Scanner;

public class ChangeRoleImpl implements ChangeUsersRoleUseCase {
    @Override
    public void changeRole() {
        Scanner input = new Scanner(System.in);
        User user;
        while (true) {
            user = GetNewEntity.getNewUser("Enter User id:");
            if (user.getId() == 1) {
                System.out.println("You are not allowed to change user's role with id 1.\n" +
                        "please enter another user id.");
            } else break;
        }
        int roleListSize = user.getRoles().size();
        if (roleListSize == 2) {
            System.out.println("This user has 2 roles.\n" +
                    "You are allowed to remove one of roles.\n" +
                    "Because it's not impossible to have more than two roles\n" +
                    "Which role would you like to remove?\n" +
                    "1: Writer\n" +
                    "2: Admin\n" +
                    "3: Exit");
            while (true) {
                String dec = input.next();
                if (dec.equals("1")) {
                    user.getRoles().remove(CrudRoles.getInstance().findById(2L));
                    break;
                } else if (dec.equals("2")) {
                    user.getRoles().remove(CrudRoles.getInstance().findById(1L));
                    break;
                } else if (dec.equals("3")) {
                    break;
                } else System.out.println("Invalid Number!");
            }
        }
        // List role size is 1
        else if(user.getRoles().get(0).getTitle().equals("writer")){
            System.out.println("You can just assign an admin role to the user.\n" +
                    "would you like to continue?\n" +
                    "1: Yes\n" +
                    "2: No");
            String dec;
            while(true){
                 dec = input.next();
                if (dec.equals("1")) {
                    user.getRoles().add(CrudRoles.getInstance().findById(1L));
                    CrudUser.getInstance().update(user);
                    System.out.println("You assigned admin role to the user successfully.");
                    break;
                }else if(dec.equals("2")) break;
                else System.out.println("Invalid Number!");
            }
        }else {
            System.out.println("You can just assign an writer role to the user.\n" +
                    "would you like to continue?\n" +
                    "1: Yes\n" +
                    "2: No");
            String dec;
            while(true){
                dec = input.next();
                if (dec.equals("1")) {
                    user.getRoles().add(CrudRoles.getInstance().findById(2L));
                    CrudUser.getInstance().update(user);
                    System.out.println("You assigned writer role to the user successfully.");
                    break;
                }else if(dec.equals("2")) break;
                else System.out.println("Invalid Number!");
            }
        }
    }
}
