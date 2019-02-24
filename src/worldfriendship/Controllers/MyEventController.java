/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldfriendship.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import org.apache.commons.lang3.RandomStringUtils;
import worldfriendship.Entities.Event;
import worldfriendship.Services.EventService;

/**
 * FXML Controller class
 *
 * @author user
 */
public class MyEventController implements Initializable {

    @FXML
    private DatePicker dateS;
    @FXML
    private DatePicker dateE;
    @FXML
    private JFXTextField nbrPlace;
    @FXML
    private JFXTextField adresseE;
    @FXML
    private JFXTextField typeHbergement;
    @FXML
    private JFXTextField adresseHebergement;
    @FXML
    private JFXTextField title;
    @FXML
    private JFXTextArea description;
    @FXML
    private JFXComboBox<String> typeEvent;
    @FXML
    private JFXButton ajouterB;
    @FXML
    private ImageView pic1;
    @FXML
    private FontAwesomeIconView image1;
    @FXML
    private JFXDrawer menu;
    @FXML
    private JFXHamburger affmenu;
    @FXML
    private AnchorPane home;
    @FXML
    private ScrollPane scrollHomePage;
    @FXML
    private AnchorPane mainAP;
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
    

    /**
     * Initializes the controller class.
     */
    @Override
   public void initialize(URL url, ResourceBundle rb) {
       
       
       typeEvent.getItems().addAll("Sportif");             
       typeEvent.getItems().addAll("Humanitaire");
       typeEvent.getItems().addAll("Festival/Musée");
       typeEvent.getItems().addAll("Salon/Exposition");
       typeEvent.getItems().addAll("Randonnée");
       typeEvent.getItems().addAll("Camping");
       typeEvent.getItems().addAll("Road Trip");
       typeEvent.getItems().addAll("Voyage en sac à dos");
       typeEvent.getItems().addAll("Croisière");
       typeEvent.getItems().addAll("Formation");
       typeEvent.getItems().addAll("‎Fête");
       typeEvent.getItems().addAll("Autre..");

       
       /* try {
            AnchorPane anchrone = FXMLLoader.load(getClass().getResource("/Views/HomePage.fxml"));
            menu.setSidePane(anchrone);
            
            
            
            HamburgerBackArrowBasicTransition burgerTask2 = new HamburgerBackArrowBasicTransition(affmenu);
            burgerTask2.setRate(-1);

            affmenu.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
                burgerTask2.setRate(burgerTask2.getRate() * -1);
                burgerTask2.play();

                if (menu.isShown()) {
                    menu.close();
                } else {
                    menu.open();
                    menu.toFront();
                }
            }
            );
        } catch (IOException ex) {
            Logger.getLogger(MyEventController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
      
       
    } 
    @FXML
    private void addEvent(ActionEvent event) throws IOException, SQLException {
        EventService eventService = new EventService();
        Event newEvent  = new Event();
        
        Image image1 = pic1.getImage();
        String nameImage1 = saveToFileImageNormal(image1);
       
        newEvent.setImage_Event(saveToFileImageNormal(image1));
        newEvent.setTitle_event(title.getText());
        newEvent.setDescription_event(description.getText());
        newEvent.setAdresse_Event(adresseE.getText());
        newEvent.setType_event(typeEvent.getValue());
        
        Date dateSt = Date.valueOf(dateS.getValue());
        Date dateEd = Date.valueOf(dateE.getValue());
        newEvent.setStartdateevent(dateSt);
        newEvent.setEnddateevent(dateEd);
        
        //newEvent.setImage(nameImage1);
        newEvent.setNbrplace_event(Integer.parseInt(nbrPlace.getText()));
        newEvent.setImage_Event(nameImage1);
        newEvent.setAdressehebergement(adresseHebergement.getText());
        newEvent.setType_hebergement(typeHbergement.getText());
        
        eventService.addevent(newEvent);
        
         //FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/ShowEvent.fxml"));
           // Parent root = loader.load();
            //ascenseur.getScene().setRoot(root);
    } 

    @FXML
    private void openmap(MouseEvent event) {
    }

    @FXML
    private void addImage(MouseEvent event)throws IOException {
         FileChooser fc = new FileChooser();

        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (.png)", "*.PNG");
        fc.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        File selectedFile = fc.showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(selectedFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            pic1.setImage(image);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static String saveToFileImageNormal(Image image) {

        String ext = "jpg";
        File dir = new File("C:/wamp64/www/images");
        String name = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(8), ext);
        File outputFile = new File(dir, name);
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        try {
            ImageIO.write(bImage, "png", outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return name;
    }

    @FXML
    private void addEvent(MouseEvent event) {
    }


   

   


   
    
    
}
