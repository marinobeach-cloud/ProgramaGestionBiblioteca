import java.awt.*;
import javax.swing.*;

public class ShowRoomsPanel extends JPanel
{
    public MainVentana getMainVentana() {
        return mainVentana;
    }

    private MainVentana mainVentana;

    public ShowRoomsPanel(MainVentana mainVentana)
    {
        this.mainVentana = mainVentana;

        this.setLayout(new GridLayout(2,2));

        Biblioteca b1 = new Biblioteca("ICAI 5ª Planta",20,"./resources/imagenes/icai.jpg", 0);
        Biblioteca b2 = new Biblioteca("ICAI 4ª Planta",20,"./resources/imagenes/icai.jpg", 1);
        Biblioteca b3 = new Biblioteca("Icade",20,"./resources/imagenes/icade.jpg", 2);
        Biblioteca b4 = new Biblioteca("Cantoblanco",20,"./resources/imagenes/cantoblanco.jpg", 3);

        PanelBiblioteca pnlbbl1 = new PanelBiblioteca(b1,this);
        PanelBiblioteca pnlbbl2 = new PanelBiblioteca(b2, this);
        PanelBiblioteca pnlbbl3 = new PanelBiblioteca(b3, this);
        PanelBiblioteca pnlbbl4 = new PanelBiblioteca(b4, this);

        //Guardar un HashMap, con relacion Biblioteca y PanelBiblioteca
        this.add(pnlbbl1);
        this.add(pnlbbl2);
        this.add(pnlbbl3);
        this.add(pnlbbl4);

        /*




        //texto alumnos libres
        JLabel alumnosLibresAula1 = new JLabel("alumnos libres aula1: " + mainVentana.getAlumnosLibres()[0]);
        alumnosLibresAula1.setBounds(40, 230, 140, 30);

        JLabel alumnosLibresAula2 = new JLabel("alumnos libres aula2: " + mainVentana.getAlumnosLibres()[1]);
        alumnosLibresAula2.setBounds(310, 230, 140, 30);

        JLabel alumnosLibresAula3 = new JLabel("alumnos libres aula3: " + mainVentana.getAlumnosLibres()[2]);
        alumnosLibresAula3.setBounds(40, 500, 140, 30);

        JLabel alumnosLibresAula4 = new JLabel("alumnos libres aula4: " + mainVentana.getAlumnosLibres()[3]);
        alumnosLibresAula4.setBounds(310, 500, 140, 30);

        //texto la sala que es

        JLabel salaIcai5 = new JLabel("Sala ICAI quinta planta ");
        salaIcai5.setBounds(40, 10, 140, 30);

        JLabel salaIcai4 = new JLabel("Sala ICAI cuarta planta " );
        salaIcai4.setBounds(310, 10, 140, 30);

        JLabel salaAA = new JLabel("Sala Alberto Aguilera " );
        salaAA.setBounds(40, 300, 140, 30);

        JLabel cantoblanco = new JLabel("Sala Cantoblanco ");
        cantoblanco.setBounds(310, 300, 140, 30);


        //Botones de las imágenes
        JButton btnIcai5 = new JButton();
        btnIcai5.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("./resources/imagenes/icai.jpg").getScaledInstance(200, 170, Image.SCALE_DEFAULT)));
        btnIcai5.setBounds(0,50,200,170);

        JButton btnIcai4 = new JButton();
        btnIcai4.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("./resources/imagenes/icai.jpg").getScaledInstance(200, 170, Image.SCALE_DEFAULT)));
        btnIcai4.setBounds(250,50,200,170);

        JButton btnIcade = new JButton();
        ImageIcon iconoIcade= new ImageIcon("./resources/Imagenes/icai.jpg");
        btnIcade.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("./resources/imagenes/icade.jpg").getScaledInstance(200, 170, Image.SCALE_DEFAULT)));
        btnIcade.setBounds(0,350,200,113);


        JButton btnCanto = new JButton();
        ImageIcon iconoCanto= new ImageIcon("./resources/Imagenes/cantoblanco.jpg");
        btnCanto.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("./resources/imagenes/cantoblanco.jpg").getScaledInstance(200, 170, Image.SCALE_DEFAULT)));
        btnCanto.setBounds(250,350,200,132);


        btnIcai5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ArrayList aula0 = new ArrayList(); //lista para Icai 5 planta
                File fichero = new File("./resources/alumnosAulas.txt");
                Scanner s = null;
                try
                {
                    int aulaNum;
                    String datos;
                    s = new Scanner(fichero); //leemos todo el fichero
                    // Leemos linea a linea el fichero
                    while (s.hasNextLine())
                    {

                        String linea = s.nextLine();// Guardamos la linea en un String
                        aulaNum = Integer.parseInt(linea.substring(0,1));

                        if (aulaNum==0)
                        {
                            datos = linea.substring(2,linea.length());
                            aula0.add(datos);
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

                //AHORA VAMOS A ENSEÑAR QUE HAY AHÍ EN MI NUEVA VENTANA
                Object[][] datos = new Object[10][3];
                String[] columnNames = {"Nombre", "Apellido", "Clave"};

                for(int i=0; i<aula0.size() ; i++)
                {
                    String[] separar = {};
                    String linea;
                    linea= (String) aula0.get(i);//linea va a ser cada componente de la lista "Lola Roca 201901063"
                    separar=linea.split(" "); //{"Lola","Roca","201901063"}
                    datos[i][0]=separar[0]; //"Lola"
                    datos[i][1]=separar[1];//"Roca"
                    datos[i][2]=separar[2];//"201901063"
                    System.out.println(datos);

                }
                JTable alumnosEnAulas = new JTable(datos, columnNames);
                alumnosEnAulas.setBounds(140, 200, 300, 200);

            }
        });





        add(alumnosLibresAula1);
        add(alumnosLibresAula2);
        add(alumnosLibresAula3);
        add(alumnosLibresAula4);
        add(salaIcai4);
        add(salaIcai5);
        add(salaAA);
        add(cantoblanco);
        add(btnIcai5);
        add(btnIcai4);
        add(btnIcade);
        add(btnCanto);
        */
    }

}




