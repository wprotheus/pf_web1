package com.wprotheus.utils;

import static java.util.Objects.isNull;

public class ValidaCampo {
    public static boolean valido(String conteudo)
    {
        if(!conteudo.isBlank() && !isNull(conteudo))
            return true;
        else
            return false;
    }
}