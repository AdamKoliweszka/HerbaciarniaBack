package com.herbaciarnia.bean;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HERBATY")
public class Herbata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_herbaty;
    private String nazwa_herbaty;
    private String opis;
    private int cenaSprzedazy;
    private int cenaDostawy;
    private int iloscDostepna;
    @ManyToOne
    @JoinColumn(name = "id_kraju")
    private KrajPochodzenia krajPochodzenia;
    @ManyToOne
    @JoinColumn(name = "id_gatunku")
    private GatunekHerbaty gatunekHerbaty;

    public long getId_herbaty() {
        return id_herbaty;
    }

    public void setId_herbaty(long id_herbaty) {
        this.id_herbaty = id_herbaty;
    }

    public String getNazwa_herbaty() {
        return nazwa_herbaty;
    }

    public void setNazwa_herbaty(String nazwa_herbaty) {
        this.nazwa_herbaty = nazwa_herbaty;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getCenaSprzedazy() {
        return cenaSprzedazy;
    }

    public void setCenaSprzedazy(int cenaSprzedazy) {
        this.cenaSprzedazy = cenaSprzedazy;
    }

    public int getCenaDostawy() {
        return cenaDostawy;
    }

    public void setCenaDostawy(int cenaDostawy) {
        this.cenaDostawy = cenaDostawy;
    }

    public int getIloscDostepna() {
        return iloscDostepna;
    }

    public void setIloscDostepna(int iloscDostepna) {
        this.iloscDostepna = iloscDostepna;
    }

    public KrajPochodzenia getKrajPochodzenia() {
        return krajPochodzenia;
    }

    public void setKrajPochodzenia(KrajPochodzenia krajPochodzenia) {
        this.krajPochodzenia = krajPochodzenia;
    }

    public GatunekHerbaty getGatunekHerbaty() {
        return gatunekHerbaty;
    }

    public void setGatunekHerbaty(GatunekHerbaty gatunekHerbaty) {
        this.gatunekHerbaty = gatunekHerbaty;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (this.id_herbaty ^ (this.id_herbaty >>> 32));
        hash = 37 * hash + Objects.hashCode(this.nazwa_herbaty);
        hash = 37 * hash + Objects.hashCode(this.opis);
        hash = 37 * hash + this.cenaSprzedazy;
        hash = 37 * hash + this.cenaDostawy;
        hash = 37 * hash + this.iloscDostepna;
        hash = 37 * hash + Objects.hashCode(this.krajPochodzenia);
        hash = 37 * hash + Objects.hashCode(this.gatunekHerbaty);
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
        final Herbata other = (Herbata) obj;
        if (this.id_herbaty != other.id_herbaty) {
            return false;
        }
        if (this.cenaSprzedazy != other.cenaSprzedazy) {
            return false;
        }
        if (this.cenaDostawy != other.cenaDostawy) {
            return false;
        }
        if (this.iloscDostepna != other.iloscDostepna) {
            return false;
        }
        if (!Objects.equals(this.nazwa_herbaty, other.nazwa_herbaty)) {
            return false;
        }
        if (!Objects.equals(this.opis, other.opis)) {
            return false;
        }
        if (!Objects.equals(this.krajPochodzenia, other.krajPochodzenia)) {
            return false;
        }
        if (!Objects.equals(this.gatunekHerbaty, other.gatunekHerbaty)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Herbata{" + "id_herbaty=" + id_herbaty + ", nazwa_herbaty=" + nazwa_herbaty + ", opis=" + opis + ", cenaSprzedazy=" + cenaSprzedazy + ", cenaDostawy=" + cenaDostawy + ", iloscDostepna=" + iloscDostepna + ", krajPochodzenia=" + krajPochodzenia + ", gatunekHerbaty=" + gatunekHerbaty + '}';
    }

    

    

}
