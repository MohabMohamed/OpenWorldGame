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

package people;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.AnimEventListener;
import com.jme3.animation.LoopMode;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.input.InputManager;     
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.CameraNode;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.CameraControl.ControlDirection;
import com.jme3.scene.control.Control;

public class Henkesh extends AbstractPerson implements AnimEventListener
{
    private Camera cam;
    private InputManager inputManager;
    
    private Node henkeshNode;
    private Spatial henkeshSpatial;
    private CharacterControl henkeshControl;
    private CameraNode camNode;
    boolean rotate = false;
    private Vector3f walkDirection = new Vector3f(0,0,0);
    private Vector3f viewDirection = new Vector3f(0,0,0);
    boolean leftStrafe = false, rightStrafe = false, forward = false, backward = false,
            leftRotate = false, rightRotate = false;

    
    public Henkesh(PhysicsSpace physicsSpace)
    {
        super(physicsSpace);
    }
    
    @Override
    protected void load()
    {
        this.cam = app.getCamera();
        this.inputManager = app.getInputManager();
        
        setUpCharacter();
        setUpHenkeshControl();
        setUpCam();
        registerInput();
        setUpAnimation();
    }
    
    public void registerInput()
    {
        inputManager.addMapping("Strafe Left",
                new KeyTrigger(KeyInput.KEY_Q),
                new KeyTrigger(KeyInput.KEY_Z));
        inputManager.addMapping("Strafe Right",
                new KeyTrigger(KeyInput.KEY_E),
                new KeyTrigger(KeyInput.KEY_X));
        inputManager.addMapping("Rotate Left",
                new KeyTrigger(KeyInput.KEY_A),
                new KeyTrigger(KeyInput.KEY_LEFT));
        inputManager.addMapping("Rotate Right",
                new KeyTrigger(KeyInput.KEY_D),
                new KeyTrigger(KeyInput.KEY_RIGHT));
        inputManager.addMapping("Walk Forward",
                new KeyTrigger(KeyInput.KEY_W),
                new KeyTrigger(KeyInput.KEY_UP));
        inputManager.addMapping("Walk Backward",
                new KeyTrigger(KeyInput.KEY_S),
                new KeyTrigger(KeyInput.KEY_DOWN));
        inputManager.addMapping("Jump",
                new KeyTrigger(KeyInput.KEY_SPACE),
                new KeyTrigger(KeyInput.KEY_RETURN));
        inputManager.addMapping("Shoot",
                new MouseButtonTrigger(MouseInput.BUTTON_LEFT));
        inputManager.addListener(actionListener, new String[] {"Strafe Left", "Strafe Right"});
        inputManager.addListener(actionListener, new String[] {"Rotate Left", "Rotate Right"});
        inputManager.addListener(actionListener, new String[] {"Walk Forward", "Walk Backward"});
        inputManager.addListener(actionListener, new String[] {"Jump", "Shoot"});

    }
    
    @Override
    protected void setUpCharacter()
    {
        henkeshNode = (Node)assetManager.loadModel("Models/7enkesh.j3o");
        henkeshNode.setLocalTranslation(0, 1, 0);
        rootNode.attachChild(henkeshNode);
    }
    
    private void setUpHenkeshControl()
    {
        henkeshControl = new CharacterControl(new CapsuleCollisionShape(0.4f, 1f), 0.4f);
        henkeshControl.setPhysicsLocation(new Vector3f(0, 1, 0));
        henkeshControl.setJumpSpeed(20);
        henkeshControl.setFallSpeed(30);
        henkeshControl.setGravity(30);
        
        henkeshNode.addControl(henkeshControl);
        physicsSpace.add(henkeshControl);

    }
    
    private void setUpCam()
    {
        camNode = new CameraNode("CamNode", cam);
        camNode.setControlDir(ControlDirection.SpatialToCamera);
        camNode.setLocalTranslation(new Vector3f(0, 6, -19));
        camNode.lookAt(henkeshNode.getLocalTranslation().add(new Vector3f(0 ,4 ,0)), Vector3f.UNIT_Y);
        henkeshNode.attachChild(camNode);
    }
    
