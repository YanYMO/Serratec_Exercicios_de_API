package org.serratec.aula06.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campos não foi preenchido corretamente.")
    @Size(max = 80)
    @Column(name = "nome", nullable = false, length = 80)
    private String nome;

    @NotBlank(message = "O campos não foi preenchido corretamente.")
    @Size(max = 50)
    @Email()
    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @NotNull(message = "O campos não foi preenchido corretamente.")
    @CPF()
    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;

    @ManyToMany(mappedBy = "alunos")
    @JsonIgnoreProperties("alunos")
    private List<Curso> cursos;

    public Aluno(Long id, String nome, String email, String cpf, List<Curso> cursos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.cursos = cursos;
    }

    public Aluno() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
