package com.venta.DTO;

public class DTOProductMoreSale {
    private int id_product;
    private long amount;

    public DTOProductMoreSale(int id_product, long amount) {
        this.id_product = id_product;
        this.amount = amount;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
