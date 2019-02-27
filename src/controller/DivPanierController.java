/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import service.PanierService;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Article;
import entities.Produit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class DivPanierController implements Initializable {

    @FXML
    private AnchorPane ap;
    @FXML
    private Pane sq;
    @FXML
    private Label txtitre;
    @FXML
    private Label id;
    @FXML
    private Rectangle rectangle;
    @FXML
    private JFXButton del;
int idprod;
int quantite;
    @FXML
    private JFXTextField q;
    @FXML
    private Label price;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
public void LoadValues(Produit e) throws IOException {
        txtitre.setText(e.getNom_prod());
        price.setText(String.valueOf(e.getPrix()));
        
        
     id.setText(String.valueOf(e.getId_prod()));
     idprod= Integer.parseInt(id.getText());
     q.setText(String.valueOf(e.getQuantite()));
    // quantite=Integer.parseInt(q.getText());
        
        
       
        sq.setPadding(new Insets(-10, -10, -10, -10));

  Image imageURI2 = new Image("file:C://wamp64/www/Images/" + e.getImage());
        rectangle.setFill(new ImagePattern(imageURI2));
////      /////////fhemna
        ap.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                   // doubleclick(event, e);
                }

            }
        });
    

      }
// public void doubleclick(MouseEvent event, Produit selectedetab) {
//      /*  if (event.getClickCount() == 2) {
//            try {
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/ProfilHotel.fxml"));
//                Parent root = loader.load();
//                ProfilHotelController DDC = loader.getController();
//                DDC.Reviewslist(selectedetab);
//                DDC.RestoProfil(selectedetab.getId());
//                FXMLLoader loade = new FXMLLoader(getClass().getResource("../Views/HomePage.fxml"));
//                Parent roo = loade.load();
//                HomePageController Dhp = loade.getController();
//                Stage ss=new Stage();
//                Scene sc = new Scene(root);
//                ss.setScene(sc);
//                ss.setWidth(1288);
//                ss.setHeight(750);
//                
//                
//                ss.show();
//
//            } catch (IOException | SQLException ex) {
//                Logger.getLogger(ListrestoController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }*/
//    }

    @FXML
    private void supprimerProd(MouseEvent event) throws IOException, SQLException {
        PanierService ps=new PanierService();
        System.out.println(idprod);
        ps.supprimerProduit(idprod);
    }


    @FXML
    private void modifierProd(KeyEvent event) throws SQLException {
         PanierService ps=new PanierService();
        quantite=Integer.parseInt(q.getText());
        ps.modifierProduit(idprod, quantite);
    }
    
}
