package com.herbaciarnia.bean;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_purchase;
    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "id_tea")
    private Tea tea;
    private int amount;
    @ManyToOne
    @JoinColumn(name = "id_status")
    private TransactionStatus status;
    private Date date_of_purchase;

    public long getId_purchase() {
        return id_purchase;
    }

    public void setId_purchase(long id_purchase) {
        this.id_purchase = id_purchase;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public Date getDate_of_purchase() {
        return date_of_purchase;
    }

    public void setDate_of_purchase(Date date_of_purchase) {
        this.date_of_purchase = date_of_purchase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return id_purchase == purchase.id_purchase &&
                amount == purchase.amount &&
                Objects.equals(customer, purchase.customer) &&
                Objects.equals(employee, purchase.employee) &&
                Objects.equals(tea, purchase.tea) &&
                Objects.equals(status, purchase.status) &&
                Objects.equals(date_of_purchase, purchase.date_of_purchase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_purchase, customer, employee, tea, amount, status, date_of_purchase);
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id_purchase=" + id_purchase +
                ", customer=" + customer +
                ", employee=" + employee +
                ", tea=" + tea +
                ", amount=" + amount +
                ", status=" + status +
                ", date_of_purchase=" + date_of_purchase +
                '}';
    }
}
