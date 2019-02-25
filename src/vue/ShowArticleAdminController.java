/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import controller.AffichageAjout;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Article;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ShowArticleAdminController implements Initializable {

    @FXML
    private AnchorPane tab;
    @FXML
    private FontAwesomeIconView trash;
    @FXML
    private JFXButton rjaime;
    @FXML
    private TextField nbrlikes;
    @FXML
    private Label txtitre;
    @FXML
    private Label txttags;
    @FXML
    private Label txtcree;
    @FXML
    private Rectangle txtimage;
    @FXML
    private Label txtblog;
    @FXML
    private JFXDrawer menu;
    @FXML
    private Label idd;

       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void DeleteArticle(MouseEvent event) throws SQLException {
     
     
 AffichageAjout af=new AffichageAjout();
 af.delete(idd.getText());
 Stage stage = (Stage) trash.getScene().getWindow();
     
        stage.close();
    }


  
   
 public void ShowArticleAdmin(int id) throws SQLException {
     AffichageAjout af= new AffichageAjout();
 Article ar = af.afficherService().filtered(e -> e.getId() == id).get(0);

      
         idd.setText(String.valueOf(ar.getId()));
        txtitre.setText(ar.getTitre_article());
        txtblog.setText(ar.getBlog());
        txttags.setText(ar.getTags());
      Image imageURI2 = new Image("file:C://wamp64/www/Images/" + ar.getImage());
        txtimage.setFill(new ImagePattern(imageURI2));
         DateFormat df1 = new SimpleDateFormat("MM/dd/yyyy");
       txtcree.setText(String.valueOf(df1.format(ar.getCree())));
       
 }

   
}
