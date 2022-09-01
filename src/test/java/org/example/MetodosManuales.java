package org.example;

import org.junit.*;

public class MetodosManuales {
    @Before
    public void setUp() throws Exception {
        System.out.println("Antes de cada Test");
    }

    @Before
    public void tearDown(){
        System.out.println("Despues de cada Test");
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Antes de todos los Test");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Despues de todos los Test");
    }

    @Test
    public void primerTest() {
        System.out.println("Primer Test");
    }

    @Test
    public void segundoTest() {
        System.out.println("Segundo Test");
    }
}
