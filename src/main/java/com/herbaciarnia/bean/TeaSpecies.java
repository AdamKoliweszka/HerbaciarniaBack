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
    private long id_Species;
    private String name;

    public long getId_Species() {
        return id_Species;
    }

    public void setId_Species(long id_Species) {
        this.id_Species = id_Species;
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
        return id_Species == that.id_Species &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_Species, name);
    }

    @Override
    public String toString() {
        return "TeaSpecies{" +
                "id_Species=" + id_Species +
                ", name='" + name + '\'' +
                '}';
    }
}
