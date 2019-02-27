/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldfriendship.Entities;

import java.sql.Date;

/**
 *
 * @author user
 */
public class Event {
    private int id_event;
    private int nbrplace_event;
    private String type_event;
    private String title_event;
    private String description_event ;
    private Date startdateevent;
    private Date enddateevent;
    private String image_Event ;
    private String adresse_Event ;
    private String type_hebergement ;
    private String adressehebergement;
    private Double lat;
    private Double lon;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
 private Date datepub;

    public Event(int id_event, int nbrplace_event, String type_event, String title_event, String description_event, Date startdateevent, Date enddateevent, String image_Event, String adresse_Event, String type_hebergement, String adressehebergement, Date datepub) {
        this.id_event = id_event;
        this.nbrplace_event = nbrplace_event;
        this.type_event = type_event;
        this.title_event = title_event;
        this.description_event = description_event;
        this.startdateevent = startdateevent;
        this.enddateevent = enddateevent;
        this.image_Event = image_Event;
        this.adresse_Event = adresse_Event;
        this.type_hebergement = type_hebergement;
        this.adressehebergement = adressehebergement;
        this.datepub = datepub;
    }
    public Event() {
    }

    public Event(int nbrplace_event, String type_event, String title_event, String description_event, Date startdateevent, Date enddateevent, String image_Event, String adresse_Event, String type_hebergement, String adressehebergement) {
        this.nbrplace_event = nbrplace_event;
        this.type_event = type_event;
        this.title_event = title_event;
        this.description_event = description_event;
        this.startdateevent = startdateevent;
        this.enddateevent = enddateevent;
        this.image_Event = image_Event;
        this.adresse_Event = adresse_Event;
        this.type_hebergement = type_hebergement;
        this.adressehebergement = adressehebergement;
    }

    public Event(int id_event, String adresse_Event,String adressehebergement, String description_event, Date enddateevent, Date startdateevent, int nbrplace_event, String type_hebergement, String type_event, String title_event) {
        this.id_event=id_event;
        this.nbrplace_event = nbrplace_event;
        this.type_event = type_event;
        this.title_event = title_event;
        this.description_event = description_event;
        this.startdateevent = startdateevent;
        this.enddateevent = enddateevent;
        //this.image_Event = image_Event;
        this.adresse_Event = adresse_Event;
        this.type_hebergement = type_hebergement;
        this.adressehebergement = adressehebergement;    }

    public Event(int id_event, String adresse_Event, String adressehebergement, String description_event, Date enddateevent, Date startdateevent, int nbrplace_event, String type_hebergement, String type_Event, String image_Event, String title_event, Date datepub) {
      this.id_event=id_event;
        this.nbrplace_event = nbrplace_event;
        this.type_event = type_event;
        this.title_event = title_event;
        this.description_event = description_event;
        this.startdateevent = startdateevent;
        this.enddateevent = enddateevent;
        //this.image_Event = image_Event;
        this.adresse_Event = adresse_Event;
        this.type_hebergement = type_hebergement;
        this.adressehebergement = adressehebergement;  
        this.datepub=datepub;
    }

   

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public int getNbrplace_event() {
        return nbrplace_event;
    }

    public void setNbrplace_event(int nbrplace_event) {
        this.nbrplace_event = nbrplace_event;
    }

    public String getType_event() {
        return type_event;
    }

    public void setType_event(String type_event) {
        this.type_event = type_event;
    }

    public String getTitle_event() {
        return title_event;
    }

    public void setTitle_event(String title_event) {
        this.title_event = title_event;
    }

    public String getDescription_event() {
        return description_event;
    }

    public void setDescription_event(String description_event) {
        this.description_event = description_event;
    }

    public Date getStartdateevent() {
        return startdateevent;
    }

    public void setStartdateevent(Date startdateevent) {
        this.startdateevent = startdateevent;
    }

    public Date getEnddateevent() {
        return enddateevent;
    }

    public void setEnddateevent(Date enddateevent) {
        this.enddateevent = enddateevent;
    }

    public String getImage_Event() {
        return image_Event;
    }

    public void setImage_Event(String image_Event) {
        this.image_Event = image_Event;
    }

    public String getAdresse_Event() {
        return adresse_Event;
    }

    public void setAdresse_Event(String adresse_Event) {
        this.adresse_Event = adresse_Event;
    }

    public String getType_hebergement() {
        return type_hebergement;
    }

    public void setType_hebergement(String type_hebergement) {
        this.type_hebergement = type_hebergement;
    }

    public String getAdressehebergement() {
        return adressehebergement;
    }

    public void setAdressehebergement(String adressehebergement) {
        this.adressehebergement = adressehebergement;
    }

    public Date getDatepub() {
        return datepub;
    }

    public void setDatepub(Date datepub) {
        this.datepub = datepub;
    }
    
}
