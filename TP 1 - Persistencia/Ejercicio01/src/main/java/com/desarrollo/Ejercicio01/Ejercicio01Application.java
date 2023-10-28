package com.desarrollo.Ejercicio01;

import com.desarrollo.Ejercicio01.Entidades.*;
import com.desarrollo.Ejercicio01.Enumeraciones.Estado;
import com.desarrollo.Ejercicio01.Enumeraciones.FormaDePago;
import com.desarrollo.Ejercicio01.Enumeraciones.TipoEnvio;
import com.desarrollo.Ejercicio01.Enumeraciones.TipoProducto;
import com.desarrollo.Ejercicio01.Repositorios.ClienteRepositorio;
import com.desarrollo.Ejercicio01.Repositorios.RubroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.text.SimpleDateFormat;
import java.util.Date;



@SpringBootApplication
public class Ejercicio01Application {

	//Añadir repositorios
	@Autowired
	ClienteRepositorio clienteRepositorio;
	@Autowired
	RubroRepositorio rubroRepositorio;


	public static void main(String[] args) {
		SpringApplication.run(Ejercicio01Application.class, args);
		System.out.println("Estoy funcionando");
	}

	@Bean
	CommandLineRunner init(ClienteRepositorio clienteRepositorio, RubroRepositorio rubroRepositorio) {
		return args -> {
			System.out.println("<-------Estoy funcionando------->");

			//Fechas
			SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
			String fechaString = "2023-09-12";

			Date fecha = formatoFecha.parse(fechaString);


			//Productos
			Producto producto = new Producto();
			producto.setTipo(TipoProducto.Insumo);
			producto.setTiempoEstimadoCocina(90);
			producto.setDenominacion("Ravioles");
			producto.setPrecioVenta(99.99);
			producto.setPrecioCompra(59.99);
			producto.setStockActual(10);
			producto.setStockMinimo(3);
			producto.setUnidadMedida("kg");
			producto.setReceta("Lorem");

			Producto producto1 = new Producto();
			producto1.setTipo(TipoProducto.Insumo);
			producto1.setTiempoEstimadoCocina(50);
			producto1.setDenominacion("Fideos");
			producto1.setPrecioVenta(79.99);
			producto1.setPrecioCompra(39.99);
			producto1.setStockActual(15);
			producto1.setStockMinimo(5);
			producto1.setUnidadMedida("kg");
			producto1.setReceta("Lorem");

			//Rubro
			Rubro rubro_uno = Rubro.builder()
					.denominacion("Pastas")
					.build();

			rubro_uno.agregarProducto(producto);
			rubro_uno.agregarProducto(producto1);

			rubroRepositorio.save(rubro_uno);

			//DetallePedido - usando método builder
			DetallePedido detallePedido = DetallePedido.builder()
					.cantidad(5)
					.subtotal(499.95)
					.build();

			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(159.98)
					.build();

			//Pedidos
			Pedido pedido = Pedido.builder()
					.total(499.95)
					.fecha(fecha)
					.tipoEnvio(TipoEnvio.Delivery)
					.estado(Estado.Entregado)
					.build();

			Pedido pedido1 = Pedido.builder()
					.total(159.98)
					.fecha(fecha)
					.tipoEnvio(TipoEnvio.RetiroEnLocal)
					.estado(Estado.EnPreparacion)
					.build();

			//Facturas
			Factura factura = Factura.builder()
					.numero(15)
					.fecha(fecha)
					.formaDePago(FormaDePago.Transferencia)
					.descuento(15)
					.total(424.96)
					.build();

			Factura factura1 = Factura.builder()
					.numero(16)
					.fecha(fecha)
					.formaDePago(FormaDePago.Efectivo)
					.descuento(30)
					.total(111.99)
					.build();

			pedido.agregarDetallePedido(detallePedido);
			pedido1.agregarDetallePedido(detallePedido1);

			detallePedido.setProducto(producto);
			detallePedido1.setProducto(producto1);

			pedido.setFactura(factura);
			pedido1.setFactura(factura1);


			//Cliente
			Cliente cliente = Cliente.builder()
					.nombre("Jackie")
					.apellido("MuyHombre")
					.telefono(261123456)
					.email("jackiemuyhombre@example.com")
					.build();

			//Domicilios
			Domicilio domicilio = Domicilio.builder()
					.calle("Independencia")
					.numero(321)
					.localidad("Las Heras")
					.build();

			Domicilio domicilio1 = Domicilio.builder()
					.calle("San Martín")
					.numero(123)
					.localidad("Godoy Cruz")
					.build();

			cliente.agregarDomicilio(domicilio);
			cliente.agregarDomicilio(domicilio1);

			cliente.agregarPedido(pedido);
			cliente.agregarPedido(pedido1);


			clienteRepositorio.save(cliente);

			Rubro rubroRecuperado = rubroRepositorio.findById(rubro_uno.getId()).orElse(null);
			if (rubroRecuperado != null) {
				System.out.println("Denominacion: " + rubroRecuperado.getDenominacion());
				rubroRecuperado.mostrarProducto();
			}
			Cliente clienteRecuperado = clienteRepositorio.findById(cliente.getId()).orElse(null);
			if (clienteRecuperado != null) {
				System.out.println("Nombre: " + clienteRecuperado.getNombre());
				System.out.println("Apellido: " + clienteRecuperado.getApellido());
				System.out.println("Telefono: " + clienteRecuperado.getTelefono());
				System.out.println("Email: " + clienteRecuperado.getEmail());
				clienteRecuperado.mostrarDomicilio();
				clienteRecuperado.mostrarPedido();
			}
		};
	}
}