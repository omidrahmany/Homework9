package config.crud;

import config.HibernateUtil;
import entities.Role;
import entities.User;
import org.hibernate.Session;

public class CrudRoles {
    private static CrudRoles crudRoles;

    private CrudRoles() {
    }

    public static CrudRoles getInstance() {
        if (crudRoles == null) {
            crudRoles = new CrudRoles();
        }
        return crudRoles;
    }

    public void save(Role role) {
        getSession().beginTransaction();
        getSession().save(role);
        getSession().getTransaction().commit();
    }


    public Role findById(Long id){
        getSession().beginTransaction();
        Role role = getSession().load(Role.class,id);
        getSession().getTransaction().commit();
        return role;
    }


    private Session getSession() {
        return HibernateUtil.getSession();
    }
}
