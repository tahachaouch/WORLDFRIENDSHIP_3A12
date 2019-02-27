/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXTextField;
import com.stripe.exception.StripeException;
import service.PanierService;
import entities.Produit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class CommandeConfirmationController implements Initializable {

    @FXML
    private Pane sq;
    @FXML
    private AnchorPane ap;
    @FXML
    private JFXTextField mp;
    @FXML
    private Button cmdB;
    @FXML
    private ListView<Produit> list;
    private ObservableList<Produit> data;
    @FXML
    private Label price;
    @FXML
    private Label pricepromo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list.getItems().clear();
        try {
            PanierService ps = new PanierService();
            data = ps.loadPanier();
            list.getItems().addAll(data);
            price.setText(String.valueOf(ps.getprixtotale()));
        } catch (SQLException ex) {
            Logger.getLogger(CommandeConfirmationController.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO

        // TODO
    }

    @FXML
    private void confirmer(MouseEvent event) throws SQLException, IOException {
        PanierService ps = new PanierService();
        if (mp.getText().equals(ps.getPass())) {

           
            Parent root = FXMLLoader.load(getClass().getResource("/vue/Facture.fxml"));
            cmdB.getScene().setRoot(root);
        }
        else
        {   Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Wrong");
        alert.setHeaderText("Mot de passe incorrecte");
        alert.setContentText("erreur ");

        alert.showAndWait();}

    }

}
