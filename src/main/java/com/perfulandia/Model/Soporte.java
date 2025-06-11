package com.perfulandia.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name= "soporte")
@Data
public class Soporte {

  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ticket;
    
 private Integer id_usuario;
 private String tipo_ticket;
 private String descripcion;
 private String estado;
 private String fecha_creacion;
 private String fecha_resolucion;
}
