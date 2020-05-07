/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Controller.Hayvan;

import hb.Controller.Dosya;
import hb.Model.Asi;
import hb.Model.Hayvan.Hayvan;
import hb.Model.Hucre.Hucre;
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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Casper
 */
public class ListeleHayvanController implements Initializable {

    @FXML
    private TableView<Hayvan> hayvanTablosu;
    @FXML
    private TableColumn<Hayvan, Integer> col_hayvanNo;
    @FXML
    private TableColumn<Hayvan, String> col_irk;
    @FXML
    private TableColumn<Hayvan, String> col_isim;
    @FXML
    private TableColumn<Hayvan, String> col_dogumTarih;
    @FXML
    private TableColumn<Hayvan, String> col_gelisTarih;
    @FXML
    private TableColumn<Hayvan, String> col_cinsiyet;
    @FXML
    private AnchorPane hayvanOzellikleri;
    @FXML
    private TextArea hayvanOzellikTextArea;
    Dosya dosya = new Dosya();

    @FXML
    public void dataTableSecim() {
        hayvanOzellikleri.setVisible(true);
        hayvanOzellikTextArea.setText(hayvanTablosu.getSelectionModel().getSelectedItem().toString());
        //System.out.println("Hayvanın İsmi" + hayvanTablosu.getSelectionModel().getSelectedItem()

    }

    @FXML
    private void hayvanGuncelleController(ActionEvent event) {
        try {
            System.out.println("bastım");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getClassLoader().getResource("hb/View/Hayvan/HayvanGuncelleFXML.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1200, 680);
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setTitle("Hayvanları Güncelle");
            stage.setScene(scene);
            stage.show();

            final Node anaPencere = (Node) event.getSource();
            final Stage anaStage = (Stage) anaPencere.getScene().getWindow();
            anaStage.close();
        } catch (IOException ex) {
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
                    Scene scene = new Scene(fxmlLoader.load(), 600, 450);
                    Stage stage = new Stage();
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
        hayvanOzellikleri.setVisible(false);
    }

    private void initTable() {
        initCol();
    }

    private void initCol() {

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
        ObservableList<Hayvan> data_table = FXCollections.observableArrayList();
        List<Hayvan> HayvanList = new ArrayList<>();
        /*
        List<Hayvan> HayvanList=new ArrayList<>();
        for (Hayvan hayvan : HayvanList) {
             data_table.add(hayvan);
        }*/

 /*
        for (int i = 0; i < 10; i++) {
            HayvanList.add(new Hayvan("Memeli-" + i,  "Deneme-" + i, ""
                    + "15.03.1998-" + i, "15.03.2001-" + i, 1, new Ilac("Parol" + i), new Asi("Tetenoz" + i)));
            /*data_table.add(new Hayvan("Memeli-" + i, "Kafes-" + i, "Deneme-" + i, ""
                    + "15.03.1998-" + i, "15.03.2001-" + i, 1, new Ilac("Parol" + i), new Asi("Tetenoz" + i),new Hucre(i, i, "ahmet", "asd", i, i)));

        }*/
        HayvanList = dosya.hayvanDosyaOku();

        for (Hayvan hayvan : HayvanList) {
            System.out.println("geldim buraya kadar ");
            System.out.println(hayvan.toString());
            data_table.add(hayvan);
        }

        hayvanTablosu.setItems(data_table);
    }
}
