/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


import java.sql.Date;
import javafx.scene.control.TableColumn;

/**
 *
 * @author ASUS
 */
public class Article {
     private int id;
   
    public String titre_article;
    public String blog;
    public String image;
    private Date modifie;
    private Date cree;
    private boolean archive;
    public String tags;

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
    

    public Article() {
    }

    public Article(int id, String titre_article, String blog, String image, Date modifie, Date cree, boolean archive, String tags) {
        this.id = id;
        this.titre_article = titre_article;
        this.blog = blog;
        this.image = image;
        this.modifie = modifie;
        this.cree = cree;
        this.archive = archive;
        this.tags = tags;
    }

    public Article(String titre_article, String blog, String image, String tags) {
        this.titre_article = titre_article;
        this.blog = blog;
        this.image = image;
        this.tags = tags;
    }

    public Article(String titre_article, String blog) {
        this.titre_article = titre_article;
        this.blog = blog;
    }

    public Article(int id, String titre_article, String blog, String image, Date modifie, Date cree, boolean archive) {
        this.id = id;
       
        this.titre_article = titre_article;
        this.blog = blog;
        this.image = image;
        this.modifie = modifie;
        this.cree = cree;
        this.archive = archive;
    }

    public Article(int id, String titre_article, String blog, String image) {
        this.id = id;
        
        this.titre_article = titre_article;
        this.blog = blog;
        this.image = image;
    }

   


    public Article(TableColumn<Article, String> titre, TableColumn<Article, String> blog) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Article(String titre_article, String blog, String image) {
        this.titre_article = titre_article;
        this.blog = blog;
        this.image = image;
    }

 

 

    public int getId() {
        return id;
    }

   
    public String getTitre_article() {
        return titre_article;
    }

    public String getBlog() {
        return blog;
    }

    public String getImage() {
        return image;
    }

    public Date getModifie() {
        return modifie;
    }

    public Date getCree() {
        return cree;
    }

    public boolean isArchive() {
        return archive;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public void setTitre_article(String titre_article) {
        this.titre_article = titre_article;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setModifie(Date modifie) {
        this.modifie = modifie;
    }

    public void setCree(Date cree) {
        this.cree = cree;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", titre_article=" + titre_article + ", blog=" + blog + ", image=" + image + ", modifie=" + modifie + ", cree=" + cree + ", archive=" + archive + ", tags=" + tags + '}';
    }

   

    
    

}