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
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.ViewPort;
import com.jme3.renderer.Camera;
import scene.*;

public class SceneManagment extends AbstractAppState
{
    private SimpleApplication app;
    private ViewPort viewPort;
    private Camera cam;
    
    private World world;
    private Buildings buildings;
    private RandomThings randomThings;
    
    SceneManagment(PeopleManagment people, BulletAppState bulletAppState)
    {
        world = new World(bulletAppState);
        buildings = new Buildings(bulletAppState);
        randomThings = new RandomThings(bulletAppState);
    }
    
    @Override
    public void initialize(AppStateManager stateManager, Application app)
    {
      super.initialize(stateManager, app); 
      this.app = (SimpleApplication) app;
      this.viewPort = this.app.getViewPort();
      this.cam = app.getCamera();
      
      stateManager.attach(world);
      stateManager.attach(buildings);
      stateManager.attach(randomThings);
      init();
    }
    
    void init()
    {
        viewPort.setBackgroundColor(new ColorRGBA(0.7f, 0.8f, 1f, 1f));
        app.getFlyByCamera().setMoveSpeed(50);
    }
    
    @Override
    public void update(float tpf)
    {
        int x = 0;
        //cam.lookAt(henkeshDirection, new Vector3f(0,1,0));
        
        //x++;
    }
}