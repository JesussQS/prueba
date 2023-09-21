package com.recorrido.ambiente.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Area")
@Data
@NoArgsConstructor
public class Area {
    
    @Id
    @Column(name = "Id_Area")
    private Integer id;

    private String descripcion;
}
