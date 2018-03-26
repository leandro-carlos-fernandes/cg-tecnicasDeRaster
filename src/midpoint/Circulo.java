package midpoint;

import java.awt.Graphics;

import basics.Ponto;

public class Circulo {
	
	private Ponto centro;
	private int raio;

	public Circulo() {
		this(new Ponto(), 10);
	}
	
	public Circulo(Ponto centro, int raio) {
		super();
		this.centro = centro;
		this.raio = raio;
	}

	public void setCentro(Ponto centro) {
		this.centro = centro;		
	}

	public void setRaio(int raio) {
		this.raio = raio;
	}

	public void draw(Graphics g) {
		MIDPOINT_CIRCLE_ALGORITHM(centro.getX(), centro.getY(), raio, g);
	}
	
	private void MIDPOINT_CIRCLE_ALGORITHM(int xCentro, int yCentro, int raio, Graphics g) {
		int x = 0;
		int y = raio;
		float d = 5f/4 - raio;
		
		SIMETRIA_DE_ORDEM_8(x + xCentro, y + yCentro, g);
		while (y > x) {
			if (d < 0) {	// seleciona E
				d = d + 2*x + 3;
				x++;
			}
			else {			// seleciona SE
				d = d + 2*(x-y) + 5;
				x++; y--;
			}
			SIMETRIA_DE_ORDEM_8(x + xCentro, y + yCentro, g);
		}
	}
	
	private void SIMETRIA_DE_ORDEM_8(int x, int y, Graphics g) {
		new Ponto( x, y).draw(g);
		new Ponto( y, x).draw(g);
		new Ponto( y,-x).draw(g);
		new Ponto( x,-y).draw(g);
		new Ponto(-x,-y).draw(g);
		new Ponto(-y,-x).draw(g);
		new Ponto(-y, x).draw(g);
		new Ponto(-x, y).draw(g);
	}
	
}
