package utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory ENTITY_MANEGER_FACTORY = Persistence.createEntityManagerFactory("ProjetoPU");

    public static EntityManager getEntityManager(){
        return ENTITY_MANEGER_FACTORY.createEntityManager();
    }
}
