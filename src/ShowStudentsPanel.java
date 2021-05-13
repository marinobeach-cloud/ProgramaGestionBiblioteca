import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class ShowStudentsPanel extends JPanel
{

    private MainVentana mainVentana;
    JTable alumnosEnAulas;
    String[] columnNames = new String[]{"Nombre", "Apellidos", "Clave"};
    int b1;
    JLabel titulo;
    JLabel nombre;
    JLabel apellido;
    JLabel clave;

    public ShowStudentsPanel(MainVentana mainVentana)
    {
        this.mainVentana = mainVentana;
        setLayout(null);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        setBackground(Color.WHITE);
    }

    public void setDatos(int b1)
    {

        this.setB1(b1);
        this.leerFichero();
        alumnosEnAulas.setVisible(true);
        titulo.setVisible(true);

    }


    public void setB1(int b1) //aqui cambiamos la b, para que sea 0,1,2 o 3 (la biblioteca)
    {
        this.b1 = b1;
    }

    public String setAula()
    {
        String aula;
        if (b1==0)
        { aula="ICAI 5ª Planta"; }
        else if (b1==1)
        { aula="ICAI 4ª Planta"; }
        else if (b1==2)
        { aula="ICADE"; }
        else
            aula="CANTOBLANCO";
        return aula;
    }

    public void leerFichero() {
        Scanner s = null;
        String[][] datos2 = new String[20][3];
        try
        {
            int aulaNum = 0;
            String datos;
            File fichero = new File("./resources/alumnosAulas.txt");
            s = new Scanner(fichero); //leemos todo el fichero
            ArrayList aula0 = new ArrayList();

            // Leemos linea a linea el fichero
            while (s.hasNextLine())
            {

                String linea = s.nextLine();// Guardamos la linea en un String
                aulaNum = Integer.parseInt(linea.substring(0,1)); //aulaNum va a almacenar el valor del número del aula (1,2,3 o 4)

                if (aulaNum == b1)  //cuando el numero sea el de la biblioteca que le hemos pedido
                {
                    datos = linea.substring(2, linea.length()); //datos = "Lola Roca 201901063"
                    aula0.add(datos); //aula0=("Lola Roca 201901063", "Ines Saavedra 201904567")
                }
            }


            for(int i=0; i<aula0.size() ;i++)
            {
                String[] separar = {};
                String linea;
                linea= (String) aula0.get(i);//linea va a ser cada componente de la lista "Lola Roca 201901063"
                separar=linea.split(" "); //{"Lola","Roca","201901063"}
                datos2[i][0]=separar[0]; //"Lola"
                datos2[i][1]=separar[1];//"Roca"
                datos2[i][2]=separar[2];//"201901063"
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


        if (this.titulo != null)
        {
            this.remove(titulo);
        }

        if (this.nombre != null)
        {
            this.remove(nombre);
            this.remove(apellido);
            this.remove(clave);

        }
        

        this.titulo = new JLabel("ALUMNOS EN "+ this.setAula());
        add(titulo);
        titulo.setBounds(10,10,500,100);
        Font fuente =new Font("Arial", Font.BOLD, 20);
        titulo.setFont(fuente);

        alumnosEnAulas = new JTable(datos2, columnNames);
        add(alumnosEnAulas);
        alumnosEnAulas.setBounds(50, 150, 350, 600);

        Font fuente2 =new Font("Arial", Font.BOLD, 20);

        this.nombre= new JLabel("NOMBRE");
        this.apellido = new JLabel("APELLIDO");
        this.clave = new JLabel("CLAVE");

        add(nombre);
        add(apellido);
        add(clave);

        nombre.setBounds(50,110, 60,30);
        apellido.setBounds(170, 110, 60,30);
        clave.setBounds(300,110,60,30);





        alumnosEnAulas.setVisible(true);


    }


}


