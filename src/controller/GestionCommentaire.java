/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connexion.conDB;
import entities.Article;
import entities.CommentaireARTICLE;

  import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
/**
 *
 * @author ASUS
 */
public class GestionCommentaire {
  
    
   static Connection cnx;
    
    public GestionCommentaire() throws SQLException {
       cnx = conDB.getInstance().getCnx();
    }    

    
    public void addReview(CommentaireARTICLE r) throws SQLException{
        
        String req ="INSERT INTO commentarticle("
               
                +"id_user,"
                +"commentaire,"                           
                + "date_comment,"
                + "id_article)"
                    
                +"VALUES (?,?,?,?)";
                PreparedStatement st = cnx.prepareStatement(req);               
                st.setInt(1,1);
                st.setString(2,r.getCommentaire());
                st.setDate(3, r.getDate_comment());
                st.setInt(4, r.getId_article().getId());
                st.executeUpdate();

                  
           
    }
     public ObservableList<CommentaireARTICLE> ListReviews(Article e) {
        ObservableList<CommentaireARTICLE> myList = FXCollections.observableArrayList();
       myList.clear();
       try {
            String requete = "SELECT `id`, `commentaire`, `date_comment` from commentarticle where id_article="+e.getId();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                CommentaireARTICLE rev = new CommentaireARTICLE();
                rev.setId(rs.getInt("id"));
                rev.setCommentaire(rs.getString("commentaire"));
                rev.setDate_comment(rs.getDate("date_comment"));
              myList.add(rev);
             }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;  
}
     
     public int CountReview(CommentaireARTICLE R) throws SQLException{
         int s=0;
     String requete = "SELECT COUNT(*) as total from likes where id_commentaire='"+R.getCommentaire()+"'";
      Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {
                s = rs.getInt("total");
            }
            return s;
    
}
      public void DeleteReveiw(int id) throws SQLException{
            

        String req = "DELETE FROM commentarticle WHERE id=?";
        PreparedStatement ste = cnx.prepareStatement(req);
        ste.setInt(1,id);
        ste.executeUpdate();
    }
       public void DeleteLike(int id1,int id2) throws SQLException{
            

        String req = "delete from likes where  id_user=? and id_commentaire=?";
        PreparedStatement ste = cnx.prepareStatement(req);
        ste.setInt(1, id1);
        ste.setInt(2, id2);
        ste.executeUpdate();
    }

}