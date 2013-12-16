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