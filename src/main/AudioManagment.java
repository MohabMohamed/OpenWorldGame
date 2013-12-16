package main;

import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import audio.*;

public class AudioManagment extends AbstractAppState
{
    
    AudioManagment()
    {
        
    }
    
    @Override
    public void initialize(AppStateManager stateManager, Application app)
    {
      super.initialize(stateManager, app); 
    }
    
}