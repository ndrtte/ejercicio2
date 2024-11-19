package hn.unah.poo.ejercicio2.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.poo.ejercicio2.Modelo.Usuarios;

public interface UsuarioRepositorio extends JpaRepository<Usuarios,String>{
    
}
