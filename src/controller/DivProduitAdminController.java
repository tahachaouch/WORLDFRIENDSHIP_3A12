package controller;

import entities.Produit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Meriem
 */
public class DivProduitAdminController implements Initializable {

    @FXML
    private AnchorPane ap;
    @FXML
    private Pane sq;
    @FXML
    private Label txtitre;
    @FXML
    private Label txtprix;
    @FXML
    private Label id;
    @FXML
    private Rectangle rectangle;

    public void LoadValues(Produit e) throws IOException {
        txtitre.setText(e.getNom_prod());
        txtprix.setText(String.valueOf(e.getPrix()));
        id.setText(String.valueOf(e.getId_prod()));

        Image imageURI2 = new Image("file:C://wamp64/www/Images/" + e.getImage());
        rectangle.setFill(new ImagePattern(imageURI2));

        ap.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    try {
                        doubleclick(event, e);
                    } catch (SQLException ex) {
                        Logger.getLogger(DivProduitAdminController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

    }

    public void doubleclick(MouseEvent event, Produit selectedetab) throws SQLException {
        if (event.getClickCount() == 2) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/ShowProduitAdmin.fxml"));
                Parent root = loader.load();
                ShowProduitAdminController DDC = loader.getController();
                DDC.ShowArticle(selectedetab.getId_prod());

                // DDC.(selectedetab);
                //  DDC.selectedetab.getId());
                FXMLLoader loade = new FXMLLoader(getClass().getResource("/vue/HomePage.fxml"));
                Parent roo = loade.load();
                HomePageController Dhp = loade.getController();
                Stage ss = new Stage();
                Scene sc = new Scene(root);
                ss.setScene(sc);
                ss.setWidth(1288);
                ss.setHeight(750);
                ss.show();

            } catch (IOException ex) {
                Logger.getLogger(DivProduitAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
