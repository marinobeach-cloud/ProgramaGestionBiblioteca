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

        Biblioteca b1 = new Biblioteca("ICAI 5ª Planta",20,"./resources/imagenes/icai.jpg",0,200,170);
        Biblioteca b2 = new Biblioteca("ICAI 4ª Planta",20,"./resources/imagenes/icai.jpg", 1,200,170);
        Biblioteca b3 = new Biblioteca("ICADE",20,"./resources/imagenes/icade.jpg", 2,200,132);
        Biblioteca b4 = new Biblioteca("CANTOBLANCO",20,"./resources/imagenes/cantoblanco.jpg", 3,200,132);


        PanelBiblioteca pnlbbl1 = new PanelBiblioteca(b1,this);
        PanelBiblioteca pnlbbl2 = new PanelBiblioteca(b2, this);
        PanelBiblioteca pnlbbl3 = new PanelBiblioteca(b3, this);
        PanelBiblioteca pnlbbl4 = new PanelBiblioteca(b4, this);


        this.add(pnlbbl1);
        this.add(pnlbbl2);
        this.add(pnlbbl3);
        this.add(pnlbbl4);

    }

}




