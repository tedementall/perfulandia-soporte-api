package com.perfulandia.Dto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@NoArgsConstructor
public class ServicioDto extends RepresentationModel<ServicioDto> {
 private Integer id_ticket;
 private Integer id_usuario;
 private String tipo_ticket;
 private String descripcion;
 private String estado;
 private String fecha_creacion;
 private String fecha_resolucion;

 public Integer getId() {
        return id_ticket;
    }

    public void setId(Integer id) {
        this.id_ticket = id;
    }
}
