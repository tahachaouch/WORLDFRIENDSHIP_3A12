/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldfriendship.Services;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import worldfriendship.Entities.Event;

/**
 *
 * @author user
 */
public class Mylist extends ListCell<Event>{
    private final GridPane gridPane = new GridPane();  
    private final Label image_Event = new Label();
    private final Label title_event = new Label();
    private final Label type_event = new Label();
    private final AnchorPane content = new AnchorPane(); 
    private final Label descriptionLabel = new Label();

    
    public Mylist(){
          image_Event.setStyle("-fx-font-style: italic; -fx-font-size: 0.9em; -fx-opacity: 0.5;"); 
        GridPane.setConstraints(image_Event, 1, 0);        
           title_event.setStyle("-fx-font-style: bold; -fx-font-size: 1.2em;"); 
        GridPane.setConstraints(title_event, 2, 0); 
        //gridPane.setStyle("-fx-background-color: #ffff; ");
        type_event.setStyle("-fx-font-style: bold; -fx-font-size: 1.2em;"); 
        GridPane.setConstraints(type_event, 3, 0); 
        //gridPane.setStyle("-fx-background-color: #ffff; ");
        
     
        
        //GridPane.setColumnSpan(Description, Integer.MAX_VALUE); 
        
        gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, HPos.LEFT, true)); 
        gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.ALWAYS, HPos.LEFT, true)); 
        gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, HPos.LEFT, true)); 
        gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, HPos.LEFT, true)); 
      
        gridPane.getRowConstraints().add(new RowConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, VPos.CENTER, true)); 
        gridPane.getRowConstraints().add(new RowConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, VPos.CENTER, true)); 
        gridPane.getRowConstraints().add(new RowConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.ALWAYS, VPos.CENTER, true)); 
        //gridPane.getRowConstraints().add(new RowConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, VPos.CENTER, true)); 
      
        gridPane.setHgap(3); 
        gridPane.setVgap(3); 
       
        gridPane.getChildren().setAll(image_Event,title_event, type_event); 
        
        
        AnchorPane.setTopAnchor(gridPane, 0d); 
        AnchorPane.setLeftAnchor(gridPane, 0d); 
        AnchorPane.setBottomAnchor(gridPane, 0d); 
        AnchorPane.setRightAnchor(gridPane, 0d); 
       
        content.getChildren().add(gridPane); 
    }

    public Label getImage_Event() {
        return image_Event;
    }

    public Label getType_event() {
        return type_event;
    }

    public Label getTitle_event() {
        return title_event;
    }
     protected void updateItem(Event item, boolean empty) { 
        super.updateItem(item, empty); 
        setGraphic(null); 
        setText(null); 
        setContentDisplay(ContentDisplay.LEFT); 
        if (!empty && item != null) { 
           
            image_Event.setText(item.getImage_Event()); 
            type_event.setText(item.getType_event());
           title_event.setText(item.getTitle_event());
           
            //brandIcon.setImage(item.getBrandImage()); 
            //carIcon.setImage(item.getCarImage()); 
            descriptionLabel.setText(String.format("%s ,%s,%s", item.getImage_Event(),item.getType_event(), item.getTitle_event())); 
           //colorRect.setFill(item.getColor()); 
            setText(null); 
            setGraphic(content); 
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY); 
        } 
    } 
}

