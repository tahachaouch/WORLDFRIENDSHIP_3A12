/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import controller.AddArticleController;
import controller.AffichageAjout;
import entities.Article;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import static org.apache.commons.lang3.time.FastDateParserSDFTest.data;
import vue.DivArticleAdminController;
import vue.DivArticleController;


/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ListArticleAdminDeleteController implements Initializable {

    @FXML
    private AnchorPane ap;
    @FXML
    private JFXTextField recherchetext;
    @FXML
    private ScrollPane pane;
     private ObservableList<Article> data;
     private ObservableList<Article> d1;
    @FXML
    private JFXDrawer menu;
    @FXML
    private JFXComboBox<String> tri;
    @FXML
    private Button guser;
    @FXML
    private Label users;
    @FXML
    private Button gAnnonce;
    @FXML
    private Button gevent;
    @FXML
    private Button gforum;
    @FXML
    private Button gservice;
    @FXML
    private Button grendezvous;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ///////////////////////
      tri.getItems().addAll("Date");
        tri.getItems().addAll("like&comment");
         
           tri.setOnAction((event) -> {
       String scvalue = tri.getValue();
if (("Date".equals(scvalue))){
           try {
               AffichageAjout af= new AffichageAjout();
               d1=af.afficherService();
           } catch (SQLException ex) {
               Logger.getLogger(ListArticleAdminDeleteController.class.getName()).log(Level.SEVERE, null, ex);
           }
           //.stream().max(Comparator.comparing(Article::getCree));
      try {
                 TilePane b = new TilePane();
                 b.setPadding(new javafx.geometry.Insets(30));
                 TilePane c = new TilePane();
                 FadeTransition ft = new FadeTransition(Duration.millis(1500));
                 
                 AffichageAjout aff= new AffichageAjout();
                 
                 d1 = aff.ArticleTridate();
                 for ( Article d : d1) {
                     
                     try {
                         
                         
                         
                         
                         FXMLLoader loader = new FXMLLoader(getClass().getResource("DivArticle.fxml"));
                         Parent root = (Pane) loader.load();
                         DivArticleController DHC = loader.getController();
                         DHC.LoadValues(d);
                         
                         //   c.setVgap(40);
                         c.getChildren().removeAll();
                         
                         
                         c.getChildren().add(root);
                     } catch (IOException ex) {
                         Logger.getLogger(ListArticleAdminDeleteController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
                 c.setPrefColumns(3);
                 c.setPadding(new javafx.geometry.Insets(0));
                 c.setHgap(10);
                 c.setVgap(80);
                 b.getChildren().add(c);
                 b.setPrefWidth(1000);
                 pane.setContent(b);
                 
                 
                 
             }catch (SQLException ex) {
                 Logger.getLogger(ListArticleAdminDeleteController.class.getName()).log(Level.SEVERE, null, ex);
             }

}
           });
              
        //////////////////////////////////////////////////////////////////////////////////////////////////////      
            
             ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
             
             try {
                 TilePane b = new TilePane();
                 b.setPadding(new javafx.geometry.Insets(30));
                 TilePane c = new TilePane();
                 FadeTransition ft = new FadeTransition(Duration.millis(1500));
                 
                 AffichageAjout aff= new AffichageAjout();
                 
                 data = aff.afficherService();
                 for ( Article d : data) {
                     
                     try {
                         
                         
                         
                         
                         FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/DivArticleAdmin.fxml"));
  Parent root = (Pane) loader.load();
                         DivArticleAdminController DHC = loader.getController();
                         DHC.LoadValues(d);
                         
                         //   c.setVgap(40);
                         c.getChildren().removeAll();
                         
                         
                         c.getChildren().add(root);
                     } catch (IOException ex) {
                         Logger.getLogger(ListArticleAdminDeleteController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
                 c.setPrefColumns(3);
                 c.setPadding(new javafx.geometry.Insets(0));
                 c.setHgap(10);
                 c.setVgap(80);
                 b.getChildren().add(c);
                 b.setPrefWidth(1000);
                 pane.setContent(b);
                 
                 
                 
             }catch (SQLException ex) {
                 Logger.getLogger(ListArticleAdminDeleteController.class.getName()).log(Level.SEVERE, null, ex);
             }

      
            }

    @FXML
    private void RechercheDynamique(KeyEvent event) throws SQLException {
                AffichageAjout aff= new AffichageAjout();
                data=aff.afficherService();
         FilteredList<Article> filteredData = new FilteredList<>(data, e -> true);
        recherchetext.setOnKeyReleased(e
                -> {
            recherchetext.textProperty().addListener((ObservableValue<? extends String> ObservableValue, String oldValue, String newValue) -> {
                filteredData.setPredicate((Predicate<? super Article>) new Predicate<Article>() {
                    @Override
                    public boolean test(Article d) {
                        if (newValue == null || newValue.isEmpty()) {
                            
                            return true;

                        }
                        String lowerCaseFilter = newValue.toLowerCase();
                        return d.getTitre_article().toLowerCase().contains(lowerCaseFilter.subSequence(0, lowerCaseFilter.length()));
                    }
                });
            });
            TilePane b = new TilePane();
        b.setPadding(new javafx.geometry.Insets(30));
        TilePane c = new TilePane();

        for ( Article d : filteredData) {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/DivArticleAdmin.fxml"));
                Parent root = (Pane) loader.load();
                DivArticleAdminController DHC = loader.getController();
                DHC.LoadValues(d);
               
                //   c.setVgap(40);
                c.getChildren().removeAll();
               
                
                c.getChildren().add(root);
            } catch (IOException ex) {
                Logger.getLogger(ListArticleAdminDeleteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        c.setPrefColumns(3);
        c.setPadding(new javafx.geometry.Insets(0));
        c.setHgap(10);
        c.setVgap(80);
        b.getChildren().add(c);
        b.setPrefWidth(1000);
        pane.setContent(b);
    });
                }

    @FXML
    private void GestionUser(ActionEvent event) {
    }

    @FXML
    private void GestionAnnonce(ActionEvent event) {
    }

    @FXML
    private void GestionEvenement(ActionEvent event) {
    }

    @FXML
    private void GestionForum(ActionEvent event) {
    }

    @FXML
    private void GestionService(ActionEvent event) {
    }

    @FXML
    private void GestionRendezVous(ActionEvent event) {
    }


    


  
     

   
    
}

