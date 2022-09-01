package org.example.junit;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class UtilidadesDosTest {
    private Utilidades utilidades = new Utilidades();

    @Test
    @Parameters({"a,b,c", "d,e,f", "g,h,i", "j,k,l"})
    public void concatenarTres(String valor1, String valor2, String valor3) {
        System.out.println("valor 1: " + valor1 + " valor 2: " + valor2 + " valor 3: " + valor3);
        String resultado = utilidades.concatenarTres(valor1, valor2, valor3);
        String expect = valor1.concat(" ").concat(valor2).concat(" ").concat(valor3);
        Assert.assertEquals("Las cadenas son diferentes", expect, resultado);
    }

}