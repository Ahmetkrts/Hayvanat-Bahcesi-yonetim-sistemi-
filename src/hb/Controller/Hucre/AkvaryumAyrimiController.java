/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Controller.Hucre;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author techn
 */
public class AkvaryumAyrimiController implements Initializable {

    @FXML
    private Button anaGeriButon;

    @FXML
    private void anaGeriController(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Geri Dönme İstegi");
        alert.setHeaderText(null);
        alert.setContentText("Ana Menuye dönmek istediğinizden Eminmisiniz !! ");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getClassLoader().getResource("hb/View/AnaPanel.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 1195, 479);
                    Stage stage = new Stage();
                    stage.initStyle(StageStyle.TRANSPARENT);
                    Image image = new Image(getClass().getResourceAsStream("/hb/View/Images/chicken.png"));
                    stage.getIcons().add(image);
                    stage.setTitle("Hayvanat Bahçesi DashBoard");
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.show();

                    final Node anaPencere = (Node) event.getSource();
                    final Stage anaStage = (Stage) anaPencere.getScene().getWindow();
                    anaStage.close();
                } catch (IOException ex) {
                    Logger.getLogger(hb.Controller.Hucre.AkvaryumAyrimiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                //cancel tusuna basılınca yılacak işlem ancak yapılacak işlem yok 
            }
        });

    }

    @FXML
    private void yirticiakvaryum(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("hb/View/Hucre/TehliklkeliBalikAkvaryumu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 700);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        Image image = new Image(getClass().getResourceAsStream("/hb/View/Images/chicken.png"));
        stage.getIcons().add(image);
        stage.setResizable(true);
        stage.setTitle("Akvaryumları Listele");
        stage.setScene(scene);
        stage.show();

        final Node anaPencere = (Node) event.getSource();
        final Stage anaStage = (Stage) anaPencere.getScene().getWindow();
        anaStage.close();

    }

    @FXML
    private void normalakvaryum(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("hb/View/Hucre/NormalBalikAkvaryumu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 700);
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
