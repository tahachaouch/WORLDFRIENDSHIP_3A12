/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldfriendship.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import worldfriendship.Entities.Event;
import worldfriendship.Utils.MyConnexion;

/**
 *
 * @author user
 */
public class ListEvent {
    public ObservableList<Event> ListeEvent() {
        ObservableList<Event> myList = FXCollections.observableArrayList();
        Connection cn = MyConnexion.getInstance().getConnection();
        myList.clear();
        try {
            String requete = "SELECT * FROM `events` WHERE startdateevent > SYSDATE() ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                
                Event etab = new Event();
                etab.setId_event(rs.getInt("id_event"));
                etab.setNbrplace_event(rs.getInt("nbrplace_event"));
                etab.setType_event(rs.getString("type_event"));
                etab.setTitle_event(rs.getString("title_event"));
                etab.setDescription_event(rs.getString("description_event"));
                etab.setStartdateevent(rs.getDate("startdateevent"));
                etab.setEnddateevent(rs.getDate("enddateevent"));
                etab.setImage_Event(rs.getString("image_Event"));
                etab.setAdresse_Event(rs.getString("adresse_Event"));
                etab.setType_hebergement(rs.getString("type_hebergement"));
                etab.setAdressehebergement(rs.getString("adressehebergement"));
               
                
                myList.add(etab);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
    
    
}
