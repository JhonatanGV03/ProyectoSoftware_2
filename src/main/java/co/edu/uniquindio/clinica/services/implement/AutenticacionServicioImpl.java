package co.edu.uniquindio.clinica.services.implement;

import co.edu.uniquindio.clinica.dto.LoginDTO;
import co.edu.uniquindio.clinica.dto.TokenDTO;
import co.edu.uniquindio.clinica.model.classes.Cuenta;
import co.edu.uniquindio.clinica.model.classes.Medico;
import co.edu.uniquindio.clinica.model.classes.Paciente;
import co.edu.uniquindio.clinica.repositories.CuentaRepository;
import co.edu.uniquindio.clinica.services.interfaces.AutenticacionServices;
import co.edu.uniquindio.clinica.utils.JWTUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AutenticacionServicioImpl implements AutenticacionServices {


    private final CuentaRepository cuentaRepo;
    private final JWTUtils jwtUtils;
    //HISTORIA 19 & 15
    @Override
    public TokenDTO login(LoginDTO loginDTO) throws Exception {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Optional<Cuenta> cuentaOptional = cuentaRepo.findByCorreo(loginDTO.correo());
        if(cuentaOptional.isEmpty()){
            throw new Exception("No existe el correo ingresado");
        }
        Cuenta cuenta = cuentaOptional.get();
        if( !passwordEncoder.matches(loginDTO.password(), cuenta.getPassword()) ){
            throw new Exception("La contraseña ingresada es incorrecta");
        }
        return new TokenDTO( crearToken(cuenta) );
    }
    private String crearToken(Cuenta cuenta){
        String rol;
        String nombre;
        if( cuenta instanceof Paciente){
            rol = "paciente";
            nombre = ((Paciente) cuenta).getNombre();
        }else if( cuenta instanceof Medico){
            rol = "codigoMedico";
            nombre = ((Medico) cuenta).getNombre();
        }else{
            rol = "admin";
            nombre = "Administrador";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("rol", rol);
        map.put("nombre", nombre);
        map.put("id", cuenta.getCodigo());
        return jwtUtils.generarToken(cuenta.getCorreo(), map);
    }
}
