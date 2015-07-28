//   This file is part of 7enkesh.
//
//    7enkesh is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    7enkesh is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with 7enkesh.  If not, see <http://www.gnu.org/licenses/>.

package main;

import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.PhysicsSpace;
import people.*;

public class PeopleManagment extends AbstractAppState
{
    private Henkesh henkesh;
    

    PeopleManagment(PhysicsSpace physicsSpace)
    {
        
        henkesh = new Henkesh(physicsSpace);
//        Butcher butcher = new Butcher();
//        MicroBusMan microBusMan = new MicroBusMan();
//        Pedestrian ped1 = new Pedestrian();      
    }
    
    @Override
    public void initialize(AppStateManager stateManager, Application app)
    {
      super.initialize(stateManager, app); 
      
      stateManager.attach(henkesh);
    }
    
    public Henkesh getHenkesh()
    {
        return henkesh;
    }
}