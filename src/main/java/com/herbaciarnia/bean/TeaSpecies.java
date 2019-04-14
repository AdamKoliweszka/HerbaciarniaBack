package com.herbaciarnia.bean;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "tea_species")
public class TeaSpecies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_species;
    private String name;

    public long getId_species() {
        return id_species;
    }

    public void setId_species(long id_species) {
        this.id_species = id_species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeaSpecies that = (TeaSpecies) o;
        return id_species == that.id_species &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_species, name);
    }

    @Override
    public String toString() {
        return "TeaSpecies{" +
                "id_species=" + id_species +
                ", name='" + name + '\'' +
                '}';
    }
}
