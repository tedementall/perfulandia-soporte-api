package com.perfulandia.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.perfulandia.Servicio.SoporteServicio;
import com.perfulandia.Dto.ServicioDto;
import org.springframework.hateoas.*;

@RestController
@RequestMapping("/api/soporte")
public class Soportecontroller {

    @Autowired
    private SoporteServicio soporteServicio;

    
    @GetMapping
    public List<ServicioDto> obtenerTodos() {
        return soporteServicio.obtenerTodosLosTickets();
    }

    
    @PostMapping
    public ServicioDto crear(@RequestBody ServicioDto dto) {
        return soporteServicio.crearTicket(dto);
    }

    
    @GetMapping("/{id}")
    public ServicioDto obtenerPorId(@PathVariable Integer id) {
        return soporteServicio.obtenerTicketPorId(id);
    }

    
    @PutMapping("/{id}/estado")
    public boolean actualizarEstado(@PathVariable Integer id, @RequestParam String estado) {
        return soporteServicio.actualizarEstadoTicket(id, estado);
    }

    
    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable Integer id) {
        return soporteServicio.eliminarTicket(id);
    }

    @GetMapping("/hateoas/{id}")
    public ServicioDto obtenerHATEOAS(@PathVariable Integer id) {
        ServicioDto dto = soporteServicio.obtenerTicketPorId(id);
        dto.add(Link.of("http://localhost:8888/api/proxy/soporte/" + dto.getId()).withSelfRel());
        dto.add(Link.of("http://localhost:8888/api/proxy/soporte/" + dto.getId()).withRel("Modificar HATEOAS").withType("PUT"));
        dto.add(Link.of("http://localhost:8888/api/proxy/soporte/" + dto.getId()).withRel("Eliminar HATEOAS").withType("DELETE"));

        return dto;
    }
 
    @GetMapping("/hateoas")
    public List<ServicioDto> obtenerTodosHATEOAS() {
        List<ServicioDto> lista = soporteServicio.obtenerTodosLosTickets();

        for (ServicioDto dto : lista) {
            
            dto.add(Link.of("http://localhost:8888/api/proxy/soporte").withRel("Get todos HATEOAS"));
            dto.add(Link.of("http://localhost:8888/api/proxy/soporte/" + dto.getId()).withRel("Crear HATEOAS").withType("POST"));
        }

        return lista;
    }
    //andru please
}