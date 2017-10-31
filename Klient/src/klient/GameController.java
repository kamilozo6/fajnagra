/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klient;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Kamil
 */
public class GameController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private class Rotate implements Runnable{
        
        private int where;
        
        
        @Override
        public void run() {
            while (pressed==true) {
                d.changeAngle(angleCh*where);

                try {
                    Thread.sleep(25);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Drawing.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    
}
    
    private final double angleCh=5;
    private boolean pressed;
    @FXML
    private Canvas gameField;
    
    private GraphicsContext gc;
    
    private Drawing d;
    Rotate rotate;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        pressed=false;
        gc=gameField.getGraphicsContext2D();
        d=new Drawing(gc);
        rotate=new Rotate();
        Thread t=new Thread(d);
        t.setDaemon(true);
        t.start();
    }    
    
    @FXML
    private void mouseMoved(MouseEvent event)throws IOException {
        
        int x=6;
        x=5;
        //gc.strokeLine(200, 200, 300, 300);
        
    }
    
    @FXML
    private void keyPressed(KeyEvent event)throws IOException
    {
        if(pressed==true)return;
        Thread t;
        
        switch(event.getCode())
        {
            case LEFT:
                pressed=true;
                rotate.where=1;
                t=new Thread(rotate);
                t.start();
                break;
            case RIGHT:
                pressed=true;
                rotate.where=-1;
                t=new Thread(rotate);
                t.start();
                break;
                
        }
    }
    
    @FXML
    private void keyRealesed(KeyEvent event)throws IOException
    {
        switch(event.getCode())
        {
            case LEFT:
                pressed=false;
                break;
            case RIGHT:
                pressed=false;
                break;
                
        }
    }
}
