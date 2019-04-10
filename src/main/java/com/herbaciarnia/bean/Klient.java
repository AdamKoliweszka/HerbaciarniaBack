package com.herbaciarnia.bean;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "KLIENCI")
public class Klient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_klienta;

    private String imie;

    private String nazwisko;

    private String miejscowosc;

    private String ulica;
   
    private String dataUsunieciaKonta;
    @OneToOne
    @JoinColumn(name = "username")
    private Uzytkownik uzytkownik;

    public long getId() {
        return id_klienta;
    }

    public void setId(int id) {
        this.id_klienta = id;
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

    public String getDataUsunieciaKonta() {
        return dataUsunieciaKonta;
    }

    public void setDataUsunieciaKonta(String dataUsunieciaKonta) {
        this.dataUsunieciaKonta = dataUsunieciaKonta;
    }

    public Uzytkownik getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(Uzytkownik uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (int) (this.id_klienta ^ (this.id_klienta >>> 32));
        hash = 13 * hash + Objects.hashCode(this.imie);
        hash = 13 * hash + Objects.hashCode(this.nazwisko);
        hash = 13 * hash + Objects.hashCode(this.miejscowosc);
        hash = 13 * hash + Objects.hashCode(this.ulica);
        hash = 13 * hash + Objects.hashCode(this.dataUsunieciaKonta);
        hash = 13 * hash + Objects.hashCode(this.uzytkownik);
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
        final Klient other = (Klient) obj;
        if (this.id_klienta != other.id_klienta) {
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
        if (!Objects.equals(this.dataUsunieciaKonta, other.dataUsunieciaKonta)) {
            return false;
        }
        if (!Objects.equals(this.uzytkownik, other.uzytkownik)) {
            return false;
        }
        return true;
    }

    
}
