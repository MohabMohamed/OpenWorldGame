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