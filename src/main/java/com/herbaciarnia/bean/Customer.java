package com.herbaciarnia.bean;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_customer;

    private String name;

    private String surname;

    private String city;

    private String street;
   
    private String dateOfDeletingAccount;
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

    public String getDateOfDeletingAccount() {
        return dateOfDeletingAccount;
    }

    public void setDateOfDeletingAccount(String dateOfDeletingAccount) {
        this.dateOfDeletingAccount = dateOfDeletingAccount;
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
                Objects.equals(dateOfDeletingAccount, customer.dateOfDeletingAccount) &&
                Objects.equals(user, customer.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_customer, name, surname, city, street, dateOfDeletingAccount, user);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id_customer=" + id_customer +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", dateOfDeletingAccount='" + dateOfDeletingAccount + '\'' +
                ", user=" + user +
                '}';
    }
}