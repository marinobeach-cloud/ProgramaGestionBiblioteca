import java.awt.*;
import java.util.ArrayList;

public class Biblioteca {

    String nombre;
    int capacidad;
    Image imagenBiblioteca;
    int numero;


    public Biblioteca(String nombre, int capacidad, String imagenBiblioteca, int numero) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.imagenBiblioteca = Toolkit.getDefaultToolkit().getImage(imagenBiblioteca);
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Image getImagenBiblioteca() {
        return imagenBiblioteca;
    }

    public int getNumero() {
        return numero;
    }
}
