/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.UtileObjet;
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
public class UtiliseObjetService {
    Connection cnx;
    
    public UtiliseObjetService() throws SQLException {
       cnx = MyDBcon.getInstance().getCnx();
       
        
    }
   
   /* int getiduserdb()
    {int id_userdb =0;
        try {
            System.out.println("connexion établie");
            Statement stm = cnx.createStatement();
            String req = "SELECT iduser_db from utiliseobjet";
            stm.executeUpdate(req);
            ResultSet resultat = stm.executeQuery(req);
            id_userdb= resultat.getInt("id_userdb");
        } catch (SQLException ex) {
            Logger.getLogger(UtiliseObjetService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id_userdb;
            
        }*/
    
     public  ArrayList<UtileObjet> getiduserdb() throws SQLException {
       ArrayList<UtileObjet> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "select id_questiondb,id_reponsedb,id_userdb FROM utiliseobjet LIMIT 1";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int id_userdb= resultat.getInt("id_userdb");
           int id_questiondb= resultat.getInt("id_questiondb");
           int id_reponsedb= resultat.getInt("id_reponsedb");
           retour.add(new UtileObjet(id_questiondb,id_reponsedb,id_userdb));
            
        }
            
        return retour;
    
   }
    
    
    
 public   void setiduserdb(int id)
    {
        try {
            String req = "UPDATE utiliseobjet set top 1 id_userdb=?";
            PreparedStatement pstm = cnx.prepareStatement(req);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtiliseObjetService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
             
    
  public  ArrayList<UtileObjet> getidquestiondb() throws SQLException {
       ArrayList<UtileObjet> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "select id_questiondb,id_reponsedb,id_userdb FROM utiliseobjet LIMIT 1";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int id_userdb= resultat.getInt("id_userdb");
           int id_questiondb= resultat.getInt("id_questiondb");
           int id_reponsedb= resultat.getInt("id_reponsedb");
           retour.add(new UtileObjet(id_questiondb,id_reponsedb,id_userdb));
            
        }
            
        return retour;
    
   }
    
    
 public   void setidquestiondb(int id)
    {
        try {
            String req = "UPDATE utiliseobjet set id_questiondb=? LIMIT 1";
            PreparedStatement pstm = cnx.prepareStatement(req);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtiliseObjetService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    
 public   ArrayList<UtileObjet> getidreponsedb() throws SQLException {
       ArrayList<UtileObjet> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "select id_questiondb,id_reponsedb,id_userdb FROM utiliseobjet LIMIT 1";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int id_userdb= resultat.getInt("id_userdb");
           int id_questiondb= resultat.getInt("id_questiondb");
           int id_reponsedb= resultat.getInt("id_reponsedb");
           retour.add(new UtileObjet(id_questiondb,id_reponsedb,id_userdb));
            
        }
            
        return retour;
    
   }
    
 public   void setidreponsedb(int id)
    {
        try {
            String req = "UPDATE utiliseobjet set id_reponsedb=? LIMIT 1";
            PreparedStatement pstm = cnx.prepareStatement(req);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtiliseObjetService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
}
