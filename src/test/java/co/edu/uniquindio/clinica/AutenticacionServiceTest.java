package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.dto.LoginDTO;
import co.edu.uniquindio.clinica.dto.TokenDTO;
import co.edu.uniquindio.clinica.services.interfaces.AutenticacionServices;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional
public class AutenticacionServiceTest {

    @Autowired
    private AutenticacionServices autenticacionServices;


    @Test
    @Sql("classpath:dataset.sql")
    public void loginTest() throws Exception {
        LoginDTO autenticar = new LoginDTO("admin1@gmail.com", "1234");
        TokenDTO token = autenticacionServices.login(autenticar);
        System.out.println(token);
        Assertions.assertNotNull(token);
    }


    @Test //Not a tester, just a "tool"
    public void encriptador() throws Exception{
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncriptada = passwordEncoder.encode("12345" );
        System.out.println(passwordEncriptada);
    }
}
