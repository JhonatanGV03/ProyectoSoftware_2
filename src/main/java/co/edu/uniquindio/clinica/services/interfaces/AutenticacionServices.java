package co.edu.uniquindio.clinica.services.interfaces;

import co.edu.uniquindio.clinica.dto.LoginDTO;
import co.edu.uniquindio.clinica.dto.TokenDTO;

public interface AutenticacionServices {
    TokenDTO login(LoginDTO loginDTO) throws Exception;
}
