/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.View;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;

/**
 *
 * @author Casper
 */
public class HayvanatBahcesiFXML extends Application {
    
    @Override
    public void start(Stage stage)  {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AnaPanel.fxml"));
            Scene scene = new Scene(root);
            Image image = new Image(getClass().getResourceAsStream("/hb/View/Images/chicken.png"));
            stage.getIcons().add(image);
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setTitle("Hayvanat Bahçesi DashBoard");
            stage.setWidth(1195);
            stage.setHeight(479);
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HayvanatBahcesiFXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
