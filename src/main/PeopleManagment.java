package main;

import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.PhysicsSpace;
import people.*;

public class PeopleManagment extends AbstractAppState
{
    private Henkesh henkesh;
    private She5 she5;
    

    PeopleManagment(PhysicsSpace physicsSpace)
    {
        
        henkesh = new Henkesh(physicsSpace);
        she5 = new She5(physicsSpace);
//        Butcher butcher = new Butcher();
//        MicroBusMan microBusMan = new MicroBusMan();
//        Pedestrian ped1 = new Pedestrian();      
    }
    
    @Override
    public void initialize(AppStateManager stateManager, Application app)
    {
      super.initialize(stateManager, app); 
      
      stateManager.attach(henkesh);
      stateManager.attach(she5);

    }
    
    public Henkesh getHenkesh()
    {
        return henkesh;
    }
}