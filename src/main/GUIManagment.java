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
import GUI.*;
import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;
import com.jme3.system.AppSettings;


public class GUIManagment extends AbstractAppState
{
    private SimpleApplication app;
    private AssetManager assetManager;
    private Node rootNode;
    private Node guiNode;
    private AppSettings settings;
    
    GUIManagment(Node guiNode, AppSettings settings)
    {
        this.guiNode = guiNode;
        this.settings = settings;
    }
    
    @Override
    public void initialize(AppStateManager stateManager, Application app)
    {
      super.initialize(stateManager, app);
      this.app = (SimpleApplication)app;
      this.rootNode = this.app.getRootNode();
      this.assetManager = this.app.getAssetManager();
      
      
      MainMenu mainMenu = new MainMenu(assetManager, guiNode, settings, this.app);
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */