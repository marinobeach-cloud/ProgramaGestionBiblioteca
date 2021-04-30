import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Biblioteca

{

    String nombre;
    int capacidad;
    Image imagenBiblioteca;
    int numero;
    int width;
    int height;

    public Biblioteca(String nombre, int capacidad, String imagenBiblioteca, int numero, int width,int height)
    {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.imagenBiblioteca = Toolkit.getDefaultToolkit().getImage(imagenBiblioteca);
        this.numero = numero;
        this.height=height;
        this.width=width;

    }



    public int getWidth() { return width; }

    public int getHeight() { return height; }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Image getImagenBiblioteca()
    {
        return imagenBiblioteca;
    }

    public int getNumero() {
        return numero;
    }
}
