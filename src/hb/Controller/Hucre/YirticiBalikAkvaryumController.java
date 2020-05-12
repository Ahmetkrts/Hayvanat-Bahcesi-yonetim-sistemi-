/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Controller.Hucre;

import hb.Controller.Hayvan.*;
import hb.Controller.Dosya;
import hb.Controller.TehlikeliBalıkAkvaryumuDosya;
import hb.Model.Asi;
import hb.Model.Hayvan.Hayvan2;
import hb.Model.Ilac;
import hb.Model.Kapasite;
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
import javafx.scene.control.Label;
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
public class YirticiBalikAkvaryumController implements Initializable {

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
    private AnchorPane hayvanOzellikleri;
    private Kapasite kapasite;
    TehlikeliBalıkAkvaryumuDosya dosya = new TehlikeliBalıkAkvaryumuDosya();
    @FXML
    private Button anaGeriButon;
    @FXML
    private Label kapasiteLabel;

    @FXML
    public void dataTableSecim() {
        hayvanOzellikleri.setVisible(true);
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
                    fxmlLoader.setLocation(getClass().getClassLoader().getResource("hb/View/Hucre/AkvaryumAyrimi.fxml"));
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
                    Logger.getLogger(YirticiBalikAkvaryumController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                //cancel tusuna basılınca yılacak işlem ancak yapılacak işlem yok 
            }
        });

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        kapasite();
        initTable();
        loadDate();

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
        ObservableList<Hayvan2> data_table = FXCollections.observableArrayList();
        List<Hayvan2> HayvanList = new ArrayList<>();
        HayvanList = dosya.hayvanDosyaOku();

        for (Hayvan2 hayvan : HayvanList) {

            System.out.println(hayvan.toString());
            data_table.add(hayvan);
        }

        hayvanTablosu.setItems(data_table);
    }
     private void kapasite(){
        this.kapasite = new Kapasite();
        this.kapasiteLabel.setText("Kapasite ="+this.kapasite.getTehlikeliAkvaryumKapasite()+"/50");
    }
}
