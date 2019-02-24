/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldfriendship.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import worldfriendship.Entities.Review;
import worldfriendship.Utils.MyConnexion;

/**
 *
 * @author user
 */
public class GReviews {
    Connection cn = MyConnexion.getInstance().getConnection();
    MyConnexion cnx = MyConnexion.getInstance();
    
    public void addReview(Review r) throws SQLException{
        
        String req ="INSERT INTO review("
               
                +"iduser,"
                +"cmt,"                           
                + "date,"
                + "id_event"
                    
                +"VALUES (?,?,?,?,?)";
                PreparedStatement st = cn.prepareStatement(req);               
                st.setInt(1,1);
                st.setString(2,r.getCmt());
                st.setDate(3, r.getDate());
                st.setInt(4, r.getId_event().getId_event());
                  st.executeUpdate();

                  
            /// TEST gittt
    }
    
}
