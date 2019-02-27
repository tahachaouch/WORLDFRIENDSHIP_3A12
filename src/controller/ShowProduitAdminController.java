package controller;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.nexmo.client.NexmoClientException;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import service.ProduitService;
import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Produit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Meriem
 */
public class ShowProduitAdminController implements Initializable {

    @FXML
    private AnchorPane tab;
    @FXML
    private JFXTextField txtitre;
    @FXML
    private JFXTextField txtqte;
    @FXML
    private JFXHamburger affmenu;
    @FXML
    private Rectangle txtimage;
    @FXML
    private JFXDrawer menu;
    @FXML
    private Label idd;

    @FXML
    private JFXTextField txtcat;
    @FXML
    private JFXTextField txtprix;
    @FXML
    private JFXButton btnmodif;
    @FXML
    private JFXButton btnsupp;
    @FXML
    private FontAwesomeIconView trash;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            AnchorPane anchrone = FXMLLoader.load(getClass().getResource("/vue/MenuAdmin.fxml"));
            menu.setSidePane(anchrone);

            HamburgerBackArrowBasicTransition burgerTask2 = new HamburgerBackArrowBasicTransition(affmenu);
            burgerTask2.setRate(-1);

            affmenu.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
                burgerTask2.setRate(burgerTask2.getRate() * -1);
                burgerTask2.play();

                if (menu.isShown()) {
                    menu.close();
                } else {
                    menu.open();
                    menu.toFront();
                }
            }
            );

        } catch (IOException ex) {
            Logger.getLogger(ShowProduitAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ShowArticle(int id) throws SQLException {
        ProduitService af = new ProduitService();
        Produit ar = af.afficherProduit().filtered(e -> e.getId_prod() == id).get(0);

        idd.setText(String.valueOf(ar.getId_prod()));
        txtitre.setText(ar.getNom_prod());
        txtprix.setText(String.valueOf(ar.getPrix()));
        txtqte.setText(String.valueOf(ar.getQuantite()));
        txtcat.setText(ar.getCategorie());

        Image imageURI2 = new Image("file:C://wamp64/www/Images/" + ar.getImage());
        txtimage.setFill(new ImagePattern(imageURI2));
    }

    @FXML
    private void modifier(ActionEvent event) throws SQLException, IOException, NexmoClientException {
////         Image image1 = txtimage.getImage();
////         String nameImage1 = saveToFileImageNormal(image1);

        String titre_article = txtitre.getText();
        String quantite = txtqte.getText();
        int iqte = Integer.parseInt(quantite);
        String prix = txtprix.getText();
        float fprix = Float.parseFloat(prix);
        String categorie = txtcat.getText();
        String id = idd.getText();
        int idp = Integer.parseInt(id);

        Produit a = new Produit();
//         a.setImage(nameImage1);
        a.setId_prod(idp);
        a.setNom_prod(titre_article);
        a.setQuantite(iqte);
        a.setPrix(fprix);
        a.setCategorie(categorie);
        //sendsms(titre_article);
        TrayNotification tray = new TrayNotification("Information", "Produit Modifié", NotificationType.SUCCESS);
        tray.setAnimationType(AnimationType.POPUP);
        tray.showAndDismiss(Duration.seconds(3));
        ProduitService af = new ProduitService();
        af.update(a);
        Stage stage = (Stage) btnmodif.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void supprimer(ActionEvent e) throws IOException, ParseException, SQLException {
        String sid = idd.getText();
        int id = Integer.parseInt(sid);
        ProduitService af = new ProduitService();
        af.delete(id);
        TrayNotification tray = new TrayNotification("Information", "Produit Supprimé", NotificationType.SUCCESS);
        tray.setAnimationType(AnimationType.POPUP);
        tray.showAndDismiss(Duration.seconds(3));
        Stage stage = (Stage) btnsupp.getScene().getWindow();
        stage.close();
    }
}
