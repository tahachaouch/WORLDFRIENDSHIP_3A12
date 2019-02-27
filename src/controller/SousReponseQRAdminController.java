/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import service.ReponseService;
import service.UtiliseObjetService;
import entities.Reponse;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author arthas
 */
public class SousReponseQRAdminController implements Initializable {

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
    private Button btn000;
    @FXML
    private TextField username;
   @FXML
    private TextField date;
   @FXML
    private TextArea contenu;
   @FXML
    private TextField G;
   @FXML
    private TextField B;
   @FXML
    private Button btn1;
   @FXML
    private Button btn2;
   @FXML
    private Button btn111;
   @FXML
    private Button btn3;
    
    
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
private void retour(ActionEvent event) throws IOException
{
    try {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("SousQuestionAdmin.fxml"));
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
         ReponseService rs = new ReponseService();
         
         UtiliseObjetService obs=new UtiliseObjetService();
         
         Reponse r=  rs.AfficherReponsesAvecTriRatePARID(obs.getidquestiondb().get(0).getId_reponsedb());
         
         
         System.out.println(r.getUsername());
         
         date.setText(r.getDate_reponse());
         date.setEditable(false);
         
         contenu.setText(r.getContenu_reponse());
         contenu.setEditable(false);
         
         G.setText(String.valueOf(r.getRate()));
         G.setDisable(true);
         contenu.setEditable(false);
         B.setText(String.valueOf(r.getUnrate()));
         B.setDisable(true);
         contenu.setEditable(false);
         username.setText(r.getUsername());
         username.setEditable(false);
     } catch (SQLException ex) {
         Logger.getLogger(SousReponseQRAdminController.class.getName()).log(Level.SEVERE, null, ex);
     }
    }    
    
}
