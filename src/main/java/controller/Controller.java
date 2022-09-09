package controller;


import entities.Match;
import entities.Team;
import entities.Tournament;
import facades.EntityFacade;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Controller {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    EntityFacade entityFacade = EntityFacade.getInstance(emf);

    public Team createTeam(String name){
        Team newTeam = entityFacade.createTeam(name);

        return newTeam;
    }

    public Tournament createTournament(String name, LocalDate regDate, String gameType)
    {
        Tournament newTournament = entityFacade.createTournament(name, regDate, gameType);

        return newTournament;
    }

    public Match createMatch (LocalDate date, Tournament tournament)
    {
        Match newMatch = entityFacade.createMatch(date, tournament);

        return newMatch;
    }


}
