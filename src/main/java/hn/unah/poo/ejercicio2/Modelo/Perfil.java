package hn.unah.poo.ejercicio2.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="perfil")
public class Perfil {
    

    @Id
    @Column(name="idperfil")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPerfil;

    private String rol;

    private String descripcion;

}
