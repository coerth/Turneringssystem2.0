package facades;

import javax.persistence.EntityManagerFactory;

public class EntityFacade {

    private static EntityFacade instance;

    private static EntityManagerFactory emf;

    public EntityFacade() {
    }

    public static EntityFacade getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new EntityFacade();
        }
        return instance;
    }
}
