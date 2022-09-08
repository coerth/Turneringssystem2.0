package facades;

import entities.Team;

import javax.persistence.EntityManager;
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

    public Team createTeam(String name) {
        EntityManager em = emf.createEntityManager();
        Team newTeam = new Team(name);

        em.getTransaction().begin();
        em.persist(newTeam);
        em.getTransaction().commit();
        em.close();

        return newTeam;
    }

    public Team getTeam(int id)
    {
        EntityManager em = emf.createEntityManager();
        try{

        return em.find(Team.class, id);
        }
        finally {
            em.close();
        }

    }

}


