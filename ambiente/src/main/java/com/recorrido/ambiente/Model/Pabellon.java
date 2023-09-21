package com.recorrido.ambiente.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Pabellon")
@Data
@NoArgsConstructor
public class Pabellon {
    
    @Id
    @Column(name = "Id_Pabellon")
    private String id;
    
    private String descripcion;
}
