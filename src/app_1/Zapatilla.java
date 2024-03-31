package app_1;

import java.util.List;

public class Zapatilla {
    public List<Integer> tallas;
    public String nombre;

    public Zapatilla(List<Integer> tallas, String nombre) {
        this.tallas = tallas;
        this.nombre = nombre;
    }

    public List<Integer> getTallas() {
        return tallas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTallas(List<Integer> tallas) {
        this.tallas = tallas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
