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
public class likeevent {
    private int idlike;
    private fos_user iduser;
    private Event idevent;

    public likeevent() {
    }

    public likeevent(int idlike, fos_user iduser, Event idevent) {
        this.idlike = idlike;
        this.iduser = iduser;
        this.idevent = idevent;
    }

    public int getIdlike() {
        return idlike;
    }

    public void setIdlike(int idlike) {
        this.idlike = idlike;
    }

    public fos_user getIduser() {
        return iduser;
    }

    public void setIduser(fos_user iduser) {
        this.iduser = iduser;
    }

    public Event getIdevent() {
        return idevent;
    }

    public void setIdevent(Event idevent) {
        this.idevent = idevent;
    }
    
    
    
}
