/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ggclient;

import com.opengg.core.engine.GGApplication;
import com.opengg.core.engine.NetworkEngine;
import com.opengg.core.engine.OpenGG;
import com.opengg.core.render.window.WindowInfo;

/**
 *
 * @author Javier
 */
public class GGClient  extends GGApplication{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OpenGG.initialize(new GGClient(), new WindowInfo());
    }

    @Override
    public void setup() {
        NetworkEngine.connect("127.0.0.1", 25565);
    }

    @Override
    public void update() {
        System.out.println(OpenGG.curworld.getChildren().get(0).pos.y);
    }

    @Override
    public void render() {}
    
}