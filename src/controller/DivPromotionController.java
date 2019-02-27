/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import service.PanierService;
import service.PromotionService;
import entities.Produit;
import entities.Promotion;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class DivPromotionController implements Initializable {

    @FXML
    private Pane sq;
    @FXML
    private AnchorPane ap;
    @FXML
private Label date;
    @FXML
    private Label desc;
    @FXML
    private Label produit;
    @FXML
    private Label idp;
    @FXML
    private Label pourcent;
    private int idpromo;

    /**
     * Initializes the controller class.
     */
    @Override

public void initialize(URL url, ResourceBundle rb) {}
        // TODO
        public void LoadValues(Promotion p) throws IOException, SQLException {
            PromotionService ps=new PromotionService();
        desc.setText(p.getDescription());
        date.setText(String.valueOf(p.getDate_promo()));
       
     idp.setText(String.valueOf(p.getId_promo()));
     idpromo= Integer.parseInt(idp.getText());
     pourcent.setText(String.valueOf(p.getPourcentage()));
     produit.setText(ps.SelectProduit(idpromo));
    }    

    @FXML
    private void supprimerPromotion(MouseEvent event) throws SQLException {
           PromotionService ps=new PromotionService();
        System.out.println(idpromo);
        ps.supprimerPromotion(idpromo);
    }

    @FXML
    private void modifierPomotion(MouseEvent event) {
    }
    
}
