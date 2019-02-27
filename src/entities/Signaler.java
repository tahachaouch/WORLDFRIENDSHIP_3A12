/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author arthas
 */
public class Signaler {
    
int id;
int id_question;
int sig;
String cause;
String date_signaler = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
int vu;
String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }




public Signaler(String username,String cause,String date_signaler)
{
this.username=username;
this.cause=cause;
this.date_signaler=date_signaler;

}

public Signaler(int id, int id_question,String cause,String date_signaler)
{
this.id=id;
this.id_question=id_question;
this.cause=cause;
this.date_signaler=date_signaler;
}

public Signaler()
{}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public int getSig() {
        return sig;
    }

    public void setSig(int sig) {
        this.sig = sig;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getDate_signaler() {
        return date_signaler;
    }

    public void setDate_signaler(String date_signaler) {
        this.date_signaler = date_signaler;
    }

    public int getVu() {
        return vu;
    }

    public void setVu(int vu) {
        this.vu = vu;
    }

    public Signaler(int id, int id_question, int sig, String cause, int vu) {
        this.id = id;
        this.id_question = id_question;
        this.sig = sig;
        this.cause = cause;
        this.vu = vu;
    }




    
}
