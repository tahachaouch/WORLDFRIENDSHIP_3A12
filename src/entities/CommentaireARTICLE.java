/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class CommentaireARTICLE {
    private int id;
    private User id_user;
    private Article id_article;
    private Date date_comment;
    private String commentaire;

    public CommentaireARTICLE(int id, User id_user, Article id_article, Date date_comment, String commentaire) {
        this.id = id;
        this.id_user = id_user;
        this.id_article = id_article;
        this.date_comment = date_comment;
        this.commentaire = commentaire;
    }

    public CommentaireARTICLE() {
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

    public Date getDate_comment() {
        return date_comment;
    }

    public void setDate_comment(Date date_comment) {
        this.date_comment = date_comment;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    
    
}
