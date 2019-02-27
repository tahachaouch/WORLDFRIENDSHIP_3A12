package entities;
import java.util.*;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 *
 * @author arthas
 */
public class Question {

    private int id;
    private int id_question;
    String date_question = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
    //Date date= new Date();
   // long time = date.getTime();
   // Timestamp date_question = new Timestamp(time);
    private String titre_question;
    private String contenu_question;
    private int etat_question;
    private String username;
    private int nbr_comment;
        private String contenu_reponse;
        private int nbr_sig;
        
        
        public Question(int id_question)
        {
        this.id_question=id_question;
        }

    public int getNbr_sig() {
        return nbr_sig;
    }

    public void setNbr_sig(int nbr_sig) {
        this.nbr_sig = nbr_sig;
    }
        

       public Question(int id,int id_question,String username,String titre_question,String date_question,int nbr_comment,int nbr_sig)
       {
    this.id=id;
    this.id_question=id_question;
    this.username=username;
    this.titre_question=titre_question;
    this.date_question=date_question;
    this.nbr_comment=nbr_comment;
    this.nbr_sig=nbr_sig;
       
       
       }
        
        
    @Override
    public String toString() {
        return "\nQuestion{\n" + "\ndate_question=" + date_question + "\ntitre_question=" + titre_question + "\ncontenu_question=" + contenu_question + "\ncontenu_reponse=" + contenu_reponse + '}'+"\n";
    }

    public String getContenu_reponse() {
        return contenu_reponse;
    }

    public void setContenu_reponse(String contenu_reponse) {
        this.contenu_reponse = contenu_reponse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public String getDate_question() {
        return date_question;
    }

    public void setDate_question(String date_question) {
        this.date_question = date_question;
    }

    public String getTitre_question() {
        return titre_question;
    }

    public void setTitre_question(String titre_question) {
        this.titre_question = titre_question;
    }

    public String getContenu_question() {
        return contenu_question;
    }

    public void setContenu_question(String contenu_question) {
        this.contenu_question = contenu_question;
    }

    public int getEtat_question() {
        return etat_question;
    }

    public void setEtat_question(int etat_question) {
        this.etat_question = etat_question;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNbr_comment() {
        return nbr_comment;
    }

    public void setNbr_comment(int nbr_comment) {
        this.nbr_comment = nbr_comment;
    }
 



  public Question(int id,int id_question,String username,String titre_question,String date_question,int nbr_comment)
  {
    this.id=id;
    this.id_question=id_question;
    this.username=username;
    this.titre_question=titre_question;
    this.date_question=date_question;
    this.nbr_comment=nbr_comment;
      
  }
  


    public Question() {
    }
    
    public Question(String titre_question,String date_question ) {
         this.titre_question=titre_question;
         this.date_question=date_question;

         
    }
    
    
    
     public Question(int id_question, String username, String titre_question,String date_question,int nbr_comment ) {
         this.id_question=id_question;
         this.username=username;
         this.titre_question=titre_question;
         this.date_question=date_question;
         this.nbr_comment=nbr_comment;
         
    }
     
  
     
     public Question(int id_question, String titre_question,String date_question,int nbr_comment ) {
         this.id_question=id_question;
         this.titre_question=titre_question;
         this.date_question=date_question;
         this.nbr_comment=nbr_comment;
         
    }

    

   public Question(String username,String titre,String date,int nbr) {
    }

    public Question(String date_question,String titre_question,String contenu_question,String contenu_reponse)
    {
        this.date_question=date_question;
        this.titre_question=titre_question;
        this.contenu_question=contenu_question;
        this.contenu_reponse=contenu_reponse;
    
    }
    
    public Question(int id,String date_question, String titre_question, String contenu_question) {
      this.id=id;
      this.date_question=date_question;
      this.titre_question=titre_question;
      this.contenu_question=contenu_question;
    }
    
    
    
    public Question(int id, int id_question, String date_question, String titre_question, String contenu_question) {
        this.id = id;
        this.id_question=id_question;
        this.date_question=date_question;
        this.titre_question=titre_question;
        this.contenu_question=contenu_question;
    
        
    }
    

    

   /* public Question(int id, int id_question, String date_question, String titre_question, String contenu_question, int etat) {
        this.id = id;
        this.id_question=id_question;
        this.date_question=date_question;
        this.titre_question=titre_question;
        this.contenu_question=contenu_question;
        this.etat_question=etat_question;
        
    }*/
    





    public Question(int id_question, String titre_question, String contenu_question) {
        this.id_question=id_question;
        this.titre_question=titre_question;
        this.contenu_question=contenu_question;
    }

   
  

    

   
   /* public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }*/

    

   

   

    
    
    

 

  

 
    
    
    
    
}