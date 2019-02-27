/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import service.PanierService;
import entities.Panier;
import entities.Produit;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class DivCommandeController implements Initializable {

    @FXML
    private AnchorPane ap;
    @FXML
    private Pane sq;
    @FXML
    private Label idc;
    @FXML
    private Label nomclient;
    int idpanier;
    String nom;
    Date dateAjout ;
    private ObservableList<Produit> items = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
public ObservableList<Produit> LoadValues(Panier e) throws IOException, SQLException {
        idc.setText(String.valueOf(e.getId_panier()));
        nomclient.setText(e.getName());
        idpanier= Integer.parseInt(idc.getText());
         dateAjout=e.getDate_ajout();
    PanierService ps=new PanierService();
    items=ps.loadCommandeProduit(idpanier);
    return items;
        
        
//     id.setText(String.valueOf(e.getId_prod()));
//     idprod= Integer.parseInt(id.getText());
    // q.setText(String.valueOf(e.getQuantite()));
    // quantite=Integer.parseInt(q.getText());
        
        
       
//        sq.setPadding(new Insets(-10, -10, -10, -10));

       // Image imageURI = new Image("file:C:/wamp64/www/Images/" + e.getImage());
//        circle.setFill(new ImagePattern(imageURI));
//       qualite.setRating(e.getMoyqualite());
//        Image imageURI2 = new Image("file:C://wamp64/www/Images/" + e.getImage());
//        rectangle.setFill(new ImagePattern(imageURI2));
//      /////////fhemna
      
    

      }
//private void loadDate(Panier pan) throws SQLException     
//{
//    idpanier= Integer.parseInt(idc.getText());
//    nom=nomclient.getText();
//    dateAjout=pan.getDate_ajout();
//    PanierService ps=new PanierService();
//    items=ps.loadCommandeProduit(idpanier);
//    
//    
//    
//}
    @FXML
    private void afficherCommande(MouseEvent event) throws IOException {
         Stage stage=new Stage();
          Parent root = FXMLLoader.load(getClass().getResource("CommandeDetail.fxml"));
        
        Scene scene = new Scene(root);
    
        
        stage.setScene(scene);
        stage.show();
    }
    

    @FXML
    private void supprimerCommande(MouseEvent event) throws SQLException {
           PanierService ps=new PanierService();
        System.out.println(idpanier);
        ps.supprimerCommande(idpanier);
    }
    
}
