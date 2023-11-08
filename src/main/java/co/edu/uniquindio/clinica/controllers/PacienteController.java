package co.edu.uniquindio.clinica.controllers;

import co.edu.uniquindio.clinica.dto.ItemPQRSDTO;
import co.edu.uniquindio.clinica.dto.MensajeDTO;
import co.edu.uniquindio.clinica.dto.NewPasswordDTO;
import co.edu.uniquindio.clinica.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.clinica.dto.paciente.*;
import co.edu.uniquindio.clinica.services.interfaces.PacienteServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pacientes")
public class PacienteController {
    private final PacienteServices pacienteService;

    @GetMapping("/detalle/{codigoPaciente}")
    public ResponseEntity<MensajeDTO<DetallePacienteDTO>> verDetallePaciente(@PathVariable int codigoPaciente) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteService.verDetallePaciente(codigoPaciente)));
    }

    @PutMapping("/editar")
    public ResponseEntity<MensajeDTO<String>> editarPerfil(@Valid @RequestBody DetallePacienteDTO pacienteDTO) throws Exception{
        pacienteService.editarPerfil(pacienteDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Perfil modificado correctamente"));
    }

    @DeleteMapping("/eliminar/{codigoPaciente}")
    public ResponseEntity<MensajeDTO<String>> eliminarCuenta(@PathVariable int codigoPaciente) throws Exception{
        pacienteService.eliminarCuenta(codigoPaciente);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Cuenta eliminada correctamente"));
    }

    @GetMapping("/listar-pacientes")
    public ResponseEntity<MensajeDTO<List<ItemPacienteDTO>>> listarPacientes() throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteService.listarPacientes()));
    }

    @PutMapping("/cambiar-password")
    public ResponseEntity<MensajeDTO<String>> cambiarPassword(@Valid @RequestBody NewPasswordDTO newPasswordDTO) throws Exception{
        pacienteService.cambiarPassword(newPasswordDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Contraseña modificada correctamente"));
    }

    @PostMapping("/crear-pqrs")
    public ResponseEntity<MensajeDTO<String>> crearPQRS(@Valid @RequestBody PQRSPacienteDTO PQRSPacienteDTO) throws Exception{
        pacienteService.crearPQRS(PQRSPacienteDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "PQRS creado correctamente"));
    }

    @GetMapping("/listar-pqrs/{codigoPaciente}")
    public ResponseEntity<MensajeDTO<List<ItemPQRSDTO>>> listarPQRSPaciente(@PathVariable int codigoPaciente) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteService.listarPQRSPaciente(codigoPaciente)));
    }

    @GetMapping("/detalles-pqrs/{codigo}")
    public ResponseEntity<MensajeDTO<DetallesPQRSDTO>> verDetallesPQRS(@PathVariable int codigo) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteService.verDetallesPQRS(codigo)));
    }

    @PostMapping("/responder-pqrs") //Puede ser put
    public ResponseEntity<MensajeDTO<String>> responderPQRS(@Valid @RequestBody RegistroRespuestaDTO registroRespuestaDTO) throws Exception{
        pacienteService.responderPQRS(registroRespuestaDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Respuesta registrada correctamente"));
    }

    @PostMapping("/agendar-cita")
    public ResponseEntity<MensajeDTO<String>> agendarCita(@Valid @RequestBody RegistroCitaDTO registroCitaDTO) throws Exception{
        pacienteService.agendarCita(registroCitaDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Cita agendada correctamente"));
    }

    @GetMapping("/detalles-cita/{codigo}")
    public ResponseEntity<MensajeDTO<DetallesCitaDTO>> verDetallesCita(@PathVariable int codigo) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteService.verDetallesCita(codigo)));
    }

    @GetMapping("/listar-citas/{codigoPaciente}")
    public ResponseEntity<MensajeDTO<List<ItemCitaDTO>>> listarCitasPaciente(@PathVariable int codigoPaciente) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteService.listarCitasPaciente(codigoPaciente)));
    }

    @GetMapping("detalles-consulta/{codigo}")
    public ResponseEntity<MensajeDTO<DetallesConsultaDTO>> verDetalleConsulta(@PathVariable int codigo) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteService.verDetalleConsulta(codigo)));
    }

    @GetMapping("/listar-cita/{codigoPaciente}/{fecha}")  //No me convencen los nombres
    public ResponseEntity<MensajeDTO<List<ItemCitaDTO>>> filtrarCitasPacientePorFecha(@PathVariable LocalDate fecha,@PathVariable int codigoPaciente) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteService.filtrarCitasPacientePorFecha(fecha,codigoPaciente)));
    }

    @GetMapping("/listar-cita-medico/{codigoPaciente}/{codigoMedico}")
    public ResponseEntity<MensajeDTO<List<ItemCitaDTO>>> filtrarCitasPacientePorMedico(@PathVariable int codigoMedico,@PathVariable int codigoPaciente) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteService.filtrarCitasPacientePorMedico(codigoMedico,codigoPaciente)));
    }
}
