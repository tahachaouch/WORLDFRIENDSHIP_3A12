/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldfriendship.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import worldfriendship.Entities.Event;
import worldfriendship.Services.EventService;
import worldfriendship.Services.Mylist;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ShowEventsController implements Initializable {
  
    @FXML
    private TextField recherchetext;
    @FXML
    private Button edit;
    @FXML
    private Button delete;

    ObservableList<Event> list;
    @FXML
    private Button add;
    @FXML
    private ListView<Event> table;
    @FXML
    private AnchorPane root;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   

 try {
        // TODO
        EventService eda= new EventService();
        
     // id.setCellValueFactory(new PropertyValueFactory<>("id"));
     // titre.setCellValueFactory(new PropertyValueFactory<>("titre_article"));
     /*  blog.setCellValueFactory(new PropertyValueFactory<>("blog"));
     image.setCellValueFactory(new PropertyValueFactory<>("image"));
     cree.setCellValueFactory(new PropertyValueFactory<>("cree"));
     modifie.setCellValueFactory(new PropertyValueFactory<>("modifie"));*/
     table.getItems().setAll(eda.afficherEvent());
       table.setCellFactory(lv -> new Mylist());
    } catch (SQLException ex) {
       // Logger.getLogger(ShowEventController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }}

    
  /*  private void deleteEvent(ActionEvent event) throws SQLException {
        EventService es =new EventService();
       
        Event e=table.getSelectionModel().getSelectedItem();
        if(e!=null)
            
//        es.deleteEvent(e);
    }

    @FXML
    private void addevent(ActionEvent event) throws IOException {
       EventService es =new EventService();
        Event e=table.getSelectionModel().getSelectedItem();
        if(e!=null)
            
        es.addevent(e);
    }*/
