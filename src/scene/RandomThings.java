package scene;

import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

public class RandomThings extends AbstractThing
{
    private Spatial tree;
    private Spatial koshk;
    private Spatial zbala;
    private Spatial car;
    
    private RigidBodyControl treeCollision;
    private RigidBodyControl koshkCollision;
    private RigidBodyControl carCollision;
    
    public RandomThings(BulletAppState bulletAppState)
    {
        super(bulletAppState);
    }
    
    @Override
    void init()
    {
        setUpScene();
        setUpPhysics();
    }
    
    private void setUpScene()
    {
        tree = assetManager.loadModel("Scenes/Tree/DeadTree.j3o");
        tree.setLocalScale(2f);
        tree.setLocalTranslation(0, -12, 0);
        rootNode.attachChild(tree);
        
        koshk = assetManager.loadModel("Scenes/Koshk/koshk.scene");
        koshk.setLocalScale(2f);
        koshk.setLocalTranslation(0, -12, 0);
        rootNode.attachChild(koshk);
        
        zbala = assetManager.loadModel("Scenes/zbala/zbala.scene");
        zbala.setLocalTranslation(0, -12, 0);
        rootNode.attachChild(zbala);
    }
    
    private void setUpPhysics()
    {
        stateManager.attach(bulletAppState);
        
        CollisionShape sceneShapetree = CollisionShapeFactory.createMeshShape((Node) tree);
        treeCollision = new RigidBodyControl(sceneShapetree, 0);
        tree.addControl(treeCollision);
        bulletAppState.getPhysicsSpace().add(treeCollision);
        
        CollisionShape sceneShapeKoshk = CollisionShapeFactory.createMeshShape((Node) koshk);
        koshkCollision = new RigidBodyControl(sceneShapeKoshk, 0);
        koshk.addControl(koshkCollision);
        bulletAppState.getPhysicsSpace().add(koshkCollision);
    }
}
