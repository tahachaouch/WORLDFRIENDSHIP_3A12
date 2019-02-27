/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import service.ReponseService;
import service.UtiliseObjetService;
import entities.Reponse;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author arthas
 */
public class ModifierSousReponseController implements Initializable {

    @FXML
    private TextArea contenu;
    @FXML
    private Button btn1;
    
    @FXML
    private Button btn2;
    @FXML
    private AnchorPane home;
    @FXML
    private ScrollPane scrollHomePage;
    @FXML
    private AnchorPane mainAP;
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
    private VBox blogVB;
    @FXML
    private JFXButton blogButton;
    @FXML
    private VBox sousMenuBlog;
    @FXML
    private JFXButton ajoutArticleB;
    @FXML
    private JFXButton listArticleB;
    @FXML
    private VBox dealVB;
    @FXML
    private JFXButton dealButton;
    @FXML
    private VBox sousMenuDeal;
    @FXML
    private JFXButton catButton;
     @FXML
      private AnchorPane addArticle;
    @FXML
    private JFXButton eventButton1;
    @FXML
    private JFXButton eventButton11;


    
    @FXML
    private void AddArticle(MouseEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("/vue/AddArticle.fxml"));
     ajoutArticleB.getScene().setRoot(root);
    }

    @FXML
    private void ShowListArticle(MouseEvent event) 
        throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("/vue/ListArticles.fxml"));
     listArticleB.getScene().setRoot(root);
    }
    
@FXML
private void AcceuilButtonAction(ActionEvent event) throws IOException
{
    try {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
    } catch (IOException ex) {
        Logger.getLogger(MesQuestionsController.class.getName()).log(Level.SEVERE, null, ex);
    }
  
}




@FXML
private void PublierQuestionButtonAction(ActionEvent event) throws IOException
{
    try {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("PublierQuestion.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
    } catch (IOException ex) {
        Logger.getLogger(MesQuestionsController.class.getName()).log(Level.SEVERE, null, ex);
    }
  
}




@FXML
private void MesQuestionButtonAction(ActionEvent event) throws IOException
{
    try {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("MesQuestions.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
    } catch (IOException ex) {
        Logger.getLogger(MesQuestionsController.class.getName()).log(Level.SEVERE, null, ex);
    }
  
}




 public void supprimer(ActionEvent event) throws IOException {
           Reponse reponse=new Reponse();
           
           
              try {
                 ReponseService rs = new ReponseService();
                 UtiliseObjetService obs =new UtiliseObjetService();
                reponse = new Reponse(obs.getiduserdb().get(0).getId_reponsedb(),contenu.getText());
                 //  System.out.println(titre.getText());
                 //  System.out.println(contenu.getText());
                 //  System.out.println(obs.getiduserdb().get(0).getId_questiondb());
                rs.modifierReponse(reponse);
                   //  Parent root= FXMLLoader.load(getClass().getResource("MesQuestions.fxml"));
                   //   nom.getScene().setRoot(root);
                   Parent home_page_parent = FXMLLoader.load(getClass().getResource("ModifierReponse.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
               } catch (SQLException ex) {
                   Logger.getLogger(PublierQuestionController.class.getName()).log(Level.SEVERE, null, ex);
               }
           
         }
    

    
    
       public void handle(ActionEvent event) throws IOException {
           Reponse reponse=new Reponse();
           
           if(contenu.getText().length()<1)
           { Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Modifier Reponse");
                alert.setHeaderText("Results:");
               alert.setContentText("Reponse Vide !!!!");
 
        alert.showAndWait();}
           
           else {
             
              try {
                 ReponseService rs = new ReponseService();
                 UtiliseObjetService obs =new UtiliseObjetService();
                reponse = new Reponse(obs.getiduserdb().get(0).getId_reponsedb(),contenu.getText());
                 //  System.out.println(titre.getText());
                 //  System.out.println(contenu.getText());
                 //  System.out.println(obs.getiduserdb().get(0).getId_questiondb());
                rs.modifierReponse(reponse);
                   //  Parent root= FXMLLoader.load(getClass().getResource("MesQuestions.fxml"));
                   //   nom.getScene().setRoot(root);
                   Parent home_page_parent = FXMLLoader.load(getClass().getResource("ModifierReponse.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
               } catch (SQLException ex) {
                   Logger.getLogger(PublierQuestionController.class.getName()).log(Level.SEVERE, null, ex);
               }
           } 
         }
    
    @FXML
private void retour(ActionEvent event) throws IOException
{
    try {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("ModifierReponse.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
    } catch (IOException ex) {
        Logger.getLogger(MesQuestionsController.class.getName()).log(Level.SEVERE, null, ex);
    }
  
} 
  
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ReponseService rs = new ReponseService();
            
            UtiliseObjetService obs=new UtiliseObjetService();
            
            
            
            Reponse r=  rs.AfficherReponsesAvecTriRatePARID(obs.getidquestiondb().get(0).getId_reponsedb());
            contenu.setText(r.getContenu_reponse());
        } catch (SQLException ex) {
            Logger.getLogger(ModifierSousReponseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
