package org.serratec.aula05.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.serratec.aula05.exception.EnumClienteException;

public enum StatusCliente {
    ATIVO,
    INATIVO,
    BLOQUEADO;

    @JsonCreator
    public static StatusCliente verifica(String status) throws EnumClienteException {
        for (StatusCliente s: values()) {
            if (status.equals(s.name())) {
                return s;
            }
        }
        throw new EnumClienteException("O status de cliente não existe.");
    }
}
