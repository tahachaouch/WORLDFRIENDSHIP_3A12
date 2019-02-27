package service;

import service.QuestionService;
import entities.Reponse;
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
public class ReponseService {
    Connection cnx;
    
    public ReponseService() throws SQLException {
       cnx = MyDBcon.getInstance().getCnx();
       
        
    }
    
 
 public   void ajouterReponse(Reponse r) {
         try {
             
             System.out.println("connexion établie");
             Statement stm = cnx.createStatement();
             String req = "INSERT INTO `reponse`(`id`,`id_question`, `date_reponse`, `contenu_reponse`) VALUES ('"+r.getId()+"','"+r.getId_question()+"','"+r.getDate_reponse()+"','"+r.getContenu_reponse()+"')";
             stm.executeUpdate(req);
         } catch (SQLException ex) {
             Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
    
public    void modifierReponse(Reponse r) {
         try {
             
             String req = "UPDATE reponse set contenu_reponse=? where id_reponse=?";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setString(1, r.getContenu_reponse());
             pstm.setInt(2, r.getId_reponse());
             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
   public void supprimerReponse(int  id) {
         try {
             
             String req = "UPDATE reponse set etat_reponse=0 WHERE id_reponse=?";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setInt(1, id);
             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
   
public    ArrayList<Reponse> getAllReponses() throws SQLException {
       ArrayList<Reponse> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM reponse";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int id= resultat.getInt("id");
           int id_question= resultat.getInt("id_question");
           int id_reponse= resultat.getInt("id_reponse");
           String date_reponse= resultat.getString("date_reponse");
           String contenu_reponse= resultat.getString("contenu_reponse");
           int etat_reponse=resultat.getInt("etat_reponse");
           retour.add(new Reponse(id,id_question,id_reponse,date_reponse,contenu_reponse,etat_reponse));
            
        }
            
        return retour;
    
   }
    
    
 public   void AfficherReponsesCompletSansTri() throws SQLException
    {
       Statement stm = cnx.createStatement();
        String req = "SELECT date_reponse,contenu_reponse,rate,unrate,username FROM reponse join fos_user on reponse.id=fos_user.id join rating on reponse.id_reponse=rating.id_reponse WHERE etat_reponse=1";
        ResultSet resultat = stm.executeQuery(req);
       while(resultat.next()){
 
       String date_reponse= resultat.getString("date_reponse");
       System.out.println(date_reponse);
       String contenu_reponse= resultat.getString("contenu_reponse");
       System.out.println(contenu_reponse);
       String username= resultat.getString("username");
       System.out.println(username);
       int rate=resultat.getInt("rate");
       System.out.println(rate);
       int unrate=resultat.getInt("unrate");
       System.out.println(unrate);
       


            
        }
    
    }
    
    
    
  public  int Calculrate(int id_reponse) throws SQLException
    {int nb=0;
    Statement stm = cnx.createStatement();
    String req = "SELECT SUM(rate) as somme FROM rating where rating.id_reponse='"+id_reponse+"'";
    ResultSet resultat = stm.executeQuery(req);
    while(resultat.next()){
    nb=resultat.getInt("somme");
    }
    return nb;
    }
    
 public   int Calculunrate(int id_reponse) throws SQLException
    {int nb=0;
    Statement stm = cnx.createStatement();
    String req = "SELECT SUM(unrate) as somme FROM rating where rating.id_reponse='"+id_reponse+"'";
    ResultSet resultat = stm.executeQuery(req);
    while(resultat.next()){
    nb=resultat.getInt("somme");
    }
    return nb;
    }
    
    
    
 public  ArrayList<Reponse> AfficherReponsesAvecTriRate(int id_question) throws SQLException
    {
        ArrayList<Reponse> retour = new ArrayList<>();
        
        Statement stm = cnx.createStatement();
        String req = "SELECT reponse.id,reponse.id_reponse,date_reponse,contenu_reponse,username FROM reponse join fos_user on reponse.id=fos_user.id  WHERE etat_reponse=1 AND reponse.id_question='"+id_question+"'";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
 
        String date_reponse= resultat.getString("date_reponse");
        String contenu_reponse= resultat.getString("contenu_reponse");
        String username= resultat.getString("username");
        int id_reponse=resultat.getInt("id_reponse");
        int id=resultat.getInt("id");
        int rate=Calculrate(id_reponse);
        int unrate=Calculunrate(id_reponse);

       

         retour.add(new Reponse(id,id_reponse,date_reponse,contenu_reponse,rate,unrate,username));
            
        }
      return retour;
    }
    
    
   
 public  Reponse AfficherReponsesAvecTriRatePARID(int id_reponse) throws SQLException
    {
        Reponse retour = new Reponse();
        
        Statement stm = cnx.createStatement();
        String req = "SELECT date_reponse,contenu_reponse,username FROM reponse join fos_user on reponse.id=fos_user.id  WHERE etat_reponse=1 AND reponse.id_reponse='"+id_reponse+"'";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
 
        String date_reponse= resultat.getString("date_reponse");
        String contenu_reponse= resultat.getString("contenu_reponse");
        String username= resultat.getString("username");
        int rate=Calculrate(id_reponse);
        int unrate=Calculunrate(id_reponse);

       

         retour=new Reponse(date_reponse,contenu_reponse,rate,unrate,username);
            
        }
      return retour;
    }
    
  /*  ArrayList<Reponse> AfficherReponsesAvecTriRate(int id_question) throws SQLException
    {
        ArrayList<Reponse> retour = new ArrayList<>();
        
        Statement stm = cnx.createStatement();
        String req = "SELECT reponse.id_reponse,date_reponse,contenu_reponse,username FROM reponse join fos_user on reponse.id=fos_user.id  WHERE etat_reponse=1 AND reponse.id_question='"+id_question+"'";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
 
        String date_reponse= resultat.getString("date_reponse");
        String contenu_reponse= resultat.getString("contenu_reponse");
        String username= resultat.getString("username");

        int id_reponse=resultat.getInt("id_reponse");
       

         retour.add(new Reponse(id_reponse,date_reponse,contenu_reponse,username));
            
        }
      return retour;
    }*/
    
    
    
            
    
    
    
    
    
    
    

    



}
