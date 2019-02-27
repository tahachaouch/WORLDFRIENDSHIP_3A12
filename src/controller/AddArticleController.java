
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ch.qos.logback.core.util.Loader;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import controller.AffichageAjout;
import controller.AffichageAjout;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Article;
import static java.awt.SystemColor.menu;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import org.apache.commons.lang3.RandomStringUtils;
import org.controlsfx.control.PopOver;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import vue.ListArticlesController;
import vue.WebcamController;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AddArticleController implements Initializable {
    
    static Image img22;

    @FXML
    private TextField txttitre;
    @FXML
    private TextArea txtblog;
    @FXML
    private TextArea txttags;
    @FXML
  private FontAwesomeIconView image1;
    @FXML
    private ImageView pic1;
    @FXML
    private FontAwesomeIconView souscatw;
    @FXML
    private FontAwesomeIconView emailw;
    @FXML
    private FontAwesomeIconView libellew;
    @FXML
    private FontAwesomeIconView descriptionw;
    @FXML
    private JFXHamburger affmenu;
        @FXML
    private JFXDrawer menu;
    private Button openCam;
    @FXML
    private FontAwesomeIconView titrew;
    @FXML
    private FontAwesomeIconView tagw;
    @FXML
    private FontAwesomeIconView imgw;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            AnchorPane anchrone = FXMLLoader.load(getClass().getResource("/vue/test.fxml"));
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
            Logger.getLogger(AddArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
       
    }    
    
    public void setImgUploaded(Image image){
        pic1.setImage(image);
       
    }
    
   @FXML
    private void ajouter(ActionEvent event) throws SQLException {
        if (controleSaisie())
        {       
        Image image1 = pic1.getImage();
            String nameImage1 = saveToFileImageNormal(image1);
         String titre_article =txttitre.getText();
      //   String image=txtimage.getText();
 String blog;
        blog = txtblog.getText();
 String tags =txttags.getText();
  Article a =new Article();
 a.setImage(nameImage1);
 a.setTags(tags);
 a.setBlog(blog);
 a.setTitre_article(titre_article);
TrayNotification tray= new TrayNotification("Information","Article Ajouté", NotificationType.SUCCESS);
tray.setAnimationType(AnimationType.POPUP);
tray.showAndDismiss(Duration.seconds(3));
 AffichageAjout af=new AffichageAjout();
 af.ajouterService(a);
        }
 
  
        
    }
    public static String saveToFileImageNormal(Image image) {

        String ext = "jpg";
        File dir = new File("C:/wamp64/www/Images");
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
    private void addImage(MouseEvent event) throws IOException{
        openCam.setDisable(true);
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

    private void show(ActionEvent event) throws IOException {
     
    
    }

    public ImageView getPic1() {
        return pic1;
    }

    public void setPic1(ImageView pic1) {
        this.pic1 = pic1;
    }

    
    
  public boolean controleSaisie() {
        if (txttitre.getText().replaceAll("\\s+","").isEmpty()) {
            titrew.setVisible(true);
            txttitre.setStyle("-jfx-focus-color:red");
            txttitre.requestFocus();
            PopOver pop = new PopOver();
            pop.setContentNode(new Label("Veuillez choisir un titre"));

            titrew.setOnMouseEntered((event) -> {
                pop.show(titrew);
            });
            titrew.setOnMouseExited((event) -> {
                pop.hide();
            });
            txttitre.setOnKeyTyped((event2) -> {
                titrew.setVisible(false);
                txttitre.setStyle("-jfx-focus-color:green");
            });
            return false;

        }

        if (txtblog.getText().replaceAll("\\s+","").isEmpty()) {
            descriptionw.setVisible(true);
            txtblog.setStyle("-jfx-focus-color:red");
            txtblog.requestFocus();
            PopOver pop = new PopOver();
            pop.setContentNode(new Label("Veuillez saisir une description"));

            descriptionw.setOnMouseEntered((event) -> {
                pop.show(descriptionw);
            });
            descriptionw.setOnMouseExited((event) -> {
                pop.hide();
            });
            txtblog.setOnKeyTyped((event2) -> {
                descriptionw.setVisible(false);
                txtblog.setStyle("-jfx-focus-color:green");
            });
            return false;

        }
        if ((txttags.getText().replaceAll("\\s+","").isEmpty())) {
            tagw.setVisible(true);
            txttags.setStyle("-jfx-focus-color:red");
            txttags.requestFocus();
            PopOver pop = new PopOver();
            pop.setContentNode(new Label("Veuillez inserer des Tags"));

            tagw.setOnMouseEntered((event) -> {
                pop.show(tagw);
            });
            tagw.setOnMouseExited((event) -> {
                pop.hide();
            });
            txttags.setOnKeyTyped((event2) -> {
                tagw.setVisible(false);
                txttags.setStyle("-jfx-focus-color:green");
            });
            return false;

        }
      
          if ((pic1.getImage()==null)) {
            imgw.setVisible(true);
            pic1.setStyle("-jfx-focus-color:red");
            pic1.requestFocus();
            PopOver pop = new PopOver();
            pop.setContentNode(new Label("Veuillez choisir une photo "));

            imgw.setOnMouseEntered((event) -> {
                pop.show(imgw);
            });
            imgw.setOnMouseExited((event) -> {
                pop.hide();
            });
             pic1.setOnMouseClicked((event2) -> {
                try {
                    imgw.setVisible(false);
                    addImage(event2);
                } catch (IOException ex) {
                    Logger.getLogger(AddArticleController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
           
            return false;

        }
        

        

        return true;
    }

    @FXML
    private void showImg(MouseEvent event) throws IOException {
           
        image1.setDisable(true);
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/webcam.fxml"));
        Parent root = loader.load();
        WebcamController m = loader.getController();
        
        Stage stage = new Stage(StageStyle.DECORATED);

        stage.setScene(new Scene(root));
        stage.show();
        m.getClosecam().setOnMouseClicked(new EventHandler<MouseEvent>() {
           @Override
           public void handle(MouseEvent event) {
               setImgUploaded(m.getImg1().getImage());
               stage.close();
           }
       });
    }
    
}
