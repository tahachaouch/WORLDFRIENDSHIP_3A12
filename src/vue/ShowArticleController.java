/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import connexion.conDB;
import controller.AddArticleController;
import controller.AffichageAjout;
import controller.AfficheArticlesController;
import controller.ListArticleController;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Article;
import entities.Main;
import static entities.Main.LoggedUser;
import entities.LikeCommentaire;
import entities.User;
import static java.awt.SystemColor.menu;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import vue.DivArticleController;
import static vue.ShowArticleController.cnx;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ShowArticleController implements Initializable {
 private ObservableList<Article> myList;
public static int i;
    @FXML
    private Label txtcree;
    private Label txttitre;
 @FXML
    private Label txtblog;
    @FXML
    private Label txttags;
    @FXML
    private JFXButton rjaime;
    private ImageView txtimg;
    @FXML
    private JFXHamburger affmenu;
    @FXML
    private Rectangle txtimage;
    @FXML
    private Label txtitre;
    @FXML
    private JFXDrawer menu;
     
  
     
    static Connection cnx;
    @FXML
    private AnchorPane tab;
    @FXML
    private Label idd;
    @FXML
    private FontAwesomeIconView trash1;
    @FXML
    private FontAwesomeIconView trash;
    @FXML
    private Label nbrlikes;
    @FXML
    private Button AddCommentaire;
    @FXML
    private JFXTabPane tabpane;
    @FXML
    private Tab tabA;
    @FXML
    private Tab tabC;
    
  
       
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
         Logger.getLogger(ShowArticleController.class.getName()).log(Level.SEVERE, null, ex);
     }
    }    

    @FXML
    private void DeleteArticle(MouseEvent event) throws SQLException {
     
     
 AffichageAjout af=new AffichageAjout();
 af.delete(idd.getText());
 Stage stage = (Stage) trash.getScene().getWindow();
     
        stage.close();
    }


    @FXML
    private void likeAction(ActionEvent event) {
         
    }
   
 public void ShowArticle(int id) throws SQLException {
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

    @FXML
    private void EditArticle(MouseEvent event) throws SQLException, IOException {
          //   Parent root = FXMLLoader.load(getClass().getResource("/vue/EditArticle.fxml"));
 //    trash1.getScene().setRoot(root);
       
                     AffichageAjout af= new AffichageAjout();

                     Article s = af.afficherService().filtered(a -> a.getId() == Integer.parseInt(idd.getText())).get(0);
                     FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/EditArticle.fxml"));
                        AnchorPane an = new AnchorPane();
                        an = (AnchorPane) loader.load();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(an));
                        EditArticleController ds = loader.getController();
                        ds.oldValues(s.getId());
                        stage.show();
                    } 

    @FXML
    private void AddCommentaire(ActionEvent event) {
    }
}
