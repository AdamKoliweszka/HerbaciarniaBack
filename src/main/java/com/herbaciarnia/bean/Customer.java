package com.herbaciarnia.bean;

import com.herbaciarnia.validator.RegistrationCustomerValidateGroup;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Null;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_customer;

    @NotBlank(groups = {RegistrationCustomerValidateGroup.class},message = "Imie jest wymagane!")
    @NotEmpty(groups = {RegistrationCustomerValidateGroup.class},message = "Imie jest wymagane!")
    private String name;

    @NotBlank(groups = {RegistrationCustomerValidateGroup.class},message = "Nazwisko jest wymagane!")
    @NotEmpty(groups = {RegistrationCustomerValidateGroup.class},message = "Nazwisko jest wymagane!")
    private String surname;

    @NotBlank(groups = {RegistrationCustomerValidateGroup.class},message = "Adres jest wymagany!")
    @NotEmpty(groups = {RegistrationCustomerValidateGroup.class},message = "Adres jest wymagany!")
    private String city;

    @NotBlank(groups = {RegistrationCustomerValidateGroup.class},message = "Adres jest wymagany!")
    @NotEmpty(groups = {RegistrationCustomerValidateGroup.class},message = "Adres jest wymagany!")
    private String street;

    @Valid()
    @OneToOne
    @JoinColumn(name = "username")
    private User user;

    public long getId_customer() {
        return id_customer;
    }

    public void setId_customer(long id_customer) {
        this.id_customer = id_customer;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id_customer == customer.id_customer &&
                Objects.equals(name, customer.name) &&
                Objects.equals(surname, customer.surname) &&
                Objects.equals(city, customer.city) &&
                Objects.equals(street, customer.street) &&
                Objects.equals(user, customer.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_customer, name, surname, city, street, user);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id_customer=" + id_customer +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", user=" + user +
                '}';
    }
}
