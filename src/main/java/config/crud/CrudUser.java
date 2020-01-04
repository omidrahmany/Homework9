package config.crud;

import entities.User;

public class CrudUser extends CrudOperation<User,Long> {
    private static CrudUser crudUser;

    private CrudUser() {
    }

    public static CrudUser getInstance() {
        if (crudUser == null) {
            crudUser = new CrudUser();
        }
        return crudUser;
    }


    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}
