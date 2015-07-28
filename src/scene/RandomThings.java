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
    private Spatial zbala;
    private Spatial car;
    
    private RigidBodyControl treeCollision;
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
    }
}
