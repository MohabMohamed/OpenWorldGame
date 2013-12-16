package people;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.scene.Node;

public abstract class AbstractPerson extends AbstractAppState
{
    protected SimpleApplication app;
    protected AssetManager assetManager;
    protected Node rootNode;
    protected AnimChannel channel;
    protected AnimControl control;
    protected PhysicsSpace physicsSpace;
    
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
      super.initialize(stateManager, app); 
      this.app = (SimpleApplication)app;
      this.rootNode = this.app.getRootNode();
      this.assetManager = this.app.getAssetManager();
      
      load();
   }
    
    public AbstractPerson(PhysicsSpace physicsSpace) {
        super();
        this.physicsSpace = physicsSpace;
    }
    
    abstract protected void load();
    
    abstract protected void setUpCharacter();
}