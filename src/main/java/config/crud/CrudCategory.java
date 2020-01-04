package config.crud;

import entities.Category;

public class CrudCategory extends CrudOperation<Category,Long> {
    private static CrudCategory crudCategory;

    private CrudCategory(){}

    public static CrudCategory getInstance() {
        if (crudCategory == null) {
            crudCategory = new CrudCategory();
        }
        return crudCategory;
    }

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }
}
