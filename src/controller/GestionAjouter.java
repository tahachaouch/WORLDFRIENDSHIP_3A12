/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Article;
import controller.AffichageAjout;

import connexion.conDB;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author karim
 */
public class GestionAjouter implements Initializable {
Connection cnxC;
     public GestionAjouter () throws SQLException {
       cnxC = conDB.getInstance().getCnx();
    }
     @FXML private TextField txtTitre;
   @FXML private TextField txtBlog;
     
     private ListView<Article> table ; 
     @FXML private TableColumn<Article,Integer> id ;
     @FXML private TableColumn<Article,String> titre ;
     @FXML private TableColumn<Article,String> blog ;
     @FXML private TableColumn<Article,String> image ;
      
       @FXML private TableColumn<Article,Date> cree ;
       @FXML private TableColumn<Article,Date> modifie ;
   
       private TextField txtid;
         private TextField txttitreservice;
           private TextField txtblogservice;
     
      @FXML
    private void Ajouter(ActionEvent event) throws SQLException {
   
 String titre_article =txtTitre.getText();
 String blog =txtBlog.getText();
 
 Article a =new Article(titre_article, blog);
 AffichageAjout af=new AffichageAjout();
 af.ajouterService(a);
     
    
       
    }
    @FXML public void getAll(ActionEvent event) throws SQLException{
    /*   AffichageAjout sg =new AffichageAjout();
       id.setCellValueFactory(new PropertyValueFactory<>("id"));
        titre.setCellValueFactory(new PropertyValueFactory<>("titre_article"));
       blog.setCellValueFactory(new PropertyValueFactory<>("blog"));
       table.setItems(sg.afficherService());
       */ 
            
       
       
    }
    
     public void getService(ActionEvent event) throws SQLException,ParseException {

          String idS =txtid.getText();
 
  int o = Integer.parseInt(idS);
 Article s=AffichageAjout.getServiceId(o);
txttitreservice.setText(s.getTitre_article());
txtblogservice.setText(s.getBlog());

 
     }
   /*  public void updateService(ActionEvent event)throws SQLException{
       
         String idS = txtid.getText();
         int id =Integer.parseInt(idS);
         String cata=txttitreservice.getText();
         String sous_cata =txtblogservice.getText();
      
        Article s = new Article();
        
         
        
         s.setId(id);
         s.setTitre_article(cata);
         s.setBlog(sous_cata);
        int status=AffichageAjout.update(id,s);
        if(status>0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("service");
            alert.setHeaderText("INFORMATIONS");
            alert.setContentText("service bien ajouté !!");
            alert.showAndWait();
            //getAll(event);
        }
        else{
            
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle(" Ajout service");
            alert.setHeaderText("INFORMATIONS");
            alert.setContentText("service Non  Ajouter !!");
            alert.showAndWait();
        }
        
        
     
         
        
        
        
    }
    */
    public void deleteService(ActionEvent event)throws SQLException{
        
         String query = "DELETE FROM ARTICLE where id ='"+txtid.getText()+"' " ;
        PreparedStatement pstm     =   cnxC.prepareStatement(query);
        pstm.executeUpdate();
        
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
   
}}
