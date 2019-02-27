/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import service.QuestionService;
import service.ReponseService;
import service.UtiliseObjetService;
import service.SignalerService;
import entities.Reponse;
import entities.Question;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
public class SousQuestionNUController implements Initializable {

 @FXML
    private TableView<Reponse> table;
    @FXML
    private TableColumn<Reponse,String> dateColumn;
    @FXML
    private TableColumn<Reponse,String> usernameColumn;
    @FXML
    private TableColumn<Reponse,String> contenuColumn;
    @FXML
    private TableColumn<Reponse,Integer> idColumn;
    @FXML
    private TableColumn<Reponse,Integer> iduColumn;
    @FXML
    private TableColumn<Reponse,Integer> likesColumn;
    @FXML
    private TableColumn<Reponse,Integer> unlikesColumn;
    @FXML
    private TextField date;
    @FXML
    private TextField titre;
    @FXML
    private TextArea contenu;
    @FXML
    private Button btn1;
    @FXML
    private Button btn111;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
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
private void Signaler(ActionEvent event) throws IOException
{
    try {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("SignalerQuestion.fxml"));
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
private void RetourAcceuilButtonAction(ActionEvent event) throws IOException
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
private void AjouterReponse(ActionEvent event) throws IOException
{
    try {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("AjouterReponse.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
    } catch (IOException ex) {
        Logger.getLogger(MesQuestionsController.class.getName()).log(Level.SEVERE, null, ex);
    }
  
}
    
@FXML
private void ConsulterReponse(ActionEvent event) throws IOException
{
    try {
        Reponse reponse= table.getSelectionModel().getSelectedItem();
        
       UtiliseObjetService obs=new UtiliseObjetService();
       obs.setidreponsedb(reponse.getId_reponse());
      // System.out.println(reponse.getId());
       
      if(reponse.getId()==obs.getiduserdb().get(0).getId_userdb())
      { Parent home_page_parent = FXMLLoader.load(getClass().getResource("ModifierReponse.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
      }
      
      else {
          Parent home_page_parent = FXMLLoader.load(getClass().getResource("SousReponse.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
      
      }
        
    } catch (IOException ex) {
        Logger.getLogger(MesQuestionsController.class.getName()).log(Level.SEVERE, null, ex);
    }   catch (SQLException ex) {
            Logger.getLogger(SousQuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
  
}
 






    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     try {
         SignalerService ss= new SignalerService();
         QuestionService qs = new QuestionService();
         UtiliseObjetService obs=new UtiliseObjetService();
         
         if(ss.signalertest(obs.getiduserdb().get(0).getId_userdb(),obs.getidquestiondb().get(0).getId_questiondb()))
         {
           btn111.setDisable(true);
         }
         
         Question q=  qs.afficherQuestionParId(obs.getidquestiondb().get(0).getId_questiondb());

         titre.setText(q.getTitre_question());
         titre.setEditable(false);
         date.setText(q.getDate_question());;
         date.setEditable(false);
         contenu.setText(q.getContenu_question());
         contenu.setEditable(false);
         
         //affichage des reponses pour la question à consulter
         
        
         ReponseService rs = new ReponseService();
         ArrayList<Reponse> reponses;
         
         
         
         System.out.println(obs.getidquestiondb().get(0).getId_questiondb());
         
        reponses = (ArrayList<Reponse>) rs.AfficherReponsesAvecTriRate(obs.getidquestiondb().get(0).getId_questiondb());
         ObservableList obss = FXCollections.observableArrayList(reponses);
         table.setItems(obss);
           //System.out.println(obs.getidquestiondb().get(0).getId_questiondb());
         dateColumn.setCellValueFactory(new PropertyValueFactory<>("date_reponse"));
         usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
         contenuColumn.setCellValueFactory(new PropertyValueFactory<>("contenu_reponse"));
         likesColumn.setCellValueFactory(new PropertyValueFactory<>("rate"));
         unlikesColumn.setCellValueFactory(new PropertyValueFactory<>("unrate"));
         idColumn.setCellValueFactory(new PropertyValueFactory<>("id_reponse"));
         iduColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
         
         // System.out.println(reponses.get(0).get);
     } catch (SQLException ex) {
         Logger.getLogger(SousQuestionNUController.class.getName()).log(Level.SEVERE, null, ex);
     }
           
           
        
    }   










}
    

