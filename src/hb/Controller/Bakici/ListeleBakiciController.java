/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Controller.Bakici;

import hb.Controller.Dosya;
import hb.Controller.Hayvan.*;
import hb.Model.Bakici.bakici;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Casper
 */
public class ListeleBakiciController implements Initializable {

    @FXML
    private Button anaGeriButon;
    @FXML
    private Button guncelleButon;
    @FXML
    private Button silButon;
    @FXML
    private TableColumn<?, ?> col_bakiciNo;
    @FXML
    private TableColumn<?, ?> col_bakiciAd;
    @FXML
    private TableColumn<?, ?> col_bakiciDogumTarihi;
    @FXML
    private AnchorPane guncelleAnchorPane;
    @FXML
    private AnchorPane silAnchorPane;
    @FXML
    private TableView<bakici> bakiciTablosu;
    private int id;
    private Dosya dosya = new Dosya();
    @FXML
    private TextArea bakicininOzekleri;

    @FXML
    public void dataTableSecim() {
        silAnchorPane.setVisible(true);
        guncelleAnchorPane.setVisible(true);
        bakicininOzekleri.setText(bakiciTablosu.getSelectionModel().getSelectedItem().toString());
    }

    @FXML
    private void anaGeriController(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
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
                    Logger.getLogger(ListeleBakiciController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                //cancel tusuna basılınca yılacak işlem ancak yapılacak işlem yok 
            }
        });

    }

    @FXML
    public void bakiciSilController(ActionEvent event) {

        bakici Bakici = bakiciTablosu.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Bakici Silme İstegi");
        alert.setHeaderText(null);
        alert.setContentText(Bakici.getIsim() + " İsimli Bakici Silmek İstediginizden Eminmisiniz!!! \n Bu işin Geri Dönüşü Yoktur!!! ");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
//                System.out.println("Secilen hayvan indexi: " + hayvanTablosu.getSelectionModel().getSelectedIndex() + "-*-*-*-*-*-*");
                List<bakici> BakiciList = new ArrayList<>();
                BakiciList = dosya.BakiciDosyaOku("dosya/BakiciDosya.dat/");
                BakiciList.remove(bakiciTablosu.getSelectionModel().getSelectedIndex());
                dosya.BakiciDosyaYaz(BakiciList, "dosya/BakiciDosya.dat/");
                System.out.println("Bakici Basariyla Silindi");
            } else {
                //cancel tusuna basılınca yılacak işlem ancak yapılacak işlem yok 
            }
        });
        initTable();
        loadDate();
        ekranitemizle();
    }

    @FXML
    private void bakiciGuncelleController(ActionEvent event) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getClassLoader().getResource("hb/View/Bakici/BakiciGuncelleFXML.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1200, 700);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            Image image = new Image(getClass().getResourceAsStream("/hb/View/Images/chicken.png"));
            stage.getIcons().add(image);
            stage.setResizable(false);
            stage.setTitle("Bakıcıları Güncelle");
            stage.setScene(scene);
            GuncelleBakiciController bakiciguncelle = fxmlLoader.getController();
            bakiciguncelle.bakiciDoldur(bakiciTablosu.getSelectionModel().getSelectedItem());
            bakiciguncelle.setBakiciIndex(bakiciTablosu.getSelectionModel().getSelectedIndex());
            stage.show();

            final Node anaPencere = (Node) event.getSource();
            final Stage anaStage = (Stage) anaPencere.getScene().getWindow();
            anaStage.close();
        } catch (IOException ex) {
            Logger.getLogger(ListeleHayvanController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTable();
        loadDate();
    }

    private void initTable() {
        initCol();
    }

    private void initCol() {
        silAnchorPane.setVisible(false);
        guncelleAnchorPane.setVisible(false);
        col_bakiciNo.setCellValueFactory(new PropertyValueFactory<>("bakiciNo"));
        col_bakiciAd.setCellValueFactory(new PropertyValueFactory<>("isim"));
        col_bakiciDogumTarihi.setCellValueFactory(new PropertyValueFactory<>("dogumTarihi"));
        editTableCol();
    }

    private void editTableCol() {

    }

    private void loadDate() {
        ObservableList<bakici> data_table = FXCollections.observableArrayList();
        List<bakici> BakiciList = new ArrayList<>();
        BakiciList = dosya.BakiciDosyaOku("dosya/BakiciDosya.dat/");

        for (bakici bakici : BakiciList) {

            // System.out.println(bakici.toString());
            data_table.add(bakici);
        }

        bakiciTablosu.setItems(data_table);
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

    public void ekranitemizle() {
        bakicininOzekleri.clear();
    }

}
