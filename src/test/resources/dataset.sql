insert into cuenta values(1, 'admin1@gmail.com', '$2a$10$l1.STX20K90ekS3.Duf8OevSIJeUd9zZe/0ltF4Ag6LAJ.1P4gWlm');
insert into cuenta values(2, 'admin2@gmail.com', '$2a$10$l1.STX20K90ekS3.Duf8OevSIJeUd9zZe/0ltF4Ag6LAJ.1P4gWlm');
insert into cuenta values(3, 'paciente1@gmail.com', '$2a$10$l1.STX20K90ekS3.Duf8OevSIJeUd9zZe/0ltF4Ag6LAJ.1P4gWlm');
insert into cuenta values(4, 'paciente2@gmail.com', '$2a$10$l1.STX20K90ekS3.Duf8OevSIJeUd9zZe/0ltF4Ag6LAJ.1P4gWlm');
insert into cuenta values(5, 'paciente3@gmail.com', '$2a$10$l1.STX20K90ekS3.Duf8OevSIJeUd9zZe/0ltF4Ag6LAJ.1P4gWlm');
insert into cuenta values(6, 'paciente4@gmail.com', '$2a$10$l1.STX20K90ekS3.Duf8OevSIJeUd9zZe/0ltF4Ag6LAJ.1P4gWlm');
insert into cuenta values(7, 'paciente5@gmail.com', '$2a$10$l1.STX20K90ekS3.Duf8OevSIJeUd9zZe/0ltF4Ag6LAJ.1P4gWlm');
insert into cuenta values(8, 'medico1@gmail.com', '$2a$10$l1.STX20K90ekS3.Duf8OevSIJeUd9zZe/0ltF4Ag6LAJ.1P4gWlm');
insert into cuenta values(9, 'medico2@gmail.com', '$2a$10$l1.STX20K90ekS3.Duf8OevSIJeUd9zZe/0ltF4Ag6LAJ.1P4gWlm');
insert into cuenta values(10, 'medico3@gmail.com', '$2a$10$l1.STX20K90ekS3.Duf8OevSIJeUd9zZe/0ltF4Ag6LAJ.1P4gWlm');
insert into cuenta values(11, 'medico4@gmail.com', '$2a$10$l1.STX20K90ekS3.Duf8OevSIJeUd9zZe/0ltF4Ag6LAJ.1P4gWlm');
insert into cuenta values(12, 'medico5@gmail.com', '$2a$10$l1.STX20K90ekS3.Duf8OevSIJeUd9zZe/0ltF4Ag6LAJ.1P4gWlm');
insert into cuenta values(13, 'paciente6@gmail,com', '$2a$10$l1.STX20K90ekS3.Duf8OevSIJeUd9zZe/0ltF4Ag6LAJ.1P4gWlm');
insert into cuenta values(14, 'medico6@gmail,com', '$2a$10$l1.STX20K90ekS3.Duf8OevSIJeUd9zZe/0ltF4Ag6LAJ.1P4gWlm');

insert into administrador values(1);
insert into administrador values(2);

insert into paciente values('24567234', 0, 0, 'Darly de Guarni', '5454545', 'url_foto', 0, 'Sin alergias', '1990-01-01', 0, 3);
insert into paciente values('87625145', 1, 0, 'Yhonatan de Valeria', '8989898', 'url_foto', 1, 'Perros', '1990-01-01', 1, 4);
insert into paciente values('87921354', 2, 0, 'Julian de Camila', '7878787', 'url_foto', 2, 'Los lacteos', '1990-01-01', 2, 5);
insert into paciente values('10384951', 3, 0, 'Juan Manuel de caracas', '6565656', 'url_foto', 3, 'Sin alergias', '1990-01-01', 3, 6);
insert into paciente values('95132016', 4, 0, 'Jhojan de la Ex', '2323232', 'url_foto', 4, 'acetaminofen', '1990-01-01', 4, 7);
insert into paciente values('12345678', 5, 0, 'Cristian de DanielaDia', '2323232', 'url_foto', 5, 'acetaminofen', '1990-01-01', 5, 13);

