package facades;

import entities.Match;
import entities.Team;
import entities.Tournament;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;

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

    public Tournament createTournament(String name, LocalDate regDate, String gameType)
    {
        EntityManager em = emf.createEntityManager();

        try
        {
        Tournament newTournament = new Tournament(name, regDate, gameType);

            em.getTransaction().begin();
                em.persist(newTournament);
            em.getTransaction().commit();

            return newTournament;
        }
        finally
        {
            em.close();
        }
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

    public Match createMatch(LocalDate date, Tournament tournament)
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            Match newMatch = new Match(date, tournament);

            em.getTransaction().begin();
            em.persist(newMatch);
            em.getTransaction().commit();

            return newMatch;
        }
        finally
        {
            em.close();

        }
    }

    public Tournament getTournament(int id)
    {
        EntityManager em = emf.createEntityManager();
        try{
            return em.find(Tournament.class, id);
        }
        finally {
            em.close();
        }
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

    public Match getMatch(int id)
    {
        EntityManager em = emf.createEntityManager();
        try{
            return em.find(Match.class, id);
        }
        finally {
            em.close();
        }
    }

}


