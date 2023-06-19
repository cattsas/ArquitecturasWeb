package com.venta.DTO;

public class DTOProductReport {
    private int id_product;
    private String name_product;
    private long amount;

    public DTOProductReport(int id_product, String name_product, long amount) {
        this.id_product = id_product;
        this.name_product = name_product;
        this.amount = amount;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
