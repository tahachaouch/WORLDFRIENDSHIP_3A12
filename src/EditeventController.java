/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author user
 */
public class EditeventController implements Initializable {

    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField description;
    @FXML
    private JFXTextField phone;
    @FXML
    private JFXTextField twitter;
    @FXML
    private JFXTextField facebook;
    @FXML
    private JFXTextField place;
    @FXML
    private JFXTextField adresse;
    @FXML
    private JFXCheckBox parking;
    @FXML
    private JFXCheckBox cartecredit;
    @FXML
    private JFXCheckBox fumer;
    @FXML
    private JFXCheckBox wifi;
    @FXML
    private JFXCheckBox enfant;
    @FXML
    private JFXCheckBox famille;
    @FXML
    private Button ajout;
    @FXML
    private JFXCheckBox ascenseur;
    @FXML
    private JFXDatePicker date;
    @FXML
    private FontAwesomeIconView image;
    @FXML
    private ImageView pic;
    @FXML
    private FontAwesomeIconView image1;
    @FXML
    private ImageView pic1;
    @FXML
    private FontAwesomeIconView image2;
    @FXML
    private ImageView pic2;
    @FXML
    private FontAwesomeIconView image21;
    @FXML
    private ImageView pic3;
    @FXML
    private JFXComboBox<?> type;
    @FXML
    private JFXTextField adressemail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ModifierEvent(ActionEvent event) {
    }

    @FXML
    private void addImage4(MouseEvent event) {
    }

    @FXML
    private void addImage(MouseEvent event) {
    }

    @FXML
    private void addImage2(MouseEvent event) {
    }

    @FXML
    private void addImage3(MouseEvent event) {
    }
    
}
