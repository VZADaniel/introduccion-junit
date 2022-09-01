package org.example;

import org.junit.*;

public class MetodosAutomaticos {
    @Before
    public void setUp() throws Exception {
        System.out.println("Antes de cada metodo");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Despues de cada metodo");
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Antes de todos");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Despues de todos");
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
