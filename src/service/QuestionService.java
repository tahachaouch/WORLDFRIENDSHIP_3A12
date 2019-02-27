package service;


import entities.Question;
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
public class QuestionService {
     Connection cnx;
    
    public QuestionService() throws SQLException {
       cnx = MyDBcon.getInstance().getCnx();
       
        
    }

  public  void ajouterQuestion(Question q) {
         try {
             
             System.out.println("connexion établie");
             Statement stm = cnx.createStatement();
             String req = "INSERT INTO `question`(`id`,`date_question`, `titre_question`, `contenu_question`) VALUES ('"+q.getId()+"','"+q.getDate_question()+"','"+q.getTitre_question()+"','"+q.getContenu_question()+"')";
             stm.executeUpdate(req);
         } catch (SQLException ex) {
             Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
public void modifierQuestion(Question q) {
         try {
             
             String req = "UPDATE question set titre_question=?,contenu_question=? where id_question=?";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setString(1, q.getTitre_question());
             pstm.setString(2, q.getContenu_question());
             pstm.setInt(3, q.getId_question());
             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

public void supprimerQuestion(Question q) {
         try {
             
             String req = "UPDATE question set etat_question=0 WHERE id_question=?";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setInt(1, q.getId_question());
             pstm.executeUpdate();
             
             
             String req2 = "UPDATE reponse set etat_reponse=0 WHERE id_question=?";
             PreparedStatement pstm2 = cnx.prepareStatement(req2);
             pstm2.setInt(1, q.getId_question());
             pstm2.executeUpdate();
             
             
             String req3="DELETE FROM signaler WHERE id_question=?";
             PreparedStatement pstm3 = cnx.prepareStatement(req3);
             pstm3.setInt(1, q.getId_question());
             pstm3.executeUpdate();
             
             
         } catch (SQLException ex) {
             Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
  /* void ajouterAlaBase2(Question q) {
         try {
             
             String req = "INSERT INTO `question`(`date_question`, `titre_question`, `contenu_question`) VALUES (?,?,?)";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setString(1, q.getDate_question());
             pstm.setString(2, q.getTitre_question());
             pstm.setString(3, q.getContenu_question());
             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }*/
   

    

  public ArrayList<Question> getAllQuestions() throws SQLException {
       ArrayList<Question> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM question";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int id= resultat.getInt("id");
         //  System.out.println(id);
           int id_question= resultat.getInt("id_question");
           String date_question= resultat.getString("date_question");
           String titre_question = resultat.getString("titre_question");
           String contenu_question= resultat.getString("contenu_question");
           int etat_question=resultat.getInt("etat_question");
           retour.add(new Question(id,id_question,date_question,titre_question,contenu_question,etat_question));
            
        }
            
        return retour;
    
   }
   
   
      public ArrayList<Question> afficherQuestionsCompletAvecSignale() throws SQLException
   {    ArrayList<Question> retour = new ArrayList<>();
        
        Statement stm = cnx.createStatement();
        Statement stm1 = cnx.createStatement();
        Statement stm2 = cnx.createStatement();
        String req = "SELECT question.id,question.id_question,titre_question,date_question,username FROM question join fos_user on question.id=fos_user.id JOIN signaler ON signaler.id_question=question.id_question WHERE etat_question=1";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
        int nbr_comment=0,nbr_sig=0;
       
       String titre_question= resultat.getString("titre_question");
       //System.out.println(titre_question);
       String date_question= resultat.getString("date_question");
      // System.out.println(date_question);
       String username= resultat.getString("username");
      // System.out.println(username);
       
       //Calculer le nombre de commentaires pour chaque question.
       int id_question= resultat.getInt("id_question");
       int id= resultat.getInt("id");
       String req1 = "SELECT id_reponse FROM reponse WHERE reponse.id_question="+id_question+" AND etat_reponse=1 ";
       ResultSet resultat1 = stm1.executeQuery(req1);
       while(resultat1.next())
       {
         nbr_comment++;
       }
      // System.out.println("Nbr de Commentaire: "+nbr_comment);
       String req2="SELECT signaler.id_question FROM signaler WHERE signaler.id_question="+id_question+" AND sig=1";
       ResultSet resultat2 = stm2.executeQuery(req2);
       while(resultat2.next())
       {
       nbr_sig++;
       }
      
      System.out.println(nbr_sig);
       
       retour.add(new Question(id,id_question,username,titre_question,date_question,nbr_comment,nbr_sig));
       
            
        }

         return retour;  
    }
   
   
   
   public ArrayList<Question> afficherQuestionsComplet() throws SQLException
   {    ArrayList<Question> retour = new ArrayList<>();
        
        Statement stm = cnx.createStatement();
        Statement stm1 = cnx.createStatement();
        String req = "SELECT question.id,id_question,titre_question,date_question,username FROM question join fos_user on question.id=fos_user.id WHERE etat_question=1";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
        int nbr_comment=0;
       
       String titre_question= resultat.getString("titre_question");
       //System.out.println(titre_question);
       String date_question= resultat.getString("date_question");
      // System.out.println(date_question);
       String username= resultat.getString("username");
      // System.out.println(username);
       
       //Calculer le nombre de commentaires pour chaque question.
       int id_question= resultat.getInt("id_question");
       int id= resultat.getInt("id");
       String req1 = "SELECT id_reponse FROM reponse WHERE reponse.id_question="+id_question+" AND etat_reponse=1 ";
       ResultSet resultat1 = stm1.executeQuery(req1);
       while(resultat1.next())
       {
         nbr_comment++;
       }
      // System.out.println("Nbr de Commentaire: "+nbr_comment);
       
       
       retour.add(new Question(id,id_question,username,titre_question,date_question,nbr_comment));
       
            
        }

         return retour;  
    }
   
   
   
   
public ArrayList<Question> afficherQuestionPDF(int id) throws SQLException
{
     ArrayList<Question> retour = new ArrayList<>();
     Statement stm = cnx.createStatement();
     String req="SELECT date_question,titre_question,contenu_question,reponse.contenu_reponse FROM question JOIN reponse ON question.id_question=reponse.id_question  WHERE etat_question=1 AND question.id="+id+" ORDER BY titre_question";
     ResultSet resultat = stm.executeQuery(req);
     while(resultat.next()){
     String date_question= resultat.getString("date_question");
     String titre_question= resultat.getString("titre_question");
     String contenu_question= resultat.getString("contenu_question");
     String contenu_reponse= resultat.getString("contenu_reponse");
     
     retour.add(new Question(date_question,titre_question,contenu_question,contenu_reponse));
     }
     
    return retour; 
}


   
 public     void afficherQuestionsCompletTri(String critere) throws SQLException
   {    
        int i=0;
        Statement stm = cnx.createStatement();
        Statement stm1 = cnx.createStatement();
        String req = "SELECT id_question,titre_question,date_question,username FROM question join fos_user on question.id=fos_user.id WHERE etat_question=1 ORDER BY '"+critere+"'";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
 
       
       String titre_question= resultat.getString("titre_question");
       System.out.println(titre_question);
       String date_question= resultat.getString("date_question");
       System.out.println(date_question);
       String username= resultat.getString("username");
       System.out.println(username);
       
       //Calculer le nombre de commentaires pour chaque question.
       int id_question= resultat.getInt("id_question");
       String req1 = "SELECT id_reponse FROM reponse WHERE reponse.id_question="+id_question+" AND etat_reponse=1";
       ResultSet resultat1 = stm1.executeQuery(req1);
       while(resultat1.next())
       {
         i++;
       }
       System.out.println("Nbr de Commentaire: "+i);
       
       
       
       
            
        }
           
    }
      
    public   void afficherQuestionsCompletRecherche(String mot) throws SQLException
   {    
        int i=0;
        Statement stm = cnx.createStatement();
        Statement stm1 = cnx.createStatement();
        String req = "SELECT id_question,titre_question,date_question,username FROM question join fos_user on question.id=fos_user.id WHERE etat_question=1 AND (titre_question LIKE '%"+mot+"%' OR fos_user.username LIKE '%"+mot+"%')";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
 
       
       String titre_question= resultat.getString("titre_question");
       System.out.println(titre_question);
       String date_question= resultat.getString("date_question");
       System.out.println(date_question);
       String username= resultat.getString("username");
       System.out.println(username);
       
       //Calculer le nombre de commentaires pour chaque question.
       int id_question= resultat.getInt("id_question");
       String req1 = "SELECT id_reponse FROM reponse WHERE reponse.id_question="+id_question+" AND etat_reponse=1";
       ResultSet resultat1 = stm1.executeQuery(req1);
       while(resultat1.next())
       {
         i++;
       }
       System.out.println("Nbr de Commentaire: "+i);
       
       
       
       
            
        }
           
    }
   
   
   
   
   
   
  public  ArrayList<Question> afficherQuestionsUser(int id) throws SQLException
   {    ArrayList<Question> retour = new ArrayList<>();
   
        Statement stm = cnx.createStatement();
        Statement stm1 = cnx.createStatement();
        String req = "SELECT id_question,titre_question,date_question FROM question WHERE etat_question=1 AND question.id="+id+"";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
        int nbr_comment=0;
       
       String titre_question= resultat.getString("titre_question");
       //System.out.println(titre_question);
       String date_question= resultat.getString("date_question");
      // System.out.println(date_question);

       
       //Calculer le nombre de commentaires pour chaque question.
       int id_question= resultat.getInt("id_question");
       String req1 = "SELECT id_reponse FROM reponse WHERE reponse.id_question="+id_question+" AND etat_reponse=1";
       ResultSet resultat1 = stm1.executeQuery(req1);
       while(resultat1.next())
       {
         nbr_comment++;
       }
      // System.out.println("Nbr de Commentaire: "+nbr_comment);
       
       
       retour.add(new Question(id_question,titre_question,date_question,nbr_comment));
       
            
        }
         return retour;  
    }
           
   
   
   
   
   
   
