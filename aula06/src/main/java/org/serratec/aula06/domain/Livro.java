package org.serratec.aula06.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo precisa ser preenchido")
    @Size(max = 50)
    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;

    @NotBlank(message = "O campo precisa ser preenchido")
    @Size(max = 13)
    @Column(name = "isbn", nullable = false, length = 13)
    private String isbn;

    @NotNull(message = "O campo precisa ser preenchido")
    @Column(name = "ano_de_publicacao", nullable = false)
    private Integer anoPublicacao;

    @NotNull(message = "O campo precisa ser preenchido")
    @DecimalMin(value = "9.90")
    @Column(name = "preco", nullable = false)
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "id_editora")
    @JsonBackReference
    private Editora editora;

    @OneToMany(mappedBy = "livro")
    @JsonManagedReference
    private List<Avaliacao> avaliacoes;

    public Livro(Long id, String titulo, String isbn, Integer anoPublicacao, BigDecimal preco, Editora editora, List<Avaliacao> avaliacoes) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.preco = preco;
        this.editora = editora;
        this.avaliacoes = avaliacoes;
    }

    public Livro() {
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
}
