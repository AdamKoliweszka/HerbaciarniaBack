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

public class ArgumentOfFilteringTea {
    protected int priceFor;
    protected int priceTo;
    protected TeaSpecies[] species;
    protected CountryOfOrigin[] countries;

    public int getPriceFor() {
        return priceFor;
    }

    public void setPriceFor(int priceFor) {
        this.priceFor = priceFor;
    }

    public int getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(int priceTo) {
        this.priceTo = priceTo;
    }

    public TeaSpecies[] getSpecies() {
        return species;
    }

    public void setSpecies(TeaSpecies[] species) {
        this.species = species;
    }

    public CountryOfOrigin[] getCountries() {
        return countries;
    }

    public void setCountries(CountryOfOrigin[] countries) {
        this.countries = countries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArgumentOfFilteringTea that = (ArgumentOfFilteringTea) o;
        return priceFor == that.priceFor &&
                priceTo == that.priceTo &&
                Arrays.equals(species, that.species) &&
                Arrays.equals(countries, that.countries);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(priceFor, priceTo);
        result = 31 * result + Arrays.hashCode(species);
        result = 31 * result + Arrays.hashCode(countries);
        return result;
    }

    @Override
    public String toString() {
        return "ArgumentOfFilteringTeaForEmployee{" +
                "priceFor=" + priceFor +
                ", priceTo=" + priceTo +
                ", species=" + Arrays.toString(species) +
                ", countries=" + Arrays.toString(countries) +
                '}';
    }
}
