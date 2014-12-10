package com.thenairn.graphics.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.thenairn.graphics.LeapApplication;

public class DesktopLauncher {

    public static void main(String[] arg) {
        System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
        config.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height;
        config.resizable = false;
        config.fullscreen = false;
        LwjglApplication lwjglApplication = new LwjglApplication(new LeapApplication(), config);
    }
}
