package com.desarrollo.Ejercicio01.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetallePedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int cantidad;
    private double subtotal;


    @ManyToOne()
    @JoinColumn(name = "producto_id")
    private Producto producto;
}
