











/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Article;

import connexion.conDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
/**
 *
 * @author karim
 */
public class AffichageAjout {
   
static Connection cnx;
    
    public AffichageAjout() throws SQLException {
       cnx = conDB.getInstance().getCnx();
    }    
    public static int ajouterService(Article article) {
        int a=0;
     try {
            java.util.Date date_util = new java.util.Date();
            java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
            
            String requete
                    = "INSERT INTO article (titre_article, blog, image, cree, modifie, archive,tags) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = cnx.prepareStatement(requete);
           // st.setInt(1,article.getId());
           
            st.setString(1,article.getTitre_article());
            st.setString(2,article.getBlog());
            st.setString(3,article.getImage()); 
        
            st.setDate(4, date_sql);
                  st.setDate(5, date_sql);
            
            st.setBoolean(6, false);
            st.setString(7,article.getTags());
           
           
            st.executeUpdate();
            System.out.println("Article ajouté");
            a=1;
            if(a==1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Article");
            alert.setHeaderText("INFORMATIONS");
            alert.setContentText("Article bien ajouté !!");
            alert.showAndWait();
            
        }
        else{
            
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle(" Ajout article");
            alert.setHeaderText("INFORMATIONS");
            alert.setContentText("Article Non  Ajouté !!");
            alert.showAndWait();
        }
        
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            
        }
     return a;
      }
    public ObservableList<Article> afficherService() throws SQLException
      {
          
         ObservableList<Article> myList = FXCollections.observableArrayList();
      
       
            Statement st = cnx.createStatement();
            String requete = "SELECT * FROM `Article`  ";
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                int id=rs.getInt("id");
              
                String titre_article=rs.getString("titre_article");
                String blog=rs.getString("blog");
                String image=rs.getString("image");
                Date cree=rs.getDate("cree");
                Date modifie=rs.getDate("modifie");
                Boolean archive=rs.getBoolean("archive");
                String tags=rs.getString("tags");
            myList.add(new Article(id,titre_article,blog,image,cree,modifie,archive,tags));
  }
        return myList;
      }    
    
    public void  update(Article a, int item ) throws SQLException  {
     
      
                cnx = conDB.getInstance().getCnx();
        
   String req = "UPDATE Article SET "
           + "titre_article=?,"
           +"blog=?,"
           +"image=?,"
           +"tags =? where id=? "; 

                

        PreparedStatement pre = cnx.prepareStatement(req);
        
        pre.setString(1, a.getTitre_article());
        pre.setString(2, a.getBlog());
        pre.setString(3, a.getImage());
        
        pre.setString(4, a.getTags());
       // pre.setDate(4, a.getModifie());
       
        pre.setInt(5, item);
        pre.executeUpdate();
        System.out.println("article modifié");

}
public void   delete(String id) throws SQLException {
    int st=0 ;
     try {
    String req="DELETE FROM Article WHERE id='"+id+"'";
        PreparedStatement ste = cnx.prepareStatement(req);
        
        ste.executeUpdate();
         System.out.println("Article supprimé");
            st=1;
            if(st==1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Article");
            alert.setHeaderText("INFORMATIONS");
            alert.setContentText("Article bien supprimé !!");
            alert.showAndWait();
            
        }
        else{
            
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle(" Ajout article");
            alert.setHeaderText("INFORMATIONS");
            alert.setContentText("Article Non  Supprimé !!");
            alert.showAndWait();
        }
        
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            
        }

        cnx.close();
    }

public static Article getServiceId(int id) throws SQLException{
    Article s =new Article();
    String req="SELECT * FROM Article WHERE id=?";
     PreparedStatement pstm     =   cnx.prepareStatement(req);
     pstm.setInt(1, id);
     ResultSet rst =pstm.executeQuery();
     if(rst.next()){
         
      s.setId(rst.getInt(1));
      s.setTitre_article(rst.getString(3));
      s.setBlog(rst.getString(4));
    
     }
  return s;  
}
 public Article getelement(String s) throws SQLException
      {
          
         Article a= new Article();
      
       
            Statement st = cnx.createStatement();
            String requete = "SELECT * FROM Article where id = '"+s+"' ";
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                int id=rs.getInt("id");
              
                String titre_article=rs.getString("titre_article");
                String blog=rs.getString("blog");
                String image=rs.getString("image");
                Date cree=rs.getDate("cree");
                Date modifie=rs.getDate("modifie");
                Boolean archive=rs.getBoolean("archive");
                String tags=rs.getString("tags");
           a= new Article(id,titre_article,blog,image,cree,modifie,archive,tags);
  }
        return a;
      }    
    
    public Article getArticle() throws SQLException
      {
          
         Article a= new Article();
      
       
            Statement st = cnx.createStatement();
            String requete = "SELECT * FROM Article ";
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                int id=rs.getInt("id");
              
                String titre_article=rs.getString("titre_article");
                String blog=rs.getString("blog");
                String image=rs.getString("image");
                Date cree=rs.getDate("cree");
                Date modifie=rs.getDate("modifie");
                Boolean archive=rs.getBoolean("archive");
                String tags=rs.getString("tags");
           a= new Article(id,titre_article,blog,image,cree,modifie,archive,tags);
  }
        return a;
      }  
    
        public ObservableList<Article> ListeArticle(Article a) throws SQLException
      {
          
         ObservableList<Article> myList1 = FXCollections.observableArrayList();
      
       
            Statement st = cnx.createStatement();
            String requete = "SELECT * FROM `Article` where id='"+a.getId()+"'";
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                int id=rs.getInt("id");
              
                String titre_article=rs.getString("titre_article");
                String blog=rs.getString("blog");
                String image=rs.getString("image");
                Date cree=rs.getDate("cree");
                Date modifie=rs.getDate("modifie");
                Boolean archive=rs.getBoolean("archive");
                String tags=rs.getString("tags");
            myList1.add(new Article(id,titre_article,blog,image,cree,modifie,archive,tags));
  }
        return myList1;
      } 
   //////////////////////////////////////////////////////////////////////////////     
               public ObservableList<Article> ArticleTridate() throws SQLException
      {
          
         ObservableList<Article> myList = FXCollections.observableArrayList();
      
       
            Statement st = cnx.createStatement();
            String requete = "SELECT * FROM `Article`  ORDER BY Cree DESC";
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                int id=rs.getInt("id");
              
                String titre_article=rs.getString("titre_article");
                String blog=rs.getString("blog");
                String image=rs.getString("image");
                Date cree=rs.getDate("cree");
                Date modifie=rs.getDate("modifie");
                Boolean archive=rs.getBoolean("archive");
                String tags=rs.getString("tags");
            myList.add(new Article(id,titre_article,blog,image,cree,modifie,archive,tags));
  }
        return myList;
      }    
     
}


   

