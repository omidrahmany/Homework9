package features.impl.admin;

import config.crud.CrudCategory;
import config.crud.CrudTag;
import entities.Category;
import entities.Tag;
import features.usecase.admin.AddNewCategoryUseCase;

import java.util.Scanner;

public class AddNewCategoryImpl implements AddNewCategoryUseCase {

    @Override
    public void addNewCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Category title:");
        String title = scanner.next();
        System.out.println("Description:");
        String description = scanner.next();
        CrudCategory.getInstance().save(new Category(title,description,null));
    }
}
