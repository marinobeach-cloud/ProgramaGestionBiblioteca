import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelBiblioteca extends JPanel
{

    private final ShowRoomsPanel showRoomsPanel;
    private ShowStudentsPanel showStudentsPanel;
    private JButton btn;
    private JLabel lblSitiosLibres;
    private int alumnosReservados; //nos va a dar una lista con las personas en esa clase

    public PanelBiblioteca(Biblioteca b1, ShowRoomsPanel showRoomsPanel)
    {
        this.showRoomsPanel = showRoomsPanel;
        this.setLayout(null);

        JLabel nombre = new JLabel(b1.getNombre());
        Font fuente=new Font("Arial", Font.BOLD, 15);
        nombre.setFont(fuente);
        nombre.setBounds(10,3,200,20);

        this.btn = new JButton();
        ImageIcon imagen = new ImageIcon(b1.getImagenBiblioteca());
        btn.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(b1.getWidth(), b1.getHeight(), Image.SCALE_AREA_AVERAGING)));
        btn.setBounds(10,50,b1.getWidth(),b1.getHeight());


        this.alumnosReservados = this.leerFichero(b1); //numero alumnos que hay en esa clase
        JLabel lblSitiosLibres = new JLabel("Sitios libres: " + (b1.getCapacidad() - this.alumnosReservados));
        lblSitiosLibres.setBounds(10,230,100,20);


        this.add(nombre);
        this.add(btn);
        this.add(lblSitiosLibres);

        this.btn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                PanelBiblioteca.this.showRoomsPanel.getMainVentana().actualizarAlumnos(b1); //b1=la biblioteca en la que estamos

            }
        });

    }

    public int leerFichero(Biblioteca b1) //me va a devolver un número con la cantidad de gente (alumnosReservados)
    {
        Scanner s = null;
        int alumnosReservados = 0;
        try
        {
            int aulaNum;
            String datos;
            File fichero = new File("./resources/alumnosAulas.txt");
            s = new Scanner(fichero); //leemos todo el fichero

            // Leemos linea a linea el fichero
            while (s.hasNextLine())
            {

                String linea = s.nextLine();// Guardamos la linea en un String
                aulaNum = Integer.parseInt(linea.substring(0,1));

                if (aulaNum == b1.getNumero())
                {
                   alumnosReservados++; //Si estamos en mi aula le sumamos 1
                }

            }

        }
        catch (Exception ex)
        {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        finally
        {
            s.close();
        }

        return alumnosReservados;
    }

}
