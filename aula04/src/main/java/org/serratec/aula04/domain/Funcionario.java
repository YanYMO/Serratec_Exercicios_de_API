package org.serratec.aula04.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table (name="funcionario")
public class Funcionario {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_funcionario")
    private Long id;

    @Size(max = 60, message = "O máximo de caracteres é 60")
    @Column(name = "nome", nullable = false, length = 60)
    private String nome;

    @Size(max = 30, message = "O máximo de caracteres é 30")
    @Column(name="cargo", nullable = false, length = 30)
    private String cargo;

    @NotNull(message = "O campo não pode ser nulo")
    @DecimalMin("0.01")
    @Column(name="salario_bruto", nullable = false, precision = 10, scale = 2)
    private BigDecimal salario;

    public Funcionario() {
    }

    public Funcionario(Long id, String cargo, BigDecimal salario) {
        this.id = id;
        this.cargo = cargo;
        this.salario = salario;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}
