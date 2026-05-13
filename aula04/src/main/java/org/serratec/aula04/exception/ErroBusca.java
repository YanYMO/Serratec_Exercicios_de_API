package org.serratec.aula04.exception;

import java.time.LocalDateTime;

public class ErroBusca {
    private final Integer status;
    private final String titulo;
    private final LocalDateTime dataHora;

    public ErroBusca(Integer status, String titulo, LocalDateTime dataHora) {
        this.status = status;
        this.titulo = titulo;
        this.dataHora = dataHora;
    }

    public Integer getStatus() {
        return status;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}
