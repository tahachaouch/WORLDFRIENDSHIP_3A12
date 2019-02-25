/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldfriendship.Entities;

/**
 *
 * @author user
 */
public class Likereview {
    private int id;
    private Review idCmt;
    private Event id_event;
    private fos_user iduser;

    public Likereview() {
    }

    public Likereview(int id, Review idCmt, Event id_event, fos_user iduser) {
        this.id = id;
        this.idCmt = idCmt;
        this.id_event = id_event;
        this.iduser = iduser;
    }

    public fos_user getIduser() {
        return iduser;
    }

    public void setIduser(fos_user iduser) {
        this.iduser = iduser;
    }

   

    public Review getIdCmt() {
        return idCmt;
    }

    public void setIdCmt(Review idCmt) {
        this.idCmt = idCmt;
    }

    public Event getId_event() {
        return id_event;
    }

    public void setId_event(Event id_event) {
        this.id_event = id_event;
    }

   

    public Likereview(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  
    
}
