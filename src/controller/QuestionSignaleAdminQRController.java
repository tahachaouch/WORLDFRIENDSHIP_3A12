/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import service.QuestionService;
import service.UtiliseObjetService;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author arthas
 */
public class QuestionSignaleAdminQRController implements Initializable {

    @FXML
    private TableView<Question> table;
@FXML
    private TableColumn<Question,Integer> idColumn;
@FXML
    private TableColumn<Question,Integer> iduColumn;
@FXML
    private TableColumn<Question,String> userColumn;
@FXML
    private TableColumn<Question,String> titreColumn;
@FXML
    private TableColumn<Question,String> dateColumn;
@FXML
    private TableColumn<Question,Integer> nbrColumn;
@FXML
    private TableColumn<Question,Integer> nbrsig;
@FXML
    private Button btn;
@FXML
    private Button btn000;
@FXML
    private Button btn1;
@FXML
    private Button btn2;
@FXML
    private Button btn3;
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
    private Text sign;
    @FXML
    private Text sign1;
    @FXML
    private Button btn01;

    /**
     * Initializes the controller class.
     */
    
    
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
private void CSQ(ActionEvent event) throws IOException
{
    try {
        Question question= table.getSelectionModel().getSelectedItem();

        UtiliseObjetService obs;
        try {
            obs = new UtiliseObjetService();
                   obs.setidquestiondb(question.getId_question());
        } catch (SQLException ex) {
            Logger.getLogger(QuestionSignaleAdminQRController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("SousQuestionSignaleAdminQR.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
    } catch (IOException ex) {
        Logger.getLogger(MesQuestionsController.class.getName()).log(Level.SEVERE, null, ex);
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
         
         
            
            
            QuestionService qs = new QuestionService();
            ArrayList<Question> questions;
            try {
                /*QuestionService qss= new QuestionService();
                    Question q=new Question();
                   ArrayList<Question> questionss = qss.getAllQuestions();
                   questionss.forEach(e->System.out.println(e));*/
                //btn.setDisable(true);
                   
                questions = (ArrayList<Question>) qs.afficherQuestionsCompletAvecSignale();
                ObservableList obs = FXCollections.observableArrayList(questions);
               // System.out.println(obs);
                table.setItems(obs);
                iduColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
                idColumn.setCellValueFactory(new PropertyValueFactory<>("id_question"));
                userColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
                titreColumn.setCellValueFactory(new PropertyValueFactory<>("titre_question"));
                dateColumn.setCellValueFactory(new PropertyValueFactory<>("date_question"));
                nbrColumn.setCellValueFactory(new PropertyValueFactory<>("nbr_comment"));
                nbrsig.setCellValueFactory(new PropertyValueFactory<>("nbr_sig"));
                
            } catch (SQLException ex) {
                Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
