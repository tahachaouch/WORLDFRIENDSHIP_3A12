/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldfriendship.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import worldfriendship.Utils.MyConnexion;

/**
 *
 * @author user
 */
public class ParticiperS {
    Connection cn = MyConnexion.getInstance().getConnection();
    MyConnexion cnx = MyConnexion.getInstance();
    public void participerevent(int id_event , int id_user){
         try {
         
        
            String requete
                    = "INSERT INTO participation (idevent, iduser) VALUES (?,?)";
            PreparedStatement st = cn.prepareStatement(requete);
            st.setInt(1, id_event );
            st.setInt(2, id_user );
            
          
            st.executeUpdate();
            System.out.println("participation ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
    }
    
    
    
    public boolean getParticip(int id)
    {
        boolean test = false;
        List<Integer> l=new ArrayList<Integer>();
        try {
            PreparedStatement myStm = cn.prepareStatement("SELECT * from participation where idevent= ?");
            myStm.setInt(1, id);
            ResultSet myRes = myStm.executeQuery();
            while(myRes.next())
            {
                l.add(myRes.getInt("iduser"));
           
            }
            if(l.size()>0){
                test = true;
            }
            else{
                test = false;
            }
            return test;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return test;
    }
}
