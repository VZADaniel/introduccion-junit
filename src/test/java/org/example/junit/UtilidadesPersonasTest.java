package org.example.junit;

import org.example.Persona;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilidadesPersonasTest {
    private UtilidadesPersonas utils;

    @Before
    public void setUp() throws Exception {
        utils = new UtilidadesPersonas();
    }

    @Test
    public void getDaniel() {
        Persona daniel = utils.getDaniel();

        assertEquals("Daniel", daniel.getNombre());
        assertEquals("Vasquez", daniel.getApellido());
    }

    @Test
    public void getCarlos() {
        Persona carlos = utils.getCarlos();

        assertEquals("Carlos", carlos.getNombre());
        assertEquals("Caloa", carlos.getApellido());
    }

    @Test
    public void personasDiferentes() {
        Persona daniel = utils.getDaniel();
        Persona carlos = utils.getCarlos();

        assertNotEquals(daniel, carlos);
    }

    @Test
    public void getArrayPersonas() {
        Persona[] esperado = {utils.getDaniel(), utils.getCarlos()};
        Persona[] resultado = utils.getArrayPersonas();

        assertArrayEquals(esperado, resultado);
        assertEquals(2, resultado.length);
        assertEquals(esperado.length, resultado.length);

        assertEquals(esperado[0], resultado[0]);
        assertEquals(esperado[1], resultado[1]);

        assertNotEquals(esperado[0], resultado[1]);
        assertNotEquals(esperado[1], resultado[0]);
    }

    @Test
    public void testAssertTrue() {
        boolean verdadero = utils.getDaniel().getEdad() < utils.getCarlos().getEdad();
        boolean falso = utils.getDaniel().getEdad() > utils.getCarlos().getEdad();

        assertTrue("La asercion ha fallado para true", verdadero);
        assertFalse("La asercion ha fallado para false", falso);
    }

    @Test
    public void testAssertSame() {
        Persona daniel = utils.findPersona("Daniel");
        Persona carlos = utils.findPersona("Carlos");

        assertSame(daniel, utils.getDaniel());
        assertSame(carlos, utils.getCarlos());

        assertNotSame(daniel, utils.getCarlos());
        assertNotSame(carlos, utils.getDaniel());
    }
}