package com.venta.DTO;

public class DTOClientsReport {
    private int id_cliente;
    private String name;
    private String last_name;
    private double total;

    public DTOClientsReport(int id_cliente, String name, String last_name, double total) {
        this.id_cliente = id_cliente;
        this.name = name;
        this.last_name = last_name;
        this.total = total;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
