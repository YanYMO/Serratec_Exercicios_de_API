package org.serratec.aula06.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "avaliacao")
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank()
    @Size(max = 500)
    @Column(name = "comentario", nullable = false, length = 500)
    private String comentario;

    @NotNull()
    @Min(1) @Max(5)
    @Column(name = "nota", nullable = false)
    private Integer nota;

    @CreationTimestamp
    @Column(name = "data_avaliacao", updatable = false)
    private LocalDate dataAvaliacao;

    @ManyToOne
    @JoinColumn(name = "id_livro")
    @JsonBackReference
    private Livro livro;

    public Avaliacao(Long id, String comentario, Integer nota, LocalDate data, Livro livro) {
        this.id = id;
        this.comentario = comentario;
        this.nota = nota;
        this.dataAvaliacao = data;
        this.livro = livro;
    }

    public Avaliacao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public LocalDate getData() {
        return dataAvaliacao;
    }

    public void setData(LocalDate data) {
        this.dataAvaliacao = data;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
