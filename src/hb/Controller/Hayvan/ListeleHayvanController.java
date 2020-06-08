/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Controller.Hayvan;

import hb.Controller.Dosya;
import hb.Model.Kapasite;
import hb.Model.Asi;
import hb.Model.Hayvan.Hayvan2;
import hb.Model.Ilac;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArrayBase;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Casper
 */
public class ListeleHayvanController implements Initializable {

    @FXML
    private TableView<Hayvan2> hayvanTablosu;
    @FXML
    private TableColumn<Hayvan2, Integer> col_hayvanNo;
    @FXML
    private TableColumn<Hayvan2, String> col_irk;
    @FXML
    private TableColumn<Hayvan2, String> col_isim;
    @FXML
    private TableColumn<Hayvan2, String> col_dogumTarih;
    @FXML
    private TableColumn<Hayvan2, String> col_gelisTarih;
    @FXML
    private TableColumn<Hayvan2, String> col_cinsiyet;
    @FXML
    private AnchorPane hayvanOzellikleri;
    @FXML
    private TextArea hayvanOzellikTextArea;
    Dosya dosya = new Dosya();
    private Kapasite kapasite;

    @FXML
    private Button hayvanGuncelleButon;
    @FXML
    private AnchorPane hayvanGuncelleAnchorPane;
    @FXML
    private AnchorPane hayvanSilAnchorPane;
    @FXML
    private Button anaGeriButon;
    @FXML
    private Button hayvanSilButon;

    @FXML
    public void dataTableSecim() {
        hayvanOzellikleri.setVisible(true);
        hayvanSilAnchorPane.setVisible(true);
        hayvanGuncelleAnchorPane.setVisible(true);
        hayvanOzellikTextArea.setText(hayvanTablosu.getSelectionModel().getSelectedItem().toString());
        //System.out.println("Hayvanın İsmi" + hayvanTablosu.getSelectionModel().getSelectedItem()

    }

