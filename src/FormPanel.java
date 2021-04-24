import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class FormPanel extends JPanel
{
    private MainVentana mainVentana;
    Image logo = Toolkit.getDefaultToolkit().getImage("./resources/imagenes/logo.png");

    public FormPanel(MainVentana mainVentana)
    {
        this.mainVentana = mainVentana;

        setLayout(null);

        JTextField nombre = new JTextField(10);
        nombre.setText("");
        nombre.setBounds(200, 25, 100, 20);
        JLabel jLabelNombre = new JLabel("Nombre:");
        jLabelNombre.setBounds(140, 20, 60, 30);
        jLabelNombre.setLabelFor(nombre);


        JTextField apellido = new JTextField(10);
        apellido.setText("");
        apellido.setBounds(200, 55, 100, 20);
        JLabel jLabelApellido = new JLabel("Apellido:");
        jLabelApellido.setBounds(140, 50, 60, 30);
        jLabelApellido.setLabelFor(apellido);

        JTextField clave = new JTextField(10);
        clave.setText(" ");
        clave.setBounds(200, 85, 100, 20);
        JLabel jLabelClave = new JLabel("Clave:");
        jLabelClave.setBounds(140, 80, 60, 30);
        jLabelClave.setLabelFor(clave);

        JRadioButton aula1 = new JRadioButton("Aula 1");
        aula1.setBounds(50, 115, 60, 30);
        JRadioButton aula2 = new JRadioButton("Aula 2");
        aula2.setBounds(110, 115, 60, 30);
        JRadioButton aula3 = new JRadioButton("Aula 3");
        aula3.setBounds(170, 115, 60, 30);
        JRadioButton aula4 = new JRadioButton("Aula 4");
        aula4.setBounds(230, 115, 60, 30);

        ButtonGroup group = new ButtonGroup();
        group.add(aula1);
        group.add(aula2);
        group.add(aula3);
        group.add(aula4);

        JButton button = new JButton("Enviar datos");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int aula = 0; //aula 1 es 0 por defecto
                if (aula2.isSelected())
                    aula = 1;
                else if (aula3.isSelected())
                    aula = 2;
                else if (aula4.isSelected())
                    aula = 3;

                mainVentana.restarAlumnosLibres(aula);

                FileWriter myWriter;
                try
                {
                    myWriter = new FileWriter("./resources/alumnosAulas.txt",true);
                    myWriter.write( String.valueOf(aula)+" "+ nombre.getText()+" "+apellido.getText()+clave.getText()+"\n");
                    myWriter.close();

                    nombre.setText("");
                    apellido.setText("");
                    clave.setText("");
                    group.clearSelection();
                }
                catch (IOException ioException)
                {
                    System.out.println("Error");
                }


            }
        });

        button.setBounds(100, 200, 200, 50);
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

        //g.setColor(Color.RED);

        g.drawImage(logo,20,400,410 ,110,null);



    }


}
