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
public class participation {
    private int idp;
    private fos_user iduser;
    private Event idevent;

    public participation() {
    }

    public participation(int idp, fos_user iduser, Event idevent) {
        this.idp = idp;
        this.iduser = iduser;
        this.idevent = idevent;
    }

    public participation(fos_user iduser, Event idevent) {
        this.iduser = iduser;
        this.idevent = idevent;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
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
