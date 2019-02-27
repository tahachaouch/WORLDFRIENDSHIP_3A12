/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import service.PanierService;
import entities.Panier;
import entities.Produit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
public class CommandeDetailController implements Initializable {

    @FXML
    private Pane sq;
    @FXML
    private AnchorPane ap;
    @FXML
    private Label idc;
    @FXML
    private Label nomclient;
    @FXML
    private Label date;
    @FXML
    private Label price;
    @FXML
    private ListView<Produit> list;
    private ObservableList<Panier> data;

    /**
     * Initializes the controller class.
     */
    @Override

    public void initialize(URL url, ResourceBundle rb) {
        try {

            PanierService ps = new PanierService();

            data = ps.loadCommande();
            for (Panier d : data) {

                try {
                     TilePane b = new TilePane();
            b.setPadding(new javafx.geometry.Insets(30));
            TilePane c = new TilePane();
            FadeTransition ft = new FadeTransition(Duration.millis(1500));

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("DivCommande.fxml"));
                    Parent root = (Pane) loader.load();
                    DivCommandeController DHC = loader.getController();
                    DHC.LoadValues(d);
                    nomclient.setText(d.getName());
                    idc.setText(String.valueOf(d.getId_panier()));
                    date.setText(String.valueOf(d.getDate_ajout()));
                    list.getItems().clear();
                    list.getItems().addAll(DHC.LoadValues(d));
                    c.getChildren().removeAll();
                    
                    
                    c.getChildren().add(root);
                } catch (IOException ex) {
                    Logger.getLogger(CommandeDetailController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
