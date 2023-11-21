package co.edu.uniquindio.clinica.services.implement;

import co.edu.uniquindio.clinica.dto.medico.*;
import co.edu.uniquindio.clinica.model.classes.*;
import co.edu.uniquindio.clinica.model.enums.EstadoCita;
import co.edu.uniquindio.clinica.repositories.*;
import co.edu.uniquindio.clinica.services.interfaces.MedicoServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicoServicioImpl implements MedicoServices {

    private final MedicoRepository medicoRepo;
    private final CitaRepository citaRepo;
    private final ConsultaRepository consultaRepo;
    private final DisponibilidadRepository disponibilidadRepo;
    private final HorarioRepository horarioRepo;
    private final PacienteRepository pacienteRepo;


    @Override
    public List<ItemCitaMedicoDTO> listarCitasPendientes(int codigoMedico, LocalDate dia) throws Exception {

        Medico medico = medicoRepo.findById(codigoMedico).orElseThrow( () -> new Exception("No existe el codigoMedico") );
        List<Cita> citas = citaRepo.findAllByMedico(medico);
        List<ItemCitaMedicoDTO> respuesta = new ArrayList<>();

        if(citas.isEmpty()){
            throw new Exception("No existen citas creadas");
        }

        for( Cita c : citas ){
            if(c.getFechaCita().equals(dia) && c.getEstado().equals(EstadoCita.PROGRAMADA)){
                respuesta.add( new ItemCitaMedicoDTO(
                        c.getCodigoCita(),
                        c.getPaciente().getNombre(),
                        c.getFechaCita(),
                        c.getHoraCita(),
                        c.getEstado()
                )  );
            }
        }



        return respuesta;

    }
/*
    Falta por programar
 */

    @Override
    public void atenderCita(RegistroConsultaDTO atencionMedica) throws Exception {

        Cita cita = citaRepo.findById(atencionMedica.codigoCita()).orElseThrow( () -> new Exception("No existe la cita") );

        cita.setEstado(atencionMedica.estadoCita());

        Consulta consulta = new Consulta();
        //Creo que no sirve para nada//consulta.setCodigoConsulta(1);
        consulta.setDiagnostico(atencionMedica.diagnosticoMedico());
        consulta.setNotasMedicas(atencionMedica.notasMedico());
        consulta.setTratamiento(atencionMedica.tratamientoMedico());
        consulta.setCita(cita);


        consultaRepo.save(consulta);
        citaRepo.save(cita);

    }

    public RegistroConsultaDTO cargarRegistro(int codigoCita) throws Exception {

        Cita cita = citaRepo.findById(codigoCita).orElseThrow( () -> new Exception("No existe la cita") );

        return new RegistroConsultaDTO(
                cita.getCodigoCita(),
                cita.getFechaCita().atTime(cita.getHoraCita()),
                "",
                "",
                "",
                cita.getMotivo(),
                cita.getEstado(),
                cita.getPaciente().getCodigo(),
                cita.getPaciente().getCedula(),
                cita.getPaciente().getNombre(),
                cita.getPaciente().getCorreo(),
                cita.getPaciente().getEPS(),
                cita.getPaciente().getTipoSangre(),
                cita.getPaciente().getAlergias()
        );

    }

    @Override
    public List<ItemCitaHistorialDTO> listarHistorialPaciente(int codigoPaciente) throws Exception {

        Paciente paciente = pacienteRepo.findById(codigoPaciente).orElseThrow( () -> new Exception("No existe el paciente") );
        List<Cita> citas = citaRepo.findAllByPaciente(paciente);
        List<ItemCitaHistorialDTO> respuesta = new ArrayList<>();

        if(citas.isEmpty()){
            throw new Exception("No existen citas creadas");
        }

        for( Cita c : citas ){
                respuesta.add( new ItemCitaHistorialDTO(
                        c.getCodigoCita(),
                        c.getFechaCita().atTime(c.getHoraCita()),
                        c.getMedico().getNombre(),
                        c.getMedico().getEspecialidad()
                )  );

        }

        return respuesta;

    }
/*

 */
    @Override
    public int agendarDiaLibre(DiaLibreDTO diaLibreDTO, int codigoMedico) throws Exception {

        Optional<Medico> medico = medicoRepo.findById(codigoMedico);
        if(medico.isEmpty()){
            throw new Exception("No existe el codigoMedico");
        }
        List<Disponibilidad> disponibilidades = disponibilidadRepo.findAllByMedico(medico.get());

        List<Cita> citas = citaRepo.findAllByMedico(medico.get());

        for( Cita c : citas ){
            if(c.getFechaCita().equals(diaLibreDTO.fecha())){
                throw new Exception("Ya existe una cita para ese dia");
            }
        }

        for( Disponibilidad d : disponibilidades ){
            if(d.getDia().equals(diaLibreDTO.fecha()) || d.getDia().isAfter(LocalDate.now())){
                throw new Exception("Ya existe una disponibilidad agendada para el codigoMedico");
            }
        }

        Disponibilidad disponibilidad = new Disponibilidad();
        disponibilidad.setDia(diaLibreDTO.fecha());
        disponibilidad.setMedico(medico.get());

        disponibilidadRepo.save(disponibilidad);
        return disponibilidad.getCodigoDisponibilidad();

    }

    @Override
    public List<ItemCitaRealizadaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception {

        Medico medico = medicoRepo.findById(codigoMedico).orElseThrow( () -> new Exception("No existe el codigoMedico") );
        List<Cita> citas = citaRepo.findAllByMedico(medico);
        List<ItemCitaRealizadaDTO> respuesta = new ArrayList<>();

        if(citas.isEmpty()){
            throw new Exception("No existen citas creadas");
        }

        for( Cita c : citas ){
            if(c.getEstado().equals(EstadoCita.COMPLETADA) || c.getEstado().equals(EstadoCita.CANCELADA) ){
                respuesta.add( new ItemCitaRealizadaDTO(
                        c.getFechaCita(),
                        c.getHoraCita(),
                        c.getPaciente().getNombre(),
                        c.getPaciente().getCedula()
                )  );
            }
        }

        return respuesta;
    }
}
