import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;


public class MainVentana extends JFrame {
    private int WIDTH = 1366;
    private int HEIGHT = 768;

    public ShowRoomsPanel showRooms;
    public FormPanel form;
    public ShowStudentsPanel showStudents;


    public int alumnosLibres[] = new int[]{20, 20, 20, 20};

    public static void main(String[] args) {
        new MainVentana();
    }

    public MainVentana()
    {

        this.setTitle("Proyecto Java");
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        form = new FormPanel(this);
        showRooms = new ShowRoomsPanel(this);
        showStudents = new ShowStudentsPanel(this); //la implementamos

        this.setLayout(new GridLayout(1, 3));
        this.add(form);
        this.add(showRooms);
        this.add(showStudents);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void restarAlumnosLibres(int aula)
    {
        if (alumnosLibres[aula] > 0)
            alumnosLibres[aula] -= 1;
    }

   public void actualizarAlumnos(Biblioteca b1)
    {
        this.showStudents.setDatos(b1.getNumero());
    }
}
