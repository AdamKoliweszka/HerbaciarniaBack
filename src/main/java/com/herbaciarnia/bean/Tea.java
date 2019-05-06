package com.herbaciarnia.bean;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tea")
public class Tea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_tea;

    @NotBlank(message = "Herbata musi posiadać nazwe!")
    @NotEmpty(message = "Herbata musi posiadać nazwe!")
    private String name;

    @NotBlank(message = "Herbata musi posiadać opis!")
    @NotEmpty(message = "Herbata musi posiadać opis!")
    private String description;

    @Min(value = 0,message = "Cena musi być dodatnia")
    private int price_of_selling;

    @Min(value = 0,message = "Cena musi być dodatnia")
    private int price_of_delivery;

    private int available_quantity;

    @NotNull(message = "Herbata musi mieć przypisany kraj pochodzenia!")
    @ManyToOne
    @JoinColumn(name = "id_country")
    private CountryOfOrigin country_of_origin;

    @NotNull(message = "Herbata musi mieć przypisany gatunek!")
    @ManyToOne
    @JoinColumn(name = "id_species")
    private TeaSpecies tea_species;

    public long getId_tea() {
        return id_tea;
    }

    public void setId_tea(long id_tea) {
        this.id_tea = id_tea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice_of_selling() {
        return price_of_selling;
    }

    public void setPrice_of_selling(int price_of_selling) {
        this.price_of_selling = price_of_selling;
    }

    public int getPrice_of_delivery() {
        return price_of_delivery;
    }

    public void setPrice_of_delivery(int price_of_delivery) {
        this.price_of_delivery = price_of_delivery;
    }

    public int getAvailable_quantity() {
        return available_quantity;
    }

    public void setAvailable_quantity(int available_quantity) {
        this.available_quantity = available_quantity;
    }

    public CountryOfOrigin getCountry_of_origin() {
        return country_of_origin;
    }

    public void setCountry_of_origin(CountryOfOrigin country_of_origin) {
        this.country_of_origin = country_of_origin;
    }

    public TeaSpecies getTea_species() {
        return tea_species;
    }

    public void setTea_species(TeaSpecies tea_species) {
        this.tea_species = tea_species;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tea tea = (Tea) o;
        return id_tea == tea.id_tea &&
                price_of_selling == tea.price_of_selling &&
                price_of_delivery == tea.price_of_delivery &&
                available_quantity == tea.available_quantity &&
                Objects.equals(name, tea.name) &&
                Objects.equals(description, tea.description) &&
                Objects.equals(country_of_origin, tea.country_of_origin) &&
                Objects.equals(tea_species, tea.tea_species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_tea, name, description, price_of_selling, price_of_delivery, available_quantity, country_of_origin, tea_species);
    }

    @Override
    public String toString() {
        return "Tea{" +
                "id_tea=" + id_tea +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price_of_selling=" + price_of_selling +
                ", price_of_delivery=" + price_of_delivery +
                ", available_quantity=" + available_quantity +
                ", country_of_origin=" + country_of_origin +
                ", tea_species=" + tea_species +
                '}';
    }
}
