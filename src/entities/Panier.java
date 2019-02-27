/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author HP
 */
public class Panier {

    private int id_panier;
    private boolean etat;
    private Date date_ajout;
    private User u;
    private  String nom;

    public Panier() {
    }

    public Panier(int id_panier, boolean etat, Date date_ajout) {
        this.id_panier = id_panier;
        this.etat = etat;
        this.date_ajout = date_ajout;
    }

    public Panier(int id_panier, Date date_ajout, String nom) {
        this.id_panier = id_panier;
        this.nom=nom;
       // this.u.setUsername(nom);
        this.date_ajout = date_ajout;
    }

    public Panier(boolean etat, Date date_ajout) {
        this.etat = etat;
        this.date_ajout = date_ajout;
    }

    public int getId_panier() {
        return id_panier;
    }

    public boolean isEtat() {
        return etat;
    }

    public Date getDate_ajout() {
        return date_ajout;
    }

    public void setId_panier(int id_panier) {
        this.id_panier = id_panier;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public void setDate_ajout(Date date_ajout) {
        this.date_ajout = date_ajout;
    }

    public String getUName() {
        return u.getUsername();
    }
      public String getName() {
        return nom;
    }

    public int getUId() {
        return u.getId();
    }

    @Override
    public String toString() {
        return "Panier{" + "id_panier=" + id_panier + ", date_ajout=" + date_ajout + '}';
    }

}
