package co.edu.uniquindio.clinica.controllers;

import co.edu.uniquindio.clinica.dto.MensajeDTO;
import co.edu.uniquindio.clinica.dto.administrador.ItemMedicoDTO;
import co.edu.uniquindio.clinica.model.enums.*;
import co.edu.uniquindio.clinica.services.interfaces.ClinicaServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clinica")
public class ClinicaContoller {
    private final ClinicaServices clinicaServices;

    @GetMapping("/lista-ciudades")
    public ResponseEntity<MensajeDTO<List<Ciudad>>> listarCiudades() throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, clinicaServices.listarCiudades()));
    }

    @GetMapping("/lista-tipo-sangre")
    public ResponseEntity<MensajeDTO<List<TipoSangre>>> listarTipoSangre() throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, clinicaServices.listarTipoSangre()));
    }

    @GetMapping("/lista-especialidad")
    public ResponseEntity<MensajeDTO<List<Especialidad>>> listarEspecialidad() throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, clinicaServices.listarEspecialidad()));
    }

    @GetMapping("/lista-eps")
    public ResponseEntity<MensajeDTO<List<EPS>>> listarEPS() throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, clinicaServices.listarEPS()));
    }
    @GetMapping("/lista-tipos-PQRS")
    public ResponseEntity<MensajeDTO<List<TipoPQRS>>> listarTiposPQRS() throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, clinicaServices.listarTiposPQRS()));
    }
    @GetMapping("/lista-medicos")
    public ResponseEntity<MensajeDTO<List<ItemMedicoDTO>>> listarMedicos() throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, clinicaServices.listarMedicos()));
    }


}
