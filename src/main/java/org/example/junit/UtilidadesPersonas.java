package org.example.junit;

import org.example.Persona;

public class UtilidadesPersonas {
    private Persona daniel;
    private Persona carlos;

    public UtilidadesPersonas() {
        this.daniel = new Persona("Daniel", "Vasquez", 28);
        this.carlos = new Persona("Carlos", "Caloa", 30);
    }

    public Persona getDaniel() {
        return daniel;
    }

    public Persona getCarlos() {
        return carlos;
    }

    public Persona[] getArrayPersonas() {
        Persona[] personas = {daniel, carlos};
        return personas;
    }

    public Persona findPersona(String nombre) {
        for (Persona p : getArrayPersonas()) {
            if (p.getNombre().equals(nombre)) {
                return p;
            }
        }
        return null;
    }
}
