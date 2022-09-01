package org.example.junit;

public class Utilidades {
    public String concatenar(String uno, String dos) {
        if (uno != null && dos != null) {
            return uno.concat(" ").concat(dos);
        }

        return null;
    }

    public String concatenarTres(String uno, String dos, String tres) {
        if (uno != null && dos != null && tres != null) {
            return uno.concat(" ").concat(dos).concat(" ").concat(tres);
        }

        return null;
    }

    public int sumaNumeros(int a, int b) {
        return a + b;
    }
}
