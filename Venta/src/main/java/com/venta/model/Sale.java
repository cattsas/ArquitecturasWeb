package com.venta.model;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_venta;

    @Column (name="id_cliente",nullable=false)
    private int id_client;

    @Column(name="id_producto", nullable = false)
    private int id_product;

    @Column(name="Fecha",nullable=false)
    private Date fecha;
    @Column(name="Precio",nullable=false)
    private double price;

    @Column(name="Cantidad",nullable = false)
    private int cantidad;
    //JPA necesita un constructor vacío para convertir la fila DB en un objeto Java.
    public Sale() {
        //super();
    }

    public Sale(int id_client, int id_product, String fecha, double price, int cantidad) {
        this.id_client = id_client;
        this.id_product = id_product;
        this.fecha = new Date(fecha);
        this.price = price;
        this.cantidad = cantidad;
    }

    public int getId_venta() {
        return id_venta;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
