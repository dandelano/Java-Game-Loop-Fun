/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameloopfun;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 *
 * @author dannyjdelanojr
 */
public class Pendulum {

    PVector location_;    // Location of bob
    PVector origin_;      // Location of arm origin
    float radius_;             // Length of arm
    float angle_;         // Pendulum arm angle
    float aVelocity_;     // Angle velocity
    float aAcceleration_; // Angle acceleration
    float damping_;       // Arbitrary damping amount
    int bobDiameter;

    Pendulum(PVector origin, float r) {
        origin_ = origin.copy();
        location_ = new PVector();
        radius_ = r;
        angle_ = (float) Math.PI/2;

        aVelocity_ = (float) 0.0;
        aAcceleration_ = (float) 0.0;
        // An arbitrary damping so that the Pendulum slows over time
        damping_ = (float) 0.995;
        bobDiameter = 24;
    }

    public void update() {
        float gravity = (float) 0.4;
        //Formula we worked out for angular acceleration
        aAcceleration_ = (float) ((-1 * gravity / radius_) * Math.sin(angle_));

        //Standard angular motion algorithm
        aVelocity_ += (float) aAcceleration_;
        angle_ += aVelocity_;

        //Apply some damping.
        aVelocity_ *= damping_;
    }

    public void draw(Graphics g, float interp) {
        location_.set((float) (radius_ * Math.sin(angle_)), (float) (radius_ * Math.cos(angle_)), 0);
        location_.add(origin_);

        //The arm
        g.setColor(Color.BLACK);
        g.drawLine((int)origin_.x, (int)origin_.y, (int)location_.x + bobDiameter/2, (int)location_.y + bobDiameter/2);
        
       
        //The bob
        g.setColor(Color.RED);
        g.fillOval((int)location_.x, (int)location_.y, bobDiameter, bobDiameter);
    }
}
