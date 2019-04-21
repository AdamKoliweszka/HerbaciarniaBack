package com.herbaciarnia.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_employee;
    private String name;
    private String surname;
    private Date date_of_employment;
    private Date date_of_dismissal;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "username")
    private User user;

    public long getId_employee() {
        return id_employee;
    }

    public void setId_employee(long id_employee) {
        this.id_employee = id_employee;
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

    public Date getDate_of_employment() {
        return date_of_employment;
    }

    public void setDate_of_employment(Date date_of_employment) {
        this.date_of_employment = date_of_employment;
    }

    public Date getDate_of_dismissal() {
        return date_of_dismissal;
    }

    public void setDate_of_dismissal(Date date_of_dismisal) {
        this.date_of_dismissal = date_of_dismisal;
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
        Employee employee = (Employee) o;
        return id_employee == employee.id_employee &&
                Objects.equals(name, employee.name) &&
                Objects.equals(surname, employee.surname) &&
                Objects.equals(date_of_employment, employee.date_of_employment) &&
                Objects.equals(date_of_dismissal, employee.date_of_dismissal) &&
                Objects.equals(user, employee.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_employee, name, surname, date_of_employment, date_of_dismissal, user);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id_employee=" + id_employee +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", date_of_employment=" + date_of_employment +
                ", date_of_dismisal=" + date_of_dismissal +
                ", user=" + user +
                '}';
    }
}
