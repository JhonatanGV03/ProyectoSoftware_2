package co.edu.uniquindio.clinica.controllers;

import co.edu.uniquindio.clinica.dto.ImagenDTO;
import co.edu.uniquindio.clinica.dto.MensajeDTO;
import co.edu.uniquindio.clinica.services.interfaces.ImagenesServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Map;
@RestController
@RequestMapping("/api/imagenes")
@RequiredArgsConstructor
public class ImagenesController {
    private final ImagenesServices imagenesService;
    @PostMapping("/subir")
    public ResponseEntity<MensajeDTO<Map>> subirImagen(@RequestParam("file") MultipartFile imagen) throws Exception{
        Map respuesta = imagenesService.subirImagen(imagen);

        return ResponseEntity.ok().body(new MensajeDTO<>(false, respuesta ));
    }
    @DeleteMapping("/eliminar")
    public ResponseEntity<MensajeDTO<Map>> eliminarImagen(@RequestBody ImagenDTO imagenDTO) throws Exception{
        Map respuesta = imagenesService.eliminarImagen( imagenDTO.id() );

        return ResponseEntity.ok().body(new MensajeDTO<>(false, respuesta ));
    }
}