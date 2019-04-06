package com.herbaciarnia.bean;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "KRAJE_POCHODZENIA")
public class KrajPochodzenia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_kraju;
    private String nazwa_kraju;

    public long getId_kraju() {
        return id_kraju;
    }

    public void setId_kraju(long id_kraju) {
        this.id_kraju = id_kraju;
    }

    public String getNazwa_kraju() {
        return nazwa_kraju;
    }

    public void setNazwa_kraju(String nazwa_kraju) {
        this.nazwa_kraju = nazwa_kraju;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.id_kraju ^ (this.id_kraju >>> 32));
        hash = 79 * hash + Objects.hashCode(this.nazwa_kraju);
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
        final KrajPochodzenia other = (KrajPochodzenia) obj;
        if (this.id_kraju != other.id_kraju) {
            return false;
        }
        if (!Objects.equals(this.nazwa_kraju, other.nazwa_kraju)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "KrajPochodzenia{" + "id=" + id_kraju + ", nazwa=" + nazwa_kraju + '}';
    }
    
}
