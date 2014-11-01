package freetl.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class PersistenceManager {

    public static PersistenceManager instance = new PersistenceManager();
    private EntityManagerFactory entityManagerFactory;

    private PersistenceManager() {
        entityManagerFactory = javax.persistence.Persistence.createEntityManagerFactory("freetl");
    }

    public static EntityManager getEntityManager() {
        return instance.entityManagerFactory.createEntityManager();
    }
}
