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
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Casper
 */
public class AnaPanelController implements Initializable {

    @FXML
    private void hayvanListesiController(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("hb/View/Hayvan/HayvanListeleFXML.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 715);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        Image image = new Image(getClass().getResourceAsStream("/hb/View/Images/chicken.png"));
        stage.getIcons().add(image);
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
        Scene scene = new Scene(fxmlLoader.load(), 900, 520);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        Image image = new Image(getClass().getResourceAsStream("/hb/View/Images/chicken.png"));
        stage.getIcons().add(image);
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
        Scene scene = new Scene(fxmlLoader.load(), 1000, 720);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        Image image = new Image(getClass().getResourceAsStream("/hb/View/Images/chicken.png"));
        stage.getIcons().add(image);
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
        Scene scene = new Scene(fxmlLoader.load(), 900, 520);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        Image image = new Image(getClass().getResourceAsStream("/hb/View/Images/chicken.png"));
        stage.getIcons().add(image);
        stage.setResizable(false);
        stage.setTitle("Yeni Bakıcı Ekle ");
        stage.setScene(scene);
        stage.show();

        final Node anaPencere = (Node) event.getSource();
        final Stage anaStage = (Stage) anaPencere.getScene().getWindow();
        anaStage.close();
    }

    @FXML
    private void akvaryum(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("hb/View/Hucre/AkvaryumAyrimi.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 476);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        Image image = new Image(getClass().getResourceAsStream("/hb/View/Images/chicken.png"));
        stage.getIcons().add(image);
        stage.setResizable(false);
        stage.setTitle("Akvaryumları Listele");
        stage.setScene(scene);
        stage.show();

        final Node anaPencere = (Node) event.getSource();
        final Stage anaStage = (Stage) anaPencere.getScene().getWindow();
        anaStage.close();

    }

    @FXML
    private void acıkalan(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("hb/View/Hucre/AcikAlanAyrimi.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 476);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        Image image = new Image(getClass().getResourceAsStream("/hb/View/Images/chicken.png"));
        stage.getIcons().add(image);
        stage.setResizable(false);
        stage.setTitle("Acık Alan Listele");
        stage.setScene(scene);
        stage.show();

        final Node anaPencere = (Node) event.getSource();
        final Stage anaStage = (Stage) anaPencere.getScene().getWindow();
        anaStage.close();

    }

    @FXML
    private void kus(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("hb/View/Hucre/KusKafesi.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 700);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        Image image = new Image(getClass().getResourceAsStream("/hb/View/Images/chicken.png"));
        stage.getIcons().add(image);
        stage.setResizable(false);
        stage.setTitle("Kus Listele");
        stage.setScene(scene);
        stage.show();

        final Node anaPencere = (Node) event.getSource();
        final Stage anaStage = (Stage) anaPencere.getScene().getWindow();
        anaStage.close();

    }

    @FXML
    private void suluacık(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("hb/View/Hucre/SuluAcikAlan.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 700);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        Image image = new Image(getClass().getResourceAsStream("/hb/View/Images/chicken.png"));
        stage.getIcons().add(image);
        stage.setResizable(false);
        stage.setTitle("Sulu Acık Listele");
        stage.setScene(scene);
        stage.show();

        final Node anaPencere = (Node) event.getSource();
        final Stage anaStage = (Stage) anaPencere.getScene().getWindow();
        anaStage.close();

    }
    double x, y;

    @FXML
    void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    void dragged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void min(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

}
