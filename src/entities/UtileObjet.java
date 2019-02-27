/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author arthas
 */
public class UtileObjet {
    private int id_questiondb;
    private int id_reponsedb;
    private int id_userdb;

    public UtileObjet(int id_userdb)
    {
     this.id_userdb=id_userdb;
    }
    
    
    public int getId_questiondb() {
        return id_questiondb;
    }

    public void setId_questiondb(int id_questiondb) {
        this.id_questiondb = id_questiondb;
    }

    public int getId_reponsedb() {
        return id_reponsedb;
    }

    public void setId_reponsedb(int id_reponsedb) {
        this.id_reponsedb = id_reponsedb;
    }

    public int getId_userdb() {
        return id_userdb;
    }

    public void setId_userdb(int id_userdb) {
        this.id_userdb = id_userdb;
    }

    public UtileObjet() {
    }

    public UtileObjet(int id_questiondb, int id_reponsedb, int id_userdb) {
        this.id_questiondb = id_questiondb;
        this.id_reponsedb = id_reponsedb;
        this.id_userdb = id_userdb;
    }


    
    
    
    
}
