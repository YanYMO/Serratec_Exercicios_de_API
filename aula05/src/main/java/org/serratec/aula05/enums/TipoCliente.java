package org.serratec.aula05.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.serratec.aula05.exception.EnumClienteException;

public enum TipoCliente {
    PF,
    PJ;

    @JsonCreator
    public static TipoCliente verifica(String tipo) throws EnumClienteException {
        for (TipoCliente t: values()) {
            if (tipo.equals(t.name())) {
                return t;
            }
        }
        throw new EnumClienteException("O tipo de cliente não existe.");
    }
}
