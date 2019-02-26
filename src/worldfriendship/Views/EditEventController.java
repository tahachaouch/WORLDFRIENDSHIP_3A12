/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldfriendship.Views;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import org.apache.commons.lang3.RandomStringUtils;
import static org.apache.xalan.lib.ExsltDatetime.date;
import static org.apache.xalan.lib.ExsltDatetime.date;
import worldfriendship.Entities.Event;
import worldfriendship.Services.EventService;

/**
 * FXML Controller class
 *
 * @author user
 */
public class EditEventController implements Initializable {

    @FXML
    private AnchorPane home;
    @FXML
    private ScrollPane scrollHomePage;
    @FXML
    private AnchorPane mainAP;
    @FXML
    private JFXHamburger affmenu;
    @FXML
    private JFXTextField typeH;
    @FXML
    private JFXTextField typeE;
    @FXML
    private Button valider;
    @FXML
    private Label idd;
    @FXML
    private JFXTextField titre;
    @FXML
    private JFXTextArea discription;
    @FXML
    private DatePicker StartD;
    @FXML
    private DatePicker endD;
    @FXML
    private JFXTextField adresseE;
    @FXML
    private JFXTextField adresseH;
    @FXML
    private JFXTextField nbrplace;
    @FXML
    private ImageView image;
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
       Event e=new Event();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void addEvent(MouseEvent event) {
    }

    @FXML
    private void ShowListEvent(MouseEvent event) {
    }

    @FXML
    private void ModifierEvent(ActionEvent event) throws SQLException, IOException {
        EventService ess=new EventService();
        e.setTitle_event(titre.getText());
        e.setDescription_event(discription.getText());
        e.setAdresse_Event(adresseE.getText());
        e.setType_event(typeE.getText());
        e.setAdressehebergement(adresseH.getText());
        e.setType_hebergement(typeH.getText());
        
        java.util.Date datee = java.util.Date.from(StartD.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        
       java.util.Date datee2 = java.util.Date.from(endD.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
       java.sql.Date sqldate = new java.sql.Date(datee.getTime());
       java.sql.Date sqldate2 = new java.sql.Date(datee2.getTime());

                e.setStartdateevent(sqldate);
                e.setEnddateevent(sqldate2);
      
        
        Image image1 = image.getImage();
        String nameImage1 = saveToFileImageNormal(image1);
        e.setImage_Event(nameImage1);
        
        ess.modifierEvent(e, e.getId_event());


    }

    @FXML
    private void addimage(MouseEvent event) {
         FileChooser fc = new FileChooser();

        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fc.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        File selectedFile = fc.showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(selectedFile);
            Image img = SwingFXUtils.toFXImage(bufferedImage, null);
            image.setImage(img);         
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

    void oldValues(int id_event) throws SQLException {
        EventService x=new EventService();
        Event s = x.afficherEvent().filtered(e -> e.getId_event() == id_event).get(0);
        e.setId_event(id_event);
        titre.setText(s.getTitle_event());
         discription.setText(s.getDescription_event());
            adresseE.setText(s.getAdresse_Event());
            typeE.setText(s.getType_event());
            nbrplace.setText(String.valueOf(s.getNbrplace_event()));
            typeH.setText(s.getType_hebergement());
            adresseH.setText(s.getAdressehebergement());
            e.setImage_Event(s.getImage_Event());
            
           // SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
           // StartD.setValue(sdf1.format(s.getStartdateevent()));
           // endD.setText(String.valueOf(sdf1.format(s.getEnddateevent())));
            
            endD.setValue(LocalDate.parse(s.getEnddateevent().toString()));
            StartD.setValue(LocalDate.parse(s.getStartdateevent().toString()));

            Image imageURI = new Image("file:C:/wamp64/www/images/" + s.getImage_Event());
       image.setImage(imageURI);
           
    }
    
}
