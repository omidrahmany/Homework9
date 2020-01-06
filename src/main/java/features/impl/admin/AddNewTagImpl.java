package features.impl.admin;

import config.crud.CrudTag;
import entities.Tag;
import features.usecase.admin.AddNewTagUseCase;

import java.util.Scanner;

public class AddNewTagImpl implements AddNewTagUseCase {
    @Override
    public void addNewTag() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tag title:");
        String title = scanner.next();
        CrudTag.getInstance().save(new Tag(title,null));
    }
}
