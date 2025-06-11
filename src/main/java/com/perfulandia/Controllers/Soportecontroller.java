package com.perfulandia.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.perfulandia.Servicio.SoporteServicio;
import com.perfulandia.Dto.ServicioDto;

@RestController
@RequestMapping("/api/soporte")
public class Soportecontroller {

    @Autowired
    private SoporteServicio soporteServicio;

    // 1. Obtener todos los tickets
    @GetMapping
    public List<ServicioDto> obtenerTodos() {
        return soporteServicio.obtenerTodosLosTickets();
    }

    // 2. Crear un ticket
    @PostMapping
    public ServicioDto crear(@RequestBody ServicioDto dto) {
        return soporteServicio.crearTicket(dto);
    }

    // 3. Buscar ticket por ID
    @GetMapping("/{id}")
    public ServicioDto obtenerPorId(@PathVariable Integer id) {
        return soporteServicio.obtenerTicketPorId(id);
    }

    // 4. Actualizar estado de un ticket
    @PutMapping("/{id}/estado")
    public boolean actualizarEstado(@PathVariable Integer id, @RequestParam String estado) {
        return soporteServicio.actualizarEstadoTicket(id, estado);
    }

    // 5. Eliminar un ticket
    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable Integer id) {
        return soporteServicio.eliminarTicket(id);
    }
}