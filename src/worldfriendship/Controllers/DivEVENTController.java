/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldfriendship.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import worldfriendship.Entities.Event;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import worldfriendship.Views.TtttttController;

/**
 * FXML Controller class
 *
 * @author user
 */
public class DivEVENTController implements Initializable {

    @FXML
    private AnchorPane ap;
    @FXML
    private Pane sq;
    @FXML
    private Label txttitre;
    @FXML
    private Label id;
    @FXML
    private Rectangle rectangle;
    @FXML
    private TextArea tt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   public void LoadValues(Event e) throws IOException {
        txttitre.setText(e.getTitle_event());
        tt.setText(e.getDescription_event());
        
        
        id.setText(String.valueOf(e.getId_event()));
       
        
       
//        sq.setPadding(new Insets(-10, -10, -10, -10));
// Image imageURI = new Image("file:C:/wamp64/www/Images/" + e.getImage());
//        circle.setFill(new ImagePattern(imageURI));
//       qualite.setRating(e.getMoyqualite());
        Image imageURI2 = new Image("file:C://wamp64/www/images/" + e.getImage_Event() );
        rectangle.setFill(new ImagePattern(imageURI2));
      /////////fhemna
    ap.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    try {
                        doubleclick(event,e);
                        //System.out.println(e.getId_event());
                    } catch (SQLException ex) {
                        Logger.getLogger(DivEVENTController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
    

      }
 public void doubleclick(MouseEvent event, Event selectedetab) throws SQLException {
       if (event.getClickCount() == 2) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/tttttt.fxml"));
                Parent root = loader.load();
                TtttttController SEC = loader.getController();
                //SEC.Reviewslist(selectedetab);
                
             //  System.out.println(selectedetab.getId_event());
               SEC.ShowEvent(selectedetab.getId_event());
                FXMLLoader loade = new FXMLLoader(getClass().getResource("../Views/HomePage.fxml"));
                Parent roo = loade.load();
                HomePageController Dhp = loade.getController();
                Stage ss=new Stage();
                Scene sc = new Scene(root);
                ss.setScene(sc);
                ss.setWidth(1288);
                ss.setHeight(750);
                
                
                ss.show();
                
       

            } catch (IOException ex) {
                Logger.getLogger(DivEVENTController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
   }
}
  


