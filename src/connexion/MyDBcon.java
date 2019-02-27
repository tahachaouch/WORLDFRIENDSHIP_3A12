

package connexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author arthas
 */
public class MyDBcon {
   private static MyDBcon instance;
    private Connection cnx ;
    
     final String url = "jdbc:mysql://127.0.0.1/worldfriendship";
    final String login = "root";
    final String password = "";

    private MyDBcon(){
       try {    
           cnx = DriverManager.getConnection(url, login, password);
           System.out.println("connexion établie!!!!");
       } catch (SQLException ex) {
           Logger.getLogger(MyDBcon.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public Connection getCnx() {
        return cnx;
    }

    public static  MyDBcon getInstance() throws SQLException{
        if(instance==null)
        instance = new MyDBcon();
        
        return instance;
    }
   
    
}