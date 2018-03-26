import java.awt.Graphics;

import javax.swing.JFrame;
import basics.Ponto;
import midpoint.Circulo;

@SuppressWarnings("serial")
public class PrgDemoCirculo extends JFrame {

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Circulo circulo = new Circulo();
		circulo.setCentro(new Ponto(150,150));
		circulo.setRaio(80);
		circulo.draw(g);
	}

	public static void main(String[] args) {
		PrgDemoCirculo janela = new PrgDemoCirculo();
		janela.setTitle("Técnicas de Raster - Círculos");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(false);
		janela.setSize(300, 300);
		janela.setVisible(true);
	}

}
