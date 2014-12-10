/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thenairn.graphics.renderers;

import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer20;
import com.thenairn.graphics.CustomGraphicsEnvironment;

/**
 *
 * @author Tom
 */
public class GridRenderer {

    private int width;
    private int height;
    private int depth;

    public GridRenderer(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    ImmediateModeRenderer20 lineRenderer = new ImmediateModeRenderer20(false, true, 0);

    private void line(float x1, float y1, float z1,
            float x2, float y2, float z2,
            float r, float g, float b, float a) {
        lineRenderer.color(r, g, b, a);
        lineRenderer.vertex(x1, y1, z1);
        lineRenderer.color(r, g, b, a);
        lineRenderer.vertex(x2, y2, z2);
    }

    private void grid(int width, int height) {
        for (int x = 0; x <= width; x++) {
            // draw vertical
            line(x, 0, 0,
                    x, 0, -height,
                    0, 1, 0, 0);
        }

        for (int y = 0; y <= height; y++) {
            // draw horizontal
            line(0, 0, -y,
                    width, 0, -y,
                    0, 1, 0, 0);
        }
    }

    public void render(CustomGraphicsEnvironment env) {

        lineRenderer.begin(env.getCamera().combined, GL30.GL_LINES);
        grid(width, height);
        lineRenderer.end();
    }

}
