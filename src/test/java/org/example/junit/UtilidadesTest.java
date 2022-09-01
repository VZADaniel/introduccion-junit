package org.example.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UtilidadesTest {
    @Parameterized.Parameters
    public static Collection<Object[]> datos() {
        return Arrays.asList(new Object[][]{
                {1, 2}, {3, 5}, {0, 4}, {8, 4}, {1, 3}
        });
    }

    private int v1;
    private int v2;
    private Utilidades utilidades = new Utilidades();

    public UtilidadesTest(int v1, int v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    @Test
    public void suma() {
        System.out.println("Los parametros son: v1=" + v1 + " v2=" + v2);
        int resultado = utilidades.sumaNumeros(v1, v2);
        Assert.assertEquals(v1 + v2, resultado);
    }

    @Test
    public void concatenar() {
        String resultado = utilidades.concatenar("Hola", "Mundo");
        Assert.assertEquals("Las cadenas son diferentes", "Hola Mundo", resultado);
    }

    @Test
    public void concatenarFallo() {
        String resultado = utilidades.concatenar("Hola", "Mundo");
        Assert.assertEquals("Las cadenas son diferentes", "Hola Mundo", resultado);
    }

    @Test
    public void concatenarError() {
        String resultado = utilidades.concatenar(null, "Mundo");
        Assert.assertEquals("Las cadenas son diferentes", null, resultado);
    }
}