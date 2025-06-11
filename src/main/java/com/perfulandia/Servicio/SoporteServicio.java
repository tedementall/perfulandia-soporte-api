package com.perfulandia.Servicio;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.perfulandia.Repository.SoporteRepositorio;
import com.perfulandia.Dto.ServicioDto;
import com.perfulandia.Model.Soporte;

@Service
public class SoporteServicio {
    @Autowired
    private SoporteRepositorio soporteRepositorio;

    // 1. Obtener todos los tickets
    public List<ServicioDto> obtenerTodosLosTickets() {
        return soporteRepositorio.findAll().stream()
            .map(soporte -> {
                ServicioDto dto = new ServicioDto();
                dto.setId_ticket(soporte.getId_ticket());
                dto.setId_usuario(soporte.getId_usuario());
                dto.setTipo_ticket(soporte.getTipo_ticket());
                dto.setDescripcion(soporte.getDescripcion());
                dto.setEstado(soporte.getEstado());
                dto.setFecha_creacion(soporte.getFecha_creacion());
                dto.setFecha_resolucion(soporte.getFecha_resolucion());
                return dto;
            })
            .collect(Collectors.toList());
    }

    // 2. Crear un ticket de soporte
    public ServicioDto crearTicket(ServicioDto dto) {
        Soporte soporte = new Soporte();
        soporte.setId_usuario(dto.getId_usuario());
        soporte.setTipo_ticket(dto.getTipo_ticket());
        soporte.setDescripcion(dto.getDescripcion());
        soporte.setEstado(dto.getEstado());
        soporte.setFecha_creacion(dto.getFecha_creacion());
        soporte.setFecha_resolucion(dto.getFecha_resolucion());
        soporte = soporteRepositorio.save(soporte);

        dto.setId_ticket(soporte.getId_ticket());
        return dto;
    }

    // 3. Buscar ticket por ID
    public ServicioDto obtenerTicketPorId(Integer id) {
        Optional<Soporte> soporteOpt = soporteRepositorio.findById(id);
        if (soporteOpt.isPresent()) {
            Soporte soporte = soporteOpt.get();
            ServicioDto dto = new ServicioDto();
            dto.setId_ticket(soporte.getId_ticket());
            dto.setId_usuario(soporte.getId_usuario());
            dto.setTipo_ticket(soporte.getTipo_ticket());
            dto.setDescripcion(soporte.getDescripcion());
            dto.setEstado(soporte.getEstado());
            dto.setFecha_creacion(soporte.getFecha_creacion());
            dto.setFecha_resolucion(soporte.getFecha_resolucion());
            return dto;
        }
        return null;
    }

    // 4. Actualizar el estado de un ticket
    public boolean actualizarEstadoTicket(Integer id, String nuevoEstado) {
        Optional<Soporte> soporteOpt = soporteRepositorio.findById(id);
        if (soporteOpt.isPresent()) {
            Soporte soporte = soporteOpt.get();
            soporte.setEstado(nuevoEstado);
            soporteRepositorio.save(soporte);
            return true;
        }
        return false;
    }

    // 5. Eliminar un ticket
    public boolean eliminarTicket(Integer id) {
        if (soporteRepositorio.existsById(id)) {
            soporteRepositorio.deleteById(id);
            return true;
        }
        return false;
    }
}