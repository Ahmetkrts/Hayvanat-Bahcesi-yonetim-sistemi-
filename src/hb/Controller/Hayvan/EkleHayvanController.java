/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Controller.Hayvan;

import hb.Controller.Dosya;
import hb.Model.Kapasite;
import hb.Controller.TheController;
import hb.Model.Asi;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Casper
 */
public class EkleHayvanController extends TheController implements Initializable {

    @FXML
    private ComboBox sinifComboBox;
    @FXML
    private TextField adTextField;
    @FXML
    private DatePicker gelisTarihiDatePicker;
    @FXML
    private DatePicker dogumTarihiDatePicker;
    @FXML
    private ChoiceBox turChoiceBox;
    @FXML
    private ChoiceBox ilacChoiceBox;
    @FXML
    private ChoiceBox cinsiyetChoiceBox;
    @FXML
    private ChoiceBox asiChoiceBox;
    @FXML
    private CheckBox extra1CheckBox;
    @FXML
    private CheckBox extra2CheckBox;
    @FXML
    private CheckBox extra3CheckBox;
    @FXML
    private CheckBox extra4CheckBox;
    @FXML
    private CheckBox extra5CheckBox;
    @FXML
    private CheckBox extra6CheckBox;

    private Dosya dosya = new Dosya();
    private Kapasite kapasite;

    private String sinifSecim;
    private String hucresecim;
    @FXML
    private Button anaGeriButon;
    @FXML
    private Button kayitEkleButon;
    @FXML
    private ChoiceBox hucreChoiceBox;

