/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import service.PanierService;
import entities.Article;
import entities.Produit;
import static java.awt.SystemColor.menu;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import static org.apache.commons.lang3.time.FastDateParserSDFTest.data;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PanierController implements Initializable {

    @FXML
    private AnchorPane ap;
    @FXML
    private JFXTextField recherchetext;
    @FXML
    private ScrollPane pane;
    private ObservableList<Produit> data;
    @FXML
    private JFXCheckBox checkprix;
    @FXML
    private JFXCheckBox checkdate;
    @FXML
    private Label price;
    @FXML
    private Button cmd;
    @FXML
    private JFXHamburger affmenu;
    @FXML
    private JFXDrawer menu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            AnchorPane anchrone = FXMLLoader.load(getClass().getResource("/vue/test.fxml"));
            menu.setSidePane(anchrone);

            HamburgerBackArrowBasicTransition burgerTask2 = new HamburgerBackArrowBasicTransition(affmenu);
            burgerTask2.setRate(-1);

            affmenu.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
                burgerTask2.setRate(burgerTask2.getRate() * -1);
                burgerTask2.play();

                if (menu.isShown()) {
                    menu.close();
                } else {
                    menu.open();
                    menu.toFront();
                }
            }
            );
        } catch (IOException ex) {
            Logger.getLogger(PanierController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            TilePane b = new TilePane();
            b.setPadding(new javafx.geometry.Insets(30));
            TilePane c = new TilePane();
            FadeTransition ft = new FadeTransition(Duration.millis(1500));

            PanierService ps = new PanierService();
            price.setText(Float.toString(ps.getprixtotale()));
            data = ps.loadPanier();
            for (Produit d : data) {

                try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("DivPanier.fxml"));
                    Parent root = (Pane) loader.load();
                    DivPanierController DHC = loader.getController();
                    DHC.LoadValues(d);

                    //   c.setVgap(40);
                    c.getChildren().removeAll();

                    c.getChildren().add(root);
                } catch (IOException ex) {
                    Logger.getLogger(PanierController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            c.setPrefColumns(3);
            c.setPadding(new javafx.geometry.Insets(0));
            c.setHgap(10);
            c.setVgap(80);
            b.getChildren().add(c);
            b.setPrefWidth(1000);
            pane.setContent(b);

        } catch (SQLException ex) {
            Logger.getLogger(PanierController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @FXML
    private void RechercheDynamique(KeyEvent event) throws SQLException {
        PanierService ps = new PanierService();
        data = ps.loadPanier();
        FilteredList<Produit> filteredData = new FilteredList<>(data, e -> true);
        recherchetext.setOnKeyReleased(e
                -> {
            recherchetext.textProperty().addListener((ObservableValue<? extends String> ObservableValue, String oldValue, String newValue) -> {
                filteredData.setPredicate((Predicate<? super Produit>) new Predicate<Produit>() {
                    @Override
                    public boolean test(Produit d) {
                        if (newValue == null || newValue.isEmpty()) {

                            return true;

                        }
                        String lowerCaseFilter = newValue.toLowerCase();
                        return d.getNom_prod().toLowerCase().contains(lowerCaseFilter.subSequence(0, lowerCaseFilter.length()));
                    }
                });
            });
            TilePane b = new TilePane();
            b.setPadding(new javafx.geometry.Insets(30));
            TilePane c = new TilePane();

            for (Produit d : filteredData) {

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("DivPanier.fxml"));
                    Parent root = (Pane) loader.load();
                    DivPanierController DHC = loader.getController();
                    DHC.LoadValues(d);

                    //   c.setVgap(40);
                    c.getChildren().removeAll();

                    c.getChildren().add(root);
                } catch (IOException ex) {
                    Logger.getLogger(PanierController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            c.setPrefColumns(3);
            c.setPadding(new javafx.geometry.Insets(0));
            c.setHgap(10);
            c.setVgap(80);
            b.getChildren().add(c);
            b.setPrefWidth(1000);
            pane.setContent(b);
        });
    }


    public void affichetrieNom() throws SQLException {

        PanierService ps = new PanierService();
        data = ps.triPanierByNom();
        TilePane b = new TilePane();
        b.setPadding(new javafx.geometry.Insets(30));
        TilePane c = new TilePane();

        for (Produit d : data) {
            System.out.println(d.getNom_prod());

            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("DivPanier.fxml"));
                Parent root = (Pane) loader.load();
                DivPanierController DHC = loader.getController();

                DHC.LoadValues(d);

                //   c.setVgap(40);
                c.getChildren().removeAll();

                c.getChildren().add(root);
            } catch (IOException ex) {
                Logger.getLogger(PanierController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        c.setPrefColumns(3);
        c.setPadding(new javafx.geometry.Insets(0));
        c.setHgap(10);
        c.setVgap(80);
        b.getChildren().add(c);
        b.setPrefWidth(1000);
        pane.setContent(b);

    }

    public void affichetriePrix() throws SQLException {

        PanierService ps = new PanierService();
        data = ps.triPanierByPrix();
        TilePane b = new TilePane();
        b.setPadding(new javafx.geometry.Insets(30));
        TilePane c = new TilePane();

        for (Produit d : data) {
            System.out.println(d.getPrix());

            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("DivPanier.fxml"));
                Parent root = (Pane) loader.load();
                DivPanierController DHC = loader.getController();

                DHC.LoadValues(d);

                //   c.setVgap(40);
                c.getChildren().removeAll();

                c.getChildren().add(root);
            } catch (IOException ex) {
                Logger.getLogger(PanierController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        c.setPrefColumns(3);
        c.setPadding(new javafx.geometry.Insets(0));
        c.setHgap(10);
        c.setVgap(80);
        b.getChildren().add(c);
        b.setPrefWidth(1000);
        pane.setContent(b);

    }

    @FXML
    private void triByPrix(MouseEvent event) throws SQLException {
        checkdate.setSelected(false);
        checkprix.setSelected(true);
        checkprix.setDisable(true);
        checkdate.setDisable(false);
        affichetriePrix();

    }

    @FXML
    private void triByNom(MouseEvent event) throws SQLException {
        checkprix.setSelected(false);
        checkprix.setDisable(false);
        checkdate.setSelected(true);
        checkdate.setDisable(true);
        affichetrieNom();
    }

    @FXML
    private void commander(MouseEvent event) throws SQLException, IOException {
        PanierService ps = new PanierService();
        if(ps.getNumberCommande()!=0)
        {
               Stage stage=new Stage();
          Parent root = FXMLLoader.load(getClass().getResource("CommandeConfirmation.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show(); }
    }

}
