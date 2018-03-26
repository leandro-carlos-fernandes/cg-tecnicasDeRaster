import java.awt.Graphics;
import javax.swing.JFrame;

import basics.DisplayRaster;
import basics.Ponto;

@SuppressWarnings("serial")
public class PrgDemoLinhas extends JFrame {
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		dda.Linha linhaDDA = new dda.Linha();
		linhaDDA.setPontoDeInicio(new Ponto(2, 6));
		linhaDDA.setPontoDeFim(new Ponto(26, 20));
		linhaDDA.draw(g);
		
		midpoint.Linha linhaMidPoint = new midpoint.Linha();
		linhaMidPoint.setPontoDeInicio(new Ponto(2, 10));
		linhaMidPoint.setPontoDeFim(new Ponto(26, 24));
		linhaMidPoint.draw(g);
	}

	public static void main(String[] args) {
		PrgDemoLinhas janela = new PrgDemoLinhas();
		janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
		janela.setTitle("Técnicas de Raster - Linhas");
		janela.setContentPane(new DisplayRaster());
		janela.setResizable(false);
		janela.setSize(300, 300);
		janela.setVisible(true);
	}

}