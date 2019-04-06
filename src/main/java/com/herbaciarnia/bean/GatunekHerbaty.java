package com.herbaciarnia.bean;

import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "GATUNKI_HERBAT")
public class GatunekHerbaty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_gatunku;
    private String nazwa_gatunku;

    public long getId_gatunku() {
        return id_gatunku;
    }

    public void setId_gatunku(long id_gatunku) {
        this.id_gatunku = id_gatunku;
    }

    public String getNazwa_gatunku() {
        return nazwa_gatunku;
    }

    public void setNazwa_gatunku(String nazwa_gatunku) {
        this.nazwa_gatunku = nazwa_gatunku;
    }

    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (this.id_gatunku ^ (this.id_gatunku >>> 32));
        hash = 97 * hash + Objects.hashCode(this.nazwa_gatunku);
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
        final GatunekHerbaty other = (GatunekHerbaty) obj;
        if (this.id_gatunku != other.id_gatunku) {
            return false;
        }
        if (!Objects.equals(this.nazwa_gatunku, other.nazwa_gatunku)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GatunekHerbaty{" + "id=" + id_gatunku + ", nazwa=" + nazwa_gatunku + '}';
    }
    
}
