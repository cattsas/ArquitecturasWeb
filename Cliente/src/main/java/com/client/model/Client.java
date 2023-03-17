package com.client.model;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_client;

    @Column(name="Nombre",nullable=false)
    private String name;
    @Column(name="Apellido",nullable=false)
    private String lastname;
    
    //JPA necesita un constructor vacío para convertir la fila DB en un objeto Java.
    public Client() {
        //super();
    }

    public Client(String name, String lastname) {
        //super();
        this.name = name;
        this.lastname = lastname;
    }

    public int getId_client() {
        return id_client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
