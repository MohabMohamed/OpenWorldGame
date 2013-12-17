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

import com.jme3.app.SimpleApplication;
import com.jme3.audio.AudioNode;
import com.jme3.renderer.RenderManager;
import com.jme3.bullet.BulletAppState;

public class Main extends SimpleApplication
{   
    
    public static void main(String[] args)
    {
        Main app = new Main();
        app.start();
    }
    
    private BulletAppState bulletAppState;
        
    @Override
    public void simpleInitApp()
    {
        //disable default camera controls
        flyCam.setEnabled(false);
        
//        AudioNode music = new AudioNode(assetManager, "Sounds/error.wav", true);
//        rootNode.attachChild(music);
        
//        GUIManagment GUI = new GUIManagment(guiNode, settings);
//        stateManager.attach(GUI);
        
        //initializing physics appState
        bulletAppState = new BulletAppState();
        stateManager.attach(bulletAppState);

        
        PeopleManagment people = new PeopleManagment(bulletAppState.getPhysicsSpace());
        stateManager.attach(people);
        SceneManagment scene = new SceneManagment(people, bulletAppState);
        stateManager.attach(scene);
        AudioManagment audio = new AudioManagment();
        stateManager.attach(audio);
    }
    
    @Override
    public void simpleUpdate(float tpf)
    {
        
    }

    @Override
    public void simpleRender(RenderManager rm)
    {
        
    }
}
