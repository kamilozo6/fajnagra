/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klient;

import static java.lang.Math.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Kamil
 */
public class Drawing implements Runnable {
    
    private double angle;
    private double x;
    private double y;
    private GraphicsContext gc;
    
    Drawing(GraphicsContext in)
    {
        x=200;
        y=200;
        angle=90;
        gc=in;
    }
    
    public void changeAngle(double change)
    {
        angle += change;
        if (angle >= 360)
            angle-=360;
        else if(angle <0)
            angle+=360;
    }
    

    @Override
    public void run() {
        double newY;
        double newX;
        while (true) {
            newX = sin(Math.toRadians(angle))+x;
            newY = cos(Math.toRadians(angle))+y;
            gc.strokeLine(x, y, newX, newY);
            x = newX;
            y = newY;
            try {
                Thread.sleep(25);
            } catch (InterruptedException ex) {
                Logger.getLogger(Drawing.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
