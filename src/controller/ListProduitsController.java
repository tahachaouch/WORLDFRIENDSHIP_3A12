package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import service.ProduitService;
import com.jfoenix.controls.JFXCheckBox;
import controller.DivProduitController;
import entities.Produit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

public class ListProduitsController implements Initializable {

    @FXML
    private AnchorPane ap;
    @FXML
    private JFXTextField recherchetext;
    @FXML
    private ScrollPane pane;
    private JFXComboBox tri;

    private ObservableList<Produit> data;
    @FXML
    private JFXHamburger affmenu;
    @FXML
    private JFXDrawer menu;
    @FXML
    private JFXCheckBox checkprix;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
            Logger.getLogger(ListProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            TilePane b = new TilePane();
            b.setPadding(new javafx.geometry.Insets(30));
            TilePane c = new TilePane();
            FadeTransition ft = new FadeTransition(Duration.millis(1500));

            ProduitService aff = new ProduitService();

            data = aff.afficherProduit();
            for (Produit d : data) {

                try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("DivProduit.fxml"));
                    Parent root = (Pane) loader.load();
                    DivProduitController DHC = loader.getController();
                    DHC.LoadValues(d);

                    //   c.setVgap(40);
                    c.getChildren().removeAll();

                    c.getChildren().add(root);
                } catch (IOException ex) {
                    Logger.getLogger(ListProduitsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            c.setPrefColumns(3);
            c.setPadding(new javafx.geometry.Insets(0));
            c.setHgap(10);
            c.setVgap(80);
            b.getChildren().add(c);
            b.setPrefWidth(1000);
            pane.setContent(b);

        } catch (SQLException ex) {
            Logger.getLogger(ListProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void RechercheDynamique(KeyEvent event) throws SQLException {
        ProduitService aff = new ProduitService();
        data = aff.afficherProduit();
        FilteredList<Produit> filteredData = new FilteredList<>(data, e -> true);
        recherchetext.setOnKeyReleased(e
                -> {
            recherchetext.textProperty().addListener((ObservableValue<? extends String> ObservableValue, String oldValue, String newValue) -> {
                filteredData.setPredicate((Predicate<? super Produit>) new Predicate<Produit>() {
                    @Override
                    public boolean test(Produit d) {
                        if (newValue == null || newValue.isEmpty()) {

                            return true;

                        }
                        String lowerCaseFilter = newValue.toLowerCase();
                        return d.getNom_prod().toLowerCase().contains(lowerCaseFilter.subSequence(0, lowerCaseFilter.length()));
                    }
                });
            });
            TilePane b = new TilePane();
            b.setPadding(new javafx.geometry.Insets(30));
            TilePane c = new TilePane();

            for (Produit d : filteredData) {

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("DivProduit.fxml"));
                    Parent root = (Pane) loader.load();
                    DivProduitController DHC = loader.getController();
                    DHC.LoadValues(d);

                    //   c.setVgap(40);
                    c.getChildren().removeAll();

                    c.getChildren().add(root);
                } catch (IOException ex) {
                    Logger.getLogger(ListProduitsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            c.setPrefColumns(3);
            c.setPadding(new javafx.geometry.Insets(0));
            c.setHgap(10);
            c.setVgap(80);
            b.getChildren().add(c);
            b.setPrefWidth(1000);
            pane.setContent(b);
        });
    }

    public void affichetriePrix() throws SQLException {

        ProduitService ps = new ProduitService();
        data = ps.triProduitByPrix();
        TilePane b = new TilePane();
        b.setPadding(new javafx.geometry.Insets(30));
        TilePane c = new TilePane();

        for (Produit d : data) {
            System.out.println(d.getPrix());

            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("DivProduit.fxml"));
                Parent root = (Pane) loader.load();
                DivProduitController DHC = loader.getController();

                DHC.LoadValues(d);

                //   c.setVgap(40);
                c.getChildren().removeAll();

                c.getChildren().add(root);
            } catch (IOException ex) {
                Logger.getLogger(ListProduitsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        c.setPrefColumns(3);
        c.setPadding(new javafx.geometry.Insets(0));
        c.setHgap(10);
        c.setVgap(80);
        b.getChildren().add(c);
        b.setPrefWidth(1000);
        pane.setContent(b);

    }

//
    @FXML
    private void triByPrix(MouseEvent event) throws SQLException {

        checkprix.setSelected(true);
//        checkprix.setDisable(true);

        affichetriePrix();

    }

}
