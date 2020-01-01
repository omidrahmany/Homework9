package features.impl;

import entities.User;
import features.usecase.ChangePasswordUseCase;
import org.hibernate.Session;

import java.util.Scanner;

public class ChangePasswordUseCaseImpl implements ChangePasswordUseCase {
    Session session;
    User user;

    public ChangePasswordUseCaseImpl(Session session, User user) {
        this.session = session;
        this.user = user;
    }

    @Override
    public void changeMyPassword() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a new password:");
        String newPass = input.next();
        user.setPassword(newPass);
        session.update(user);
        System.out.println("The password is changed successfully.");
    }
}
