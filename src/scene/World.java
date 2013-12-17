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
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;

public class World extends AbstractThing
{
    private Spatial sceneModel;
    private RigidBodyControl landscape;
    
    public World(BulletAppState bulletAppState)
    {
        super(bulletAppState);
    }
    void init()
    {
        setUpScene();
        setUpLight();
        setUpPhysics();
    }
    
    private void setUpScene()
    {
        sceneModel = assetManager.loadModel("Scenes/Base/Base.j3o");
        sceneModel.setLocalScale(2f);
        sceneModel.setLocalTranslation(0, -12, 0);
        rootNode.attachChild(sceneModel);
        
        
    }
    
    private void setUpLight()
    {
        // We add light so we see the scene
        AmbientLight al = new AmbientLight();
        al.setColor(ColorRGBA.White.mult(3.3f));
        rootNode.addLight(al);

        DirectionalLight dl = new DirectionalLight();
        dl.setColor(ColorRGBA.White);
        dl.setDirection(new Vector3f(2.8f, -2.8f, -2.8f).normalizeLocal());
        rootNode.addLight(dl);
        
        DirectionalLight dlnegate = new DirectionalLight();
        dlnegate.setColor(ColorRGBA.White);
        dlnegate.setDirection(new Vector3f(-2.8f, 2.8f, 2.8f).normalizeLocal());
        rootNode.addLight(dlnegate);
    }
    
    private void setUpPhysics()
    {
        
        stateManager.attach(bulletAppState);
        
        CollisionShape sceneShape = CollisionShapeFactory.createMeshShape((Node) sceneModel);
        landscape = new RigidBodyControl(sceneShape, 0);
        sceneModel.addControl(landscape);
        
        bulletAppState.getPhysicsSpace().add(landscape);
    }
}