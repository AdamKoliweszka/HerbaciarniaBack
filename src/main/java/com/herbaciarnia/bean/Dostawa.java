package com.herbaciarnia.bean;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DOSTAWY")
public class Dostawa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Dostawca dostawca;
    @ManyToOne
    private Pracownik pracownik;
    @ManyToOne
    private Herbata herbata;
    private int ilosc;
    @ManyToOne
    private StatusTransakcji status;
    private Date dataDostawy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Dostawca getDostawca() {
        return dostawca;
    }

    public void setDostawca(Dostawca dostawca) {
        this.dostawca = dostawca;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public Herbata getHerbata() {
        return herbata;
    }

    public void setHerbata(Herbata herbata) {
        this.herbata = herbata;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public StatusTransakcji getStatus() {
        return status;
    }

    public void setStatus(StatusTransakcji status) {
        this.status = status;
    }

    public Date getDataDostawy() {
        return dataDostawy;
    }

    public void setDataDostawy(Date dataDostawy) {
        this.dataDostawy = dataDostawy;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 83 * hash + Objects.hashCode(this.dostawca);
        hash = 83 * hash + Objects.hashCode(this.pracownik);
        hash = 83 * hash + Objects.hashCode(this.herbata);
        hash = 83 * hash + this.ilosc;
        hash = 83 * hash + Objects.hashCode(this.status);
        hash = 83 * hash + Objects.hashCode(this.dataDostawy);
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
        final Dostawa other = (Dostawa) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.ilosc != other.ilosc) {
            return false;
        }
        if (!Objects.equals(this.dataDostawy, other.dataDostawy)) {
            return false;
        }
        if (!Objects.equals(this.dostawca, other.dostawca)) {
            return false;
        }
        if (!Objects.equals(this.pracownik, other.pracownik)) {
            return false;
        }
        if (!Objects.equals(this.herbata, other.herbata)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dostawa{" + "id=" + id + ", dostawca=" + dostawca + ", pracownik=" + pracownik + ", herbata=" + herbata + ", ilosc=" + ilosc + ", status=" + status + ", dataDostawy=" + dataDostawy + '}';
    }
    
}
