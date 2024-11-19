package hn.unah.poo.ejercicio2.Servicio;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.poo.ejercicio2.Modelo.Usuarios;
import hn.unah.poo.ejercicio2.Repositorio.UsuarioRepositorio;
import hn.unah.poo.ejercicio2.dto.UsuarioDTO;
import hn.unah.poo.ejercicio2.modelmapper.ModelMapperSingleton;


@Service
public class UsuarioServicio {
    
    private ModelMapper modelMapper = ModelMapperSingleton.getInstancia();

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public String crearUsuarios(UsuarioDTO nvoUsuario) {
        if (usuarioRepositorio.existsById(nvoUsuario.getCodigoUsuario())){
            return "Este usuario ya existe";
        }
        Usuarios usuarioBD = new Usuarios();
        usuarioBD = modelMapper.map(nvoUsuario, Usuarios.class);
        usuarioRepositorio.save(usuarioBD);
        return "Este usuario ha sido creado con exito";
    }

    public String eliminarUsuario(String codigoUsuario){
        if(!usuarioRepositorio.existsById(codigoUsuario)){
            return "El usuario no existe";
        }
        usuarioRepositorio.deleteById(codigoUsuario);
        return "El usuario ha sido borrado con exito";
    }

    public UsuarioDTO obtenerUsuario(String codigoUsuario) {
        Optional <Usuarios> usuario = usuarioRepositorio.findById(codigoUsuario);
        UsuarioDTO usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
        return usuarioDTO;
    }

    public List<Usuarios> obtenerTodos() {
        return this.usuarioRepositorio.findAll();
    }
    

}
