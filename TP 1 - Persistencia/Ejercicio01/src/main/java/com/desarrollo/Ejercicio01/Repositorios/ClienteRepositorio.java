package com.desarrollo.Ejercicio01.Repositorios;


import com.desarrollo.Ejercicio01.Entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
}
