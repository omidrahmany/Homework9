package features.impl.writer;

import config.crud.CrudUser;
import entities.User;
import features.usecase.writer.ChangePasswordUseCase;
import org.hibernate.Session;

import java.util.Scanner;

public class ChangePasswordUseCaseImpl implements ChangePasswordUseCase {
    private User user;

    public ChangePasswordUseCaseImpl( User user) {
        this.user = user;
    }

    @Override
    public void changeMyPassword() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a new password:");
        String newPass = input.next();
        user.setPassword(newPass);
        CrudUser.getInstance().update(user);
        System.out.println("The password is changed successfully.");
    }
}
