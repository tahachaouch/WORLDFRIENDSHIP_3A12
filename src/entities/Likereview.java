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
public class Likereview {
    private int id ;
    private String id_user;
    private  int id_article;

    public Likereview(String id_user, int id_article) {
        this.id_user = id_user;
        this.id_article = id_article;
    }

  
    public int getId() {
        return id;
    }

    public String getId_user() {
        return id_user;
    }

    public int getId_article() {
        return id_article;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

 

  
}