    @FXML
    public void hayvanSilController(ActionEvent event) {

        Hayvan2 hy = hayvanTablosu.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Hayvan Silme İstegi");
        alert.setHeaderText(null);
        alert.setContentText(hy.getIsmi() + " İsimli Hayvanı Silmek İstediginizden Eminmisiniz!!! \n Bu işin Geri Dönüşü Yoktur!!! ");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Secilen hayvan indexi: " + hayvanTablosu.getSelectionModel().getSelectedIndex() + "-*-*-*-*-*-*");
                List<Hayvan2> HayvanList = new ArrayList<>();
                HayvanList = dosya.HayvanDosyaOku("dosya/HayvanListesi.dat");
                HayvanList.remove(hayvanTablosu.getSelectionModel().getSelectedIndex());
                dosya.HayvanDosyaYaz(HayvanList, "dosya/HayvanListesi.dat");
            } else {
                //cancel tusuna basılınca yılacak işlem ancak yapılacak işlem yok 
            }
        });
        List<Hayvan2> HayvanList = new ArrayList<>();
        this.kapasite = new Kapasite();
        switch (hy.getHucre()) {
            case "Tehlikeli Balık Akvaryumu":
                this.kapasite.TehlikeliAkvaryumKapasiteAzalt();
                HayvanList = dosya.HayvanDosyaOku("dosya/TehlikeliBalıkAkvaryumu.dat");
                HayvanList.remove(hayvanTablosu.getSelectionModel().getSelectedIndex());
                dosya.HayvanDosyaYaz(HayvanList, "dosya/TehlikeliBalıkAkvaryumu.dat");

                break;
            case "Normal Balık Akvaryumu":
                this.kapasite.NormalAkvaryumKapasiteAzalt();
                HayvanList = dosya.HayvanDosyaOku("dosya/NormalBalıkAkvaryumu.dat");
                HayvanList.remove(hayvanTablosu.getSelectionModel().getSelectedIndex());
                dosya.HayvanDosyaYaz(HayvanList, "dosya/NormalBalıkAkvaryumu.dat");

                break;
            case "Normal Açık Alan":
                this.kapasite.NormalAcikAlanAzalt();
                HayvanList = dosya.HayvanDosyaOku("dosya/NormalAcikAlan.dat");
                HayvanList.remove(hayvanTablosu.getSelectionModel().getSelectedIndex());
                dosya.HayvanDosyaYaz(HayvanList, "dosya/NormalAcikAlan.dat");

                break;
            case "Tehlikeli Açık Alan":
                this.kapasite.TehlikeliAcikAlanKapasiteAzalt();
                HayvanList = dosya.HayvanDosyaOku("dosya/TehlikeliAcikAlan.dat");
                HayvanList.remove(hayvanTablosu.getSelectionModel().getSelectedIndex());
                dosya.HayvanDosyaYaz(HayvanList, "dosya/TehlikeliAcikAlan.dat");

                break;
            case "Kuş Kafesi":
                this.kapasite.KusKapasiteAzalt();

                HayvanList = dosya.HayvanDosyaOku("dosya/KusKafesi.dat");
                HayvanList.remove(hayvanTablosu.getSelectionModel().getSelectedIndex());
                dosya.HayvanDosyaYaz(HayvanList, "dosya/KusKafesi.dat");

                break;
            case "Sulu Açık Alan":
                this.kapasite.SuluAcikkapasiteAzalt();
                HayvanList = dosya.HayvanDosyaOku("dosya/SuluAcik.dat");
                HayvanList.remove(hayvanTablosu.getSelectionModel().getSelectedIndex());
                dosya.HayvanDosyaYaz(HayvanList, "dosya/SuluAcik.dat");

                break;
        }

        initTable();
        loadDate();

    }

    @FXML
    private void hayvanGuncelleController(ActionEvent event) {
        System.out.println("bastım");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("hb/View/Hayvan/HayvanGuncelleFXML.fxml"));
        try {

            // fxmlLoader.setLocation(getClass().getClassLoader().getResource("hb/View/Hayvan/HayvanGuncelleFXML.fxml"));
            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root, 1200, 700);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            Image image = new Image(getClass().getResourceAsStream("/hb/View/Images/chicken.png"));
            stage.getIcons().add(image);
            stage.setResizable(false);
            stage.setTitle("Hayvanları Güncelle");
            stage.setScene(scene);
            GuncelleHayvanController hayvanguncelle = fxmlLoader.getController();
            hayvanguncelle.hayvanDoldur(hayvanTablosu.getSelectionModel().getSelectedItem());
            hayvanguncelle.setHayvanIndex(hayvanTablosu.getSelectionModel().getSelectedIndex());
            stage.show();

            final Node anaPencere = (Node) event.getSource();
            final Stage anaStage = (Stage) anaPencere.getScene().getWindow();
            anaStage.close();
        } catch (IOException ex) {
            System.out.println("Pencereden Kaynaklı Sorun " + ex.getMessage());
            Logger.getLogger(ListeleHayvanController.class.getName()).log(Level.SEVERE, null, ex);
        }

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
                    Logger.getLogger(ListeleHayvanController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                //cancel tusuna basılınca yılacak işlem ancak yapılacak işlem yok 
            }
        });

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
        hayvanOzellikleri.setVisible(false);
        hayvanSilAnchorPane.setVisible(false);
        hayvanGuncelleAnchorPane.setVisible(false);
        col_hayvanNo.setCellValueFactory(new PropertyValueFactory<>("hayvanNo"));
        col_irk.setCellValueFactory(new PropertyValueFactory<>("irki"));
        col_isim.setCellValueFactory(new PropertyValueFactory<>("ismi"));
        col_dogumTarih.setCellValueFactory(new PropertyValueFactory<>("dogumTarihi"));
        col_gelisTarih.setCellValueFactory(new PropertyValueFactory<>("gelisTarihi"));
        col_cinsiyet.setCellValueFactory(new PropertyValueFactory<>("cinsiyeti"));

        editTableCol();
    }

    private void editTableCol() {

    }

    private void loadDate() {
        ObservableList<Hayvan2> data_table = FXCollections.observableArrayList();
        List<Hayvan2> HayvanList = new ArrayList<>();
        HayvanList = dosya.HayvanDosyaOku("dosya/HayvanListesi.dat");

        for (Hayvan2 hayvan : HayvanList) {
            //System.out.println(hayvan.toString());
            data_table.add(hayvan);
        }
        hayvanTablosu.setItems(data_table);
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

}
