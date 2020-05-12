/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Controller.Bakici;

import hb.Controller.BakiciDosya;
import hb.Model.Asi;
import hb.Model.Bakici.bakici;
import hb.Model.Hayvan.Hayvan2;
import hb.Model.Hayvan.denizCanlisiOlustur;
import hb.Model.Hayvan.kanatliOlustur;
import hb.Model.Hayvan.memeliDenizCanlisiOlustur;
import hb.Model.Hayvan.memeliOlustur;
import hb.Model.Hayvan.surungenDenizCanlisiOlustur;
import hb.Model.Hayvan.surungenOlustur;
import hb.Model.Ilac;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Casper
 */
public class GuncelleBakiciController implements Initializable {

    @FXML
    private Button anaGeriButon;
    @FXML
    private DatePicker bakiciDogumTarihi;
    @FXML
    private TextField bakiciAd;
    @FXML
    private Button bakiciGuncelleButon;
    private int bakiciIndex;
    private BakiciDosya dosya = new BakiciDosya();

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
                    fxmlLoader.setLocation(getClass().getClassLoader().getResource("hb/View/Bakici/BakiciListeleFXML.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 1000, 700);
                    Stage stage = new Stage();
                    stage.setTitle("Bakici Liste");
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.show();

                    final Node anaPencere = (Node) event.getSource();
                    final Stage anaStage = (Stage) anaPencere.getScene().getWindow();
                    anaStage.close();
                } catch (IOException ex) {
                    Logger.getLogger(GuncelleBakiciController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                //cancel tusuna basılınca yılacak işlem ancak yapılacak işlem yok 
            }
        });

    }

    @FXML
    public void kayitGuncelleController(ActionEvent event) {

        bakici Bakici = new bakici();
        Bakici.setIsim(bakiciAd.getText());
        Bakici.setDogumTarihi(bakiciDogumTarihi.getValue().toString());
        try {

            List<bakici> bakiciList = dosya.bakiciDosyaOku();
            bakiciList.set(bakiciIndex, Bakici);
            dosya.bakiciDosyaYaz(bakiciList);

        } catch (Exception e) {
            System.out.println("bakici guncelleme hata verdi");
            e.getMessage();
        } finally {
            alanTemizle();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Başarılı");
            alert.setHeaderText(null);
            alert.setContentText("Bakici Güncelleme İşlemi Başarıyla Tamamlanmıştır...");

            alert.showAndWait();

        }

    }

    private void alanTemizle() {
        bakiciAd.setText(null);
        bakiciDogumTarihi.setValue(null);
    }

    public int getBakiciIndex() {
        return bakiciIndex;
    }

    public void setBakiciIndex(int bakiciIndex) {
        this.bakiciIndex = bakiciIndex;
    }

    public void bakiciDoldur(bakici bakici) {
        bakiciAd.setText(bakici.getIsim());
        bakiciDogumTarihi.setValue(LocalDate.parse(bakici.getDogumTarihi()));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
