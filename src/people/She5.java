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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.AnimEventListener;
import com.jme3.animation.LoopMode;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author adam
 */
public class She5 extends AbstractPerson implements AnimEventListener
{
    
    private Node she5Node;
    private Spatial she5Spatial;
    
    public She5(PhysicsSpace physicsSpace)
    {
        super(physicsSpace);
    }
    
    @Override
    protected void load() {
        setUpCharacter();
        setUpAnimation();
    }
    
    private void setUpAnimation()
    {
        control = she5Node.getChild("Basic charcter").getControl(AnimControl.class);
        control.addListener(this);
        channel = control.createChannel();
        channel.setAnim("salah");
    }
    
    @Override
    protected void setUpCharacter()
    {
        she5Node = (Node)assetManager.loadModel("Models/shiekh.j3o");;
        she5Node.setLocalTranslation(0, -7, 0);
        rootNode.attachChild(she5Node);
    }
    
    @Override
    public void update(float tpf)
    {
        
    }
    
    public void onAnimCycleDone(AnimControl control, AnimChannel channel, String animName) {
        channel.setAnim("salah", 0.50f);
        channel.setLoopMode(LoopMode.Loop);
    }

    public void onAnimChange(AnimControl control, AnimChannel channel, String animName) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
