/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Controller.Bakici;

import hb.Controller.BakiciDosya;
import hb.Model.Bakici.bakici;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Casper
 */
public class EkleBakiciController implements Initializable {

    @FXML
    private Button anaGeriButon;
    @FXML
    private TextField bakiciAdText;
    @FXML
    private DatePicker bakiciDogumTarihiDate;
    @FXML
    private Button bakiciEkleButon;
    @FXML
    private CheckBox nitelikMemeli;
    @FXML
    private CheckBox nitelikSurungen;
    @FXML
    private CheckBox nitelikKus;
    @FXML
    private CheckBox nitelikBalik;

    private BakiciDosya dosya = new BakiciDosya();
    private int sayac = 0;

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
                    Scene scene = new Scene(fxmlLoader.load(), 1190, 440);
                    Stage stage = new Stage();
                    stage.setTitle("Hayvanat Bahçesi DashBoard");
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.show();

                    final Node anaPencere = (Node) event.getSource();
                    final Stage anaStage = (Stage) anaPencere.getScene().getWindow();
                    anaStage.close();
                } catch (IOException ex) {
                    Logger.getLogger(EkleBakiciController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                //cancel tusuna basılınca yılacak işlem ancak yapılacak işlem yok 
            }
        });

    }

    @FXML
    public void kayitEkleController(ActionEvent event) {

        bakici Bakici = new bakici();
        String isim = bakiciAdText.getText();
        String dogum = bakiciDogumTarihiDate.getValue().toString();
        try {
            Bakici.setIsim(isim);
            Bakici.setDogumTarihi(dogum);
            Bakici.setBalikNitelik(Bakici.Balik(secilimi(nitelikBalik.isSelected())));
            Bakici.setKusNitelik(Bakici.Kus(secilimi(nitelikKus.isSelected())));
            Bakici.setMemeliNitelik(Bakici.Memeli(secilimi(nitelikMemeli.isSelected())));
            Bakici.setSurungenNitelik(Bakici.Surungen(secilimi(nitelikSurungen.isSelected())));
            this.dosya.bakiciEkle((bakici) Bakici);
        } catch (Exception e) {
            System.out.println("Bakici eklenirken hata meydana geldi");
            e.getMessage();
        } finally {
            alanTemizle();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Başarılı");
            alert.setHeaderText(null);
            alert.setContentText("Bakici Eklme İşlemi Başarıyla Tamamlanmıştır...");

            alert.showAndWait();

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void alanTemizle() {
        nitelikBalik.setDisable(false);
        nitelikKus.setDisable(false);
        nitelikMemeli.setDisable(false);
        nitelikSurungen.setDisable(false);
        bakiciAdText.setText(null);
        bakiciDogumTarihiDate.setValue(null);
        nitelikBalik.setSelected(false);
        nitelikKus.setSelected(false);
        nitelikMemeli.setSelected(false);
        nitelikSurungen.setSelected(false);
    }

    private int secilimi(boolean secim) {

        if (secim) {
            return 1;
        } else {
            return 0;
        }
    }

    public void sayacArttir() {
        this.sayac++;
        System.out.println(secilimi(nitelikBalik.isSelected()));
        if (this.sayac == 2) {
            if (nitelikBalik.isSelected() == false && nitelikKus.isSelected() == false && nitelikMemeli.isSelected() != false && nitelikSurungen.isSelected() != false) {
                nitelikBalik.setDisable(true);
                nitelikKus.setDisable(true);
            } else if (nitelikBalik.isSelected() == false && nitelikKus.isSelected() != false && nitelikMemeli.isSelected() == false && nitelikSurungen.isSelected() != false) {
                nitelikBalik.setDisable(true);
                nitelikMemeli.setDisable(true);
            } else if (nitelikBalik.isSelected() == false && nitelikKus.isSelected() != false && nitelikMemeli.isSelected() != false && nitelikSurungen.isSelected() == false) {
                nitelikBalik.setDisable(true);
                nitelikSurungen.setDisable(true);
            } else if (nitelikBalik.isSelected() != false && nitelikKus.isSelected() == false && nitelikMemeli.isSelected() == false && nitelikSurungen.isSelected() != false) {
                nitelikKus.setDisable(true);
                nitelikMemeli.setDisable(true);
            } else if (nitelikBalik.isSelected() != false && nitelikKus.isSelected() == false && nitelikMemeli.isSelected() != false && nitelikSurungen.isSelected() == false) {
                nitelikKus.setDisable(true);
                nitelikSurungen.setDisable(true);
            } else if (nitelikBalik.isSelected() != false && nitelikKus.isSelected() != false && nitelikMemeli.isSelected() == false && nitelikSurungen.isSelected() == false) {
                nitelikMemeli.setDisable(true);
                nitelikSurungen.setDisable(true);
            }

            sayac = 0;
        }
        if (nitelikBalik.isSelected() != false && nitelikKus.isSelected() == false && nitelikMemeli.isSelected() == false && nitelikSurungen.isSelected() == false) {
            nitelikMemeli.setDisable(false);
            nitelikSurungen.setDisable(false);
            nitelikKus.setDisable(false);
        }
        if (nitelikBalik.isSelected() == false && nitelikKus.isSelected() != false && nitelikMemeli.isSelected() == false && nitelikSurungen.isSelected() == false) {
            nitelikMemeli.setDisable(false);
            nitelikSurungen.setDisable(false);
            nitelikBalik.setDisable(false);
        }
        if (nitelikBalik.isSelected() == false && nitelikKus.isSelected() == false && nitelikMemeli.isSelected() != false && nitelikSurungen.isSelected() == false) {
            nitelikBalik.setDisable(false);
            nitelikSurungen.setDisable(false);
            nitelikKus.setDisable(false);
        }
        if (nitelikBalik.isSelected() == false && nitelikKus.isSelected() == false && nitelikMemeli.isSelected() == false && nitelikSurungen.isSelected() != false) {
            nitelikMemeli.setDisable(false);
            nitelikBalik.setDisable(false);
            nitelikKus.setDisable(false);
        }
    }
}
