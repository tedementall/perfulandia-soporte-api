package com.perfulandia.Dto;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ServicioDto {
 private Integer id_ticket;
 private Integer id_usuario;
 private String tipo_ticket;
 private String descripcion;
 private String estado;
 private String fecha_creacion;
 private String fecha_resolucion;
}
