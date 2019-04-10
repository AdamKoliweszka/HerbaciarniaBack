/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.bean;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author user
 */

public class ArgumentWyszukiwaniaHerbaty {
    private int cenaOd;
    private int cenaDo;
    private TeaSpecies[] gatunki;
    private CountryOfOrigin[] kraje;
    private boolean czyDostepne;
    private boolean czyNiedostepne;

    public ArgumentWyszukiwaniaHerbaty()
    {
        //CountryOfOrigin kraj = new CountryOfOrigin();
        //kraj.setId_kraju(4);
        //kraj.setNazwa_kraju("Brazylia");
        //kraj.setId_kraju(1);
        //kraj.setNazwa_kraju("Niezdefiniowany");
        
        //kraje = new ArrayList();
        //kraje.add(kraj);
    }
    
    public int getCenaOd() {
        return cenaOd;
    }

    public void setCenaOd(int cenaOd) {
        this.cenaOd = cenaOd;
    }

    public int getCenaDo() {
        return cenaDo;
    }

    public void setCenaDo(int cenaDo) {
        this.cenaDo = cenaDo;
    }

    public TeaSpecies[] getGatunki() {
        return gatunki;
    }

    public void setGatunki(TeaSpecies[] gatunki) {
        this.gatunki = gatunki;
    }

    public CountryOfOrigin[] getKraje() {
        return kraje;
    }

    public void setKraje(CountryOfOrigin[] kraje) {
        this.kraje = kraje;
    }

    public boolean isCzyDostepne() {
        return czyDostepne;
    }

    public void setCzyDostepne(boolean czyDostepne) {
        this.czyDostepne = czyDostepne;
    }

    public boolean isCzyNiedostepne() {
        return czyNiedostepne;
    }

    public void setCzyNiedostepne(boolean czyNiedostepne) {
        this.czyNiedostepne = czyNiedostepne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArgumentWyszukiwaniaHerbaty that = (ArgumentWyszukiwaniaHerbaty) o;
        return cenaOd == that.cenaOd &&
                cenaDo == that.cenaDo &&
                czyDostepne == that.czyDostepne &&
                czyNiedostepne == that.czyNiedostepne &&
                Arrays.equals(gatunki, that.gatunki) &&
                Arrays.equals(kraje, that.kraje);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(cenaOd, cenaDo, czyDostepne, czyNiedostepne);
        result = 31 * result + Arrays.hashCode(gatunki);
        result = 31 * result + Arrays.hashCode(kraje);
        return result;
    }

    @Override
    public String toString() {
        return "ArgumentWyszukiwaniaHerbaty{" +
                "cenaOd=" + cenaOd +
                ", cenaDo=" + cenaDo +
                ", gatunki=" + Arrays.toString(gatunki) +
                ", kraje=" + Arrays.toString(kraje) +
                ", czyDostepne=" + czyDostepne +
                ", czyNiedostepne=" + czyNiedostepne +
                '}';
    }
}