    @FXML
    public void kayitEkleController(ActionEvent event) {

        Hayvan2 hayvan = null;
        String isim = adTextField.getText();
        String irki = turChoiceBox.getValue().toString();
        String dogum = dogumTarihiDatePicker.getValue().toString();
        String gelis = gelisTarihiDatePicker.getValue().toString();
        hucresecim = hucreChoiceBox.getValue().toString();
        int cinsiyet = 0;
        if (cinsiyetChoiceBox.getValue().toString().equals("Erkek")) {
            cinsiyet = 1;
        }
        Asi asi = new Asi(asiChoiceBox.getValue().toString());
        Ilac ilac = new Ilac(ilacChoiceBox.getValue().toString());
        try {
            switch (this.sinifSecim) {
                case "Memeli":
                    memeliOlustur memeli = new memeliOlustur("Memeli", irki, isim, dogum, gelis, cinsiyet, ilac, asi, hucresecim);
                    memeli.setOfkeli(secilimi(extra1CheckBox.isSelected()));
                    memeli.setYirtici(secilimi(extra2CheckBox.isSelected()));
                    memeli.setGuvenlik(secilimi(extra3CheckBox.isSelected()));
                    memeli.setKilli(secilimi(extra4CheckBox.isSelected()));
                    memeli.setSosyal(secilimi(extra5CheckBox.isSelected()));
                    hayvan = memeli;
                    break;
                case "Memeli Deniz Canlısı":
                    memeliDenizCanlisiOlustur memeliDenizCanlisi = new memeliDenizCanlisiOlustur("Memeli Deniz Canlısı", irki, isim, dogum, gelis, cinsiyet, ilac, asi, hucresecim);
                    memeliDenizCanlisi.setOfkeli(secilimi(extra1CheckBox.isSelected()));
                    memeliDenizCanlisi.setAquaDisindaYasar(secilimi(extra2CheckBox.isSelected()));
                    hayvan = memeliDenizCanlisi;
                    break;
                case "Sürüngen":
                    surungenOlustur surungen = new surungenOlustur("Sürüngen", irki, isim, dogum, gelis, cinsiyet, ilac, asi, hucresecim);
                    surungen.setZehirli(secilimi(extra1CheckBox.isSelected()));
                    surungen.setGuvenlik(secilimi(extra2CheckBox.isSelected()));
                    surungen.setYemek(secilimi(extra3CheckBox.isSelected()));
                    surungen.setYirtici(secilimi(extra4CheckBox.isSelected()));
                    surungen.setBoy(secilimi(extra5CheckBox.isSelected()));
                    hayvan = surungen;
                    break;
                case "Sürüngen Deniz Canlısı":
                    surungenDenizCanlisiOlustur surungenDenizCanlisi = new surungenDenizCanlisiOlustur("Sürüngen Deniz Canlısı", irki, isim, dogum, gelis, cinsiyet, ilac, asi, hucresecim);
                    surungenDenizCanlisi.setZehirli(secilimi(extra1CheckBox.isSelected()));
                    surungenDenizCanlisi.setAquaDisindaYasar(secilimi(extra2CheckBox.isSelected()));
                    surungenDenizCanlisi.setGuvenlik(secilimi(extra3CheckBox.isSelected()));
                    surungenDenizCanlisi.setYemek(secilimi(extra4CheckBox.isSelected()));
                    surungenDenizCanlisi.setYirtici(secilimi(extra5CheckBox.isSelected()));
                    surungenDenizCanlisi.setBoy(secilimi(extra6CheckBox.isSelected()));
                    hayvan = surungenDenizCanlisi;
                    break;
                case "Deniz Canlısı":
                    denizCanlisiOlustur denizCanlisi = new denizCanlisiOlustur("Deniz Canlısı", irki, isim, dogum, gelis, cinsiyet, ilac, asi, hucresecim);
                    denizCanlisi.setAquaDisindaYasar(secilimi(extra1CheckBox.isSelected()));
                    denizCanlisi.setYemek(secilimi(extra2CheckBox.isSelected()));
                    denizCanlisi.setYirtici(secilimi(extra3CheckBox.isSelected()));
                    denizCanlisi.setSosyal(secilimi(extra4CheckBox.isSelected()));
                    denizCanlisi.setGuvenlik(secilimi(extra5CheckBox.isSelected()));
                    hayvan = denizCanlisi;

                    break;
                case "Kanatlı":
                    kanatliOlustur kanatli = new kanatliOlustur("Kanatlı", irki, isim, dogum, gelis, cinsiyet, ilac, asi, hucresecim);
                    kanatli.setUcaBilir(secilimi(extra1CheckBox.isSelected()));
                    kanatli.setYirtici(secilimi(extra2CheckBox.isSelected()));
                    kanatli.setBeslenme(secilimi(extra3CheckBox.isSelected()));
                    kanatli.setGuvenlik(secilimi(extra4CheckBox.isSelected()));
                    hayvan = kanatli;
                    break;
                default:
                    System.out.println("Boş ");
                    break;
            }

            //hayvan = new Hayvan(irki, isim, dogum, gelis, cinsiyet, ilac, asi);
            this.dosya.Ekle(hayvan,"dosya/HayvanListesi.dat");
            this.kapasite = new Kapasite();
            switch (this.hucresecim) {
                case "Tehlikeli Balık Akvaryumu":
                    this.dosya.Ekle(hayvan , "dosya/TehlikeliBalıkAkvaryumu.dat");
                    this.kapasite.TehlikeliAkvaryumKapasiteArttir();

                    System.out.println("Tehlikeli Balık Akvaryumuna dosya eklendi");
                    break;
                case "Normal Balık Akvaryumu":
                    this.dosya.Ekle(hayvan , "dosya/NormalBalıkAkvaryumu.dat");
                    this.kapasite.NormalAkvaryumKapasiteArttir();

                    System.out.println("Normal Balık Akvaryumuna dosya eklendi");
                    break;
                case "Tehlikeli Açık Alan":
                    this.dosya.Ekle(hayvan , "dosya/TehlikeliAcikAlan.dat");
                    this.kapasite.TehlikeliAcikAlanKapasiteArttir();

                    System.out.println("Tehlikeli Memeli Acik alana eklendi");
                    break;
                case "Normal Açık Alan":
                    this.dosya.Ekle(hayvan , "dosya/NormalAcikAlan.dat");
                    this.kapasite.NormalAcikAlanArttir();
                    System.out.println("Normal Memeli Acik alana eklendi");
                    break;
                case "Kuş Kafesi":
                    this.dosya.Ekle(hayvan , "dosya/KusKafesi.dat");
                    this.kapasite.KusKapasiteArttir();
                    System.out.println("Kus Kafesi alana eklendi");
                    break;
                case "Sulu Açık Alan":
                    this.dosya.Ekle(hayvan , "dosya/SuluAcik.dat");
                    this.kapasite.SuluAcikkapasiteArttir();
                    System.out.println("Sulu Acik alana eklendi");
                    break;
            }

        } catch (Exception e) {
            System.out.println("ekle hayvan geldi hata");
            e.getMessage();
        } finally {
            alanTemizle();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Başarılı");
            alert.setHeaderText(null);
            alert.setContentText("Hayvan Eklme İşlemi Başarıyla Tamamlanmıştır...");

            alert.showAndWait();

        }

    }

