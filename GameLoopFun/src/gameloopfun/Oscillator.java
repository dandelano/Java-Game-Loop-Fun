/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameloopfun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;

/**
 *
 * @author dannyjdelanojr
 */
public class Oscillator {
    AffineTransform affine;
    Utility util;
    PVector angle;
    PVector velocity;
    PVector amplitude;
    Color bobColor;

    Oscillator() {
        util = new Utility();
        angle = new PVector();
        velocity = new PVector(util.random((float) -0.05, (float) 0.05), util.random((float) -0.05, (float) 0.05));
        //Random velocities and amplitudes
        amplitude = new PVector(util.random(200), util.random(200));
        int rndmColor = (int) util.random(9);
        switch(rndmColor){
            case 1:
                bobColor = Color.RED;
                break;
            case 2:
                bobColor = Color.GREEN;
                break;
            case 3:
                bobColor = Color.BLUE;
                break;
            case 4:
                bobColor = Color.ORANGE;
                break;
            case 5:
                bobColor = Color.CYAN;
                break;
            case 6:
                bobColor = Color.MAGENTA;
                break;
            case 7:
                bobColor = Color.YELLOW;
                break;
            case 8:
                bobColor = Color.PINK;
                break;
            default:
                bobColor = Color.GRAY;
                break;
        }
    }

    void oscillate() {
        angle.add(velocity);
    }

    void draw(Graphics g, float interp) {
        //Oscillating on the x-axis
        float x = (float)(Math.sin(angle.x) * amplitude.x);
        //Oscillating on the y-axis
        float y = (float) (Math.sin(angle.y) * amplitude.y);
        
        // Translate (x + width/2)
        x += 250; 
        y += 250;
        
        //Drawing the Oscillator as a line connecting a circle 
//        g.setColor(Color.BLACK);
//        g.drawLine(250,250, (int)x + 8,(int) y + 8);
        g.setColor(bobColor);
        g.fillOval((int)x,(int) y, 20, 20);
        g.setColor(Color.black);
        g.drawOval((int)x,(int) y, 20, 20);
    }

}
