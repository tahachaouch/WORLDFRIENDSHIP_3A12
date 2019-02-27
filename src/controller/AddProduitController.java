package controller;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.auth.AuthMethod;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.sms.messages.TextMessage;
import service.ProduitService;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Produit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import org.apache.commons.lang3.RandomStringUtils;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class AddProduitController implements Initializable {

    @FXML
    private TextField txttitre;
    @FXML
    private JFXTextField txtqte;
    @FXML
    private JFXTextField txtprix;
    @FXML
    private FontAwesomeIconView image1;
    @FXML
    private ImageView pic1;
    @FXML
    private FontAwesomeIconView souscatw;
    @FXML
    private FontAwesomeIconView emailw;
    @FXML
    private FontAwesomeIconView libellew;
    @FXML
    private FontAwesomeIconView descriptionw;
    @FXML
    private JFXHamburger affmenu;
    @FXML
    private JFXDrawer menu;
    @FXML
    private JFXTextField txtcat;
    @FXML
    private Label labelquantite;
    @FXML
    private Label labelprix;
    @FXML
    private Label labeltitre;
    @FXML
    private Label labelcategorie;
    @FXML
    private Label labelimage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
            Logger.getLogger(AddProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static final String API_KEY = "1965da7c";
    public static final String API_SECRET = "ca454f2ad634ab36";

    public void sendsms(String titre_article) throws IOException, NexmoClientException {
        String tel = "+21650783037";
        AuthMethod auth = new TokenAuthMethod(API_KEY, API_SECRET);
        NexmoClient client = new NexmoClient(auth);
        client.getSmsClient().submitMessage(
                new TextMessage("E SHOP", tel, "Nouveau Article: " + titre_article));
    }

    @FXML
    private void ajouter(ActionEvent event) throws SQLException, IOException, NexmoClientException {
        if (txttitre.getText().equals("")) {
            labeltitre.setText("Veuillez insérer un nom");
        } else if (txtqte.getText().equals("")) {
            labelquantite.setText("Veuillez indiquer une quantité");
        } else if (Integer.parseInt(txtqte.getText()) <= 0) {
            labelquantite.setText("Veuillez indiquer une valeur positive");
        } else if (txtprix.getText().equals("")) {
            labelprix.setText("Veuillez choisir un prix");
        } else if (txtcat.getText().equals("")) {
            labelcategorie.setText("Veuillez choisir une catégorie");
        } else if (pic1.getImage() == null) {
            labelimage.setText("Veuillez choisir une image");
        } else {
            Image image1 = pic1.getImage();
            String nameImage1 = saveToFileImageNormal(image1);
            String titre_article = txttitre.getText();
            String quantite = txtqte.getText();
            int iqte = Integer.parseInt(quantite);
            String prix = txtprix.getText();
            float fprix = Float.parseFloat(prix);
            String categorie = txtcat.getText();
            Produit a = new Produit();
            a.setImage(nameImage1);
            a.setNom_prod(titre_article);
            a.setQuantite(iqte);
            a.setPrix(fprix);
            a.setCategorie(categorie);
            sendsms(titre_article);
            TrayNotification tray = new TrayNotification("Information", "Produit Ajouté", NotificationType.SUCCESS);
            tray.setAnimationType(AnimationType.POPUP);
            tray.showAndDismiss(Duration.seconds(3));
            ProduitService af = new ProduitService();
            af.ajouterProduit(a);
        }
    }

    public static String saveToFileImageNormal(Image image) {

        String ext = "jpg";
        File dir = new File("C:/wamp64/www/Images");
        String name = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(8), ext);
        File outputFile = new File(dir, name);
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        try {
            ImageIO.write(bImage, "png", outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return name;
    }

    @FXML
    private void addImage(MouseEvent event) throws IOException {
        FileChooser fc = new FileChooser();

        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (.png)", "*.PNG");
        fc.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        File selectedFile = fc.showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(selectedFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            pic1.setImage(image);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
