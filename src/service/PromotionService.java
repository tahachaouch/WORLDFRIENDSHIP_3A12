/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Article;

import connexion.conDB;
import entities.Panier;
import entities.Produit;
import entities.Promotion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author HP
 */
public class PromotionService {

    static Connection cnx;
    private ObservableList<Promotion> items = FXCollections.observableArrayList();
    java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

    public PromotionService() throws SQLException {
        cnx = conDB.getInstance().getCnx();
    }
//    //   public static int AjouterAuPanier(Produit p) {
////        int a=0;
////     try {
////            java.util.Date date_util = new java.util.Date();
////            java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
////            
////            String requete
////                    = "INSERT INTO article (titre_article, blog, image, cree, modifie, archive,tags) VALUES (?,?,?,?,?,?,?)";
////            PreparedStatement st = cnx.prepareStatement(requete);
////           // st.setInt(1,article.getId());
////           
////            st.setString(1,article.getTitre_article());
////            st.setString(2,article.getBlog());
////            st.setString(3,article.getImage()); 
////        
////            st.setDate(4, date_sql);
////                  st.setDate(5, date_sql);
////            
////            st.setBoolean(6, false);
////            st.setString(7,article.getTags());
////           
////           
////            st.executeUpdate();
////            System.out.println("Article ajouté");
////            a=1;
////            if(a==1){
////            Alert alert = new Alert(Alert.AlertType.INFORMATION);
////            alert.setTitle("Article");
////            alert.setHeaderText("INFORMATIONS");
////            alert.setContentText("Article bien ajouté !!");
////            alert.showAndWait();
////            
////        }
////        else{
////            
////            Alert alert =new Alert(Alert.AlertType.ERROR);
////            alert.setTitle(" Ajout article");
////            alert.setHeaderText("INFORMATIONS");
////            alert.setContentText("Article Non  Ajouté !!");
////            alert.showAndWait();
////        }
////        
////        } catch (SQLException ex) {
////            System.err.println(ex.getMessage());
////            
////        }
////     return a;
//
//    //  int id=7218854;
//    // while(ps.rechercherproduit(Integer.valueOf(idproduit.getText())))
//    //{
//    //  idproduit1=Integer.valueOf(idproduit.getText());
//    //}
////                    int quantite1=Integer.valueOf(quantite.getText());
////                    int x=ps.rechercherutilisateur(idutilisateur);
////                    ligneproduitservice lps= new ligneproduitservice();
////                        ligneproduit lp = new ligneproduit(x,idproduit1,quantite1);
////                    if(x!=0) //aandou panier el x
////                    {
////                        if(ps.rechercherproduit(idproduit1))
////                                {
////                        lps.ajouterauligneproduit(lp);
////                        Alert alert = new Alert(AlertType.INFORMATION);
////                        alert.setTitle("Information");
////                        alert.setHeaderText("votre produit a été ajouté à votre panier");
////                        alert.setContentText("produit ajouté avec succes ");
////
////                        alert.showAndWait();
////                        
////                    }
////                        else
////                        {
////                            Alert alert = new Alert(AlertType.ERROR);
////                        alert.setTitle("Information");
////                        alert.setHeaderText("nooooo");
////                        alert.setContentText("noooooo ");
////                        alert.showAndWait();
////                                
////                                }
////                    }
////                    else 
////                    {
////                        if(ps.rechercherproduit(idproduit1)){
////                        panierservice pas= new panierservice();
////                        panier p = new panier(idutilisateur,0);
////                        pas.ajouterAlaBase2(p);
////                        int y=ps.rechercherutilisateur(idutilisateur);
////                        ligneproduit lp1 = new ligneproduit(y,idproduit1,quantite1);
////                        lps.ajouterauligneproduit(lp1);
////                        
////                        Alert alert = new Alert(AlertType.INFORMATION);
////                        alert.setTitle("Information");
////                        alert.setHeaderText("votre produit a été ajouté dans votre nouveau panier");
////                        alert.setContentText("produit ajouté avec succes");
////
////                        alert.showAndWait();
////                         
////                        }
////                        else 
////                        {
////                             Alert alert = new Alert(AlertType.ERROR);
////                        alert.setTitle("Information");
////                        alert.setHeaderText("nooooo");
////                        alert.setContentText("noooooo ");
////                        alert.showAndWait();
////                            
////                        }
////                        
////                    
////     }}

    public ObservableList<Promotion> loadPromotion() throws SQLException {
        //list.setItems(items);
//        Statement stm = cnx.createStatement();
//        String req = "SELECT id FROM `fos_user` WHERE `enabled`=1 and `roles`=\"client\"";
//        ResultSet res = stm.executeQuery(req);
//        int id_user = res.getInt(1);
        PreparedStatement pt = cnx.prepareStatement("SELECT * from promotion");
        ResultSet resultat = pt.executeQuery();
        while (resultat.next()) {
            String desc = resultat.getString("description");
            float pour = resultat.getFloat("pourcentage");
            //  items.add("Prix:   " + Float.toString(prix));
            Date date = resultat.getDate("date_promo");
            int idpromo = resultat.getInt("id_promo");
            int id = resultat.getInt("id_prod");
            Promotion p = new Promotion(idpromo, pour, desc, date, id);
            items.add(p);
        }
        return items;
    }

    public String SelectProduit(int idpro) throws SQLException {
        String nom = "";
        String r = "select produit.nom_prod from `produit`,`promotion`  where promotion.id_prod=? and promotion.id_prod=produit.id_prod";
        PreparedStatement pst = cnx.prepareStatement(r);
        pst.setInt(1, idpro);
        ResultSet res = pst.executeQuery();

        while (res.next()) {

            nom = res.getString("nom_prod");

        }
        return nom;
    }

    public void supprimerPromotion(int idpromo) {
        try {

            Statement stm = cnx.createStatement();

            String req = "DELETE FROM `promotion` WHERE `id_promo`= '" + idpromo + "' ";
            stm.executeUpdate(req);
            System.out.println("suppression done");
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Suppression");
            alert.setHeaderText("Votre promotion a été bien supprimée");
            alert.setContentText("Promotion supprimée avec succés ");

            alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ajouterPromotion(Promotion p) {
        try {

            PreparedStatement pst = cnx.prepareStatement("INSERT INTO `promotion`( `pourcentage`, `date_promo`, `description`, `id_prod`) VALUES (?,?,?,?)");
            pst.setFloat(1,p.getPourcentage());
            pst.setDate(2, date);
            pst.setString(3,p.getDescription());
            pst.setInt(4,p.getIdprod());
            pst.executeUpdate();
            System.out.println("Insertion done");

        } catch (SQLException ex) {
            Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modifierPromotion(int idprod, float pour) {
        try {

            Statement stm = cnx.createStatement();

            String req = "UPDATE ligne_commande` SET `quantite`= '" + pour + "' WHERE `id_prod`= '" + idprod + "' ";
            stm.executeUpdate(req);
            System.out.println("Modification done");

        } catch (SQLException ex) {
            Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteAll() {
        try {

            Statement stm = cnx.createStatement();

            String req = "DELETE FROM `promotion` ";
            stm.executeUpdate(req);
            System.out.println("suppression done");
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Suppression");
            alert.setHeaderText("Liste de promotion a été bien supprimée");
            alert.setContentText("Promotion supprimée avec succés ");

            alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
