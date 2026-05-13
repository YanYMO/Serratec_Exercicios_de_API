package org.serratec.aula04.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ErroResposta {
    private final Integer status;
    private final String titulo;
    private final LocalDateTime dataHora;
    private final List<String> erros;

    public ErroResposta(Integer status, String titulo, LocalDateTime dataHora, List<String> erros) {
        super();
        this.status = status;
        this.titulo = titulo;
        this.dataHora = dataHora;
        this.erros = erros;
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

    public List<String> getErros() {
        return erros;
    }
}
