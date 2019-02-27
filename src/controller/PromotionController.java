/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import service.PanierService;
import service.PromotionService;
import entities.Produit;
import entities.Promotion;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class PromotionController implements Initializable {

    @FXML
    private AnchorPane ap;
    private ScrollPane pane;
    private Label price;
    @FXML
    private Button del;
private ObservableList<Promotion> data;
    @FXML
    private ListView<Promotion> list;
    @FXML
    private JFXButton update;
    @FXML
    private JFXButton delete;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          list.getItems().clear();
        try {
            PromotionService ps= new PromotionService();
            data=ps.loadPromotion();
              list.getItems().addAll(data);
        } catch (SQLException ex) {
            Logger.getLogger(PromotionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          
    }    


    @FXML
    private void deleteAll(MouseEvent event) throws SQLException {
         PromotionService ps= new PromotionService();
         ps.deleteAll();
         list.getItems().clear();
    }


    @FXML
    private void delete(MouseEvent event) throws SQLException {
        PromotionService ps= new PromotionService();
    int item=list.getSelectionModel().getSelectedItem().getId_promo();
    ps.supprimerPromotion(item);
     data=ps.loadPromotion();
     list.getItems().clear();
    list.getItems().addAll(data);
    }

    @FXML
    private void ajouter(MouseEvent event) throws IOException {
        Stage stage=new Stage();
          Parent root = FXMLLoader.load(getClass().getResource("AjoutPromotion.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    
}
