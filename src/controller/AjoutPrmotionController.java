/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entities.Promotion;
import service.PanierService;
import service.PromotionService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AjoutPrmotionController implements Initializable {

    @FXML
    private Pane sq;
    @FXML
    private AnchorPane ap;
    @FXML
    private JFXTextField pour;
    @FXML
    private JFXButton val;
    @FXML
    private JFXTextField prod;
    @FXML
    private JFXTextField desc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void validerAjout(MouseEvent event) throws SQLException {
        int idprod = Integer.parseInt(prod.getText());
        float pourcentage = Float.parseFloat(pour.getText());
        Promotion p = new Promotion(pourcentage, desc.getText(), idprod);

        PromotionService ps = new PromotionService();

        ps.ajouterPromotion(p);
        Stage stage = (Stage) val.getScene().getWindow();
        stage.close();
    }

}
