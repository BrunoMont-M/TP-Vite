package com.desarrollo.Ejercicio01.Repositorios;

import com.desarrollo.Ejercicio01.Entidades.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroRepositorio extends JpaRepository<Rubro, Long> {
}
