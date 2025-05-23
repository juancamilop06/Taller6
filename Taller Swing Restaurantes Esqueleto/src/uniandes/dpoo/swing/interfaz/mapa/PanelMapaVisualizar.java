package uniandes.dpoo.swing.interfaz.mapa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelMapaVisualizar extends JPanel
{
    /**
     * La etiqueta donde se dibuja el mapa y se hacen las señales de los restaurantes
     */
    private JLabel labMapa;

    /**
     * La lista de restaurantes que se están dibujando en el mapa
     */
    private List<Restaurante> restaurantes;

    public PanelMapaVisualizar( )
    {
        this.labMapa = new JLabel( new ImageIcon( "./imagenes/mapa.png" ) );
        labMapa.setBorder( new LineBorder( Color.DARK_GRAY ) );
        add( labMapa, BorderLayout.CENTER );
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);  

        if (restaurantes != null)
        {
            g.setColor(Color.RED);
            for (Restaurante r : restaurantes)
            {
                int x = r.getX();
                int y = r.getY();

                g.fillOval(x - 4, y - 4, 8, 8);

                g.setColor(Color.BLACK);
                g.drawString(r.getNombre(), x + 6, y - 6);

                g.setColor(Color.RED);
            }
        }
    }

    /**
     * Actualiza la lista de restaurantes y llama al método repaint() para que se actualice el mapa
     * @param nuevosRestaurantes
     */
    public void actualizarMapa( List<Restaurante> nuevosRestaurantes )
    {
        if( restaurantes != null )
        {
            this.restaurantes.clear( );
            this.restaurantes.addAll( nuevosRestaurantes );
        }
        else
        {
            this.restaurantes = nuevosRestaurantes;
        }
        repaint( );
    }
}
