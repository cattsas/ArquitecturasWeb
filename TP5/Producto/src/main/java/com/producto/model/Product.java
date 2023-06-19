package com.producto.model;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_product;

    @Column(name="Nombre",nullable=false)
    private String name;
    @Column(name="Precio",nullable=false)
    private double price;
    
    //JPA necesita un constructor vacío para convertir la fila DB en un objeto Java.
    public Product() {
        //super();
    }

    public Product(String name, double price) {
        //super();
        this.name = name;
        this.price = price;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
