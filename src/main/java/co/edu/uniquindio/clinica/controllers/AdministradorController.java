package co.edu.uniquindio.clinica.controllers;

import co.edu.uniquindio.clinica.dto.ItemPQRSDTO;
import co.edu.uniquindio.clinica.dto.MensajeDTO;
import co.edu.uniquindio.clinica.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.clinica.dto.administrador.*;
import co.edu.uniquindio.clinica.model.enums.EstadoPQRS;
import co.edu.uniquindio.clinica.services.interfaces.AdministradorServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdministradorController {
    private final AdministradorServices administradorService;

    //Autenticacion¿?
    @PostMapping("/crearAdmin")
    public ResponseEntity<MensajeDTO<String>> crearAdmin(@Valid @RequestBody RegistroAdminDTO admin) throws Exception{
        administradorService.crearAdmin(admin);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Administrador registrado correctamente"));
    }

    //Autenticacion¿?
    @PostMapping("/crearMedico")
    public ResponseEntity<MensajeDTO<Integer>> crearMedico(@Valid @RequestBody RegistroMedicoDTO medico) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, administradorService.crearMedico(medico)));
    }

    //Autenticacion¿?
    @PutMapping("/actualizarMedico")
    public ResponseEntity<MensajeDTO<Integer>> actualizarmedico(@Valid @RequestBody DetallesMedicoDTO medicoDTO) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, administradorService.actualizarmedico(medicoDTO)));
    }
    @DeleteMapping("/eliminarMedico/{codigo}")
    public ResponseEntity<MensajeDTO<String>> eliminarmedico(@PathVariable int codigo) throws Exception{
        administradorService.eliminarmedico(codigo);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Medico eliminado correctamente"));
    }

    @GetMapping("/listarMedicos")
    public ResponseEntity<MensajeDTO<List<ItemMedicoDTO>>> listarmedicos() throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, administradorService.listarmedicos()));
    }

    @GetMapping("/verDetallesMedico/{codigo}")
    public ResponseEntity<MensajeDTO<DetallesMedicoDTO>> obtenerMedico(@PathVariable int codigo) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, administradorService.obtenerMedico(codigo)));
    }

    @GetMapping("/listarPQRS")
    public ResponseEntity<MensajeDTO<List<ItemPQRSDTO>>> listarPQRS() throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, administradorService.listarPQRS()));
    }
    @GetMapping("/verDetallesPQRS/{codigo}")
    public ResponseEntity<MensajeDTO<DetallesPQRSAdminDTO>> verDetallesPQRS(@PathVariable int codigo) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, administradorService.verDetallesPQRS(codigo)));
    }

    @PostMapping("/responderPQRS")
    public ResponseEntity<MensajeDTO<Integer>> responderPQRS(@Valid @RequestBody RegistroRespuestaDTO registroRespuesta) throws Exception{
            return ResponseEntity.ok().body( new MensajeDTO<>(false, administradorService.responderPQRS(registroRespuesta)));
    }

    @PutMapping("/cambiarEstadoPQRS/{codigoPQRS}")
    public ResponseEntity<MensajeDTO<String>> cambiarEstadoPQRS(@PathVariable int codigoPQRS,@Valid @RequestBody EstadoPQRS estadoPQRS) throws Exception{
        administradorService.cambiarEstadoPQRS(codigoPQRS,estadoPQRS);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Estado de PQRS modificado correctamente"));
    }

    @GetMapping("/listarCitas")
    public ResponseEntity<MensajeDTO<List<ItemCitaAdminDTO>>> listarCitas() throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, administradorService.listarCitas()));
    }
}
