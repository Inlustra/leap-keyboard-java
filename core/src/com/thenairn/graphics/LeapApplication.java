package com.thenairn.graphics;

import com.thenairn.graphics.renderers.HandRenderer;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.thenairn.graphics.renderers.GridRenderer;
import com.thenairn.leap.LeapController;

public class LeapApplication extends ApplicationAdapter {

    private LeapController controller;
    private CustomGraphicsEnvironment env;
    private HandRenderer handRenderer;
    private GridRenderer gridRenderer;

    @Override
    public void create() {
        controller = new LeapController();

        PerspectiveCamera cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.position.set(500f, 500f, 500f);
        cam.lookAt(0, 0, 0);
        cam.near = 1f;
        cam.far = 1000f;
        cam.update();

        CameraInputController camController = new CameraInputController(cam);
        Gdx.input.setInputProcessor(camController);

        Environment environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

        env = new CustomGraphicsEnvironment(cam, environment, camController);
        handRenderer = new HandRenderer();
        gridRenderer = new GridRenderer(300, 300, 300);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        gridRenderer.render(env);
        handRenderer.render(env, controller.getFrame());
    }

}
