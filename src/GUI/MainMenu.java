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


package GUI;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetManager;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.scene.Node;
import com.jme3.system.AppSettings;
import com.jme3.ui.Picture;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.renderer.ViewPort;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.builder.ImageBuilder;
import de.lessvoid.nifty.builder.ScreenBuilder;
import de.lessvoid.nifty.builder.LayerBuilder;
import de.lessvoid.nifty.builder.PanelBuilder;
import de.lessvoid.nifty.controls.button.builder.ButtonBuilder;
import de.lessvoid.nifty.screen.DefaultScreenController;


public class MainMenu {
    
    private AssetManager assetManager;
    private Node guiNode;
    private AppSettings settings;
    private SimpleApplication app;
    private ViewPort guiViewPort;
    
    public MainMenu(AssetManager assetManager, Node guiNode, AppSettings settings, SimpleApplication app)
    {
        this.assetManager = assetManager;
        this.guiNode = guiNode;
        this.settings = settings;
        this.app = app;
        
        guiViewPort = app.getGuiViewPort();
        
        setUpNifty();
//        setUpMenu();
    }
    
    private void setUpNifty()
    {
        NiftyJmeDisplay niftyDisplay = new NiftyJmeDisplay(
            assetManager, app.getInputManager(), app.getAudioRenderer(), guiViewPort);
        
        Nifty nifty = niftyDisplay.getNifty();
    guiViewPort.addProcessor(niftyDisplay);
    app.getFlyByCamera().setDragToRotate(true);
 
    nifty.loadStyleFile("nifty-default-styles.xml");
    nifty.loadControlFile("nifty-default-controls.xml");
 
    // <screen>
    nifty.addScreen("start", new ScreenBuilder("start") {{
        controller(new DefaultScreenController());
        layer(new LayerBuilder("background") {{
            childLayoutCenter();
            backgroundColor("#000f");
            // <!-- ... -->
        }});
 
        layer(new LayerBuilder("background") {{
            childLayoutCenter();
            backgroundColor("#000f");
 
            // add image
//            image(new ImageBuilder() {{
//                filename("GUI/Menu.png");
//            }});
 
            // panel added
            panel(new PanelBuilder("panel_top_right2") {{
                    childLayoutCenter();
                    backgroundColor("#44f8");
                    height("15%");
                    width("100%");
 
                    // add image
                    image(new ImageBuilder() {{
                        filename("GUI/7enkeshparted.png");
                        valignCenter();
                        alignCenter();
                        height("50%");
                        width("30%");
                    }});
 
                }});
            
//            panel(new PanelBuilder("panel_bottom_left") {{
//                    childLayoutCenter();
//                    valignCenter();
//                    backgroundColor("#44f8");
//                    height("50%");
//                    width("50%");
// 
//                    // add control
//                    control(new ButtonBuilder("StartButton", "Start") {{
//                      alignCenter();
//                      valignCenter();
//                      height("50%");
//                      width("50%");
//                    }});
// 
//                }});
// 
//                panel(new PanelBuilder("panel_bottom_right") {{
//                    childLayoutCenter();
//                    valignCenter();
//                    backgroundColor("#88f8");
//                    height("50%");
//                    width("50%");
// 
//                    // add control
//                    control(new ButtonBuilder("QuitButton", "Quit") {{
//                      alignCenter();
//                      valignCenter();
//                      height("50%");
//                      width("50%");
//                    }});
// 
//                }});
            
            panel(new PanelBuilder("panel_top") {{
                childLayoutCenter();
                alignCenter();
                backgroundColor("#f008");
                height("25%");
                width("75%");
            }});
 
            panel(new PanelBuilder("panel_mid") {{
                childLayoutCenter();
                alignCenter();
                backgroundColor("#0f08");
                height("50%");
                width("75%");
            }});
 
            panel(new PanelBuilder("panel_bottom") {{
                childLayoutHorizontal();
                alignCenter();
                backgroundColor("#00f8");
                height("25%");
                width("75%");
 
                panel(new PanelBuilder("panel_bottom_left") {{
                    childLayoutCenter();
                    valignCenter();
                    backgroundColor("#44f8");
                    height("50%");
                    width("50%");
                }});
 
                panel(new PanelBuilder("panel_bottom_right") {{
                    childLayoutCenter();
                    valignCenter();
                    backgroundColor("#88f8");
                    height("50%");
                    width("50%");
                }});
            }}); // panel added
        }});
 
    }}.build(nifty));
    // </screen>
 
    nifty.gotoScreen("start"); // start the screen
    }
    
//    private void setUpMenu()
//    {
//        Picture pic = new Picture("Main Menu");
//        pic.setImage(assetManager, "GUI/Menu.png", true);
//        pic.setWidth(settings.getWidth());
//        pic.setHeight(settings.getHeight());
//        guiNode.attachChild(pic);
//    }
}
