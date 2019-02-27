package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import service.ProduitService;
import entities.Produit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author Meriem
 */
public class ShowProduitUserController implements Initializable {

    @FXML
    private AnchorPane tab;
    @FXML
    private Label txtitre;
//    @FXML
//    private Label txtqte;

    @FXML
    private JFXHamburger affmenu;
    @FXML
    private Rectangle txtimage;

    @FXML
    private JFXDrawer menu;
    @FXML
    private Label idd;
    @FXML
    private Label txtprix;
    @FXML
    private JFXButton add;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            AnchorPane anchrone = FXMLLoader.load(getClass().getResource("/vue/test.fxml"));
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
            Logger.getLogger(ShowProduitUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ShowArticle(int id) throws SQLException {
        ProduitService af = new ProduitService();
        Produit ar = af.afficherProduit().filtered(e -> e.getId_prod() == id).get(0);

        idd.setText(String.valueOf(ar.getId_prod()));
        txtitre.setText(ar.getNom_prod());
//        txtqte.setText(String.valueOf(ar.getQuantite()));
        txtprix.setText(String.valueOf(ar.getPrix()));

        Image imageURI2 = new Image("file:C://wamp64/www/Images/" + ar.getImage());
        txtimage.setFill(new ImagePattern(imageURI2));

    }

    @FXML
    private void ajouterAuPanier(MouseEvent event) {
    }

}
