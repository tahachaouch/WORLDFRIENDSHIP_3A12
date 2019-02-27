/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import controller.AffichageAjout;
import controller.GestionCommentaire;
import controller.Partage;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Article;
import entities.CommentaireARTICLE;
import entities.LikeArticle;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import net.glxn.qrgen.QRCode;

import net.glxn.qrgen.image.ImageType;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ShowArticleController implements Initializable {
 private ObservableList<Article> myList;
  private ObservableList<CommentaireARTICLE> listReview;
 
public static int i;
    @FXML
    private Label txtcree;
    private Label txttitre;
 @FXML
    private Label txtblog;
    @FXML
    private Label txttags;
    @FXML
    private JFXButton rjaime;
    private ImageView txtimg;
    @FXML
    private JFXHamburger affmenu;
    @FXML
    private Rectangle txtimage;
    @FXML
    private Label txtitre;
    @FXML
    private JFXDrawer menu;
     
  
     Article arti;
    static Connection cnx;
    @FXML
    private AnchorPane tab;
    @FXML
    private Label idd;
    @FXML
    private FontAwesomeIconView trash1;
    @FXML
    private FontAwesomeIconView trash;
    @FXML
    private Button AddCommentaire;
    @FXML
    private JFXTabPane tabpane;
    @FXML
    private Tab tabA;
    @FXML
    private Tab tabC;
    @FXML
    private JFXTextArea commentaire;
    Article newArticle;
    @FXML
    private ScrollPane comments;
    @FXML
    private Button fcb;
    @FXML
    private JFXButton rjaime1;
    @FXML
    private ImageView QRImage;
    

       
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
         Logger.getLogger(ShowArticleController.class.getName()).log(Level.SEVERE, null, ex);
     }
    }    

    @FXML
    private void DeleteArticle(MouseEvent event) throws SQLException {
     
     
 AffichageAjout af=new AffichageAjout();
 af.delete(idd.getText());
     TrayNotification tray= new TrayNotification("Information","Article Supprimé", NotificationType.SUCCESS);
tray.setAnimationType(AnimationType.POPUP);
tray.showAndDismiss(Duration.seconds(3));
 Stage stage = (Stage) trash.getScene().getWindow();
     
        stage.close();
    }


   
 public void ShowArticle(int id) throws SQLException {
     rjaime.setOnMouseClicked((event) -> {
           
            try {
                
                rjaime.setVisible(false);
                rjaime1.setVisible(true);
                AffichageAjout es=new AffichageAjout();
                
                LikeArticle lr=new LikeArticle();
                Article e=new Article();
                lr.setId_article(e);
                // lr.setIduser(worldfriendship.Views.FirstFrame.user);
                try {
                    es.AjouterLike(lr,1,Integer.parseInt(idd.getText()));
                } catch (SQLException ex) {
                    Logger.getLogger(ShowArticleController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ShowArticleController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
       });
      rjaime1.setOnMouseClicked((event) -> {
           try {
               AffichageAjout es=new AffichageAjout();
               Article e=new Article();
               try {
                   es.EffacerLike(1, e.getId()); ///sesssion
                   rjaime.setVisible(true);
                   rjaime1.setVisible(false);
               } catch (SQLException ex) {
                   Logger.getLogger(ShowArticleController.class.getName()).log(Level.SEVERE, null, ex);
               }
               
           } catch (SQLException ex) {
                Logger.getLogger(ShowArticleController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
      });
     ///////////////////////////////////////////////////////////////////////
     tabpane.getSelectionModel().select(tabA);
     
     AffichageAjout af= new AffichageAjout();
     newArticle = new Article();
 newArticle = af.afficherService().filtered(e -> e.getId() == id).get(0);

      
         idd.setText(String.valueOf(newArticle.getId()));
        txtitre.setText(newArticle.getTitre_article());
        txtblog.setText(newArticle.getBlog());
        txttags.setText(newArticle.getTags());
      Image imageURI2 = new Image("file:C://wamp64/www/Images/" + newArticle.getImage());
        txtimage.setFill(new ImagePattern(imageURI2));
         DateFormat df1 = new SimpleDateFormat("MM/dd/yyyy");
       txtcree.setText(String.valueOf(df1.format(newArticle.getCree())));
       Reviewslist(newArticle);

     
       arti=newArticle;
       /////////////////test like 
       
 try {
            AffichageAjout s=new AffichageAjout();
            //s.testlike(1,Integer.parseInt(idd.getText()));
            boolean b ;
            int m;
                        System.out.println("ssssssssssssss"+idd.getText());

            m=Integer.parseInt(idd.getText());
            b=s.testlike(1,m);
            System.out.println(b);
            if (b==true)
            {
              rjaime.setVisible(false);
              rjaime1.setVisible(true);  
            }
            else{
                rjaime1.setVisible(false);
                rjaime.setVisible(true);
            }
                    } catch (SQLException ex) {
            Logger.getLogger(ShowArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }

     try {
         QRCode();
     } catch (IOException ex) {
         Logger.getLogger(ShowArticleController.class.getName()).log(Level.SEVERE, null, ex);
     } catch (WriterException ex) {
         Logger.getLogger(ShowArticleController.class.getName()).log(Level.SEVERE, null, ex);
     }
}//////////////////////////////////////////////////////

    @FXML
    private void EditArticle(MouseEvent event) throws SQLException, IOException {
          //   Parent root = FXMLLoader.load(getClass().getResource("/vue/EditArticle.fxml"));
 //    trash1.getScene().setRoot(root);
       
                     AffichageAjout af= new AffichageAjout();

                     Article s = af.afficherService().filtered(a -> a.getId() == Integer.parseInt(idd.getText())).get(0);
                     FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/EditArticle.fxml"));
                        AnchorPane an = new AnchorPane();
                        an = (AnchorPane) loader.load();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(an));
                        EditArticleController ds = loader.getController();
                        ds.oldValues(s.getId());
                        stage.show();
                    } 
////////////////////////////////////// Commentaire
    public void Reviewslist(Article e) throws SQLException{
         TilePane b = new TilePane();
        tabpane.getSelectionModel().select(tabC);
        b.setPadding(new javafx.geometry.Insets(30));
        TilePane c = new TilePane();

        GestionCommentaire gr = new GestionCommentaire();
        listReview = gr.ListReviews(e);
        
        for (CommentaireARTICLE d : listReview) {

            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/DivComment.fxml"));
                Parent root = (Pane) loader.load();
                DivCommentController DHC = loader.getController();
                DHC.LoadValues(d,e);

                //   c.setVgap(40);
                c.getChildren().removeAll();

                c.getChildren().add(root);
            } catch (IOException ex) {
                Logger.getLogger(ShowArticleController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        c.setPrefColumns(1);
        c.setPadding(new javafx.geometry.Insets(0));
        c.setHgap(25);
        c.setVgap(50);
        b.getChildren().add(c);
        b.setPrefWidth(1000);
      comments.setContent(b);
      //  scroll.getChildren().add(b);
        

    }

    
    
    
    
    
    
  ////////////////////////////////////////////////////////////////////////// end  
    @FXML
    private void AddCommentaire(ActionEvent event) throws SQLException {
        GestionCommentaire greviews = new GestionCommentaire();
        CommentaireARTICLE r = new CommentaireARTICLE();
        r.setCommentaire(commentaire.getText());
        r.setId_article(newArticle);
        java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        r.setDate_comment(date_sql);
        greviews.addReview(r);
        Reviewslist(newArticle);
    }

    @FXML
    private void Reviewslist(Event event) {
    }

    @FXML
    private void Partager(ActionEvent event) {
             Partage p=new Partage();
     p.Partager(txtitre.getText().toString(),arti.getImage());
    }
    
    private void QRCode() throws IOException, WriterException{
  
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        String myWeb = txtblog.getText();
        int width = 300;
        int height = 300;
        String fileType = "png";
         
        BufferedImage bufferedImage = null;
        try {
            BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();
             
            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);
             
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
             
            System.out.println("Success...");
             
        } catch (WriterException ex) {
            Logger.getLogger(ShowArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        QRImage.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
        
    
        
        
    }
}
