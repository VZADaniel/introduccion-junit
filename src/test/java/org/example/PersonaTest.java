package org.example;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PersonaTest {
    private static final String NOMBRE = "Daniel";
    private static final String APELLIDO = "Vasquez";
    private static final int EDAD = 28;

    @Test
    public void constructorConParametros() {
        Persona persona = new Persona(NOMBRE, APELLIDO, EDAD);

        MatcherAssert.assertThat(persona, CoreMatchers.notNullValue());
        MatcherAssert.assertThat(persona.getNombre(), CoreMatchers.is(NOMBRE));
        MatcherAssert.assertThat(persona.getApellido(), CoreMatchers.is(APELLIDO));
        MatcherAssert.assertThat(persona.getEdad(), CoreMatchers.equalTo(EDAD));
        assertTrue(persona.equals(persona));
    }

    @Test
    public void constructorSinParametros() {
        Persona persona = new Persona();
        persona.setNombre(NOMBRE);
        persona.setApellido(APELLIDO);
        persona.setEdad(EDAD);

        MatcherAssert.assertThat(persona, CoreMatchers.notNullValue());
        MatcherAssert.assertThat(persona.getNombre(), CoreMatchers.is(NOMBRE));
        MatcherAssert.assertThat(persona.getApellido(), CoreMatchers.is(APELLIDO));
        MatcherAssert.assertThat(persona.getEdad(), CoreMatchers.equalTo(EDAD));
    }
}