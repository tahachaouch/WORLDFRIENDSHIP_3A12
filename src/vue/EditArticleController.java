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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class EditArticleController implements Initializable {

    @FXML
    private AnchorPane tab;
    @FXML
    private JFXButton rjaime;
    @FXML
    private TextField txtitre;
    @FXML
    private TextField txttags;
    @FXML
    private Label txtcree;
    @FXML
    private JFXHamburger affmenu;
    @FXML
    private ImageView txtimage;
    @FXML
    private TextArea txtblog;
    @FXML
    private JFXDrawer menu;
    @FXML
    private Label idd;
    @FXML
    private Button edit;
    private ImageView pic1;
    @FXML
    private FontAwesomeIconView image1;
Article a=new Article();
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
                 Logger.getLogger(EditArticleController.class.getName()).log(Level.SEVERE, null, ex);
             }
             
          
             
             
             
     
 
         
         
         
    }  
   
    public void oldValues(int idd) throws SQLException {
        AffichageAjout SS = new AffichageAjout();
        Article s = SS.afficherService().filtered(e -> e.getId() == idd).get(0);
        a.setId(idd);
        txtitre.setText(s.getTitre_article());
        txttags.setText(s.getTags());
        //.setText(String.valueOf(s.getCreateDt()));
        txtblog.setText(s.getBlog());
      //  pic1.setImage(s.getImage());
         Image imageURI2 = new Image("file:C://wamp64/www/Images/" + s.getImage());
        txtimage.setImage(imageURI2);
        DateFormat df1 = new SimpleDateFormat("MM/dd/yyyy");
       txtcree.setText(String.valueOf(df1.format(s.getCree())));
         }

    @FXML
    private void likeAction(ActionEvent event) {
    }

    @FXML
    private void edit(ActionEvent event) throws SQLException {
     AffichageAjout af = new AffichageAjout();
   
        a.setTitre_article(txtitre.getText());
        a.setBlog(txtblog.getText());
        
        a.setTags(txttags.getText());
    
              
        
        Image image1 = txtimage.getImage();
        String nameImage1 = saveToFileImageNormal(image1);
        a.setImage(nameImage1);
        
        af.update(a, a.getId());
        System.out.println("mrigyek");
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
            txtimage.setImage(image);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    

    
    
}

