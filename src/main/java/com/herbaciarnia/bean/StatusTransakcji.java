package com.herbaciarnia.bean;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "STATUSY_TRANSAKCJI")
public class StatusTransakcji {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_statusu;
    private String nazwa;

    public long getId() {
        return id_statusu;
    }

    public void setId(int id) {
        this.id_statusu = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.id_statusu ^ (this.id_statusu >>> 32));
        hash = 79 * hash + Objects.hashCode(this.nazwa);
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
        final StatusTransakcji other = (StatusTransakcji) obj;
        if (this.id_statusu != other.id_statusu) {
            return false;
        }
        if (!Objects.equals(this.nazwa, other.nazwa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StatusTransakcji{" + "id=" + id_statusu + ", nazwa=" + nazwa + '}';
    }
    
}
