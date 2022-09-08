package controller;


import entities.Team;
import facades.EntityFacade;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Controller {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    EntityFacade entityFacade = EntityFacade.getInstance(emf);

    public void createTeam(){
        Team newTeam = entityFacade.createTeam("Shitty Memes And Bigger Dreams");
        System.out.println("New team: "+newTeam +" has been created");
    }


}
