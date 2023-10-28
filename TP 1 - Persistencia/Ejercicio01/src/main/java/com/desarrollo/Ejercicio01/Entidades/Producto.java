package com.desarrollo.Ejercicio01.Entidades;

import com.desarrollo.Ejercicio01.Enumeraciones.TipoEnvio;
import com.desarrollo.Ejercicio01.Enumeraciones.TipoProducto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private TipoProducto Tipo;
    private int TiempoEstimadoCocina;
    private String Denominacion;
    private double PrecioVenta;
    private double PrecioCompra;
    private int StockActual;
    private int StockMinimo;
    private String UnidadMedida;
    private String Receta;
}