    private int secilimi(boolean secim) {

        if (secim) {
            return 1;
        } else {
            return 0;
        }
    }

    private void alanTemizle() {
        sinifComboBox.getSelectionModel().clearSelection();;
        adTextField.setText(null);
        gelisTarihiDatePicker.setValue(null);
        dogumTarihiDatePicker.setValue(null);
        turChoiceBox.getSelectionModel().clearSelection();
        ilacChoiceBox.getSelectionModel().clearSelection();
        cinsiyetChoiceBox.getSelectionModel().clearSelection();
        asiChoiceBox.getSelectionModel().clearSelection();
        hucreChoiceBox.getSelectionModel().clearSelection();

        checkBoxControl(null, null, null, null, null, null);
    }

    @FXML
    public void turDoldur() {
        String secim = sinifComboBox.getValue().toString();

        switch (secim) {
            case "Memeli":
                sinifSecim = "Memeli";
                turChoiceBox.getItems().clear();
                hucreChoiceBox.getItems().clear();
                turChoiceBox.getItems().addAll("Kaplan", "Aslan", "Yunus Balığı", "Yarasa");
                checkBoxControl("Öfkeli", "Yırtıcı", "Extra Güvenlik", "Kıllı", "Sosyal", null);
                hucreChoiceBox.getItems().addAll("Tehlikeli Açık Alan", "Normal Açık Alan");

                break;
            case "Memeli Deniz Canlısı":
                sinifSecim = "Memeli Deniz Canlısı";
                turChoiceBox.getItems().clear();
                hucreChoiceBox.getItems().clear();
                turChoiceBox.getItems().addAll("Kaplan", "Aslan", "Yunus Balığı", "Yarasa");
                checkBoxControl("Öfkeli", "Aqua Dışında Yaşar", null, null, null, null);
                hucreChoiceBox.getItems().addAll("Tehlikeli Balık Akvaryumu", "Normal Balık Akvaryumu");

                break;
            case "Sürüngen":
                sinifSecim = "Sürüngen";
                turChoiceBox.getItems().clear();
                hucreChoiceBox.getItems().clear();
                turChoiceBox.getItems().addAll("Kertenkele", "Timsah", "Yılan", "Sümüklü Böcek");
                checkBoxControl("Zehirli", "Extra Güvenlik", "Et ile Beslenir", "Yırtıcı", "Boy 5 Metreden Büyük", null);
                hucreChoiceBox.getItems().addAll("Sulu Açık Alan");
                break;
            case "Sürüngen Deniz Canlısı":
                sinifSecim = "Sürüngen Deniz Canlısı";
                turChoiceBox.getItems().clear();
                hucreChoiceBox.getItems().clear();
                turChoiceBox.getItems().addAll("Kertenkele", "Timsah", "Yılan", "Sümüklü Böcek");
                checkBoxControl("Zehirli", "Aqua Dışında Yaşar", "Extra Güvenlik", "Et ile Beslenir", "Yırtıcı", "Boy 5 Mtreden Büyük");
                hucreChoiceBox.getItems().addAll("Sulu Açık Alan");
                break;
            case "Deniz Canlısı":
                sinifSecim = "Deniz Canlısı";
                turChoiceBox.getItems().clear();
                hucreChoiceBox.getItems().clear();
                turChoiceBox.getItems().addAll("Ala Balık", "Hamsi", "Kılıç Balıgı", "Köpek Balığı");
                checkBoxControl("Aqua Dışında Yaşar", "Et ile beslenir", "Yırtıcı", "Sosyal", "Extra Güvenlik", null);
                hucreChoiceBox.getItems().addAll("Tehlikeli Balık Akvaryumu", "Normal Balık Akvaryumu");
                break;
            case "Kanatlı":
                sinifSecim = "Kanatlı";
                turChoiceBox.getItems().clear();
                hucreChoiceBox.getItems().clear();
                turChoiceBox.getItems().addAll("Papağan", "Serçe", "Bülbül", "Tavus kuşu");
                checkBoxControl("Uçabilir", "Yırtıcı", "Et ile Beslenir", "Extra Güvenlik", null, null);
                hucreChoiceBox.getItems().addAll("Kuş Kafesi");
                break;
            default:
                System.out.println("Boş ");
                break;
        }

    }

