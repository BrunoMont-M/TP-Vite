package com.desarrollo.Ejercicio01.Entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rubro implements Serializable {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String denominacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "rubro_id")
    @Builder.Default
    private List<Producto> productos = new ArrayList<>();


        public void agregarProducto(Producto producto) {

            productos.add(producto);
        }

        public void mostrarProducto() {
            System.out.println("Productos de este rubro: ");
            for (Producto producto : productos) {
                System.out.println("Denomincacion: " + producto.getDenominacion());
                System.out.println("Tipo: " + producto.getTipo());
                System.out.println("Tiempo estimado de cocina: " + producto.getTiempoEstimadoCocina());
                System.out.println("Unidad de medida: " + producto.getUnidadMedida());
                System.out.println("Stock minimo: " + producto.getStockMinimo());
                System.out.println("Stock actual: " + producto.getStockActual());
                System.out.println("Precio de venta: " + producto.getPrecioVenta());
                System.out.println("Precio de compra: " + producto.getPrecioCompra());
                System.out.println("Receta: " + producto.getReceta());
            }
        }

}