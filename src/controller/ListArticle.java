/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;




import entities.Article;
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

/**
 *
 * @author hedi store
 */
public class ListArticle extends ListCell<Article>{
    private final GridPane gridPane = new GridPane();  
    private final Label image = new Label();
    private final Label titre_article = new Label();
    private final Label tags = new Label();

    private final Label descriptionLabel = new Label();
    private final AnchorPane content = new AnchorPane(); 
    
    public ListArticle(){
          image.setStyle("-fx-font-style: italic; -fx-font-size: 0.9em; -fx-opacity: 0.5;"); 
        GridPane.setConstraints(image, 1, 0); 
        
        
           tags.setStyle("-fx-font-style: bold; -fx-font-size: 1.2em;"); 
        GridPane.setConstraints(tags, 2, 0); 
        //gridPane.setStyle("-fx-background-color: #ffff; ");
        titre_article.setStyle("-fx-font-style: bold; -fx-font-size: 1.2em;"); 
        GridPane.setConstraints(titre_article, 3, 0); 
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
       
        gridPane.getChildren().setAll(image,tags, titre_article); 
        
        
        AnchorPane.setTopAnchor(gridPane, 0d); 
        AnchorPane.setLeftAnchor(gridPane, 0d); 
        AnchorPane.setBottomAnchor(gridPane, 0d); 
        AnchorPane.setRightAnchor(gridPane, 0d); 
       
        content.getChildren().add(gridPane); 
    }

    public Label getImage() {
        return image;
    }

    public Label getTitre_article() {
        return titre_article;
    }

    public Label getTags() {
        return tags;
    }
        @Override 
     protected void updateItem(Article item, boolean empty) { 
        super.updateItem(item, empty); 
        setGraphic(null); 
        setText(null); 
        setContentDisplay(ContentDisplay.LEFT); 
        if (!empty && item != null) { 
           
            image.setText(item.getImage()); 
            titre_article.setText(item.getTitre_article());
           tags.setText(item.getTags());
           
            //brandIcon.setImage(item.getBrandImage()); 
            //carIcon.setImage(item.getCarImage()); 
            descriptionLabel.setText(String.format("%s ,%s,%s", item.getImage(),item.getTitre_article(), item.getTags())); 
           //colorRect.setFill(item.getColor()); 
            setText(null); 
            setGraphic(content); 
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY); 
        } 
    } 
}

