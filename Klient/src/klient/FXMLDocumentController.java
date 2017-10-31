/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klient;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Kamil
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button credits;
    @FXML
    private Button back;
    @FXML
    private Button start;
    
    @FXML
    private void handleButtonAction(ActionEvent event)throws IOException {
        Stage stage; 
        Parent root;
        if(event.getSource() == credits){
        //get reference to the button's stage         
            stage=(Stage) credits.getScene().getWindow();
        //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("Credits.fxml"));
        }
        else if (event.getSource() == back){
            stage=(Stage) back.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        }else if (event.getSource() == start)
        {
            stage=(Stage) start.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Game.fxml"));
        }
        else
        {
            return;
        }
     //create a new scene with root and set the stage
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
      scene.getRoot().requestFocus();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
