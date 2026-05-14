package org.serratec.aula05.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.serratec.aula05.enums.StatusCliente;
import org.serratec.aula05.enums.TipoCliente;

@Embeddable
public class DocumentoCliente {

    @NotNull (message = "O campo precisa ser preenchido")
    @Column (name="cpf_cnpj", nullable = false, length = 20)
    private String cpfOuCnpj;

    @NotBlank (message = "O campo precisa ser preenchido")
    @Column (name="rg_ie", nullable = false, length = 20)
    private String rgInscricaoEstadual;

    @NotNull(message = "O campo precisa ser preenchido")
    @Column (name="tipo_de_cliente", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoCliente tipoCliente;

    @NotNull (message = "O campo precisa ser preenchido")
    @Column (name="status_do_cliente", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusCliente statusCliente;

    public DocumentoCliente() {
    }

    public DocumentoCliente(String cpfOuCnpj, String rgInscricaoEstadual, TipoCliente tipoCliente, StatusCliente statusCliente) {
        this.cpfOuCnpj = cpfOuCnpj;
        this.rgInscricaoEstadual = rgInscricaoEstadual;
        this.tipoCliente = tipoCliente;
        this.statusCliente = statusCliente;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public String getRgInscricaoEstadual() {
        return rgInscricaoEstadual;
    }

    public void setRgInscricaoEstadual(String rgInscricaoEstadual) {
        this.rgInscricaoEstadual = rgInscricaoEstadual;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public StatusCliente getStatusCliente() {
        return statusCliente;
    }

    public void setStatusCliente(StatusCliente statusCliente) {
        this.statusCliente = statusCliente;
    }
}