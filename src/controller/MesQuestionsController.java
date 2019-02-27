/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import service.QuestionService;
import service.UtiliseObjetService;
import entities.UtileObjet;
import entities.Question;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import pdf.creater.GeneratePDF;



public class MesQuestionsController implements Initializable {

@FXML
    private TableView<Question> table;
@FXML
    private TableColumn<Question,Integer> idColumn;

@FXML
    private TableColumn<Question,String> titreColumn;
@FXML
    private TableColumn<Question,String> dateColumn;
@FXML
    private TableColumn<Question,Integer> nbrColumn;
@FXML
    private Button btn0;
@FXML
    private Button btn00;
@FXML
    private Button btn11;
@FXML
    private Button btn21;
@FXML
    private Button btn31;
@FXML
    private Button btn41;
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

      private AnchorPane addArticle;
    @FXML
    private JFXButton eventButton1;
    @FXML
    private JFXButton eventButton11;
 

    
    @FXML
private void Archiver(ActionEvent event) throws IOException
{ 
 try {
               UtiliseObjetService obs=new UtiliseObjetService();
                QuestionService qs = new QuestionService();
                ArrayList<Question> questions;   
                questions = (ArrayList<Question>) qs.afficherQuestionPDF(obs.getiduserdb().get(0).getId_userdb());
                String s=questions.toString();             
                System.out.println();
                    
                    try {
                        OutputStream file = new FileOutputStream(new File("G:\\Test.pdf"));
                        
                        Document document = new Document();
                        PdfWriter.getInstance(document, file);
                        
                        document.open();
                        
                        if(document.add(new Paragraph(s)))
                        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Archiver Question");
             alert.setHeaderText("Resultas:");
             alert.setContentText("Archivage Réussi !!!");
             alert.showAndWait();
                }
                        document.add(new Paragraph(new Date().toString()));
                        
                        document.close();
                        file.close();
                        
                    } catch (Exception e) {
                        
                        e.printStackTrace();
                    }
                } catch (SQLException ex) {

			Logger.getLogger(GeneratePDF.class.getName()).log(Level.SEVERE, null, ex);
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




@FXML
private void deleteQuestion(ActionEvent event) throws IOException
{
    try {
        Question question =new Question();
        question= table.getSelectionModel().getSelectedItem();
        QuestionService qs = new QuestionService();
        qs.supprimerQuestion(question);
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("MesQuestions.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    } catch (SQLException ex) {
        Logger.getLogger(MesQuestionsController.class.getName()).log(Level.SEVERE, null, ex);
    }

}


@FXML
private void ConsulterQuestion(ActionEvent event) throws IOException
{
    try {
        // UtileObjets UO;
        
        
        
        Question question= table.getSelectionModel().getSelectedItem();
        //UO.(question.getId_question());
        /*UtileObjet ob =new UtileObjet();
        UtiliseObjetService obs=new UtiliseObjetService();
        obs.setidquestiondb(question.getId_question());*/
        UtiliseObjetService obs=new UtiliseObjetService();
       obs.setidquestiondb(question.getId_question());
      //  System.out.println(question.getId_question());
        
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("SousQuestion.fxml"));
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
       //UtileObjets UO= new UtileObjets();
    try {
        QuestionService qs = new QuestionService();
        ArrayList<Question> questions;
        UtileObjet ob =new UtileObjet();
        UtiliseObjetService obss=new UtiliseObjetService();
        
       
        questions = (ArrayList<Question>) qs.afficherQuestionsUser(obss.getiduserdb().get(0).getId_userdb());
        ObservableList obs = FXCollections.observableArrayList(questions);
        table.setItems(obs);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id_question"));
        titreColumn.setCellValueFactory(new PropertyValueFactory<>("titre_question"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date_question"));
        nbrColumn.setCellValueFactory(new PropertyValueFactory<>("nbr_comment"));
    } catch (SQLException ex) {
        Logger.getLogger(MesQuestionsController.class.getName()).log(Level.SEVERE, null, ex);
    }
            
    }    
    
}
