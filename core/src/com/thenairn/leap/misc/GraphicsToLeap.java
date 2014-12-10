/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thenairn.leap.misc;

import com.badlogic.gdx.math.Vector3;
import com.leapmotion.leap.Vector;

/**
 *
 * @author Tom
 */
public class GraphicsToLeap {

    public static Vector3 leapToVector3(Vector v) {
        return new Vector3(v.getX(), v.getY(), v.getZ());
    }

    public static Vector vector3ToLeap(Vector3 v) {
        return new Vector(v.x, v.y, v.z);
    }
}
