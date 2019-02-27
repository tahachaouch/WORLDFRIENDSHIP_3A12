package entities;

/**
 *
 * @author HP
 */
public class Produit {

    private int id_prod;
    private String nom_prod;
    private int quantite;
    private float prix;
    private String image;
    private String categorie;

    public Produit(int id_prod, String nom_prod, String image, int quantite, float prix, String categorie) {
        this.id_prod = id_prod;
        this.nom_prod = nom_prod;
        this.image = image;
        this.quantite = quantite;
        this.prix = prix;
        this.categorie = categorie;
    }
     public Produit(int id_prod, String nom_prod, String image, float prix) {
        this.id_prod = id_prod;
        this.nom_prod = nom_prod;
        this.image = image;
        this.quantite = quantite;
        this.prix = prix;
        this.categorie = categorie;
    }


    public Produit(String nom_prod, String image, int quantite, float prix, String categorie) {
        this.nom_prod = nom_prod;
        this.image = image;
        this.quantite = quantite;
        this.prix = prix;
        this.categorie = categorie;
    }

    public Produit() {
    }

    public Produit(int id_prod, String nom_prod, int quantite, float prix) {
        this.id_prod = id_prod;
        this.nom_prod = nom_prod;
        this.quantite = quantite;
        this.prix = prix;
    }

    public Produit(String nom_prod, int quantite) {
        this.nom_prod = nom_prod;
        this.quantite = quantite;
    }

    public Produit(String nom_prod, int quantite, float prix) {
        this.nom_prod = nom_prod;
        this.quantite = quantite;
        this.prix = prix;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getImage() {
        return image;
    }

    public String getCategorie() {
        return categorie;
    }

    public int getId_prod() {
        return id_prod;
    }

    public String getNom_prod() {
        return nom_prod;
    }

    public int getQuantite() {
        return quantite;
    }

    public float getPrix() {
        return prix;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public void setNom_prod(String nom_prod) {
        this.nom_prod = nom_prod;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
    String Newligne = System.getProperty("line.separator");

    @Override
    public String toString() {
        return "Nom= "
                + "" + nom_prod + Newligne
                + " Quantité= "
                + "" + quantite + Newligne
                + " Prix=  "
                + "" + prix;
    }

}
