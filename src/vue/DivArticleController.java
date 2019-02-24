/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


///////////TEST
package vue;

import controller.HomePageController;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Article;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
public class DivArticleController implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
public void LoadValues(Article e) throws IOException {
        txtitre.setText(e.getTitre_article());
        
        
        id.setText(String.valueOf(e.getId()));
        
        
       
//        sq.setPadding(new Insets(-10, -10, -10, -10));

       // Image imageURI = new Image("file:C:/wamp64/www/Images/" + e.getImage());
//        circle.setFill(new ImagePattern(imageURI));
//       qualite.setRating(e.getMoyqualite());
        Image imageURI2 = new Image("file:C://wamp64/www/Images/" + e.getImage());
        rectangle.setFill(new ImagePattern(imageURI2));
      /////////fhemna
        ap.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    try {
                        doubleclick(event, e);
                    } catch (SQLException ex) {
                        Logger.getLogger(DivArticleController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
    

      }
 public void doubleclick(MouseEvent event, Article selectedetab) throws SQLException {
       if (event.getClickCount() == 2) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/ShowArticle.fxml"));
                Parent root = loader.load();
               ShowArticleController DDC = loader.getController();
            // DDC.(selectedetab);
              DDC.ShowArticle(selectedetab.getId());
                FXMLLoader loade = new FXMLLoader(getClass().getResource("/vue/HomePage.fxml"));
                Parent roo = loade.load();
                HomePageController Dhp = loade.getController();
                Stage ss=new Stage();
                Scene sc = new Scene(root);
                ss.setScene(sc);
                ss.setWidth(1288);
                ss.setHeight(750);
                
                
                ss.show();

            } catch (IOException ex) {
                Logger.getLogger(DivArticleController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}