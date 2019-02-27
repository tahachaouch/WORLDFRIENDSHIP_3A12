package entities;



import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 *
 * @author arthas
 */
public class Reponse {
    int id;
    int id_question;
    int id_reponse;
    String date_reponse = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
    String contenu_reponse;
    int etat_reponse;
    int rate;
    int unrate;
    String username;
    
    
    
   public Reponse(int id,int id_reponse,String date_reponse,String contenu_reponse,int rate,int unrate,String username) 
   {
       this.id=id;
       this.id_reponse=id_reponse;
       this.date_reponse=date_reponse;
       this.contenu_reponse=contenu_reponse;
       this.rate=rate;
       this.unrate=unrate;
       this.username=username;
   
   }
    
  public Reponse(int id_reponse,String date_reponse,String contenu_reponse,String username)
  {
  this.id_reponse=id_reponse;
this.date_reponse=date_reponse;
this.contenu_reponse=contenu_reponse;
this.username=username;
      
  }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getUnrate() {
        return unrate;
    }

    public void setUnrate(int unrate) {
        this.unrate = unrate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    
    public Reponse(String date_reponse,String contenu_reponse,int rate,int unrate,String username){

this.date_reponse=date_reponse;
this.contenu_reponse=contenu_reponse;
this.rate=rate;
this.unrate=unrate;
this.username=username;


}
    
    
public Reponse(int id_reponse,String date_reponse,String contenu_reponse,int rate,int unrate,String username){

this.id_reponse=id_reponse;
this.date_reponse=date_reponse;
this.contenu_reponse=contenu_reponse;
this.rate=rate;
this.unrate=unrate;
this.username=username;


}
    public Reponse() {
    }

    public Reponse(String contenu_reponse) {
        this.contenu_reponse = contenu_reponse;
    }

    
    public Reponse(int id_reponse) {
        this.id_reponse = id_reponse;
    }
    

    public Reponse(int id_reponse, String contenu_reponse) {
        this.id_reponse = id_reponse;
        this.contenu_reponse = contenu_reponse;
    }
    
    
    public Reponse(int id, int id_question,String date_reponse, String contenu_reponse) {
        this.id = id;
        this.id_question = id_question;
        this.date_reponse=date_reponse;
        this.contenu_reponse = contenu_reponse;
    }
    
    public Reponse(int id, int id_question, int id_reponse, String contenu_reponse,String date_reponse, int etat_reponse) {
        this.id = id;
        this.id_question = id_question;
        this.id_reponse = id_reponse;
        this.contenu_reponse = contenu_reponse;
        this.date_reponse=date_reponse;
        this.etat_reponse = etat_reponse;
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

    public int getId_reponse() {
        return id_reponse;
    }

    public void setId_reponse(int id_reponse) {
        this.id_reponse = id_reponse;
    }

    public String getDate_reponse() {
        return date_reponse;
    }

    public void setDate_reponse(String date_reponse) {
        this.date_reponse = date_reponse;
    }

    public String getContenu_reponse() {
        return contenu_reponse;
    }

    public void setContenu_reponse(String contenu_reponse) {
        this.contenu_reponse = contenu_reponse;
    }

    public int getEtat_reponse() {
        return etat_reponse;
    }

    public void setEtat_reponse(int etat_reponse) {
        this.etat_reponse = etat_reponse;
    }

    @Override
    public String toString() {
        return "Reponse{" + "id=" + id + ", id_question=" + id_question + ", id_reponse=" + id_reponse + ", date_reponse=" + date_reponse + ", contenu_reponse=" + contenu_reponse + ", etat_reponse=" + etat_reponse + '}';
    }


    
    
    
    
    
    
    
}


