package hn.unah.poo.ejercicio2.Controlador;

import org.springframework.web.bind.annotation.RestController;

import hn.unah.poo.ejercicio2.Modelo.Usuarios;
import hn.unah.poo.ejercicio2.Servicio.UsuarioServicio;
import hn.unah.poo.ejercicio2.dto.UsuarioDTO;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/usuario")
public class UsuariosController {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping("/crear/nuevo")
    public String crearUsuarios(@RequestBody UsuarioDTO nvoUsuario) {
        return usuarioServicio.crearUsuarios(nvoUsuario);
    }
    
    @DeleteMapping("/eliminar/{codigoUsuario}")
    public String eliminarUsuario(@PathVariable(name="codigoUsuario")String codigoUsuario){
        return usuarioServicio.eliminarUsuario(codigoUsuario);
    }

    @GetMapping("/obtener/codigoUsuario")
    public UsuarioDTO obtenerUsuario(@RequestParam(name="codigoUsuario") String codigoUsuario) {
        return usuarioServicio.obtenerUsuario(codigoUsuario);
    }
    
    @GetMapping("/obtener")
    public List<Usuarios> obtenerTodos() {
        return usuarioServicio.obtenerTodos();
    }
    

}
