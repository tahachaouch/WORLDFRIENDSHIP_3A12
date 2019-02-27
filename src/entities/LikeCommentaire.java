/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ASUS
 */
public class LikeCommentaire {
    private int id ;
    private User id_user;

    private CommentaireARTICLE id_commentaire;

    public LikeCommentaire(int id, User id_user,CommentaireARTICLE id_commentaire) {
        this.id = id;
        this.id_user = id_user;
        
        this.id_commentaire = id_commentaire;
    }

    public LikeCommentaire() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getId_user() {
        return id_user;
    }

    public void setId_user(User id_user) {
        this.id_user = id_user;
    }

    

    public CommentaireARTICLE getId_commentaire() {
        return id_commentaire;
    }

    public void setId_commentaire(CommentaireARTICLE id_commentaire) {
        this.id_commentaire = id_commentaire;
    }
    

   
    
  
}
