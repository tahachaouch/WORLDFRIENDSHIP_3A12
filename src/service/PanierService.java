/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;



import connexion.conDB;
import entities.Panier;
import entities.Produit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.HashMap;
import java.util.Map;
import java.util.Calendar;

/**
 *
 * @author karim
 */
public class PanierService {

    static Connection cnx;
    private ObservableList<Produit> items = FXCollections.observableArrayList();
    private ObservableList<Panier> commande = FXCollections.observableArrayList();
    java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

    
    public PanierService() throws SQLException {
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
   public int getPanier() throws SQLException
   {int panier=-1;
          PreparedStatement pt = cnx.prepareStatement("SELECT panier.id_panier from panier where etat=0 and panier.id_user=?");
        pt.setInt(1, 7218854);
        ResultSet resultat = pt.executeQuery();
        while (resultat.next()) {
            panier = resultat.getInt("id_panier");
   }
   return panier;}
    public void ajouterAuPanier() throws SQLException
    {
        if(getPanier()!=-1)
        {
            
        }
    }
            

    public ObservableList<Produit> loadPanier() throws SQLException {
        //list.setItems(items);
//        Statement stm = cnx.createStatement();
//        String req = "SELECT id FROM `fos_user` WHERE `enabled`=1 and `roles`=\"client\"";
//        ResultSet res = stm.executeQuery(req);
//        int id_user = res.getInt(1);
        PreparedStatement pt = cnx.prepareStatement("SELECT produit.id_prod, produit.nom_prod,produit.prix,panier.date_ajout,ligne_commande.quantite FROM `ligne_commande` ,`produit` ,`panier` WHERE panier.id_panier IN (select id_panier from panier where id_user=?)and panier.id_panier=ligne_commande.id_panier and produit.id_prod=ligne_commande.id_prod and panier.etat=?");
        pt.setInt(1, 7218854);
        pt.setInt(2, 0);
        ResultSet resultat = pt.executeQuery();
        while (resultat.next()) {
            String nom = resultat.getString("nom_prod");
            float prix = resultat.getFloat("prix");
            //  items.add("Prix:   " + Float.toString(prix));
            // Date date = resultat.getDate("date_ajout");
            int quantite = resultat.getInt("quantite");
            int id = resultat.getInt("id_prod");
            Produit p = new Produit(id, nom, quantite, prix);
            items.add(p);
        }
        return items;
    }

    public ObservableList<Panier> loadCommande() throws SQLException {
        //list.setItems(items);
//        Statement stm = cnx.createStatement();
//        String req = "SELECT id FROM `fos_user` WHERE `enabled`=1 and `roles`=\"client\"";
//        ResultSet res = stm.executeQuery(req);
//        int id_user = res.getInt(1);
        PreparedStatement pt = cnx.prepareStatement("SELECT panier.id_panier,panier.date_ajout,fos_user.username from panier,fos_user where etat=? and fos_user.id=panier.id_user");
        // pt.setInt(1, 7218854);
        pt.setInt(1, 1);
        ResultSet resultat = pt.executeQuery();
        while (resultat.next()) {
            int id = resultat.getInt("id_panier");
            String nom = resultat.getString("username");
            //  items.add("Prix:   " + Float.toString(prix));
            Date date = resultat.getDate("date_ajout");
            //  Float total=getPrixTotal();

            Panier p = new Panier(id, date, nom);
            commande.add(p);
        }
        return commande;
    }

    public ObservableList<Produit> loadCommandeProduit(int panier) throws SQLException {
        //list.setItems(items);
//        Statement stm = cnx.createStatement();
//        String req = "SELECT id FROM `fos_user` WHERE `enabled`=1 and `roles`=\"client\"";
//        ResultSet res = stm.executeQuery(req);
//        int id_user = res.getInt(1);
        PreparedStatement pt = cnx.prepareStatement("SELECT produit.id_prod, produit.nom_prod,produit.prix,ligne_commande.quantite FROM `ligne_commande` ,`produit` ,`panier` WHERE panier.id_panier=? and panier.id_panier=ligne_commande.id_panier and produit.id_prod=ligne_commande.id_prod");
        pt.setInt(1, panier);
        ResultSet resultat = pt.executeQuery();
        while (resultat.next()) {
            String nom = resultat.getString("nom_prod");
            float prix = resultat.getFloat("prix");
            //  items.add("Prix:   " + Float.toString(prix));
            // Date date = resultat.getDate("date_ajout");
            int quantite = resultat.getInt("quantite");
            int id = resultat.getInt("id_prod");
            Produit p = new Produit(id, nom, quantite, prix);
            items.add(p);
        }
        return items;
    }

    public int SelectPanierUser() throws SQLException {
        // lc.ajouterLigne(prod, p);
        // this.ajouterCommande(p, u);
        int id = 7218854;
        int id_panier = 0;
        String r = "select id_panier from `panier` where id_user=?";
        PreparedStatement pst = cnx.prepareStatement(r);
        pst.setInt(1, id);
        ResultSet res = pst.executeQuery();

        while (res.next()) {

            id_panier = res.getInt("id_panier");

        }
        return id_panier;
    }

    public void supprimerProduit(int idprod) {
        try {

            int id_pa = SelectPanierUser();
            Statement stm = cnx.createStatement();

            String req = "DELETE FROM `ligne_commande` WHERE `id_prod`= '" + idprod + "' and `id_panier`= '" + id_pa + "' ";
            stm.executeUpdate(req);
            System.out.println("suppression done");
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Suppression");
            alert.setHeaderText("votre produit a été supprimé de votre panier");
            alert.setContentText("produit supprimé avec succés ");

            alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modifierProduit(int idprod, int q) {
        try {

            int id_pa = SelectPanierUser();
            Statement stm = cnx.createStatement();

            String req = "UPDATE `ligne_commande` SET `quantite`= '" + q + "' WHERE `id_prod`= '" + idprod + "' and `id_panier`= '" + id_pa + "' ";
            stm.executeUpdate(req);
            System.out.println("Modification done");

        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObservableList<Produit> triPanierByPrix() throws SQLException {
        //list.setItems(items);
//        Statement stm = cnx.createStatement();
//        String req = "SELECT id FROM `fos_user` WHERE `enabled`=1 and `roles`=\"client\"";
//        ResultSet res = stm.executeQuery(req);
//        int id_user = res.getInt(1);
        PreparedStatement pt = cnx.prepareStatement("SELECT produit.id_prod, produit.nom_prod,produit.prix,panier.date_ajout,ligne_commande.quantite FROM `ligne_commande` ,`produit` ,`panier` WHERE panier.id_panier IN (select id_panier from panier where id_user=?)and panier.id_panier=ligne_commande.id_panier and produit.id_prod=ligne_commande.id_prod and panier.etat=? order by produit.prix");
        pt.setInt(1, 7218854);
        pt.setInt(2, 0);
        ResultSet resultat = pt.executeQuery();
        while (resultat.next()) {
            String nom = resultat.getString("nom_prod");
            float prix = resultat.getFloat("prix");
            //  items.add("Prix:   " + Float.toString(prix));
            // Date date = resultat.getDate("date_ajout");
            int quantite = resultat.getInt("quantite");
            int id = resultat.getInt("id_prod");
            Produit p = new Produit(id, nom, quantite, prix);
            items.add(p);
        }
        return items;
    }

    public ObservableList<Produit> triPanierByNom() throws SQLException {
        //list.setItems(items);
//        Statement stm = cnx.createStatement();
//        String req = "SELECT id FROM `fos_user` WHERE `enabled`=1 and `roles`=\"client\"";
//        ResultSet res = stm.executeQuery(req);
//        int id_user = res.getInt(1);
        PreparedStatement pt = cnx.prepareStatement("SELECT produit.id_prod, produit.nom_prod,produit.prix,panier.date_ajout,ligne_commande.quantite FROM `ligne_commande` ,`produit` ,`panier` WHERE panier.id_panier IN (select id_panier from panier where id_user=?)and panier.id_panier=ligne_commande.id_panier and produit.id_prod=ligne_commande.id_prod and panier.etat=? order by produit.nom_prod ");
        pt.setInt(1, 7218854);
        pt.setInt(2, 0);
        ResultSet resultat = pt.executeQuery();
        while (resultat.next()) {
            String nom = resultat.getString("nom_prod");
            float prix = resultat.getFloat("prix");
            //  items.add("Prix:   " + Float.toString(prix));
            // Date date = resultat.getDate("date_ajout");
            int quantite = resultat.getInt("quantite");
            int id = resultat.getInt("id_prod");
            Produit p = new Produit(id, nom, quantite, prix);
            items.add(p);
        }
        return items;
    }

    public float getprixtotale() throws SQLException {
        int id = 7218854;
        PreparedStatement pt = cnx.prepareStatement("SELECT produit.prix,ligne_commande.quantite FROM `ligne_commande` ,`produit` ,`panier` WHERE panier.id_panier IN (select id_panier from panier where id_user=?)and panier.id_panier=ligne_commande.id_panier and produit.id_prod=ligne_commande.id_prod and panier.etat=0");
        pt.setInt(1, id);
        ResultSet resultat = pt.executeQuery();
        float prixtotale = 0;
        while (resultat.next()) {
            float prix = resultat.getFloat("prix");
            int quantite = resultat.getInt("quantite");
            prixtotale += quantite * prix;
        }
        return prixtotale;

    }
//      public float getprixPromo() throws SQLException {
//        int id = 7218854;
//        float prix=getprixtotale();
//        PreparedStatement pt = cnx.prepareStatement("SELECT pourcentage from promotion where ");
//        pt.setInt(1, id);
//        ResultSet resultat = pt.executeQuery();
//        float prixtotale = 0;
//        while (resultat.next()) {
//            float prix = resultat.getFloat("prix");
//            int quantite = resultat.getInt("quantite");
//            prixtotale += quantite * prix;
//        }
//        return prixtotale;
//
//    }

    public void supprimerLigne(int id_panier) throws SQLException {
        Statement stm = cnx.createStatement();

        String req = "DELETE FROM `ligne_commande` WHERE `id_panier`= '" + id_panier + "' ";
        stm.executeUpdate(req);
        System.out.println("suppression ligne done");

    }

    public void supprimerAllLigne() throws SQLException {
        Statement stm = cnx.createStatement();

        String req = "DELETE FROM `ligne_commande` WHERE `id_panier` IN (select id_panier from panier where etat=1)";
        stm.executeUpdate(req);
        System.out.println("suppression All ligne done");

    }

    public void supprimerCommande(int id_panier) throws SQLException {
        Statement stm = cnx.createStatement();

        String req = "DELETE FROM `panier` WHERE `id_panier`= '" + id_panier + "' ";
        stm.executeUpdate(req);
        supprimerLigne(id_panier);
        System.out.println("suppression commande done");
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Suppression");
        alert.setHeaderText("La commande a été bien supprimée");
        alert.setContentText("Commande supprimée avec succés ");

        alert.showAndWait();
    }

    public void supprimerAllCommande() throws SQLException {
        supprimerAllLigne();
        Statement stm = cnx.createStatement();

        String req = "DELETE FROM `panier` WHERE etat=1 ";
        stm.executeUpdate(req);

        System.out.println("suppression commande done");
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Suppression");
        alert.setHeaderText("La liste des commandes a été bien supprimée");
        alert.setContentText("Commande supprimée avec succés ");

        alert.showAndWait();
    }

    public ObservableList<Panier> triCommande() throws SQLException {
        //list.setItems(items);
//        Statement stm = cnx.createStatement();
//        String req = "SELECT id FROM `fos_user` WHERE `enabled`=1 and `roles`=\"client\"";
//        ResultSet res = stm.executeQuery(req);
//        int id_user = res.getInt(1);
        PreparedStatement pt = cnx.prepareStatement("SELECT panier.id_panier,panier.date_ajout,fos_user.username from panier,fos_user where etat=? and fos_user.id=panier.id_user order by panier.date_ajout DESC");
        // pt.setInt(1, 7218854);
        pt.setInt(1, 1);
        ResultSet resultat = pt.executeQuery();
        while (resultat.next()) {
            int id = resultat.getInt("id_panier");
            String nom = resultat.getString("username");
            //  items.add("Prix:   " + Float.toString(prix));
            Date date = resultat.getDate("date_ajout");
            //  Float total=getPrixTotal();

            Panier p = new Panier(id, date, nom);
            commande.add(p);
        }
        return commande;
    }

    public Panier getCommande() throws SQLException {
        //list.setItems(items);
//        Statement stm = cnx.createStatement();
//        String req = "SELECT id FROM `fos_user` WHERE `enabled`=1 and `roles`=\"client\"";
//        ResultSet res = stm.executeQuery(req);
//        int id_user = res.getInt(1);
        int id = 7218854;
        String nom = getNomUser(id);
        PreparedStatement pt = cnx.prepareStatement("SELECT `id_panier`, `date_ajout`, `id_user` FROM `panier` WHERE etat=0 and id_user=?");
        pt.setInt(1, id);
        // pt.setInt(1, 1);
        Panier p = new Panier();
        ResultSet resultat = pt.executeQuery();
        while (resultat.next()) {
            int id_panier = resultat.getInt("id_panier");
            p.setId_panier(id_panier);
            int id_user = resultat.getInt("id_user");

            // String nom = resultat.getString("username");
            //  items.add("Prix:   " + Float.toString(prix));
            Date date = resultat.getDate("date_ajout");
            p.setDate_ajout(date);
            //  Float total=getPrixTotal();

            // commande.add(p);
        }
        return p;
    }
       public int getNumberCommande() throws SQLException {
        //list.setItems(items);
//        Statement stm = cnx.createStatement();
//        String req = "SELECT id FROM `fos_user` WHERE `enabled`=1 and `roles`=\"client\"";
//        ResultSet res = stm.executeQuery(req);
//        int id_user = res.getInt(1);
        int id = 7218854;
        String nom = getNomUser(id);
        PreparedStatement pt = cnx.prepareStatement("SELECT count(`id_panier`) FROM `panier` WHERE etat=0 and id_user=?");
        pt.setInt(1, id);
        int number=0;
        ResultSet resultat = pt.executeQuery();
        while (resultat.next()) {
            number = resultat.getInt(1);
         
            //  Float total=getPrixTotal();

            // commande.add(p);
        }
        return number;
    }

    public String getNomUser(int id_user) throws SQLException {
        //list.setItems(items);
//        Statement stm = cnx.createStatement();
//        String req = "SELECT id FROM `fos_user` WHERE `enabled`=1 and `roles`=\"client\"";
//        ResultSet res = stm.executeQuery(req);
//        int id_user = res.getInt(1);
        String nom = "";
        PreparedStatement pt = cnx.prepareStatement("SELECT username FROM `fos_user` WHERE id=?");
        pt.setInt(1, id_user);
        ResultSet resultat = pt.executeQuery();
        while (resultat.next()) {
            nom = resultat.getString("username");

        }
        return nom;
    }

    public void confirmerCommande() throws SQLException {
        Panier p = getCommande();
        PreparedStatement pt = cnx.prepareStatement("UPDATE `panier` SET `etat`=1,`date_ajout`=? WHERE `id_panier`=?");
        pt.setDate(1,date);
        pt.setInt(2, p.getId_panier());
        pt.executeUpdate();

    }
    
    public String getPass() throws SQLException
    {int id_user=2;
          String pass = "";
        PreparedStatement pt = cnx.prepareStatement("SELECT `password` FROM `fos_user` WHERE `id`=?");
        pt.setInt(1, id_user);
        ResultSet resultat = pt.executeQuery();
        while (resultat.next()) {
            pass= resultat.getString("password");

        }
        return pass;
        
    }
}
