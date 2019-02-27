package entities;

import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 *
 * @author arthas
 */
public class Rating {
    
   int id;
   int id_reponse;
   int rate;
   int unrate;

    public Rating() {
    }

    public Rating(int id, int id_reponse) {
        this.id = id;
        this.id_reponse = id_reponse;
    }

    public Rating(int rate) {
        this.rate = rate;
    }
   
    

    public Rating(int id, int id_reponse, int rate, int unrate) {
        this.id = id;
        this.id_reponse = id_reponse;
        this.rate = rate;
        this.unrate=unrate;
    }

    public int getUnrate() {
        return unrate;
    }

    public void setUnrate(int unrate) {
        this.unrate = unrate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_reponse() {
        return id_reponse;
    }

    public void setId_reponse(int id_reponse) {
        this.id_reponse = id_reponse;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Rating{" + "id=" + id + ", id_reponse=" + id_reponse + ", rate=" + rate + ", unrate=" + unrate + '}';
    }

   
   
   
    
    
}
