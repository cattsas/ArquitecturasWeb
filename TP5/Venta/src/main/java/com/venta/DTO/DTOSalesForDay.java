package com.venta.DTO;

import java.util.Date;

public class DTOSalesForDay {

    private Date date;
    private long quantity;
    private double amount;

    public DTOSalesForDay(Date date, long quantity, double amount) {
        this.date =date;
        this.quantity = quantity;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "DTOSalesForDay{" +
                "date='" + date + '\'' +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }
}
