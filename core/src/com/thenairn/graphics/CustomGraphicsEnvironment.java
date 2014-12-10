/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thenairn.graphics;

import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.thenairn.leap.LeapController;

/**
 *
 * @author Tom
 */
public class CustomGraphicsEnvironment {

    private PerspectiveCamera cam;

    private Environment environment;

    private CameraInputController camController;

    public CustomGraphicsEnvironment(PerspectiveCamera cam, Environment environment, CameraInputController camController) {
        this.cam = cam;
        this.environment = environment;
        this.camController = camController;
    }

    public PerspectiveCamera getCamera() {
        return cam;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public CameraInputController getCamController() {
        return camController;
    }

}
