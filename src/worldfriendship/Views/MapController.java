/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldfriendship.Views;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.service.geocoding.GeocoderStatus;
import com.lynden.gmapsfx.service.geocoding.GeocodingResult;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MapController implements Initializable {
    

    @FXML
    private Label latitudeLabel;

    @FXML
    private Label longitudeLabel;
    @FXML
    private AnchorPane searchAP;
    //private ObservableList<Etablissement> data;
    private GoogleMapView googleMapView1;
    private JFXTextField address1;
    private Label latitudeLabel1;

    public JFXTextField getAddress1() {
        return address1;
    }

    public Label getLatitudeLabel1() {
        return latitudeLabel1;
    }

    public Label getLongitudeLabel1() {
        return longitudeLabel1;
    }

    public GoogleMap getMap1() {
        return map1;
    }
    private Label longitudeLabel1;

    public AnchorPane getSearchAP() {
        return searchAP;
    }

    public void setSearchAP(AnchorPane searchAP) {
        this.searchAP = searchAP;
    }

    public TextField getAddress() {
        return address;
    }

    public void setAddress(TextField address) {
        this.address = address;
    }

    @FXML
    private GoogleMapView googleMapView;

    private GoogleMap map;
    private GoogleMap map1;

    public GoogleMap getMap() {
        return map;
    }

    public void setMap(GoogleMap map) {
        this.map = map;
    }
  

    private DecimalFormat formatter = new DecimalFormat("###.00000");
    private GeocodingService geocodingService;
    @FXML
    private TextField address;
    @FXML
    private AnchorPane clear;
    @FXML
    private JFXButton save;
    private JFXTextField adresseX;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        googleMapView.addMapInializedListener(() -> {
         
            try {
                configureMap();
            } catch (IOException ex) {
                Logger.getLogger(MapController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                
             
        });
   /*     googleMapView1.addMapInializedListener(() -> {
           
                configureMap1();
                
                
            
        });*/
    }

    protected void configureMap() throws IOException {

        MapOptions mapOptions = new MapOptions();

        mapOptions.center(new LatLong(36.80040, 10.18662))
                .mapType(MapTypeIdEnum.ROADMAP)
                .zoom(15);
        map = googleMapView.createMap(mapOptions, false);
        MarkerOptions markerOptions = new MarkerOptions();
        map.addMouseEventHandler(UIEventType.click, (GMapMouseEvent event) -> {
        try {
            LatLong latLong = event.getLatLong();
            latitudeLabel.setText(formatter.format(latLong.getLatitude()));
            longitudeLabel.setText(formatter.format(latLong.getLongitude()));

            markerOptions.position(latLong)
                    .visible(Boolean.TRUE)
                    .title("My Marker");

            Marker marker = new Marker(markerOptions);
            map.clearMarkers();
            map.addMarker(marker);
            ///
            URL url = new URL("https://maps.googleapis.com/maps/api/geocode/json?latlng="+latitudeLabel.getText().replace(',','.')+","+longitudeLabel.getText().replace(',', '.')+"&sensor=true&key=AIzaSyCcqmzXtsiSoucU_0A_z4UpnR3oIv0Zj9E");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            String formattedAddress = "";
            
            try {
                InputStream in = url.openStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String result, line = reader.readLine();
                result = line;
                while ((line = reader.readLine()) != null) {
                    result += line;
                }
                
                JSONParser parser = new JSONParser();
                JSONObject rsp = (JSONObject) parser.parse(result);
                
                System.out.println(result);
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX");
                System.out.println(rsp);
                
                if (rsp.containsKey("results")) {
                    JSONArray matches = (JSONArray) rsp.get("results");
                    JSONObject data = (JSONObject) matches.get(0); //TODO: check if idx=0 exists
                    formattedAddress = (String) data.get("formatted_address");
                }
                
                adresseX.setText("");
            } catch (ParseException ex) {
                Logger.getLogger(MapController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                urlConnection.disconnect();
                System.out.println("Teeeeeeeess"+formattedAddress);
                address.setText(formattedAddress);
                
            }
            ///
            
        }   catch (MalformedURLException ex) {
                Logger.getLogger(MapController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MapController.class.getName()).log(Level.SEVERE, null, ex);
            }
            ///

        });
         
  /*      ListEtablissement LDS = new ListEtablissement();
        data = LDS.ListEtab();
 for (Etablissement etab : data)
         {
            
            MarkerOptions markerOptionss = new MarkerOptions();
 
            markerOptionss.position(new LatLong(etab.getLatitude(),etab.getLongitude()))
                    .visible(Boolean.TRUE).label(etab.getCategorie()+" : " +etab.getName());
            Marker markers = new Marker(markerOptionss);
            map.addMarker(markers);
         }*/
//         clear.setOnMouseClicked((MouseEvent event) -> {
//             
//         map.clearMarkers();
//         });
  
    }

    @FXML
    private void search(ActionEvent event) throws IOException {
        System.out.println("salut");

        geocodingService = new GeocodingService();
        geocodingService.geocode(address.getText(), (GeocodingResult[] results, GeocoderStatus status) -> {

            LatLong latLong = null;

            if (status == GeocoderStatus.ZERO_RESULTS) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Pas de resultat");
                alert.show();
                return;
            } else if (results.length > 1) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Multiple results found, showing the first one.");
                alert.show();
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
            } else {
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
            }
            latitudeLabel.setText(formatter.format(latLong.getLatitude()));
            longitudeLabel.setText(formatter.format(latLong.getLongitude()));
            map.setZoom(15);
            MarkerOptions markerOptions = new MarkerOptions();

            markerOptions.position(latLong)
                    .visible(Boolean.TRUE);

            Marker marker = new Marker(markerOptions);

            map.addMarker(marker);

            map.setCenter(latLong);

        });

    }

    @FXML
    private void addposition(ActionEvent event) throws IOException {
    }

    public Label getLatitudeLabel() {
        return latitudeLabel;
    }

    public Label getLongitudeLabel() {
        return longitudeLabel;
    }

    public JFXButton getSave() {
        return save;
    }

    public void setSave(JFXButton save) {
        this.save = save;
    }
    public void listRestaurant() throws IOException
    {
      
    }
 
   

}
