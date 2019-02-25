/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldfriendship.Entities;


import java.sql.Date;

/**
 *
 * @author user
 */
public class Review {
    private int idCmt;
    private String cmt;
    private Date date;
    private Event id_event;
    private fos_user iduser;

    public Review() {
    }

    public Review(String cmt, Date date, Event id_event) {
        this.cmt = cmt;
        this.date = date;
        this.id_event = id_event;
    }

    public Review(String cmt, Date date, Event id_event, fos_user iduser) {
        this.cmt = cmt;
        this.date = date;
        this.id_event = id_event;
        this.iduser = iduser;
    }

    public fos_user getIduser() {
        return iduser;
    }

    public void setIduser(fos_user iduser) {
        this.iduser = iduser;
    }
    

    public int getIdCmt() {
        return idCmt;
    }

    public void setIdCmt(int idCmt) {
        this.idCmt = idCmt;
    }
   

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Event getId_event() {
        return id_event;
    }

    public void setId_event(Event id_event) {
        this.id_event = id_event;
    }
    
    
}
