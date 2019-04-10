package com.herbaciarnia.bean;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "providers")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_provider;
    private String name;
    private String surname;
    private String city;
    private String street;
    private String account_number;

    public long getId_provider() {
        return id_provider;
    }

    public void setId_provider(long id_provider) {
        this.id_provider = id_provider;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Provider provider = (Provider) o;
        return id_provider == provider.id_provider &&
                Objects.equals(name, provider.name) &&
                Objects.equals(surname, provider.surname) &&
                Objects.equals(city, provider.city) &&
                Objects.equals(street, provider.street) &&
                Objects.equals(account_number, provider.account_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_provider, name, surname, city, street, account_number);
    }

    @Override
    public String toString() {
        return "Provider{" +
                "id_provider=" + id_provider +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", account_number='" + account_number + '\'' +
                '}';
    }
}
