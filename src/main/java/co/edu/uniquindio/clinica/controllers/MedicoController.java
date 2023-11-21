package co.edu.uniquindio.clinica.controllers;

import co.edu.uniquindio.clinica.dto.MensajeDTO;
import co.edu.uniquindio.clinica.dto.medico.*;
import co.edu.uniquindio.clinica.services.interfaces.MedicoServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/medicos")
public class MedicoController {
    private final MedicoServices medicoService;

    @GetMapping("/citasPendientes/{codigoMedico}/{dia}")
    public ResponseEntity<MensajeDTO<List<ItemCitaMedicoDTO>>> listarCitasPendientes(@PathVariable int codigoMedico, @PathVariable LocalDate dia) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, medicoService.listarCitasPendientes(codigoMedico, dia)));
    }
    @PostMapping("/atencionCita")
    public ResponseEntity<MensajeDTO<String>> atenderCita(@Valid @RequestBody RegistroConsultaDTO atencionMedica) throws Exception{
        medicoService.atenderCita(atencionMedica);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Cita atendida correctamente"));
    }
    @GetMapping("/carga_Cita/{codigoCita}")
    public ResponseEntity<MensajeDTO<RegistroConsultaDTO>> cargarRegistro(@PathVariable int codigoCita) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, medicoService.cargarRegistro(codigoCita)));
    }
    @GetMapping("/cargaHistorialPaciente/{codigoPaciente}")
    public ResponseEntity<MensajeDTO<List<ItemCitaHistorialDTO>>> listarHistorialPaciente(@PathVariable int codigoPaciente) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, medicoService.listarHistorialPaciente(codigoPaciente)));
    }
    @PostMapping("/agendarDiaLibre/{codigoMedico}")
    public ResponseEntity<MensajeDTO<Integer>> agendarDiaLibre(@Valid @RequestBody DiaLibreDTO diaLibreDTO,@PathVariable int codigoMedico) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, medicoService.agendarDiaLibre(diaLibreDTO, codigoMedico)));
    }
    @GetMapping("/citasRealizadas/{codigoMedico}")
    public ResponseEntity<MensajeDTO<List<ItemCitaRealizadaDTO>>> listarCitasRealizadasMedico(@PathVariable int codigoMedico) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, medicoService.listarCitasRealizadasMedico(codigoMedico)));
    }
}
