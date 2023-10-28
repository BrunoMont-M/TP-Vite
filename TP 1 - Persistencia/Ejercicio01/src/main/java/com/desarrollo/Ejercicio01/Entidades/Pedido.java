package com.desarrollo.Ejercicio01.Entidades;

import com.desarrollo.Ejercicio01.Enumeraciones.Estado;
import com.desarrollo.Ejercicio01.Enumeraciones.TipoEnvio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Estado estado;
    private Date fecha;
    private TipoEnvio tipoEnvio;
    private double total;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "Pedido_id")
    @Builder.Default
    private List<DetallePedido> detalles = new ArrayList<>();


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "factura_id")
    private Factura factura;



        public void agregarDetallePedido(DetallePedido detalleP) {

            detalles.add(detalleP);
        }
    }



