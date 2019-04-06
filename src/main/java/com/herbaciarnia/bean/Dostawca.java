package com.herbaciarnia.bean;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "DOSTAWCY")
public class Dostawca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_dostawcy;
    private String imie;
    private String nazwisko;
    private String miejscowosc;
    private String ulica;
    private String numerKonta;

    public long getId() {
        return id_dostawcy;
    }

    public void setId(long id) {
        this.id_dostawcy = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNumerKonta() {
        return numerKonta;
    }

    public void setNumerKonta(String numerKonta) {
        this.numerKonta = numerKonta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (int) (this.id_dostawcy ^ (this.id_dostawcy >>> 32));
        hash = 83 * hash + Objects.hashCode(this.imie);
        hash = 83 * hash + Objects.hashCode(this.nazwisko);
        hash = 83 * hash + Objects.hashCode(this.miejscowosc);
        hash = 83 * hash + Objects.hashCode(this.ulica);
        hash = 83 * hash + Objects.hashCode(this.numerKonta);
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
        final Dostawca other = (Dostawca) obj;
        if (this.id_dostawcy != other.id_dostawcy) {
            return false;
        }
        if (!Objects.equals(this.imie, other.imie)) {
            return false;
        }
        if (!Objects.equals(this.nazwisko, other.nazwisko)) {
            return false;
        }
        if (!Objects.equals(this.miejscowosc, other.miejscowosc)) {
            return false;
        }
        if (!Objects.equals(this.ulica, other.ulica)) {
            return false;
        }
        if (!Objects.equals(this.numerKonta, other.numerKonta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dostawca{" + "id=" + id_dostawcy + ", imie=" + imie + ", nazwisko=" + nazwisko + ", miejscowosc=" + miejscowosc + ", ulica=" + ulica + ", numerKonta=" + numerKonta + '}';
    }
    
}
