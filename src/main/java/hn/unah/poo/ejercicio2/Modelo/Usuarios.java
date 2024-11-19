package hn.unah.poo.ejercicio2.Modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="usuario")
public class Usuarios {
    
    @Id
    @Column(name="codigousuario")
    private String codigoUsuario;
    
    private String nombre;
    
    private String apellido;

    private String departamento;

    private String correo;
    
    private String telefono;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idperfil",referencedColumnName = "idperfil")
    private Perfil perfil;
}
