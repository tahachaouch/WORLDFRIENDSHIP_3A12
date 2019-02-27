package entities;




import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author karim
 */
public class Main extends Application{

 public static User LoggedUser;
   @Override 
 public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/vue/HomePage.fxml"));
        
        Scene scene = new Scene(root);
       
        
        stage.setScene(scene);
      //  stage.setTitle("");
        stage.show();
  
 }
   public static void main(String[] args) {
        launch(args);
    }  
}
