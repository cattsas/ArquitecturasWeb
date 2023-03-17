package com.venta.DTO;

public class DTOReportShoppingClient {

    private int id_client;
    private double amount;

    public DTOReportShoppingClient(int id_client, double amount) {
        this.id_client = id_client;
        this.amount = amount;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "DTOReporteShoppingClient{" +
                "id_client=" + id_client +
                ", amount=" + amount +
                '}';
    }
}
