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
    private fos_user iduser;

    public Likereview() {
    }

    public Likereview(int id, Review idCmt, fos_user iduser) {
        this.id = id;
        this.idCmt = idCmt;
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
