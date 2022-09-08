package controller;


import entities.Team;
import facades.EntityFacade;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Controller {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    EntityFacade entityFacade = EntityFacade.getInstance(emf);

    public void Ui(){
        Team newTeam = entityFacade.createTeam("Shittymemes");
        System.out.println("New team: "+newTeam +" has been created");
    }


}
