package com.desarrollo.Ejercicio01.Entidades;

import com.desarrollo.Ejercicio01.Enumeraciones.FormaDePago;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int numero;
    private Date fecha;
    private double descuento;
    private FormaDePago formaDePago;
    private double total;
}
