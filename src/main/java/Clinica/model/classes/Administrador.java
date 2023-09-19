package Clinica.model.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Administrador extends Cuenta implements Serializable {

    //Relaciones
    @OneToMany(mappedBy="codigoAdministrador")
    private List<Mensaje> mensajes;

}
