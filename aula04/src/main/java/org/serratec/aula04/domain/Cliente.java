package org.serratec.aula04.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Entity
@Table (name="cliente")
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private Long id;

    @Size (max = 60, message = "O máximo de caracteres é 60")
    @Column(name="nome", nullable=true, length=60)
    private String nome;

    @NotBlank (message = "O campo não pode ser nulo")
    @CPF (message = "CPF inválido ou já cadastrado")
    @Column(name="cpf",  nullable=false, length=11, unique=true)
    private String cpf;

    @NotBlank (message = "O campo não pode ser nulo")
    @Size (max = 50, message = "O máximo de caracteres é 50")
    @Email (message = "O campo não foi preenchido com um e-mail")
    @Column(name="email", nullable=false, length=50)
    private String email;

    @NotNull (message = "O campo não pode ser nulo")
    @Column(name="data_nascimento", nullable=false)
    private LocalDate dataNascimento;

    public Cliente(Long id, String nome, String cpf, String email, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public Cliente() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
