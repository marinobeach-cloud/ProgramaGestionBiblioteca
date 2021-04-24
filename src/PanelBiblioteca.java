import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelBiblioteca extends JPanel {

    private final ShowRoomsPanel showRoomsPanel;
    private JButton btn;
    private JLabel lblSitiosLibres;
    private int alumnosReservados;

    public PanelBiblioteca(Biblioteca b1, ShowRoomsPanel showRoomsPanel) {
        this.showRoomsPanel = showRoomsPanel;
        this.setLayout(new GridLayout(3,1));
        this.add(new JLabel(b1.getNombre()));
        this.btn = new JButton();
        btn.setIcon(new ImageIcon(b1.getImagenBiblioteca()));
        this.add(btn);
        this.alumnosReservados = this.leerFichero(b1);
        this.lblSitiosLibres = new JLabel("Sitios libres: " + (b1.getCapacidad() - this.alumnosReservados));

        this.add(lblSitiosLibres);
        this.btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelBiblioteca.this.showRoomsPanel.getMainVentana().actualizarAlumnos(b1);
            }
        });

    }

    public int leerFichero(Biblioteca b1) {
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
                   alumnosReservados++;
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
