/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import service.ProduitService;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Meriem
 */
public class StatistiquesController implements Initializable {

    @FXML
    private PieChart stat;
    @FXML
    private JFXHamburger affmenu;
    @FXML
    private JFXDrawer menu;
    ObservableList<PieChart.Data> dataa = FXCollections.observableArrayList();
    
    public ObservableList<PieChart.Data> getData() {
        return dataa;
    }

    public void setData(ObservableList<PieChart.Data> data) {
        this.dataa = dataa;
    }

    public void statistique() throws Exception {
        ProduitService aa = new ProduitService();
        ResultSet rs = aa.buildDatapro();
        while (rs.next()) {
            dataa.add(new PieChart.Data(rs.getString(1), rs.getDouble(2)));
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            AnchorPane anchrone = FXMLLoader.load(getClass().getResource("/vue/MenuAdmin.fxml"));
            menu.setSidePane(anchrone);

            HamburgerBackArrowBasicTransition burgerTask2 = new HamburgerBackArrowBasicTransition(affmenu);
            burgerTask2.setRate(-1);

            affmenu.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
                burgerTask2.setRate(burgerTask2.getRate() * -1);
                burgerTask2.play();

                if (menu.isShown()) {
                    menu.close();
                } else {
                    menu.open();
                    menu.toFront();
                }
            }
            );
        } 
       
        catch (IOException ex) {
            Logger.getLogger(StatistiquesController.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
            statistique();
        } catch (Exception e) {
            System.out.println(e);
        }
        stat.getData().addAll(dataa);
    }    
    
}
