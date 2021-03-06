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

public class Buildings extends AbstractThing
{
    private Spatial buildings;
    private Spatial building5azan;
    private Spatial firstBuilding;
    private Spatial secondBuilding;
    private Spatial highWayBuilding;
    
    private RigidBodyControl buildingsCollision;
    private RigidBodyControl building5azanCollision;
    private RigidBodyControl firstBuildingCollision;
    private RigidBodyControl secondBuildingCollision;
    private RigidBodyControl highWayBuildingCollision;
    
    
    public Buildings(BulletAppState bulletAppState)
    {
        super(bulletAppState);
    }
    
    void init()
    {
        setUpScene();
        setUpPhysics();
    }
    
    private void setUpScene()
    {
        buildings = assetManager.loadModel("Scenes/Buildings/buildings.j3o");
        buildings.setLocalScale(2f);
        buildings.setLocalTranslation(0, -12, 0);
        rootNode.attachChild(buildings);
        
        building5azan = assetManager.loadModel("Scenes/Buildings/3omara_5azan.j3o");
        building5azan.setLocalScale(2f);
        building5azan.setLocalTranslation(0, -12, 0);
        rootNode.attachChild(building5azan);
        
        firstBuilding = assetManager.loadModel("Scenes/Buildings/FirstBuilding.j3o");
        firstBuilding.setLocalScale(2f);
        firstBuilding.setLocalTranslation(0, -12, 0);
        rootNode.attachChild(firstBuilding);
        
        secondBuilding = assetManager.loadModel("Scenes/Buildings/SecondBuilding.j3o");
        secondBuilding.setLocalScale(2f);
        secondBuilding.setLocalTranslation(0, -12, 0);
        rootNode.attachChild(secondBuilding);
        
        highWayBuilding = assetManager.loadModel("Scenes/Buildings/HighwayBuilding.j3o");
        highWayBuilding.setLocalScale(2f);
        highWayBuilding.setLocalTranslation(0, -12, 0);
        rootNode.attachChild(highWayBuilding);
        
    }
    
    private void setUpPhysics()
    {
        
        stateManager.attach(bulletAppState);
        
        CollisionShape sceneShapebuildings = CollisionShapeFactory.createMeshShape((Node) buildings);
        buildingsCollision = new RigidBodyControl(sceneShapebuildings, 0);
        buildings.addControl(buildingsCollision);
        bulletAppState.getPhysicsSpace().add(buildingsCollision);
        
        CollisionShape sceneShapebuilding5azan = CollisionShapeFactory.createMeshShape((Node) building5azan);
        building5azanCollision = new RigidBodyControl(sceneShapebuilding5azan, 0);
        building5azan.addControl(building5azanCollision);
        bulletAppState.getPhysicsSpace().add(buildingsCollision);
        
        CollisionShape sceneShapefirstBuilding = CollisionShapeFactory.createMeshShape((Node) firstBuilding);
        firstBuildingCollision = new RigidBodyControl(sceneShapefirstBuilding, 0);
        firstBuilding.addControl(firstBuildingCollision);
        bulletAppState.getPhysicsSpace().add(firstBuildingCollision);
        
        CollisionShape sceneShapesecondBuilding = CollisionShapeFactory.createMeshShape((Node) secondBuilding);
        secondBuildingCollision = new RigidBodyControl(sceneShapesecondBuilding, 0);
        secondBuilding.addControl(secondBuildingCollision);
        bulletAppState.getPhysicsSpace().add(secondBuildingCollision);
        
        CollisionShape sceneShapehighWayBuilding = CollisionShapeFactory.createMeshShape((Node) highWayBuilding);
        highWayBuildingCollision = new RigidBodyControl(sceneShapehighWayBuilding, 0);
        highWayBuilding.addControl(highWayBuildingCollision);
        bulletAppState.getPhysicsSpace().add(highWayBuildingCollision);
    }
}