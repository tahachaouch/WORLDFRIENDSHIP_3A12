/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import com.jfoenix.controls.JFXButton;
import controller.GestionCommentaire;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Article;
import entities.CommentaireARTICLE;
import entities.LikeCommentaire;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class DivCommentController implements Initializable {

    @FXML
    private Label rname;
    @FXML
    private Pane sq;
    @FXML
    private JFXButton rjaime;
    @FXML
    private JFXButton rliekd;
    @FXML
    private Label nbrlikes;
    @FXML
    private Circle rcircle;
    @FXML
    private Label rtitre;
    @FXML
    private Label rcom;
    @FXML
    private Label id;
    @FXML
    private Label rdate;
    @FXML
    private FontAwesomeIconView trash;
    @FXML
    private Label daterev;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
public void LoadValues(CommentaireARTICLE r, Article e) throws SQLException {
        ////recuêrer esm l user
        // String charname = r.getIduser().getUsername().substring(0, 1).toUpperCase();
       // rname.setText(charname + r.getIduser().getUsername().substring(1));
        ShowArticleController pr= new ShowArticleController();
        rcom.setText(r.getCommentaire());
        /////recuperer limage de user                  
   //Image imageURI = new Image("file:C:/wamp64/www/images/" + r.getIduser().******);
    //  rcircle.setFill(new ImagePattern(imageURI));  
        
    
         GestionCommentaire gr = new GestionCommentaire();
        nbrlikes.setText(String.valueOf(gr.CountReview(r)));
         id.setText(String.valueOf(r.getId()));
      
      /////
     /* if (woldfriendship.Views.FirstFrame.user==null)
      {
          rjaime.setVisible(false);
      }
      trash.setVisible(false);
         
      if (PIDEV.Views.FirstFrame.user!=null)
             
      {if ((gr.checkreview(PIDEV.Views.FirstFrame.user,r))>0)
      { 
          rjaime.setVisible(false);
          rliekd.setVisible(true);
      }
       if (PIDEV.Views.FirstFrame.user.getId()==r.getIduser().getId())
        {trash.setVisible(true);
            
        }
      
      }*/

      
      trash.setOnMouseClicked((event) -> {
            try {
                GestionCommentaire de = new GestionCommentaire();
            de.DeleteReveiw(r.getId());
           /* FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/ProfilUser.fxml"));
            Parent root = loader.load();
            ProfilUserController pu = loader.getController();
            AnchorPane Rev = FXMLLoader.load(getClass().getResource("../Views/MyReviews.fxml"));
            pu.setNode(Rev);
            rname.getScene().setRoot(root);*/
           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/ShowArticle.fxml"));
           
                
                  Parent  root = loader.load();
                
           ShowArticleController pu = loader.getController();
            pu.ShowArticle(e.getId());
            pu.Reviewslist(e);
            rname.getScene().setRoot(root);
        
      
            } catch (SQLException ex) {
                Logger.getLogger(DivCommentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DivCommentController.class.getName()).log(Level.SEVERE, null, ex);
            }   
          
      });
      rjaime.setOnMouseClicked((event) -> {
           
          rjaime.setVisible(false);
          rliekd.setVisible(true);
           
           LikeCommentaire lr=new LikeCommentaire();
       lr.setId_commentaire(r);
      /* lr.setIduser(worldfriendship.Views.FirstFrame.user);
            try {
                gr.AddLike(lr);
            } catch (SQLException ex) {
                Logger.getLogger(DivReviewController.class.getName()).log(Level.SEVERE, null, ex);
            }
             try {
                nbrlikes.setText(String.valueOf(gr.CountReview(r)));
            } catch (SQLException ex) {
                Logger.getLogger(DivReviewController.class.getName()).log(Level.SEVERE, null, ex);
            }*/
       });
      rliekd.setOnMouseClicked((event) -> {
           
          /*  try {
                gr.DeleteLike(PIDEV.Views.FirstFrame.user.getId(),r.getId());
                rjaime.setVisible(true);
                rliekd.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(DivReviewController.class.getName()).log(Level.SEVERE, null, ex);
            }*/
             try {
                nbrlikes.setText(String.valueOf(gr.CountReview(r)));
            } catch (SQLException ex) {
                Logger.getLogger(ShowArticleController.class.getName()).log(Level.SEVERE, null, ex);
            }
      });

    }

   
}
    

