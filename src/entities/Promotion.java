/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import service.PromotionService;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Promotion {
    private int id_promo;
    private float pourcentage;
    private String description ;
    private Date date_promo;
    private Produit p;
    private int idprod;
    private String nomprod;

    public Promotion() {
    }

    public Promotion(int id_promo, float pourcentage, String description, Date date_promo) {
        this.id_promo = id_promo;
        this.pourcentage = pourcentage;
        this.description = description;
        this.date_promo = date_promo;
    }

    public Promotion(int id_promo, float pourcentage, String description, Date date_promo, int idprod) {
        this.id_promo = id_promo;
        this.pourcentage = pourcentage;
        this.description = description;
        this.date_promo = date_promo;
        this.idprod = idprod;
        
    }

    public Promotion(float pourcentage, String description, int idprod) {
        this.pourcentage = pourcentage;
        this.description = description;
        this.idprod = idprod;
    }
    

    public int getIdprod() {
        return idprod;
    }
    

    public int getId_promo() {
        return id_promo;
    }

    public float getPourcentage() {
        return pourcentage;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate_promo() {
        return date_promo;
    }

    public void setId_promo(int id_promo) {
        this.id_promo = id_promo;
    }

    public void setPourcentage(float pourcentage) {
        this.pourcentage = pourcentage;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate_promo(Date date_promo) {
        this.date_promo = date_promo;
    }

    public String getNomprod() throws SQLException {
         PromotionService ps= new PromotionService();
        return ps.SelectProduit(idprod);
    }

    String Newligne=System.getProperty("line.separator");
   
    @Override
    public String toString() {
      
        try {
            return  "Nom Produit :  "
                    + " " + getNomprod() +Newligne
                    + " Date : "
                    + " " + date_promo +Newligne
                    + " Pourcentage : "
                    + " " + pourcentage;
        } catch (SQLException ex) {
            Logger.getLogger(Promotion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
    
}