    private ActionListener actionListener = new ActionListener()
    {
        public void onAction(String binding, boolean value, float tpf)
        {
            if (binding.equals("Strafe Left")) {
                if (value) {
                    leftStrafe = true;
                } else {
                    leftStrafe = false;
                }
            } else if (binding.equals("Strafe Right")) {
                if (value) {
                    rightStrafe = true;
                } else {
                    rightStrafe = false;
                }
            } else if (binding.equals("Rotate Left")) {
                if (value) {
                    leftRotate = true;
                } else {
                    leftRotate = false;
                }
            } else if (binding.equals("Rotate Right")) {
                if (value) {
                    rightRotate = true;
                } else {
                    rightRotate = false;
                }
            } else if (binding.equals("Walk Forward")) {
                if (value) {
                    forward = true;
                    channel.setAnim("Walking", 0.50f);
                    channel.setLoopMode(LoopMode.Loop);
                    channel.setSpeed(2f);
                } else {
                    forward = false;
                    channel.setAnim("Standing", 0.50f);
                    channel.setLoopMode(LoopMode.DontLoop);
                    channel.setSpeed(1f);
                }
            } else if (binding.equals("Walk Backward")) {
                if (value) {
                    backward = true;
                    channel.setAnim("Walking Backwards", 0.50f);
                    channel.setLoopMode(LoopMode.Loop);
                    channel.setSpeed(2f);
                } else {
                    backward = false;
                    channel.setAnim("Standing", 0.50f);
                    channel.setLoopMode(LoopMode.DontLoop);
                    channel.setSpeed(1f);
                }
            } else if (binding.equals("Jump")) {
                henkeshControl.jump();
                if (forward == true)
                {
                    channel.setAnim("Jumping", 0.50f);
                    channel.setLoopMode(LoopMode.DontLoop);
                    channel.setSpeed(2f);
                }
                else if (backward == true)
                {
                    channel.setAnim("Jumping Backwards", 0.50f);
                    channel.setLoopMode(LoopMode.DontLoop);
                    channel.setSpeed(2f);
                }
            }
        }
    };
    
    public Spatial getSpatial()
    {
        return henkeshSpatial;
    }
    
    public void addControl(Control control)
    {
        if(henkeshSpatial != null)
        {
            henkeshSpatial.addControl(control);
        }
        else
        {
            System.out.println("henkeshSpatial is null");
        }
    }
    
    @Override
    public void update(float tpf)
    {
        Vector3f camDir = cam.getDirection().mult(0.2f);
        Vector3f camLeft = cam.getLeft().mult(0.2f);
        camDir.y = 0;
        camLeft.y = 0;
        viewDirection.set(camDir);
        walkDirection.set(0, 0, 0);
        if (leftStrafe) {
            walkDirection.addLocal(camLeft);
        } else
        if (rightStrafe) {
            walkDirection.addLocal(camLeft.negate());
        }
        if (leftRotate) {
            viewDirection.addLocal(camLeft.mult(0.07f));
        } else
        if (rightRotate) {
            viewDirection.addLocal(camLeft.mult(0.07f).negate());
        }
        if (forward) {
            walkDirection.addLocal(camDir.mult(5f));
        } else
        if (backward) {
            walkDirection.addLocal(camDir.negate());
        }
        henkeshControl.setWalkDirection(walkDirection);
        henkeshControl.setViewDirection(viewDirection);
    }
    
    private void setUpAnimation()
    {
        control = henkeshNode.getChild("Henkesh").getControl(AnimControl.class);
        control.addListener(this);
        channel = control.createChannel();
        channel.setAnim("Standing");

    }
    
    public void onAnimCycleDone(AnimControl control, AnimChannel channel, String animName) {
        if (animName.equals("Standing")) {
        channel.setAnim("Bored", 0.50f);
        channel.setLoopMode(LoopMode.Loop);
        channel.setSpeed(1f);
      }
        if (animName.equals("Jumping") && forward == true)
        {
            channel.setAnim("Walking", 0.50f);
            channel.setLoopMode(LoopMode.Loop);
            channel.setSpeed(2f);
        }
        
        if (animName.equals("Jumping Backwards") && backward == true)
        {
            channel.setAnim("Walking Backwards", 0.50f);
            channel.setLoopMode(LoopMode.Loop);
            channel.setSpeed(2f);
        }
    }

    public void onAnimChange(AnimControl control, AnimChannel channel, String animName) {
//        channel.setAnim("Standing", 0.50f);
//        channel.setLoopMode(LoopMode.Loop);
//        channel.setSpeed(1f);
    }
}