insert into medico values('13684632', 0, 0, 'Pepito Perez', '1019521', 'url_foto', 0, 8);
insert into medico values('98412055', 1, 0, 'Fernando Salazar', '0545025', 'url_foto', 1, 9);
insert into medico values('57136548', 2, 0, 'Mateo Duque', '9851421', 'url_foto', 2, 10);
insert into medico values('10134554', 3, 0, 'Sebastian Coy', '3468912', 'url_foto', 3, 11);
insert into medico values('79842001', 4, 0, 'Daniela Idalgo', '7951320', 'url_foto', 4, 12);
insert into medico values('12345678', 5, 0, 'Juan de la Ex', '2323232', 'url_foto', 5, 14);

insert into disponibilidad values(1, '2023-10-10', 8);
insert into disponibilidad values(2, '2023-10-10', 9);
insert into disponibilidad values(3, '2023-10-10', 10);
insert into disponibilidad values(4, '2023-10-10', 11);
insert into disponibilidad values(5, '2023-10-10', 12);

insert into horario values(1, 'MONDAY', '12:00:00','08:00:00', 8);
insert into horario values(2, 'TUESDAY', '12:00:00','07:00:00', 9);
insert into horario values(3, 'WEDNESDAY', '18:00:00','14:00:00', 10);
insert into horario values(4, 'THURSDAY', '17:00:00','13:00:00', 11);
insert into horario values(5, 'FRIDAY', '08:00:00','06:00:00', 12);

insert into registro_recordatorio values(1, 0, '2023-10-21');
insert into registro_recordatorio values(2, 1, '2023-10-23');
insert into registro_recordatorio values(3, 0, '2023-10-23');
insert into registro_recordatorio values(4, 0, '2023-10-24');
insert into registro_recordatorio values(5, 1, '2023-10-26');
insert into registro_recordatorio values(6, 0, '2023-10-26');

insert into cita values(1, 0, '2023-10-25', '2023-10-15', '11:00:00', 'Motivo1', 9, 4, 1);
insert into cita values(2, 0, '2023-10-23', '2023-10-16', '11:00:00', 'Motivo2', 8, 6, 2);
insert into cita values(3, 2, '2023-10-25', '2023-10-17', '11:00:00', 'Motivo3', 10, 13, 3);
insert into cita values(4, 1, '2023-10-26', '2023-10-19', '11:00:00', 'Motivo4', 11, 5, 4);
insert into cita values(5, 0, '2023-10-25', '2023-10-19', '11:00:00', 'Motivo5', 12, 4, 5);
insert into cita values(6, 0, '2023-10-27', '2023-10-20', '11:00:00', 'Motivo6', 14, 13, 6);

insert into consulta values(1, 'Diagnostico1', 'NotasMedico1','Tratamiento1', 1);
insert into consulta values(2, 'Diagnostico2', 'NotasMedico2','Tratamiento2', 2);
insert into consulta values(3, 'Diagnostico3', 'NotasMedico3','Tratamiento3', 3);
insert into consulta values(4, 'Diagnostico4', 'NotasMedico4','Tratamiento4', 4);
insert into consulta values(5, 'Diagnostico5', 'NotasMedico5','Tratamiento5', 5);

insert into pqrs values(1, 0, '2023-10-22','Motivo1', 0, 1);
insert into pqrs values(2, 1, '2023-10-23','Motivo2', 1, 2);
insert into pqrs values(3, 2, '2023-10-24','Motivo3', 2, 3);
insert into pqrs values(4, 3, '2023-10-25','Motivo4', 3, 4);
insert into pqrs values(5, 1, '2023-10-26','Motivo5', 0, 5);
insert into pqrs values(6, 1, '2023-10-26','Motivo5', 0, 6);


insert into mensaje values(1, '2023-10-20','Mensaje1', 1, 1);
insert into mensaje values(2, '2023-10-21','Mensaje2', 2, 1);
insert into mensaje values(3, '2023-10-22','Mensaje3', 3, 1);
insert into mensaje values(4, '2023-10-23','Mensaje4', 4, 1);
insert into mensaje values(5, '2023-10-24','Mensaje5', 5, 1);


