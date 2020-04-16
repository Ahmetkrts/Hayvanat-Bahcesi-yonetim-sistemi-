/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Controller.Bakici;

import hb.Controller.Hayvan.*;
import hb.Model.Hayvan.Asi;
import hb.Model.Hayvan.Hayvan;
import hb.Model.Hayvan.Ilac;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 *
 * @author Casper
 */
public class ListeleBakiciController implements Initializable {

    

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
                    Logger.getLogger(ListeleBakiciController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                //cancel tusuna basılınca yılacak işlem ancak yapılacak işlem yok 
            }
        });

    }
    @FXML
    private void bakiciGuncelleController(ActionEvent event) {
        try {
            
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getClassLoader().getResource("hb/View/Bakici/BakiciGuncelleFXML.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1200, 680);
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setTitle("Bakıcıları Güncelle");
            stage.setScene(scene);
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
        
       
        
        editTableCol();
    }

    private void editTableCol() {
        
        
    }
    private void loadDate()
    {/*
        ObservableList<Hayvan> data_table =FXCollections.observableArrayList();
        
        for (int i = 0; i < 25; i++) {
            data_table.add(new Hayvan("Memeli-"+i, "Kafes-"+i,"Deneme-"+i, ""
                    + "15.03.1998-"+i, "15.03.2001-"+i, 1, new Ilac("Parol"+i),new Asi("Tetenoz"+i)));
            
        }*/
        
    }
}
