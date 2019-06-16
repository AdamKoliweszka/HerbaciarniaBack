package com.herbaciarnia.bean;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "country_of_origin")
public class CountryOfOrigin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_country;

    @NotBlank(message = "Kraj pochodzenia herbaty musi posiadać nazwę!")
    @NotEmpty(message = "Kraj pochodzenia herbaty musi posiadać nazwę!")
    private String name;

    public long getId_country() {
        return id_country;
    }

    public void setId_country(long id_country) {
        this.id_country = id_country;
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
        CountryOfOrigin that = (CountryOfOrigin) o;
        return id_country == that.id_country &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_country, name);
    }

    @Override
    public String toString() {
        return "CountryOfOrigin{" +
                "id_country=" + id_country +
                ", name='" + name + '\'' +
                '}';
    }
}
