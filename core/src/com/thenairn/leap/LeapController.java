/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thenairn.leap;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;

/**
 *
 * @author Tom
 */
public class LeapController {

    Controller controller = new Controller();

    public LeapController() {
    }
    
    public boolean hasFocus() {
        return controller.hasFocus();
    }

    public Frame getFrame() {
        return controller.frame();
    }

}
