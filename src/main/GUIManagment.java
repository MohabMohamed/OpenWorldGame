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