package org.example;

public class Main {
    public static void main(String[] args) {
        //  Primitivos
        int a = 5;
        int b = 5;

        System.out.println("Primitivos -> " + (a == b));

        //  Objetos
        Persona persona = new Persona("Daniel", "Vasquez",28);
        Persona persona1 = new Persona("Carlos", "Caloa",30);

        System.out.println("Objetos -> " + (persona == persona1));
        System.out.println("Objetos -> " + (persona.equals(persona)));
    }
}