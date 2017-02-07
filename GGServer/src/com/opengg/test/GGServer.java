/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opengg.test;

import com.opengg.core.engine.GGApplication;
import com.opengg.core.engine.NetworkEngine;
import com.opengg.core.engine.OpenGG;

/**
 *
 * @author Javier
 */
public class GGServer extends GGApplication{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OpenGG.initializeHeadless(new GGServer());
    }

    @Override
    public void setup() {
        NetworkEngine.initializeServer("TestServer", 25565);
    }

    @Override
    public void update() {
    }

    @Override
    public void render() {}
    
}
