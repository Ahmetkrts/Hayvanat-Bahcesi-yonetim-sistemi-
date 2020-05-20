/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Controller.Bakici;

import hb.Controller.Dosya;
import hb.Model.Bakici.bakici;
import hb.Model.Hayvan.Hayvan2;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Casper
 */
public class GuncelleBakiciController implements Initializable {

    //Bakicinın bakabilecegi Hayvanların listesi
    @FXML
    private TableView<Hayvan2> hayvanListesiTableView;
    @FXML
    private TableColumn<Hayvan2, Integer> col_hayvanNo;
    @FXML
    private TableColumn<Hayvan2, String> col_irki;
    @FXML
    private TableColumn<Hayvan2, String> col_isim;
    @FXML
    private TableColumn<Hayvan2, String> col_dogumTarihi;
    @FXML
    private TableColumn<Hayvan2, String> col_gelisTarihi;
    @FXML
    private TableColumn<Hayvan2, String> col_cinsiyeti;
    //Bakicinin baktıgı Hayvan listesi 
    @FXML
    private TableView<Hayvan2> bakiciHayvanListesiTableView;
    @FXML
    private TableColumn<Hayvan2, Integer> col_hayvanNo1;
    @FXML
    private TableColumn<Hayvan2, String> col_irki1;
    @FXML
    private TableColumn<Hayvan2, String> col_isim1;
    @FXML
    private TableColumn<Hayvan2, String> col_dogumTarihi1;
    @FXML
    private TableColumn<Hayvan2, String> col_gelisTarihi1;
    @FXML
    private TableColumn<Hayvan2, String> col_cinsiyeti1;

    @FXML
    private Button anaGeriButon;
    @FXML
    private DatePicker bakiciDogumTarihi;
    @FXML
    private TextField bakiciAd;
    @FXML
    private Button bakiciGuncelleButon;
    private int id;
    private String balikNitelikleri;
    private String memeliNitelikleri;
    private String kusNitelikleri;
    private String surungenNitelikleri;
    private int bakiciIndex;
    private bakici myBakici;
    private Dosya dosya = new Dosya();

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
                    Scene scene = new Scene(fxmlLoader.load(), 1000, 720);
                    Stage stage = new Stage();
                    stage.initStyle(StageStyle.TRANSPARENT);
                    Image image = new Image(getClass().getResourceAsStream("/hb/View/Images/chicken.png"));
                    stage.getIcons().add(image);
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
        Bakici.setBakiciNo(getId());
        Bakici.setBalikNitelik(getBalikNitelikleri());
        Bakici.setKusNitelik(getKusNitelikleri());
        Bakici.setMemeliNitelik(getMemeliNitelikleri());
        Bakici.setSurungenNitelik(getSurungenNitelikleri());
        List<Hayvan2> hayvanList = new ArrayList<>();

