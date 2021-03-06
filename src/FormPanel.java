import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class FormPanel extends JPanel
{
    private MainVentana mainVentana;
    Image logo = Toolkit.getDefaultToolkit().getImage("./resources/imagenes/logo.png");

    public FormPanel(MainVentana mainVentana)
    {
        this.mainVentana = mainVentana;

        setLayout(null);

        Font fuente =new Font("Arial", Font.BOLD, 20);
        JLabel jTitulo1= new JLabel("BIENVENIDOS AL SERVICIO DE BIBLIOTECAS ");
        JLabel jTitulo2= new JLabel("DE COMILLAS");
        jTitulo1.setFont(fuente);
        jTitulo2.setFont(fuente);
        jTitulo1.setBounds(10, 25, 500, 20);
        jTitulo2.setBounds(150, 65, 500, 20);


        JTextField nombre = new JTextField(10);
        nombre.setText("");
        nombre.setBounds(200, 125, 100, 20);
        JLabel jLabelNombre = new JLabel("Nombre:");
        jLabelNombre.setBounds(140, 120, 60, 30);
        jLabelNombre.setLabelFor(nombre);


        JTextField apellido = new JTextField(10);
        apellido.setText("");
        apellido.setBounds(200, 155, 100, 20);
        JLabel jLabelApellido = new JLabel("Apellido:");
        jLabelApellido.setBounds(140, 150, 60, 30);
        jLabelApellido.setLabelFor(apellido);


        JTextField clave = new JTextField(10);
        clave.setText("");
        clave.setBounds(200, 185, 100, 20);
        JLabel jLabelClave = new JLabel("Clave:");
        jLabelClave.setBounds(140, 180, 60, 30);
        jLabelClave.setLabelFor(clave);


        JRadioButton aula1 = new JRadioButton("Icai5");
        aula1.setBounds(50, 215, 60, 30);
        JRadioButton aula2 = new JRadioButton("Icai4");
        aula2.setBounds(110, 215, 60, 30);
        JRadioButton aula3 = new JRadioButton("Icade");
        aula3.setBounds(170, 215, 60, 30);
        JRadioButton aula4 = new JRadioButton("Cantoblanco");
        aula4.setBounds(230, 215, 100, 30);

        ButtonGroup group = new ButtonGroup();
        group.add(aula1);
        group.add(aula2);
        group.add(aula3);
        group.add(aula4);

        JButton button = new JButton("Enviar datos");

        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                boolean e1 = mensajeErrorEspacios(nombre);
                boolean e2 = mensajeErrorEspacios(apellido);
                boolean e3 = mensajeErrorEspacios(apellido);
                boolean e4 = mensajeErrorNumeros(clave);
                boolean cl = alumnoEnSala(clave);


                int aula = 0; //aula 1 es 0 por defecto
                if (aula2.isSelected())
                    aula = 1;
                else if (aula3.isSelected())
                    aula = 2;
                else if (aula4.isSelected())
                    aula = 3;

                boolean llena = mensajeSalaLLena(aula);

                mainVentana.restarAlumnosLibres(aula);

                FileWriter myWriter;
                try
                {
                    if (e1==false && e2==false && e3==false && e4==false )
                    {
                        if( llena==false && cl ==false)
                        {
                            myWriter = new FileWriter("./resources/alumnosAulas.txt", true);
                            myWriter.write(aula + " " + nombre.getText() + " " + apellido.getText() + " " + clave.getText() + "\n");
                            myWriter.close();

                        }
                    }


                    nombre.setText(""); //las inicializamos a 0 las entradas
                    apellido.setText("");
                    clave.setText("");
                    group.clearSelection();
                }
                catch (IOException ioException)
                {
                    System.out.println("Error");
                }


                mainVentana.resetShowRoomsPanel();

            }

        });

        button.setBounds(100, 300, 200, 50);
        add(jTitulo1);
        add(jTitulo2);
        add(jLabelNombre);
        add(nombre);
        add(jLabelApellido);
        add(apellido);
        add(jLabelClave);
        add(clave);
        add(aula1);
        add(aula2);
        add(aula3);
        add(aula4);
        add(button);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        setBackground(Color.getHSBColor(163,39,67));
        g.drawImage(logo,20,400,410 ,110,null);
    }

    public boolean mensajeErrorEspacios(JTextField text)
    {
        String linea;
        linea=text.getText();
        if(linea.contains(" "))
        {
            JOptionPane.showMessageDialog(null, "Pongalo sin espacios");
            return true;
        }
        else
            return false;

    }

    public boolean mensajeErrorNumeros(JTextField text)
    {
        String linea;
        linea=text.getText();
        if(linea.length() != 9 )
        {
            JOptionPane.showMessageDialog(null, "Su clave tiene que estar compuesta por 9 n??meros");
            return true;
        }
        else
            return false;

    }

    public boolean mensajeSalaLLena(int aula)
    {
        Scanner s = null;
        try
        {
            int aulaNum = 0;
            int a= 0;
            File fichero = new File("./resources/alumnosAulas.txt");
            s = new Scanner(fichero); //leemos todo el fichero

            // Leemos linea a linea el fichero
            while (s.hasNextLine())
            {

                String linea = s.nextLine();// Guardamos la linea en un String
                aulaNum = Integer.parseInt(linea.substring(0,1)); //aulaNum va a almacenar el valor del n??mero del aula (1,2,3 o 4)
                if (aulaNum==aula)
                {
                    a=a+1;
                }

                if (a==20 )
                {
                    JOptionPane.showMessageDialog(null, "Esta aula ya est?? complete intente reservar en otra");
                    return true;
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
        return false;

    }

    public boolean alumnoEnSala(JTextField c) //va a recibir la clave
    {
        Scanner s = null;
        try
        {
            String cl = c.getText();
            File fichero = new File("./resources/alumnosAulas.txt");
            s = new Scanner(fichero); //leemos todo el fichero
            while (s.hasNextLine())
            {

                String linea = s.nextLine();// Guardamos la linea en un String
                String clave = linea.substring(linea.length()-9,linea.length()); //almacena la clave
               if(cl.equals(clave))
                    {
                        JOptionPane.showMessageDialog(null, "Este alumno ya est?? en una sala");
                        return true;

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
        return false;
    }

}
