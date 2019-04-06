/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.bean;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Adam
 */
@Entity
@Table(name = "UZYTKOWNICY")
public class Uzytkownik implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_uzytkownika;
    private String login;
    private String haslo;
    private String salt;

    public long getId() {
        return id_uzytkownika;
    }

    public void setId(long id) {
        this.id_uzytkownika = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String hash) {
        this.haslo = hash;
    }

    public void setSalt(String salt){this.salt = salt;}
    public String getSalt(){return salt;}

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (int) (this.id_uzytkownika ^ (this.id_uzytkownika >>> 32));
        hash = 67 * hash + Objects.hashCode(this.login);
        hash = 67 * hash + Objects.hashCode(this.haslo);
        hash = 67 * hash + Objects.hashCode(this.salt);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Uzytkownik other = (Uzytkownik) obj;
        if (this.id_uzytkownika != other.id_uzytkownika) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.haslo, other.haslo)) {
            return false;
        }
        if (!Objects.equals(this.salt, other.salt)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Uzytkownik{" + "id=" + id_uzytkownika + ", login=" + login + ", hash=" + haslo + ", salt=" + salt + '}';
    }

    
    
}
