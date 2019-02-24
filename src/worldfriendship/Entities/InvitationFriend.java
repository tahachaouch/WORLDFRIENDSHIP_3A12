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
public class InvitationFriend {
    private int id;
    private int idusersender ;
    private int iduserreciever;

    public InvitationFriend(int id, int idusersender, int iduserreciever) {
        this.id = id;
        this.idusersender = idusersender;
        this.iduserreciever = iduserreciever;
    }

    public InvitationFriend() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdusersender() {
        return idusersender;
    }

    public void setIdusersender(int idusersender) {
        this.idusersender = idusersender;
    }

    public int getIduserreciever() {
        return iduserreciever;
    }

    public void setIduserreciever(int iduserreciever) {
        this.iduserreciever = iduserreciever;
    }
    
}
