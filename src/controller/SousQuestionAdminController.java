/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import service.QuestionService;
import service.ReponseService;
import service.UtiliseObjetService;
import entities.Reponse;
import entities.Question;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author arthas
 */
public class SousQuestionAdminController implements Initializable {

     @FXML
    private Button guser;
     @FXML
    private Button consulter;
    @FXML
    private Label users;
    @FXML
    private Button btn000;
    @FXML
    private Button gArticle;
    @FXML
    private Button gevent;
    @FXML
    private Button gProduit;
    @FXML
    private Button gcommande;
    @FXML
    private Button gLivraison;
    @FXML
    private TextField date;
    @FXML
    private TextField titre;
    @FXML
    private TextArea contenu;
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
    private TableColumn<Reponse,Integer> likesColumn;
    @FXML
    private TableColumn<Reponse,Integer> unlikesColumn;


    
    @FXML
private void AcceuilButtonAction(ActionEvent event) throws IOException
{
    try {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("AcceuilAdminQR.fxml"));
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
       
       

      
      
          Parent home_page_parent = FXMLLoader.load(getClass().getResource("SousReponseQRAdmin.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
      
      

        
    } catch (IOException ex) {
        Logger.getLogger(MesQuestionsController.class.getName()).log(Level.SEVERE, null, ex);
    }   catch (SQLException ex) {
            Logger.getLogger(SousQuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
  
}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         try {
             QuestionService qs = new QuestionService();
             // ArrayList<Question> questions;
             UtiliseObjetService obs=new UtiliseObjetService();
             
             
             
             Question q=  qs.afficherQuestionParId(obs.getidquestiondb().get(0).getId_questiondb());
             // System.out.println(obs.getidquestiondb().get(0).getId_questiondb());
             titre.setText(q.getTitre_question());
             titre.setEditable(false);
             date.setText(q.getDate_question());;
             date.setEditable(false);
             contenu.setText(q.getContenu_question());
             contenu.setEditable(false);
             
             //affichage des reponses pour la question à consulter
             
             ReponseService rs = new ReponseService();
             ArrayList<Reponse> reponses;
             
             
             
             
             //System.out.println(rs.Calculunrate(2));
             
             
             reponses = (ArrayList<Reponse>) rs.AfficherReponsesAvecTriRate(obs.getidquestiondb().get(0).getId_questiondb());
             ObservableList obss = FXCollections.observableArrayList(reponses);
             table.setItems(obss);
             dateColumn.setCellValueFactory(new PropertyValueFactory<>("date_reponse"));
             usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
             contenuColumn.setCellValueFactory(new PropertyValueFactory<>("contenu_reponse"));
             likesColumn.setCellValueFactory(new PropertyValueFactory<>("rate"));
             unlikesColumn.setCellValueFactory(new PropertyValueFactory<>("unrate"));
             idColumn.setCellValueFactory(new PropertyValueFactory<>("id_reponse"));
         } catch (SQLException ex) {
             Logger.getLogger(SousQuestionAdminController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }    

    @FXML
    private void GestionUser(ActionEvent event) {
    }

    @FXML
    private void GestionArticle(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/ListArticleAminDelete.fxml"));
                Parent root = loader.load();
    }

    @FXML
    private void GestionEvenement(ActionEvent event) {
    }

    @FXML
    private void GestionProduit(ActionEvent event) {
    }

    @FXML
    private void GestionCommandes(ActionEvent event) {
    }

    @FXML
    private void GestionLivraison(ActionEvent event) {
    }
    
}
