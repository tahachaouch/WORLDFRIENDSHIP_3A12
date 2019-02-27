/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Signaler;
import connexion.MyDBcon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arthas
 */
public class SignalerService {
     Connection cnx;
    
    public SignalerService() throws SQLException {
       cnx = MyDBcon.getInstance().getCnx();
       
        
    }
    
    
    
    public void ajouter_signaler(Signaler sig)
    {
         try {
             Statement stm = cnx.createStatement();
             String req = "INSERT INTO `signaler`(`id`,`id_question`, `sig`, `cause` ,`date_signaler` ) VALUES ('"+sig.getId()+"','"+sig.getId_question()+"',1,'"+sig.getCause()+"','"+sig.getDate_signaler()+"')";
             stm.executeUpdate(req);
         } catch (SQLException ex) {
             Logger.getLogger(SignalerService.class.getName()).log(Level.SEVERE, null, ex);
         }
    
    }
    
    
 public boolean signalertest(int id,int id_q) throws SQLException
    { boolean retour=false;
        
        Statement stm = cnx.createStatement();
        String req = "SELECT id,id_question FROM signaler";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
 
        int id_user=resultat.getInt("id");
        int id_question=resultat.getInt("id_question");  
         if(id_question==id_q && id==id_user )
             retour=true;
        }
        
             return retour;
    }
  
  
  
public  int signaleexiste()
  { int nb=0;
         try {
             
             Statement stm = cnx.createStatement();
             String req = "SELECT vu, COUNT( * ) as nb FROM signaler WHERE vu=0";
             ResultSet resultat = stm.executeQuery(req);
             while(resultat.next()){
                nb=resultat.getInt("nb");
              
             }
             
             
             
         } catch (SQLException ex) {
             Logger.getLogger(SignalerService.class.getName()).log(Level.SEVERE, null, ex);
         }return nb;
  } 
  

  
 public ArrayList<Signaler> AfficherSignaler(int id_question) throws SQLException
    {
        ArrayList<Signaler> retour = new ArrayList<>();
        
        Statement stm = cnx.createStatement();
        String req = "SELECT  username,cause,date_signaler FROM signaler join fos_user on signaler.id=fos_user.id WHERE signaler.id_question='"+id_question+"'";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
 
        String username= resultat.getString("username");
        String cause= resultat.getString("cause");
        String date_signaler= resultat.getString("date_signaler");



       

         retour.add(new Signaler(username,cause,date_signaler));
            
        }
      return retour;
    }
  
  
  
  
 public void Setvu(int id_question)
  {
   try {
            String req = "UPDATE signaler set  vu=1 WHERE id_question=?";
            PreparedStatement pstm = cnx.prepareStatement(req);
            pstm.setInt(1, id_question);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtiliseObjetService.class.getName()).log(Level.SEVERE, null, ex);
        }
  
  }
  
  
}
    




