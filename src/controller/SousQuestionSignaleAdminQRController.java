/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import service.QuestionService;
import service.UtiliseObjetService;
import service.SignalerService;
import entities.Signaler;
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
public class SousQuestionSignaleAdminQRController implements Initializable {

    @FXML
    private Button guser;
    @FXML
    private Label users;
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
    private Button retour;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private TextField date;
    @FXML
    private TextField titre;
    @FXML
    private TextArea contenu;
    @FXML
    private TableView<Signaler> table;
    @FXML
    private TableColumn<Signaler,String> dateColumn;
    @FXML
    private TableColumn<Signaler,String> usernameColumn;
    @FXML
    private TableColumn<Signaler,String> contenuColumn;


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
private void retourAction(ActionEvent event) throws IOException
{
    try {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("QuestionSignaleAdminQR.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
    } catch (IOException ex) {
        Logger.getLogger(MesQuestionsController.class.getName()).log(Level.SEVERE, null, ex);
    }
  
}


@FXML
private void deleteQuestion(ActionEvent event) throws IOException
{
    try {
         UtiliseObjetService obs=new UtiliseObjetService();
        Question question =new Question(obs.getidquestiondb().get(0).getId_questiondb());
        QuestionService qs = new QuestionService();
        qs.supprimerQuestion(question);
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("AcceuilAdminQR.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    } catch (SQLException ex) {
        Logger.getLogger(MesQuestionsController.class.getName()).log(Level.SEVERE, null, ex);
    }

}

@FXML
private void Enlever(ActionEvent event) throws IOException
{
    try {
         UtiliseObjetService obs=new UtiliseObjetService();
        obs.getidquestiondb().get(0).getId_questiondb();
        SignalerService ss = new SignalerService();
        ss.Setvu(obs.getidquestiondb().get(0).getId_questiondb());
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("AcceuilAdminQR.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    } catch (SQLException ex) {
        Logger.getLogger(MesQuestionsController.class.getName()).log(Level.SEVERE, null, ex);
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
            
            
            SignalerService ss = new SignalerService();
             ArrayList<Signaler> signalers;
             
            
            
             signalers = (ArrayList<Signaler>) ss.AfficherSignaler(obs.getidquestiondb().get(0).getId_questiondb());
        ObservableList obss = FXCollections.observableArrayList(signalers);
           table.setItems(obss);
           dateColumn.setCellValueFactory(new PropertyValueFactory<>("date_signaler"));
           usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
           contenuColumn.setCellValueFactory(new PropertyValueFactory<>("cause"));
        } catch (SQLException ex) {
            Logger.getLogger(SousQuestionSignaleAdminQRController.class.getName()).log(Level.SEVERE, null, ex);
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
