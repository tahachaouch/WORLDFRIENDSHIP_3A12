/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import service.PanierService;
import entities.Panier;
import entities.Produit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class CommandeController implements Initializable {

    @FXML
    private JFXTextField recherchetext;
    @FXML
    private ScrollPane pane;
    @FXML
    private JFXCheckBox checkdate;
    @FXML
    private Label price;
    @FXML
    private Button cmd;
    private ObservableList<Panier> data;
    @FXML
    private JFXDrawer menu;
    @FXML
    private JFXHamburger affmenu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            AnchorPane anchrone = FXMLLoader.load(getClass().getResource("/vue/MenuAdmin.fxml"));
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
            
            PanierService ps= new PanierService();
           // price.setText(Float.toString(ps.getprixtotale()));
            data = ps.loadCommande();
            for ( Panier d : data) {
                
                try {
                    
                    
                    
                    
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("DivCommande.fxml"));
                    Parent root = (Pane) loader.load();
                    DivCommandeController DHC = loader.getController();
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
            
                    
                    
                }catch (SQLException ex) {
                    Logger.getLogger(PanierController.class.getName()).log(Level.SEVERE, null, ex);
                }
//            ////////// end 9dima////////////
//
////        editicon.setVisible(false);
////        deleteicon.setVisible(false);
//            ////////// end 9dima////////////
//
////        editicon.setVisible(false);
////        deleteicon.setVisible(false);
//            ////////// end 9dima////////////
//
////        editicon.setVisible(false);
////        deleteicon.setVisible(false);
//            ////////// end 9dima////////////
//
////        editicon.setVisible(false);
////        deleteicon.setVisible(false);

    }
        // TODO
        

    @FXML
    private void RechercheDynamique(KeyEvent event) throws SQLException {
        PanierService ps= new PanierService();
                data=ps.loadCommande();
         FilteredList<Panier> filteredData = new FilteredList<>(data, e -> true);
        recherchetext.setOnKeyReleased(e
                -> {
            recherchetext.textProperty().addListener((ObservableValue<? extends String> ObservableValue, String oldValue, String newValue) -> {
                filteredData.setPredicate((Predicate<? super Panier>) new Predicate<Panier>() {
                    @Override
                    public boolean test(Panier d) {
                        if (newValue == null || newValue.isEmpty()) {
                            
                            return true;

                        }
                        String lowerCaseFilter = newValue.toLowerCase();
                        return d.getName().toLowerCase().contains(lowerCaseFilter.subSequence(0, lowerCaseFilter.length()));
                    }
                });
            });
            TilePane b = new TilePane();
        b.setPadding(new javafx.geometry.Insets(30));
        TilePane c = new TilePane();

        for ( Panier d : filteredData) {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("DivCommande.fxml"));
                Parent root = (Pane) loader.load();
                DivCommandeController DHC = loader.getController();
                DHC.LoadValues(d);
               
                //   c.setVgap(40);
                c.getChildren().removeAll();
               
                
                c.getChildren().add(root);
            } catch (IOException ex) {
                Logger.getLogger(PanierController.class.getName()).log(Level.SEVERE, null, ex);
            }   catch (SQLException ex) {
                    Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
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
@FXML
   private void triByDate(MouseEvent event) throws SQLException {
         
       PanierService ps= new PanierService();
       affichetrie();
//         
           
            }
   
    public void affichetrie() throws SQLException {

        PanierService ps = new PanierService();
        data = ps.triCommande();
        TilePane b = new TilePane();
        b.setPadding(new javafx.geometry.Insets(30));
        TilePane c = new TilePane();

        for (Panier d : data) {
            System.out.println(d.getDate_ajout());

            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("DivCommande.fxml"));
                Parent root = (Pane) loader.load();
                DivCommandeController DHC = loader.getController();

                DHC.LoadValues(d);

                //   c.setVgap(40);
                c.getChildren().removeAll();

                c.getChildren().add(root);
            } catch (IOException ex) {
                Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void deleteAll(ActionEvent event) throws SQLException {
         PanierService ps= new PanierService();
        ps.supprimerAllCommande();
    }

    @FXML
    private void deleteAll(MouseEvent event) {
    }
    
}
