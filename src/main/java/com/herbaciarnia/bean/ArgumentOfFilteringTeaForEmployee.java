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

public class ArgumentOfFilteringTeaForEmployee extends ArgumentOfFilteringTea {
    private boolean avaible;
    private boolean unavaible;

    public boolean isAvaible() {
        return avaible;
    }

    public void setAvaible(boolean avaible) {
        this.avaible = avaible;
    }

    public boolean isUnavaible() {
        return unavaible;
    }

    public void setUnavaible(boolean unavaible) {
        this.unavaible = unavaible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArgumentOfFilteringTeaForEmployee that = (ArgumentOfFilteringTeaForEmployee) o;
        return priceFor == that.priceFor &&
                priceTo == that.priceTo &&
                avaible == that.avaible &&
                unavaible == that.unavaible &&
                Arrays.equals(species, that.species) &&
                Arrays.equals(countries, that.countries);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(priceFor, priceTo, avaible, unavaible);
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
                ", avaible=" + avaible +
                ", unavaible=" + unavaible +
                '}';
    }
}