        for (Hayvan2 hayvan2 : bakiciHayvanListesiTableView.getItems()) {
            hayvanList.add(hayvan2);
        }
        Bakici.setHayvanList(hayvanList);
        try {

            List<bakici> bakiciList = dosya.BakiciDosyaOku("dosya/BakiciDosya.dat");
            bakiciList.set(bakiciIndex, Bakici);
            dosya.BakiciDosyaYaz(bakiciList, "dosya/BakiciDosya.dat");

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

    @FXML
    public void bakiciHayvanAta(ActionEvent event) {
        ObservableList<Hayvan2> data_table = FXCollections.observableArrayList();
        if (bakiciHayvanListesiTableView.getItems().size() != 0) {
            for (Hayvan2 hayvan2 : bakiciHayvanListesiTableView.getItems()) {
                data_table.add(hayvan2);
            }

        }

        data_table.add((Hayvan2) hayvanListesiTableView.getSelectionModel().getSelectedItem());
        
        bakiciHayvanListesiTableView.setItems(data_table);
        hayvanYukle(myBakici);
    }

    private void alanTemizle() {
        
        bakiciAd.setText(null);
        bakiciDogumTarihi.setValue(null);
    }

    public void bakiciDoldur(bakici bakici) {
        myBakici=bakici;
        bakiciAd.setText(bakici.getIsim());
        bakiciDogumTarihi.setValue(LocalDate.parse(bakici.getDogumTarihi()));
        setId(bakici.getBakiciNo());
        setBalikNitelikleri(bakici.getBalikNitelik());
        setKusNitelikleri(bakici.getKusNitelik());
        setMemeliNitelikleri(bakici.getMemeliNitelik());
        setSurungenNitelikleri(bakici.getSurungenNitelik());
        //loadDate Ye hayvan listesi ve 2 yolladıgımda bakıcının Hayvan listesini Dolduracak  
        List<Hayvan2> hayvanList = new ArrayList<>();
        if (bakici.getHayvanList() != null) {
            hayvanList.addAll(bakici.getHayvanList());
            loadDate(hayvanList, 2);
        }

        hayvanYukle(bakici);
    }

    private void hayvanYukle(bakici bakici) {
        List<Hayvan2> hayvanListesi = hayvanGetir(bakici);
        initCol();
        //loadDate Ye hayvan listesi ve 1 yolladıgımda bakıcının bakabilecegi Hayvanları listesini Dolduracak  
        loadDate(hayvanListesi, 1);
    }

    public List<Hayvan2> hayvanGetir(bakici bakici) {

        List<Hayvan2> hayvanTablosu = new ArrayList<>();
        List<Hayvan2> HayvanList = dosya.HayvanDosyaOku("dosya/HayvanListesi.dat");
        System.out.println("Burası Hayvan Getir");
        if (bakici.getBalikNitelik() != null) {
            System.out.println("Balık Var");
            for (Hayvan2 hayvan : HayvanList) {
                if (hayvan.getSinif().equals("Deniz Canlısı")) {
                    if (!hayvanVarMi(hayvan, bakici)) {
                        hayvanTablosu.add(hayvan);
                    }
                }
            }
        }
        if (bakici.getKusNitelik() != null) {
            System.out.println("Kuş Var");
            for (Hayvan2 hayvan : HayvanList) {
                if (hayvan.getSinif().equals("Kanatlı")) {
                    if (!hayvanVarMi(hayvan, bakici)) {
                        hayvanTablosu.add(hayvan);
                    }
                }
            }
        }
        if (bakici.getMemeliNitelik() != null) {
            System.out.println("Memeli Var");
            for (Hayvan2 hayvan : HayvanList) {
                if ((hayvan.getSinif().equals("Memeli")) || (hayvan.getSinif().equals("Memeli Deniz Canlısı"))) {
                    if (!hayvanVarMi(hayvan, bakici)) {
                        hayvanTablosu.add(hayvan);
                    }
                }
            }
        }
        if (bakici.getSurungenNitelik() != null) {
            System.out.println("Sürüngen Var");
            for (Hayvan2 hayvan : HayvanList) {
                if (hayvan.getSinif().equals("Sürüngen") || hayvan.getSinif().equals("Sürüngen Deniz Canlısı")) {
                    if (!hayvanVarMi(hayvan, bakici)) {
                        hayvanTablosu.add(hayvan);
                    }
                }
            }
        }

        return hayvanTablosu;

    }

    public Boolean hayvanVarMi(Hayvan2 hayvan, bakici bakici) {
        for (Hayvan2 hayvan2 : bakiciHayvanListesiTableView.getItems()) {
            System.out.println("Hayvan isim :" + hayvan.getIsmi() + "--" + hayvan2.getIsmi() + ":Hayvan 2 isim ");
            if (hayvan2.getIsmi() == null ? hayvan.getIsmi() == null : hayvan2.getIsmi().equals(hayvan.getIsmi())) {
                return true;
            }
        }

        return false;
    }

    private void initCol() {
        //Bakicinın Bakabilecegi Hayvanların Listesi 
        col_hayvanNo.setCellValueFactory(new PropertyValueFactory<>("hayvanNo"));
        col_irki.setCellValueFactory(new PropertyValueFactory<>("irki"));
        col_isim.setCellValueFactory(new PropertyValueFactory<>("ismi"));
        col_dogumTarihi.setCellValueFactory(new PropertyValueFactory<>("dogumTarihi"));
        col_gelisTarihi.setCellValueFactory(new PropertyValueFactory<>("gelisTarihi"));
        col_cinsiyeti.setCellValueFactory(new PropertyValueFactory<>("cinsiyeti"));
        //Bakicinın Baktıgı Hayvanları Listesi 
        col_hayvanNo1.setCellValueFactory(new PropertyValueFactory<>("hayvanNo"));
        col_irki1.setCellValueFactory(new PropertyValueFactory<>("irki"));
        col_isim1.setCellValueFactory(new PropertyValueFactory<>("ismi"));
        col_dogumTarihi1.setCellValueFactory(new PropertyValueFactory<>("dogumTarihi"));
        col_gelisTarihi1.setCellValueFactory(new PropertyValueFactory<>("gelisTarihi"));
        col_cinsiyeti1.setCellValueFactory(new PropertyValueFactory<>("cinsiyeti"));

        editTableCol();
    }

    private void editTableCol() {

    }

    private void loadDate(List<Hayvan2> HayvanList, int a) {
        ObservableList<Hayvan2> data_table = FXCollections.observableArrayList();
        for (Hayvan2 hayvan : HayvanList) {
            //System.out.println(hayvan.toString());
            //System.out.println("Hayvan Eklendi--*-*-*-*-*-*-*-*-*-*-----------------*****************");
            data_table.add(hayvan);
        }
        if (a == 1) {
            hayvanListesiTableView.setItems(data_table);
        } else {
            bakiciHayvanListesiTableView.setItems(data_table);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

    public int getBakiciIndex() {
        return bakiciIndex;
    }

    public void setBakiciIndex(int bakiciIndex) {
        this.bakiciIndex = bakiciIndex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBalikNitelikleri() {
        return balikNitelikleri;
    }

    public void setBalikNitelikleri(String balikNitelikleri) {
        this.balikNitelikleri = balikNitelikleri;
    }

    public String getMemeliNitelikleri() {
        return memeliNitelikleri;
    }

    public void setMemeliNitelikleri(String memeliNitelikleri) {
        this.memeliNitelikleri = memeliNitelikleri;
    }

    public String getKusNitelikleri() {
        return kusNitelikleri;
    }

    public void setKusNitelikleri(String kusNitelikleri) {
        this.kusNitelikleri = kusNitelikleri;
    }

    public String getSurungenNitelikleri() {
        return surungenNitelikleri;
    }

    public void setSurungenNitelikleri(String surungenNitelikleri) {
        this.surungenNitelikleri = surungenNitelikleri;
    }

}
