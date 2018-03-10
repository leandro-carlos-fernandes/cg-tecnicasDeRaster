import java.awt.Graphics;
import javax.swing.JFrame;

import basics.Ponto;

@SuppressWarnings("serial")
public class PrgDemoLinhas extends JFrame {

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		dda.Linha linhaDDA = new dda.Linha();
		linhaDDA.setPontoDeInicio(new Ponto(40, 60));
		linhaDDA.setPontoDeFim(new Ponto(260, 200));
		linhaDDA.draw(g);
		
		midpoint.Linha linhaMidPoint = new midpoint.Linha();
		linhaMidPoint.setPontoDeInicio(new Ponto(40, 65));
		linhaMidPoint.setPontoDeFim(new Ponto(260, 205));
		linhaMidPoint.draw(g);
	}

	public static void main(String[] args) {
		PrgDemoLinhas janela = new PrgDemoLinhas();
		janela.setTitle("Técnicas de Raster - Linhas");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(false);
		janela.setSize(300, 300);
		janela.setVisible(true);
	}

}
