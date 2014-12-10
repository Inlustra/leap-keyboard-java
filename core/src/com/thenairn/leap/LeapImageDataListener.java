/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thenairn.leap;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Image;
import com.leapmotion.leap.ImageList;
import com.leapmotion.leap.Listener;
import static com.sun.javafx.iio.ImageStorage.ImageType.RGB;

/**
 *
 * @author Tom
 */
public class LeapImageDataListener extends Listener {

    @Override
    public void onFrame(Controller controller) {
        super.onFrame(controller); //To change body of generated methods, choose Tools | Templates.
        Frame frame = controller.frame();
        if (frame.isValid()) {
            ImageList images = frame.images();
            for (Image image : images) {
          
            }
        }
    }

}
