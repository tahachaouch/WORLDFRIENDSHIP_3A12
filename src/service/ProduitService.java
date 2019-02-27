package service;

import entities.Produit;
import connexion.conDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class ProduitService {

    static Connection cnx;
    private ObservableList<Produit> items = FXCollections.observableArrayList();

    public ProduitService() throws SQLException {
        cnx = conDB.getInstance().getCnx();
    }

    public static int ajouterProduit(Produit p) throws SQLException {
        int a = 0;
        String requete = "INSERT INTO `produit`(`nom_prod`, `image`, `quantite`, `prix`, `categorie`) VALUES (?,?,?,?,?)";
        PreparedStatement st = cnx.prepareStatement(requete);
        st.setString(1, p.getNom_prod());
        st.setString(2, p.getImage());
        st.setInt(3, p.getQuantite());
        st.setFloat(4, p.getPrix());
        st.setString(5, p.getCategorie());
        st.executeUpdate();
        System.out.println("Article ajouté");
        a = 1;

        return a;
    }

    public ObservableList<Produit> afficherProduit() throws SQLException {

        ObservableList<Produit> myList = FXCollections.observableArrayList();
        Statement st = cnx.createStatement();
        String requete = "SELECT * from produit";
        ResultSet rs = st.executeQuery(requete);
        while (rs.next()) {
            int id_prod = rs.getInt("id_prod");
            String nom_prod = rs.getString("nom_prod");
            String image = rs.getString("image");
            int quantite = rs.getInt("quantite");
            float prix = rs.getFloat("prix");
            String categorie = rs.getString("categorie");
            myList.add(new Produit(id_prod, nom_prod, image, quantite, prix, categorie));

        }
        return myList;
    }

    public static int update(Produit p) throws SQLException {
        int st = 0;
        try {
            String req = "UPDATE produit SET nom_prod=?,quantite=? ,prix=?, categorie=? WHERE id_prod= ?";
            Connection cnx = conDB.getInstance().getCnx();
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, p.getNom_prod());
            pst.setInt(2, p.getQuantite());
            pst.setFloat(3, p.getPrix());
            pst.setString(4, p.getCategorie());
            pst.setInt(5, p.getId_prod());

            pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return st;
    }

    public static int delete(int id_prod) throws SQLException {
        int st = 0;
        try {
            String req = "DELETE FROM produit WHERE id_prod= ?";
            Connection cnx = conDB.getInstance().getCnx();
            PreparedStatement pstm = cnx.prepareStatement(req);
            pstm.setInt(1, id_prod);
            st = pstm.executeUpdate();
//            cnx.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return st;
    }

    public Produit getelement(String id) throws SQLException {
        Produit a = new Produit();
        Statement st = cnx.createStatement();
        String requete = "SELECT * FROM produit where id_prod = '" + id + "' ";
        ResultSet rs = st.executeQuery(requete);
        while (rs.next()) {
            int id_prod = rs.getInt("id_prod");
            String nom_prod = rs.getString("nom_prod");
            String image = rs.getString("image");
            int quantite = rs.getInt("quantite");
            float prix = rs.getFloat("prix");
            String categorie = rs.getString("categorie");
            a = new Produit(id_prod, nom_prod, image, quantite, prix, categorie);
        }
        return a;
    }

   

    public ResultSet buildDatapro() {
        ResultSet rs = null;

        try {

            String SQL = "SELECT categorie as t  , COUNT(categorie) FROM produit group by categorie ";
            PreparedStatement ps;
            ps = cnx.prepareStatement(SQL);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {

            System.out.println("Error on DB connection");
            System.out.println(e.getMessage());

        }
        return rs;
    }

    public ObservableList<Produit> triProduitByPrix() throws SQLException {

        PreparedStatement pt = cnx.prepareStatement("SELECT id_prod ,nom_prod , prix , image from produit ORDER BY prix");
        ResultSet resultat = pt.executeQuery();
        while (resultat.next()) {
            int id_prod = resultat.getInt("id_prod");
            String nom_prod = resultat.getString("nom_prod");
            String image = resultat.getString("image");
            float prix = resultat.getFloat("prix");

            Produit p = new Produit(id_prod, nom_prod, image, prix);
            items.add(p);
        }
        return items;
    }

}
