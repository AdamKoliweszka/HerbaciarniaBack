package com.herbaciarnia.bean;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "PRACOWNICY")
public class Pracownik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_Pracownika;
    private String Imie;
    private String Nazwisko;
    private Date DataZatrudnienia;
    private Date DataZwolnienia;
    @OneToOne
    @JoinColumn(name = "id_uzytkownika")
    private Uzytkownik uzytkownik;
    public long getId() {
        return id_Pracownika;
    }

    public void setId(int id) {
        this.id_Pracownika = id;
    }

    public String getImie() {
        return Imie;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        Nazwisko = nazwisko;
    }

    public Date getDataZatrudnienia() {
        return DataZatrudnienia;
    }

    public void setDataZatrudnienia(Date dataZatrudnienia) {
        DataZatrudnienia = dataZatrudnienia;
    }

    public Date getDataZwolnienia() {
        return DataZwolnienia;
    }

    public void setDataZwolnienia(Date dataZwolnienia) {
        DataZwolnienia = dataZwolnienia;
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
        hash = 89 * hash + (int) (this.id_Pracownika ^ (this.id_Pracownika >>> 32));
        hash = 89 * hash + Objects.hashCode(this.Imie);
        hash = 89 * hash + Objects.hashCode(this.Nazwisko);
        hash = 89 * hash + Objects.hashCode(this.DataZatrudnienia);
        hash = 89 * hash + Objects.hashCode(this.DataZwolnienia);
        hash = 89 * hash + Objects.hashCode(this.uzytkownik);
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
        final Pracownik other = (Pracownik) obj;
        if (this.id_Pracownika != other.id_Pracownika) {
            return false;
        }
        if (!Objects.equals(this.Imie, other.Imie)) {
            return false;
        }
        if (!Objects.equals(this.Nazwisko, other.Nazwisko)) {
            return false;
        }
        if (!Objects.equals(this.DataZatrudnienia, other.DataZatrudnienia)) {
            return false;
        }
        if (!Objects.equals(this.DataZwolnienia, other.DataZwolnienia)) {
            return false;
        }
        if (!Objects.equals(this.uzytkownik, other.uzytkownik)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pracownik{" + "id=" + id_Pracownika + ", Imie=" + Imie + ", Nazwisko=" + Nazwisko + ", DataZatrudnienia=" + DataZatrudnienia + ", DataZwolnienia=" + DataZwolnienia + ", uzytkownik=" + uzytkownik + '}';
    }

    
    
}
