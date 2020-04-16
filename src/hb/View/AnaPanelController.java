/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Casper
 */
public class AnaPanelController implements Initializable {

    @FXML
    private void hayvanListesiController(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("hb/View/Hayvan/HayvanListeleFXML.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 700);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("Hayvanları Listele");
        stage.setScene(scene);
        stage.show();

        final Node anaPencere = (Node) event.getSource();
        final Stage anaStage = (Stage) anaPencere.getScene().getWindow();
        anaStage.close();

    }

    @FXML
    private void hayvanEkleController(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("hb/View/Hayvan/HayvanEkleFXML.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 500);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("Yeni Hayvan Ekle ");
        stage.setScene(scene);
        stage.show();

        final Node anaPencere = (Node) event.getSource();
        final Stage anaStage = (Stage) anaPencere.getScene().getWindow();
        anaStage.close();
    }
    @FXML
     private void bakiciListesiController(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("hb/View/Bakici/BakiciListeleFXML.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 700);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("Bakıcıları Listele");
        stage.setScene(scene);
        stage.show();

        final Node anaPencere = (Node) event.getSource();
        final Stage anaStage = (Stage) anaPencere.getScene().getWindow();
        anaStage.close();

    }

    @FXML
    private void bakiciEkleController(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("hb/View/Bakici/BakiciEkleFXML.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 500);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("Yeni Bakıcı Ekle ");
        stage.setScene(scene);
        stage.show();

        final Node anaPencere = (Node) event.getSource();
        final Stage anaStage = (Stage) anaPencere.getScene().getWindow();
        anaStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
