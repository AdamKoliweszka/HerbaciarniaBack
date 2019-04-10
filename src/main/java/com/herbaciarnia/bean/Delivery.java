package com.herbaciarnia.bean;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "deliveries")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_delivery;
    @ManyToOne
    private Provider provider;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Tea tea;
    private int amount;
    @ManyToOne
    private TransactionStatus status;
    private Date date_of_delivery;

    public long getId_delivery() {
        return id_delivery;
    }

    public void setId_delivery(long id_delivery) {
        this.id_delivery = id_delivery;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Tea getTea() {
        return tea;
    }

    public void setTea(Tea tea) {
        this.tea = tea;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public Date getDate_of_delivery() {
        return date_of_delivery;
    }

    public void setDate_of_delivery(Date date_of_delivery) {
        this.date_of_delivery = date_of_delivery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return id_delivery == delivery.id_delivery &&
                amount == delivery.amount &&
                Objects.equals(provider, delivery.provider) &&
                Objects.equals(employee, delivery.employee) &&
                Objects.equals(tea, delivery.tea) &&
                Objects.equals(status, delivery.status) &&
                Objects.equals(date_of_delivery, delivery.date_of_delivery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_delivery, provider, employee, tea, amount, status, date_of_delivery);
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id_delivery=" + id_delivery +
                ", provider=" + provider +
                ", employee=" + employee +
                ", tea=" + tea +
                ", amount=" + amount +
                ", status=" + status +
                ", date_of_delivery=" + date_of_delivery +
                '}';
    }
}
