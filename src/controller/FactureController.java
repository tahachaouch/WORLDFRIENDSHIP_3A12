/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import service.PanierService;
import entities.Produit;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FactureController implements Initializable {

    @FXML
    private Pane sq;

    @FXML
    private JFXButton quit;
    @FXML
    private JFXButton export;
    private ObservableList<Produit> data;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PanierService ps;
        try {
            ps = new PanierService();
            data = ps.loadPanier();
        } catch (SQLException ex) {
            Logger.getLogger(FactureController.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO

        // TODO
    }

    @FXML
    private void quit(MouseEvent event) throws SQLException {
        Stage stage = (Stage) quit.getScene().getWindow();
      PanierService  ps = new PanierService();
       ps.confirmerCommande();
    // do what you have to do
    stage.close();
    }

    @FXML
    private void pdf(MouseEvent event) throws SQLException {
        try {
            // System.out.println("Haouet------------------------------------->"+nom);

            com.itextpdf.text.Document document = new com.itextpdf.text.Document();
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\HP\\Desktop/facture2.pdf"));
            document.open();
            document.add(new Paragraph(" WorldFriendship ", FontFactory.getFont(FontFactory.TIMES)));
            //cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            //String date=new Date().toString();
            //document.add(new Paragraph(" Date : " + new Date().toString()));
            //  document.add(new Paragraph("-----------------------------------------------------------------"));
            // document.add(new Paragraph("-----------------------------------------------------------------"));
            com.itextpdf.text.pdf.PdfPTable table = new com.itextpdf.text.pdf.PdfPTable(2);
            com.itextpdf.text.pdf.PdfPCell cell = new com.itextpdf.text.pdf.PdfPCell(new Paragraph("Facture"));
            cell.setColspan(4);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.PINK);
            table.addCell(cell);

//                table.addCell("nom");
//              table.addCell(nom1);
//              table.addCell("prenom");
//              table.addCell(prenom1);
            for (Produit d : data) {
                table.addCell("Produit");
                table.addCell(d.getNom_prod());
                table.addCell("Quantite");
                table.addCell(Float.toString(d.getQuantite()));

            }
            PanierService ps = new PanierService();

            // int id1=ps2.rechercheridutili(nom1, prenom1);
            float h = ps.getprixtotale();
            //table.addCell("Prenom");
            //    table.addCell(selectedUser.getPrix());
            table.addCell("Date");
            table.addCell(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            table.addCell("*****************************");
            table.addCell("*****************************");
            table.addCell("Montant Totale");
            table.addCell(Float.toString(h));

            //Image image = Image.getInstance ("file:C://wamp64/www/image/" +"radius.png"); 
            // image.setAbsolutePosition(50,50);
            //document.add(new Paragraph("test\n  test")); 
            //  document.add(image);  
            //    table.addCell("email");
            //      table.addCell(selectedUser.getQuantiteStock());
            //     table.addCell("email");
            //table.addCell(selectedUser.getNom());
            //System.out.println("*************"+selectedUser.getNom().toString());
            //  data = loadPanier();
            document.add(table);
            document.close();
            Notifications notificationBuilder = Notifications.create()
                    .title("Facture Exportée")
                    .text("succés")
                    .graphic(null)
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT)
                    .onAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            System.out.println("clicked on notification");
                        }
                    });
            notificationBuilder.show();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FactureController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(FactureController.class.getName()).log(Level.SEVERE, null, ex);
        }
        PanierService  ps = new PanierService();
       ps.confirmerCommande();

    }
}
