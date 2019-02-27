package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GestionUtilisateurController implements Initializable {

    @FXML
    private Button guser;
    @FXML
    private Label users;
    @FXML
    private Button gArticle;
    @FXML
    private Button gevent;
    @FXML
    private Button gProduit;
    @FXML
    private Button gcommande;
    @FXML
    private Button gLivraison;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void GestionUser(ActionEvent event) {
    }

    @FXML
    private void GestionArticle(ActionEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/ListArticleAminDelete.fxml"));
//                Parent root = loader.load();
    }

    @FXML
    private void GestionEvenement(ActionEvent event) {
    }

    @FXML
    private void GestionProduit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/vue/ListProduitsAdmin.fxml"));
        gcommande.getScene().setRoot(root);
    }

    @FXML
    private void GestionCommandes(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("/vue/Commande.fxml"));
        gcommande.getScene().setRoot(root);
    }

    @FXML
    private void GestionLivraison(ActionEvent event) {
    }

}
