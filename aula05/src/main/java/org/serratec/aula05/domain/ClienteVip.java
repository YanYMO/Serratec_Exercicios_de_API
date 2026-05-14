package org.serratec.aula05.domain;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
@Table(name = "cliente_vip")
public class ClienteVip extends Cliente {

    @NotBlank
    @Column(name="consultor_responsavel", nullable = false, length = 50)
    private String consultorResponsavel;

    public ClienteVip(Long id, String nome, String cpf, String email, LocalDate dataNascimento, DocumentoCliente documentoCliente, String consultorResponsavel) {
        super(id, nome, cpf, email, dataNascimento, documentoCliente);
        this.consultorResponsavel = consultorResponsavel;
    }

    public ClienteVip() {
    }

    public String getConsultorResponsavel() {
        return consultorResponsavel;
    }

    public void setConsultorResponsavel(String consultorResponsavel) {
        this.consultorResponsavel = consultorResponsavel;
    }
}
