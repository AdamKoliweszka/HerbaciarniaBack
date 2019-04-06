package com.herbaciarnia.bean;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "HISTORIA_ZAKUPOW")
public class Zakup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_zakupu;
    @ManyToOne
    @JoinColumn(name = "id_klienta")
    private Klient klient;
    @ManyToOne
    @JoinColumn(name = "id_pracownika")
    private Pracownik pracownik;
    @ManyToOne
    @JoinColumn(name = "id_herbaty")
    private Herbata herbata;
    private int ilosc;
    @ManyToOne
    @JoinColumn(name = "id_statusu")
    private StatusTransakcji status;
    private Date dataZakupu;

    public long getId() {
        return id_zakupu;
    }

    public void setId(long id) {
        this.id_zakupu = id;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
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

    public Date getDataZakupu() {
        return dataZakupu;
    }

    public void setDataZakupu(Date dataZakupu) {
        this.dataZakupu = dataZakupu;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (int) (this.id_zakupu ^ (this.id_zakupu >>> 32));
        hash = 41 * hash + Objects.hashCode(this.klient);
        hash = 41 * hash + Objects.hashCode(this.pracownik);
        hash = 41 * hash + Objects.hashCode(this.herbata);
        hash = 41 * hash + this.ilosc;
        hash = 41 * hash + Objects.hashCode(this.status);
        hash = 41 * hash + Objects.hashCode(this.dataZakupu);
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
        final Zakup other = (Zakup) obj;
        if (this.id_zakupu != other.id_zakupu) {
            return false;
        }
        if (this.ilosc != other.ilosc) {
            return false;
        }
        if (!Objects.equals(this.dataZakupu, other.dataZakupu)) {
            return false;
        }
        if (!Objects.equals(this.klient, other.klient)) {
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
        return "Zakup{" + "id=" + id_zakupu + ", klient=" + klient + ", pracownik=" + pracownik + ", herbata=" + herbata + ", ilosc=" + ilosc + ", status=" + status + ", dataZakupu=" + dataZakupu + '}';
    }
    
    
}