 /*  ArrayList<Question> getQuestions() throws SQLException {
       ArrayList<Question> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT id,id_question,date_question,titre_question,contenu_question FROM question WHERE etat_question=1";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int id= resultat.getInt("id");
           int id_question= resultat.getInt("id_question");
           String date_question= resultat.getString("date_question");
           String titre_question = resultat.getString("titre_question");
           String contenu_question= resultat.getString("contenu_question");
           retour.add(new Question(id,id_question,date_question,titre_question,contenu_question));
            
        }
            
        return retour;
    
   }*/
    
  public  Question afficherQuestionParId(int id) throws SQLException
   {    Question retour = new Question();
   
        Statement stm = cnx.createStatement();
        String req = "SELECT id_question,titre_question,date_question,contenu_question FROM question WHERE etat_question=1 AND question.id_question="+id+"";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
       
       String titre_question= resultat.getString("titre_question");
       String contenu_question= resultat.getString("contenu_question");
       String date_question= resultat.getString("date_question");
       int id_question= resultat.getInt("id_question");
       String req1 = "SELECT id_reponse FROM reponse WHERE reponse.id_question="+id_question+" ";
       retour=new Question(id_question,titre_question,date_question,contenu_question);
       
            
        }
         return retour;  
    }
    
    
    
   
}
   