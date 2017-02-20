/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ggclient;

import com.opengg.core.engine.BindController;
import com.opengg.core.engine.GGApplication;
import com.opengg.core.engine.NetworkEngine;
import com.opengg.core.engine.OpenGG;
import com.opengg.core.engine.RenderEngine;
import com.opengg.core.engine.WorldEngine;
import com.opengg.core.io.ControlType;
import static com.opengg.core.io.input.keyboard.Key.*;
import com.opengg.core.math.Vector3f;
import com.opengg.core.online.client.Client;
import com.opengg.core.render.light.Light;
import com.opengg.core.render.objects.ObjectCreator;
import com.opengg.core.render.shader.ShaderController;
import com.opengg.core.render.texture.Cubemap;
import com.opengg.core.render.window.WindowInfo;
import com.opengg.core.world.Camera;
import com.opengg.core.world.components.CameraComponent;
import com.opengg.core.world.components.PlayerComponent;
import com.opengg.core.world.components.UserControlComponent;

/**
 *
 * @author Javier
 */
public class GGClient extends GGApplication{

    Vector3f pos = new Vector3f(), rot = new Vector3f();
    Camera c;
    
    public static void main(String[] args) {
        WindowInfo info = new WindowInfo();
        info.width = 1024;
        info.height = 960;
        OpenGG.initialize(new GGClient(), info);
    }

    @Override
    public void setup() {
        Client client = NetworkEngine.connect("127.0.0.1", 25565);
        
        Light l = new Light(new Vector3f(10,10,10), new Vector3f(1,1,1), 80f, 0);
        
        RenderEngine.addLight(l);
        RenderEngine.setSkybox(ObjectCreator.createCube(1500f), Cubemap.get("C:/res/skybox/majestic"));
        
        PlayerComponent player = new PlayerComponent();
        CameraComponent camera = new CameraComponent();
        UserControlComponent controller = new UserControlComponent();
        player.attach(camera);
        player.attach(controller);

        camera.use();
        
        WorldEngine.getCurrent().attach(player);
        BindController.addController(controller);
        BindController.addBind(ControlType.KEYBOARD, "forward", KEY_W);
        BindController.addBind(ControlType.KEYBOARD, "backward", KEY_S);
        BindController.addBind(ControlType.KEYBOARD, "left", KEY_A);
        BindController.addBind(ControlType.KEYBOARD, "right", KEY_D);
        BindController.addBind(ControlType.KEYBOARD, "up", KEY_SPACE);
        BindController.addBind(ControlType.KEYBOARD, "down", KEY_LEFT_SHIFT);
        BindController.addBind(ControlType.KEYBOARD, "lookright", KEY_Q);
        BindController.addBind(ControlType.KEYBOARD, "lookleft", KEY_E);
        BindController.addBind(ControlType.KEYBOARD, "lookup", KEY_U);
        BindController.addBind(ControlType.KEYBOARD, "lookdown", KEY_F);
    }

    @Override
    public void update() {
    }

    @Override
    public void render() {
        ShaderController.setPerspective(90, OpenGG.window.getRatio(), 1, 5000f);
        RenderEngine.draw();
    }
    
}