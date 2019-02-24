/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.apache.commons.lang3.RandomStringUtils;
import vue.ListArticlesController;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AddArticleController implements Initializable {

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

   @FXML
    private void ajouter(ActionEvent event) throws SQLException {
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

 AffichageAjout af=new AffichageAjout();
 af.ajouterService(a);
     
 
  
        
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

    
}
