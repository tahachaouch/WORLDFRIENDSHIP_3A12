
package service;

import service.QuestionService;
import entities.Rating;
import connexion.MyDBcon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.sql.Timestamp;
/**
 *
 * @author arthas
 */
public class RatingService {
    
    Connection cnx;
    
    public RatingService() throws SQLException {
       cnx = MyDBcon.getInstance().getCnx();
       
        
    }
    
    
 public   void ajouterRating(int id_reponse) {
         try {
             
             Statement stm = cnx.createStatement();
             
             String req0 ="DELETE FROM `rating` where `rate`=0 and `unrate`=0";
             stm.executeUpdate(req0);
             
             PreparedStatement pstmt1 = cnx.prepareStatement("select rate from rating where id=? and id_reponse=? and rate=1");
             pstmt1.setInt(1, id_reponse);
             pstmt1.setInt(2, id_reponse);
             ResultSet rs1 = pstmt1.executeQuery();
             boolean exist1 = rs1.next();
            // System.out.println(exist1);
            
             PreparedStatement pstmt2 = cnx.prepareStatement("select unrate from rating where id=? and id_reponse=? and unrate=1");
             pstmt2.setInt(1, id_reponse);
             pstmt2.setInt(2, id_reponse);
             ResultSet rs2 = pstmt2.executeQuery();
             boolean exist2 = rs2.next();
            // System.out.println(exist2);
             
            if(exist1)
            {  
              String req = "UPDATE rating set rate=0 where id=? and id_reponse=?";
              PreparedStatement pstm3 = cnx.prepareStatement(req);
              pstm3.setInt(1, id_reponse);
              pstm3.setInt(2, id_reponse);
              pstm3.executeUpdate();
            } 
            else if(exist2)
            {
              String req = "UPDATE rating set rate=1,unrate=0 where id=? and id_reponse=?";
              PreparedStatement pstm4 = cnx.prepareStatement(req);
              pstm4.setInt(1, id_reponse);
              pstm4.setInt(2, id_reponse);
              pstm4.executeUpdate();
            }
            else{
                  String req = "INSERT INTO `rating`(`id`,`id_reponse`, `rate`,`unrate`) VALUES ('"+id_reponse+"','"+id_reponse+"',1,0)";
                  stm.executeUpdate(req);
            
            }
            

            
         } catch (SQLException ex) {
             Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
         }
    
    

   }
    
    
   public     void ajouterUnrating(int id_reponse) {
         try {
             
             Statement stm = cnx.createStatement();
             
             String req0 ="DELETE FROM `rating` where `rate`=0 and `unrate`=0";
             stm.executeUpdate(req0);
             
             PreparedStatement pstmt1 = cnx.prepareStatement("select unrate from rating where id=? and id_reponse=? and unrate=1");
             pstmt1.setInt(1, id_reponse);
             pstmt1.setInt(2, id_reponse);
             ResultSet rs1 = pstmt1.executeQuery();
             boolean exist1 = rs1.next();
            // System.out.println(exist1);
            
             PreparedStatement pstmt2 = cnx.prepareStatement("select unrate from rating where id=? and id_reponse=? and rate=1");
             pstmt2.setInt(1, id_reponse);
             pstmt2.setInt(2, id_reponse);
             ResultSet rs2 = pstmt2.executeQuery();
             boolean exist2 = rs2.next();
            // System.out.println(exist2);
             
            if(exist1)
            {  
              String req = "UPDATE rating set unrate=0 where id=? and id_reponse=?";
              PreparedStatement pstm3 = cnx.prepareStatement(req);
              pstm3.setInt(1, id_reponse);
              pstm3.setInt(2, id_reponse);
              pstm3.executeUpdate();
            } 
            else if(exist2)
            {
              String req = "UPDATE rating set unrate=1,rate=0 where id=? and id_reponse=?";
              PreparedStatement pstm4 = cnx.prepareStatement(req);
              pstm4.setInt(1, id_reponse);
              pstm4.setInt(2, id_reponse);
              pstm4.executeUpdate();
            }
            else{
                  String req = "INSERT INTO `rating`(`id`,`id_reponse`, `rate`,`unrate`) VALUES ('"+id_reponse+"','"+id_reponse+"',0,1)";
                  stm.executeUpdate(req);
            
            }
            

            
         } catch (SQLException ex) {
             Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
         }
    
     }
    
    
        
        
        
        
    public     ArrayList<Rating> getAllRatings() throws SQLException {
       ArrayList<Rating> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM rating";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int id= resultat.getInt("id");
           int id_reponse= resultat.getInt("id_reponse");
           int rate=resultat.getInt("rate");
           int unrate=resultat.getInt("unrate");
           retour.add(new Rating(id,id_reponse,rate,unrate));
            
         }
            
        return retour;
    
   }
    
    
    
    
    
    
    
    
    
    
    
}
