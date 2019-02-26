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
    private  Article id_article;
    private CommentaireARTICLE id_commentaire;

    public LikeCommentaire(int id, User id_user, Article id_article, CommentaireARTICLE id_commentaire) {
        this.id = id;
        this.id_user = id_user;
        this.id_article = id_article;
        this.id_commentaire = id_commentaire;
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

    public Article getId_article() {
        return id_article;
    }

    public void setId_article(Article id_article) {
        this.id_article = id_article;
    }

    public CommentaireARTICLE getId_commentaire() {
        return id_commentaire;
    }

    public void setId_commentaire(CommentaireARTICLE id_commentaire) {
        this.id_commentaire = id_commentaire;
    }
    

   
    
  
}
