import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class ShowStudentsPanel extends JPanel
{


    JTable alumnosEnAulas;
    String[] columnNames = {"Nombre, Apellidos, Clave, Aula"};
    Biblioteca b1;

    public ShowStudentsPanel(MainVentana mainVentana)
    {

        alumnosEnAulas = new JTable(new Object[][]{}, columnNames);


        alumnosEnAulas.setVisible(false);
/*        this.add(alumnosEnAulas);*/
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.setColor(Color.RED);
    }

    public void setDatos(Biblioteca b1) {

        this.setB1(b1);
        //this.datos = datos;
        //this.alumnosEnAulas = new JTable(datos,
        //        columnNames);
        this.leerFichero();
        alumnosEnAulas.setVisible(true);
        //this.add(alumnosEnAulas);

    }

    public void setB1(Biblioteca b1) {
        this.b1 = b1;
    }

    public void leerFichero() {
        Scanner s = null;

        try
        {
            int aulaNum;
            String datos;
            File fichero = new File("./resources/alumnosAulas.txt");
            s = new Scanner(fichero); //leemos todo el fichero
            ArrayList aula0 = new ArrayList();

            // Leemos linea a linea el fichero
            while (s.hasNextLine())
            {

                String linea = s.nextLine();// Guardamos la linea en un String
                aulaNum = Integer.parseInt(linea.substring(0,1));

                if (aulaNum == b1.getNumero()) {
                    datos = linea.substring(2, linea.length());
                    aula0.add(datos);
                }
            }

            Object[][] datos2 = new Object[10][3];

            for(int i=0; i<aula0.size() ;i++)
            {
                String[] separar = {};
                String linea2;
                linea2 = (String) aula0.get(i);//linea va a ser cada componente de la lista "Lola Roca 201901063"
                separar = linea2.split(" "); //{"Lola","Roca","201901063"}
                datos2[i][0] = separar[0]; //"Lola"
                datos2[i][1] = separar[1];//"Roca"
                datos2[i][2] = separar[2];//"201901063"
                System.out.println(datos2);

            }

            alumnosEnAulas = new JTable(new Object[][]{
                datos2},
                columnNames);

        }
        catch (Exception ex)
        {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        finally
        {
            s.close();
        }




    }


}