    private void check(CheckBox ch, String s) {
        if (s == null) {
            ch.setVisible(false);
            ch.setText("Null");
        } else {
            ch.setSelected(false);
            ch.setVisible(true);
            ch.setText(s);
        }

    }

    private void checkBoxControl(String extra1, String extra2, String extra3, String extra4, String extra5, String extra6) {
        if (extra1 != null) {
            extra1CheckBox.setSelected(false);
            extra1CheckBox.setVisible(true);
            extra1CheckBox.setText(extra1);
        }
        if (extra1 == null) {
            extra1CheckBox.setVisible(false);
            extra1CheckBox.setText("null");
        }
        if (extra2 != null) {
            extra2CheckBox.setSelected(false);
            extra2CheckBox.setVisible(true);
            extra2CheckBox.setText(extra2);
        }
        if (extra2 == null) {
            extra2CheckBox.setVisible(false);
            extra2CheckBox.setText("null");
        }
        if (extra3 != null) {
            extra3CheckBox.setSelected(false);
            extra3CheckBox.setVisible(true);
            extra3CheckBox.setText(extra3);
        }
        if (extra3 == null) {
            extra3CheckBox.setVisible(false);
            extra3CheckBox.setText("null");
        }
        if (extra4 != null) {
            extra4CheckBox.setSelected(false);
            extra4CheckBox.setVisible(true);
            extra4CheckBox.setText(extra4);
        }
        if (extra4 == null) {
            extra4CheckBox.setVisible(false);
            extra4CheckBox.setText("null");
        }
        if (extra5 != null) {
            extra5CheckBox.setSelected(false);
            extra5CheckBox.setVisible(true);
            extra5CheckBox.setText(extra5);
        }
        if (extra5 == null) {
            extra5CheckBox.setVisible(false);
            extra5CheckBox.setText("null");
        }
        if (extra6 != null) {
            extra6CheckBox.setSelected(false);
            extra6CheckBox.setVisible(true);
            extra6CheckBox.setText(extra6);
        }
        if (extra6 == null) {
            extra6CheckBox.setVisible(false);
            extra6CheckBox.setText("null");
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
                    Logger.getLogger(EkleHayvanController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                //cancel tusuna basılınca yılacak işlem ancak yapılacak işlem yok 
            }
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        extra1CheckBox.setVisible(false);
        extra2CheckBox.setVisible(false);
        extra3CheckBox.setVisible(false);
        extra4CheckBox.setVisible(false);
        extra5CheckBox.setVisible(false);
        extra6CheckBox.setVisible(false);
        sinifComboBox.getItems().addAll("Memeli", "Memeli Deniz Canlısı", "Sürüngen", "Sürüngen Deniz Canlısı", "Deniz Canlısı", "Kanatlı");
        cinsiyetChoiceBox.getItems().addAll("Erkek", "Dişi");
        ilacChoiceBox.getItems().addAll("AVA-BioThrax", "DTaP", "PCV13", "Rabies", "RV1", "RV5", "Vaccinia", "Tenivac", "MMRV", "Typhoid-Oral", "Flulaval", "MenACWY", "MenB", "Fluzone", "Zostavax");
        asiChoiceBox.getItems().addAll("Lovetoin", "Trandoronate", "Afanuma", "Cortimadin", "Tetapitant", "Ablastral", "Bactaxime", "Allokyn", "Sublamin", "Nornex", "Adiline", "Veratasol");

    }

    public String getSinifSecim() {
        return sinifSecim;
    }

    public void setSinifSecim(String sinifSecim) {
        this.sinifSecim = sinifSecim;
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