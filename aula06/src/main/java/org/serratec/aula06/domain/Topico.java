package org.serratec.aula06.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "topico")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 60)
    @Column(name = "titulo", nullable = false, length = 60)
    private String titulo;

    @NotNull(message = "O campos não foi preenchido corretamente.")
    @Column(name = "ordem", nullable = false)
    private Integer ordem;

    @NotNull(message = "O campos não foi preenchido corretamente.")
    @Min(0)
    @Column(name = "carga_horaria", nullable = false)
    private Integer cargaHoraria;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Topico(Long id, String titulo, Integer ordem, Integer cargaHoraria, Curso curso) {
        this.id = id;
        this.titulo = titulo;
        this.ordem = ordem;
        this.cargaHoraria = cargaHoraria;
        this.curso = curso;
    }

    public Topico() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
