/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldfriendship.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import worldfriendship.Entities.Event;
import worldfriendship.Entities.Likereview;
import worldfriendship.Entities.Review;
import worldfriendship.Utils.MyConnexion;

/**
 *
 * @author user
 */
public class GReviews {
    Connection cn = MyConnexion.getInstance().getConnection();
    MyConnexion cnx = MyConnexion.getInstance();
    
    public void addReview(Review r) throws SQLException{
        
        String req ="INSERT INTO review("
               
                +"iduser,"
                +"cmt,"                           
                + "date,"
                + "id_event)"
                    
                +"VALUES (?,?,?,?)";
                PreparedStatement st = cn.prepareStatement(req);               
                st.setInt(1,1);
                st.setString(2,r.getCmt());
                st.setDate(3, r.getDate());
                st.setInt(4, r.getId_event().getId_event());
                  st.executeUpdate();

                  
           
    }
     public ObservableList<Review> ListReviews(Event e) {
        ObservableList<Review> myList = FXCollections.observableArrayList();
       myList.clear();
       try {
            String requete = "SELECT `idCmt`, `cmt`, `date` from review where id_event="+e.getId_event();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Review rev = new Review();
                rev.setIdCmt(rs.getInt("idCmt"));
                rev.setCmt(rs.getString("cmt"));
                rev.setDate(rs.getDate("date"));
              myList.add(rev);
             }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;  
}
     
     public int CountReview(Review R) throws SQLException{
         int s=0;
     String requete = "SELECT COUNT(*) as total from likereview where idCmt='"+R.getIdCmt()+"'";
      Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {
                s = rs.getInt("total");
            }
            return s;
    
}
      public void DeleteReveiw(int id) throws SQLException{
            

        String req = "DELETE FROM review WHERE idCmt=?";
        PreparedStatement ste = cn.prepareStatement(req);
        ste.setInt(1,id);
        ste.executeUpdate();
    }
       public void DeleteLike(int id1,int id2) throws SQLException{
            

        String req = "delete from likereview where  iduser=? and idCmt=?";
        PreparedStatement ste = cn.prepareStatement(req);
        ste.setInt(1, id1);
        ste.setInt(2, id2);
        ste.executeUpdate();
    }
       public void AddLike (Likereview R) throws SQLException
    {
        String requete
                    = "INSERT INTO likereview ( iduser, idCmt) VALUES (?,?)";
        PreparedStatement st = cn.prepareStatement(requete);
            st.setInt(1,1);
            st.setInt(2, R.getIdCmt().getIdCmt());
            
         st.executeUpdate();
        }
}
