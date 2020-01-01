package config.crud;

import com.sun.xml.bind.v2.model.core.ID;
import config.HibernateUtil;
import entities.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class CrudUser {
    private static CrudUser crudUser;

    private CrudUser() {
    }

    public static CrudUser getInstance() {
        if (crudUser == null) {
            crudUser = new CrudUser();
        }
        return crudUser;
    }


    public void save(User user) {
        getSession().beginTransaction();
        getSession().save(user);
        getSession().getTransaction().commit();
    }

    public void update(User user) {
        getSession().beginTransaction();
        getSession().update(user);
        getSession().getTransaction().commit();
    }
//
//    public void remove(Entity entity) {
//        getSession().beginTransaction();
//        getSession().remove(entity);
//        getSession().getTransaction().commit();
//    }
//
//    public void removeById(ID id) {
//        Entity entity = findById(id);
//        if (entity != null) {
//            getSession().beginTransaction();
//            getSession().remove(entity);
//            getSession().getTransaction().commit();
//        }
//    }

    public User findById(Long id) {
        getSession().beginTransaction();
        User user = getSession().get(User.class, id);
        getSession().getTransaction().commit();
        return user;
    }

//    public List<Entity> findAll() {
//        getSession().beginTransaction();
//        Query<Entity> query = getSession()
//                .createQuery("from " + getEntityClass().getName(), getEntityClass());
//        List<Entity> entities = query.list();
//        getSession().getTransaction().commit();
//        return entities;
//    }

    private Session getSession() {
        return HibernateUtil.getSession();
    }

}
