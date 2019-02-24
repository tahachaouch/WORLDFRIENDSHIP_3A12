/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldfriendship.Services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
public class EventService {
     Connection cn = MyConnexion.getInstance().getConnection();
    MyConnexion cnx = MyConnexion.getInstance();
    
    
    
    public void addevent(Event event) throws IOException {
        try {

            java.util.Date date_util = new java.util.Date();
            java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
            //  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          
            String requete
                    = "INSERT INTO event (iduser,nbrplace_event ,type_event,title_event ,description_event,startdateevent,enddateevent,image_Event,adresse_Event,type_hebergement,adressehebergement ) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = cn.prepareStatement(requete);
            st.setInt(1,1);
            st.setInt(2, event.getNbrplace_event());
            st.setString(3, event.getType_event());
            st.setString(4, event.getTitle_event());
            st.setString(5, event.getDescription_event());
            st.setDate(6, event.getStartdateevent());
            st.setDate(7, event.getEnddateevent());
            st.setString(8, event.getImage_Event());
            st.setString(9, event.getAdresse_Event());
            st.setString(10, event.getType_hebergement());
            st.setString(11, event.getAdressehebergement());
            
            st.executeUpdate();
            System.out.println("event ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }

    }
    
    public void deleteEvent(String id) throws SQLException{
        String req="DELETE FROM event WHERE id_event='"+id+"'";
        PreparedStatement ste = cn.prepareStatement(req);
      //  ste.setString(1, id);
        ste.executeUpdate();
    }
 
    public Event afficherEventById(int id) throws SQLException
        {
            Event event= new Event();
            String requete ="Select * from event where id_event ='"+id+"'";
              PreparedStatement st = cn.prepareStatement(requete);
              ResultSet rs = st.executeQuery();
             while (rs.next()) {
                    
                    event.setId_event(rs.getInt("id_event"));
                    event.setAdresse_Event(rs.getString("adresse_Event"));
                    event.setAdressehebergement(rs.getString("adressehebergement"));
                    event.setDescription_event(rs.getString("description_event"));
                    event.setEnddateevent(rs.getDate("enddateevent"));
                    event.setStartdateevent(rs.getDate("startdateevent"));
                    event.setNbrplace_event(rs.getInt("nbrplace_event"));
                    event.setType_hebergement(rs.getString("type_hebergement"));
                    event.setType_event(rs.getString("type_Event"));
                    event.setImage_Event(rs.getString("image_Event"));
                    event.setTitle_event(rs.getString("title_event"));}
             return event;
} 
    public ObservableList<Event> afficherEvent() throws SQLException
        { 
           ObservableList<Event> myL = FXCollections.observableArrayList();
         
            String requete ="SELECT `id_event`, `nbrplace_event`, `type_event`, `title_event`, `description_event`, `startdateevent`, `enddateevent`, `image_Event`, `adresse_Event`, `type_hebergement`, `adressehebergement` FROM `event` ";

              PreparedStatement st = cn.prepareStatement(requete);
             ResultSet rs = st.executeQuery();
              
             while (rs.next()) {
                 Event event =new Event();
                  event.setId_event(rs.getInt("id_event"));
                    event.setAdresse_Event(rs.getString("adresse_Event"));
                    event.setAdressehebergement(rs.getString("adressehebergement"));
                    event.setDescription_event(rs.getString("description_event"));
                    event.setEnddateevent(rs.getDate("enddateevent"));
                    event.setStartdateevent(rs.getDate("startdateevent"));
                    event.setNbrplace_event(rs.getInt("nbrplace_event"));
                    event.setType_hebergement(rs.getString("type_hebergement"));
                    event.setType_event(rs.getString("type_Event"));
                    event.setImage_Event(rs.getString("image_Event"));
                    event.setTitle_event(rs.getString("title_event"));
                    
                    myL.add(event);}
             
            
         return myL;}
    
 
       public void modifierEvent(Event etab, int item) throws SQLException, IOException {
        Connection cn = MyConnexion.getInstance().getConnection();
        String req = "UPDATE event SET "
                + "nbrplace_event = ?,"
                + "type_event = ?,"
                + "title_event = ?,"
                + "description_event = ?,"
                + "startdateevent = ?,"
                + "enddateevent = ?,"
                + "image_Event = ?,"
                + "adresse_Event = ?,"
                + "type_hebergement = ?,"
                + "adressehebergement = ? where id_event=?";
                

        PreparedStatement pre = cn.prepareStatement(req);
        
        pre.setInt(1, etab.getNbrplace_event());
        pre.setString(2, etab.getType_event());
        pre.setString(3, etab.getTitle_event());
        
        pre.setString(4, etab.getDescription_event());
        pre.setDate(5, etab.getStartdateevent());
        pre.setDate(6, etab.getEnddateevent());
        pre.setString(7, etab.getImage_Event());
        pre.setString(8, etab.getAdresse_Event());

        pre.setString(9, etab.getType_hebergement());
        pre.setString(10, etab.getAdressehebergement());

        
        pre.setInt(11, item);
        pre.executeUpdate();
        System.out.println("event modifié");

    }

             
}
