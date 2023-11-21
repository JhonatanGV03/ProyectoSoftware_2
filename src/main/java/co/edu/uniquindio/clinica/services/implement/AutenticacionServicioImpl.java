package co.edu.uniquindio.clinica.services.implement;

import co.edu.uniquindio.clinica.dto.LoginDTO;
import co.edu.uniquindio.clinica.dto.TokenDTO;
import co.edu.uniquindio.clinica.model.classes.Cuenta;
import co.edu.uniquindio.clinica.model.classes.Medico;
import co.edu.uniquindio.clinica.model.classes.Paciente;
import co.edu.uniquindio.clinica.model.enums.EstadoUsuario;
import co.edu.uniquindio.clinica.repositories.CuentaRepository;
import co.edu.uniquindio.clinica.repositories.MedicoRepository;
import co.edu.uniquindio.clinica.repositories.PacienteRepository;
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
    private final PacienteRepository pacienteRepo;
    private final MedicoRepository medicoRepo;
    private final JWTUtils jwtUtils;

    @Override
    public TokenDTO login(LoginDTO loginDTO) throws Exception {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Optional<Cuenta> cuentaOptional = cuentaRepo.findByCorreo(loginDTO.correo());
        if (cuentaOptional.isEmpty()) {
            throw new Exception("No existe el correo ingresado");
        }
        Cuenta cuenta = cuentaOptional.get();
        if (!passwordEncoder.matches(loginDTO.password(), cuenta.getPassword())) {
            throw new Exception("La contraseña ingresada es incorrecta");
        }


        /*
        Validación de cuenta inactiva
         */
        Optional<Paciente> pacienteOptional = pacienteRepo.findById(cuenta.getCodigo());
        if (!pacienteOptional.isEmpty()) {
            if (pacienteOptional.get().getEstado() == EstadoUsuario.INACTIVO) {
                throw new Exception("Esta cuenta esta inactiva");
            }
        }

        Optional<Medico> medicoOptional = medicoRepo.findById(cuenta.getCodigo());
        if (!medicoOptional.isEmpty()) {
            if (medicoOptional.get().getEstado() == EstadoUsuario.INACTIVO) {
                throw new Exception("Esta cuenta esta inactiva");

            }
        }


        Map<String, Object> map = crearToken(cuenta);
        String jwtToken = jwtUtils.generarToken(cuenta.getCorreo(), map);
        String refreshToken = jwtUtils.generateRefreshToken(cuenta.getCorreo(), map);
        return new TokenDTO(jwtToken, refreshToken);

    }

    private Map crearToken(Cuenta cuenta) {
        String rol;
        String nombre;
        if (cuenta instanceof Paciente) {
            rol = "paciente";
            nombre = ((Paciente) cuenta).getNombre();
        } else if (cuenta instanceof Medico) {
            rol = "medico";
            nombre = ((Medico) cuenta).getNombre();
        } else {
            rol = "admin";
            nombre = "Administrador";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("rol", rol);
        map.put("nombre", nombre);
        map.put("id", cuenta.getCodigo());
        return map;
    }

    @Override
    public TokenDTO refreshToken(TokenDTO tokenDTO) throws Exception {
        try {
            String email = jwtUtils.parseJwt(tokenDTO.refreshToken()).getBody().getSubject();
            Optional<Cuenta> cuentaOptional = cuentaRepo.findByCorreo(email);
            if (cuentaOptional.isEmpty()) {
                throw new Exception("No existe el correo ingresado");
            }
            Cuenta cuenta = cuentaOptional.get();
            Map<String, Object> map = crearToken(cuenta);
            String jwtToken = jwtUtils.generarToken(cuenta.getCorreo(), map);
            return new TokenDTO(jwtToken, tokenDTO.refreshToken());
        } catch (Exception e) {
            throw new Exception("El token de refresco no es valido");
        }
    }
}
