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
public class LikeArticle {
    private int id_like;
    private User id_user;
    private Article id_article;

    public LikeArticle() {
    }

    public LikeArticle(int id_like, User id_user, Article id_article) {
        this.id_like = id_like;
        this.id_user = id_user;
        this.id_article = id_article;
    }

    public int getId_like() {
        return id_like;
    }

    public void setId_like(int id_like) {
        this.id_like = id_like;
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
    
}
