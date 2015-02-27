/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameloopfun;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author dannyjdelanojr
 */
public class Ball {

    private PVector location_;
    private PVector lastLocation_;
    private PVector velocity_;
    private PVector acceleration_;
    private float mass_;
    private float maxspeed_;
    private int diameter_;
    private final int bottomButtonOffset_ = 25;

    public Ball() {
        location_ = new PVector(50,50);
        lastLocation_ = new PVector(location_.x,location_.y);
        velocity_ = new PVector(0,0);
        acceleration_ = new PVector(0,0);
        mass_ = 5;
        maxspeed_ = 10;
        diameter_ = 25;        
    }

    public void applyForce(PVector force)
    {
        acceleration_.add(force);
    }
    
    public void update()
    {
        lastLocation_ = location_;
        velocity_.add(acceleration_);
        velocity_.limit(this.maxspeed_);
        location_.add(velocity_);
        acceleration_.mult(0);
    }
    public void checkBounds(JPanel panel)
    {
        if(location_.x > panel.getWidth())
        {
            velocity_.x = velocity_.x * -1;
            location_.x = panel.getWidth();            
        }
        else if (location_.x < 0)
        {
            velocity_.x = velocity_.x * -1;
            location_.x = 0;
        }
        
        if(location_.y > panel.getHeight() - bottomButtonOffset_)
        {
            velocity_.y = velocity_.y * -1;
            location_.y = panel.getHeight() - bottomButtonOffset_;
        }
        else if(location_.y < 0)
        {
            velocity_.y = velocity_.y * -1;
            location_.y = 0;
        }
    }

    public void draw(Graphics g, float interpolation) {
        
//        int drawX = (int) (start + (stop - start) * interpolation - diameter_ / 2);
//        int drawY = (int) ((ballY - lastBallY) * interpolation + lastBallY - diameter_ / 2);
        
        g.setColor(Color.RED);
        g.fillOval((int)location_.x, (int)location_.y, diameter_, diameter_);
    }
}
