package config.crud;

import config.HibernateUtil;
import entities.Role;
import org.hibernate.Session;

public class CrudRoles extends CrudOperation<Role,Long> {
    private static CrudRoles crudRoles;

    private CrudRoles() {
    }

    public static CrudRoles getInstance() {
        if (crudRoles == null) {
            crudRoles = new CrudRoles();
        }
        return crudRoles;
    }


    @Override
    protected Class<Role> getEntityClass() {
        return Role.class;
    }

}
