package scene;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.scene.Node;

public abstract class AbstractThing extends AbstractAppState
{
    protected SimpleApplication app;
    protected AssetManager assetManager;
    protected Node rootNode;
    protected AppStateManager stateManager;
    protected BulletAppState bulletAppState;
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
      super.initialize(stateManager, app); 
      this.app = (SimpleApplication)app;          // cast to a more specific class
      this.rootNode = this.app.getRootNode();
      this.assetManager = this.app.getAssetManager();
      this.stateManager = this.app.getStateManager();
      
      init();
   }
    
    public AbstractThing(BulletAppState bulletAppState) {
        this.bulletAppState = bulletAppState;
    }
    
    abstract void init();
}