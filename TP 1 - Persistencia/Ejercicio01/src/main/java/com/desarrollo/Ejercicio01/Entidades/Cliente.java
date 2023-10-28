package com.desarrollo.Ejercicio01.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String apellido;
    private int telefono;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "Cliente_id")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "Cliente_id")
    @Builder.Default
    private List<Domicilio> domicilios = new ArrayList<>();

        public void agregarPedido(Pedido pedi2) {
            pedidos.add(pedi2);
        }

        public void agregarDomicilio(Domicilio domicilio) {
            domicilios.add(domicilio);
        }

        public void mostrarPedido() {
            System.out.println("Pedidos de " + nombre + " " + apellido + " " + telefono + " " + email + ":");
            for (Pedido pedido : pedidos) {
                System.out.println("Total: " + pedido.getTotal());
                System.out.println("Fecha: " + pedido.getFecha());
                System.out.println("Tipo de envío: " + pedido.getTipoEnvio());
                System.out.println("Estado: " + pedido.getEstado());
            }
        }

        public void mostrarDomicilio() {
            System.out.println("Domicilios de " + nombre + " " + apellido + ":");
            for (Domicilio domicilio : domicilios) {
                System.out.println("Calle: " + domicilio.getCalle() + "Numero: " + domicilio.getNumero());
            }
        }
}
