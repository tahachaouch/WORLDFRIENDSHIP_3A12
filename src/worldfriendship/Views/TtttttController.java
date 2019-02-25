/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldfriendship.Views;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import worldfriendship.Controllers.DivReviewController;
import worldfriendship.Entities.Event;
import worldfriendship.Entities.Review;
import worldfriendship.Services.EventService;
import worldfriendship.Services.GReviews;

/**
 * FXML Controller class
 *
 * @author user
 */
public class TtttttController implements Initializable {

    @FXML
    private Label title;
    @FXML
    private Label adresseH;
    @FXML
    private Button delete;
    @FXML
    private Label endD;
    @FXML
    private Label startD;
    @FXML
    private Label typeH;
    @FXML
    private Label nbrplace;
    @FXML
    private Label typeE;
    @FXML
    private Label adresseE;
    @FXML
    private Label discription;
    @FXML
    private Rectangle image;
    @FXML
    private Label idd;
    Event newEvent;
    @FXML
    private AnchorPane home;
    @FXML
    private ScrollPane scrollHomePage;
    @FXML
    private AnchorPane mainAP;
    @FXML
    private JFXHamburger affmenu;
    @FXML
    private JFXDrawer menu;
    @FXML
    private AnchorPane menuBar;
    @FXML
    private AnchorPane loginRegisterProfie;
    @FXML
    private HBox profileHB;
    @FXML
    private Circle photoProfilMenu;
    @FXML
    private HBox menuHB;
    @FXML
    private VBox profileVB;
    @FXML
    private JFXButton profilMenu;
    @FXML
    private JFXButton settingsProfile;
    @FXML
    private Label nameUserMenu;
    @FXML
    private Label labelLastLoginMenu;
    @FXML
    private Label LastLoginMenu;
    @FXML
    private JFXButton logoutMenu;
    @FXML
    private JFXButton admin;
    @FXML
    private AnchorPane barreRecherche;
    @FXML
    private JFXButton eventButton1;
    @FXML
    private VBox menuVB;
    @FXML
    private VBox accueilVB;
    @FXML
    private VBox catVB;
    @FXML
    private VBox sousMenuCat;
    @FXML
    private VBox eventVB;
    @FXML
    private JFXButton eventButton;
    @FXML
    private VBox sousMenuEvent;
    @FXML
    private JFXButton ajoutevent;
    @FXML
    private JFXButton listevent;
    @FXML
    private VBox blogVB;
    @FXML
    private JFXButton blogButton;
    @FXML
    private VBox sousMenuBlog;
    @FXML
    private VBox dealVB;
    @FXML
    private JFXButton dealButton;
    @FXML
    private VBox sousMenuDeal;
    @FXML
    private JFXButton catButton;
    @FXML
    private JFXButton eventButton11;
    @FXML
    private Button Edit;
    @FXML
    private JFXTextArea comment;
    @FXML
    private JFXButton AddReview;
    @FXML
    private Tab tabX;
    private ObservableList<Review> listreview;
    @FXML
    private JFXTabPane tab;
    @FXML
    private ScrollPane comments;
    @FXML
    private Tab tabY;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

  

  public void ShowEvent(int id) throws SQLException {
      //System.out.println(id);
      
        tab.getSelectionModel().select(tabY);
               EventService es=new EventService();
        newEvent = new Event(); 
        
            newEvent=es.afficherEvent().filtered(e -> e.getId_event() == id).get(0);
        
         // System.out.println(id);
        idd.setText(String.valueOf(newEvent.getId_event()));
        title.setText(newEvent.getTitle_event());
            discription.setText(newEvent.getDescription_event());
            adresseE.setText(newEvent.getAdresse_Event());
            typeE.setText(newEvent.getType_event());
            nbrplace.setText(String.valueOf(newEvent.getNbrplace_event()));
            typeH.setText(newEvent.getType_hebergement());
            adresseH.setText(newEvent.getAdressehebergement());
            
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
            startD.setText(sdf1.format(newEvent.getStartdateevent()));
            endD.setText(sdf1.format(newEvent.getEnddateevent()));

            Image imageURI = new Image("file:C:/wamp64/www/images/" + newEvent.getImage_Event());
            image.setFill(new ImagePattern(imageURI));
            Reviewslist(newEvent);
            
       
                

    
}

    @FXML
    private void deleteEvent(ActionEvent event) throws SQLException {
      
        EventService eventService = new EventService();
         eventService.deleteEvent(idd.getText());
        
          Stage stage = (Stage) delete.getScene().getWindow();
         stage.close();
    }

    @FXML
    private void addEvent(MouseEvent event) {
    }

    @FXML
    private void ShowListEvent(MouseEvent event) {
    }

    @FXML
    private void modifierEvent(ActionEvent event) throws SQLException, IOException {
        EventService af= new EventService();

                     Event s = af.afficherEvent().filtered(a -> a.getId_event()== Integer.parseInt(idd.getText())).get(0);
                     FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/editEvent.fxml"));
                        AnchorPane an = new AnchorPane();
                        an = (AnchorPane) loader.load();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(an));
                        EditEventController ds = loader.getController();
                        ds.oldValues(s.getId_event());
                        stage.show();
    }
    
    public void Reviewslist(Event e) throws SQLException{
         TilePane b = new TilePane();
        tab.getSelectionModel().select(tabX);
        b.setPadding(new javafx.geometry.Insets(30));
        TilePane c = new TilePane();

        GReviews gr = new GReviews();
        listreview = gr.ListReviews(e);
        
        for (Review d : listreview) {

            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/DivReview.fxml"));
                Parent root = (Pane) loader.load();
                DivReviewController DHC = loader.getController();
                DHC.LoadValues(d,e);

                //   c.setVgap(40);
                c.getChildren().removeAll();

                c.getChildren().add(root);
            } catch (IOException ex) {
                Logger.getLogger(TtttttController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        c.setPrefColumns(1);
        c.setPadding(new javafx.geometry.Insets(0));
        c.setHgap(25);
        c.setVgap(50);
        b.getChildren().add(c);
        b.setPrefWidth(1000);
        comments.setContent(b);
      //  scroll.getChildren().add(b);
        

    }

    @FXML
    private void addReview(ActionEvent event) throws SQLException {
        GReviews greviews = new GReviews();
        Review r = new Review();
        r.setCmt(comment.getText());
        r.setId_event(newEvent);
        java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        r.setDate(date_sql);
        greviews.addReview(r);
        Reviewslist(newEvent);
        
    }

    @FXML
    private void Reviewslist(javafx.event.Event event) throws SQLException {
   
        
    }
    }
    

 

