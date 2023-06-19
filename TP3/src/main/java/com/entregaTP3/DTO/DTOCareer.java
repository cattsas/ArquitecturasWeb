package com.entregaTP3.DTO;

import java.io.Serializable;

public class DTOCareer implements Serializable {

    private int id_career;
    private String name;
    private long quantity;

    public DTOCareer(int id_career, String name, long quantity) {
        this.id_career = id_career;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId_career() {
        return id_career;
    }

    public void setId_career(int id_career) {
        this.id_career = id_career;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "DTOCareer{" +
                "id_career=" + id_career +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
