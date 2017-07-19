package database_service;

import entitys.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Created by kuteynikov on 29.06.2017.
 */
public class DbService {
    EntityManager em;
    public DbService() {
         this.em = Persistence.createEntityManagerFactory("eclipsMysql").createEntityManager();
    }


    public void addUserInDb(User user){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
    }
    public void addChildrenUser(User parentUser, User childrenUser){
        int rightKey = parentUser.getRightKey();
        childrenUser.setLeftKey(rightKey);
        childrenUser.setRightKey(rightKey+1);
        childrenUser.setLevel(parentUser.getLevel()+1);
        updateKey(rightKey);
        addUserInDb(childrenUser);

    }
    public User getUserFromDb(long userId){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        User usserFromDb = em.find(User.class,userId);
        transaction.commit();
        return usserFromDb;
    }

    private void updateKey(int rightKey){
        Query query = em.createNamedQuery("Users.addUserStep1");
        query.setParameter("key",rightKey);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        query.executeUpdate();
        transaction.commit();
        System.out.println("Обнолена чать1 rightKey:"+rightKey);
        query = em.createNamedQuery("Users.addUserStep2");
        query.setParameter("key",rightKey);
        transaction.begin();
        query.executeUpdate();
        transaction.commit();
        System.out.println("Обнолена чать2 rightKey:"+rightKey);
    }

}
