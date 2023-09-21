package com.recorrido.ambiente.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Ambiente")
@Data
@NoArgsConstructor
public class Ambiente {
    
    @Id
    @Size(max=4 , min=4)
    @Column(name = "Id_Ambiente")
    private String id;

    @NotBlank
    private String descripcion;

    @NotBlank
    @Column(name = "Enlace_Foto")
    private String foto;

    @NotBlank
    private String contacto;

    @NotBlank
    private String horario;

    @NotBlank
    private String piso;

    @NotBlank
    private String referencia;

    @ManyToOne
    @JoinColumn(name = "Id_Area")
    @NotNull
    private Area area;

    @ManyToOne
    @JoinColumn(name = "Id_Pabellon")
    @NotNull
    private Pabellon pabellon;
}
