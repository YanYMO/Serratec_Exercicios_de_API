package org.serratec.aula06.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "editora")
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo precisa ser preenchido")
    @Size(max = 80)
    @Column(name="nome", nullable = false, length = 80)
    private String nome;

    @NotBlank(message = "O campo precisa ser preenchido")
    @Size(max = 18)
    @Column(name = "cnpj", nullable = false, length = 18)
    private String cnpj;

    @NotBlank(message = "O campo precisa ser preenchido")
    @Size(max = 60)
    @Column(name = "cidade", nullable = false, length = 60)
    private String cidade;

    @JsonManagedReference
    @OneToMany(mappedBy = "editora")
    private List<Livro> livros;

    public Editora(Long id, String nome, String cnpj, String cidade, List<Livro> livros) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.livros = livros;
    }

    public Editora() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
