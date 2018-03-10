package basics;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Abstração da primitiva mais fundamental da geometria e do desenho, o Ponto. 
 * Esta classe modela um ponto no espaço bi-dimensional, sendo caracterizado
 * por duas coordenadas (x e y) e uma cor.
 * 
 * @author Leandro Fernandes
 */
public class Ponto {
	
	private int x, y;
	private Color cor;
	
	/**
	 * Construtor padrão.
	 * Cria uma instância de ponto com coordenadas localizadas na origem e na
	 * cor preta.
	 */
	public Ponto() {
		this(0, 0, Color.BLACK);
	}

	/**
	 * Cria um novo ponto localizado nas coordenadas (x,y) e define também a
	 * sua cor.
	 * @param x coordenada da abscissa.
	 * @param y coordenada da ordenada.
	 * @param cor a cor do ponto.
	 */
	public Ponto(int x, int y) {
		this(x, y, Color.BLACK);
	}

	/**
	 * Cria um novo ponto localizado nas coordenadas (x,y) e define também a
	 * sua cor.
	 * @param x coordenada da abscissa.
	 * @param y coordenada da ordenada.
	 * @param cor a cor do ponto.
	 */
	public Ponto(int x, int y, Color cor) {
		this.x = x;
		this.y = y;
		this.cor = cor;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getCor() {
		return cor;
	}

	public void setCor(Color cor) {
		this.cor = cor;
	}

	/**
	 * Método responsável por desenhar um ponto no dispositivo ou componente
	 * gráfico informado.
	 * @param g dispositivo ou componente gráfico onde será desenhado o ponto.
	 */
	public void draw(Graphics g){
		g.setColor(cor);
		g.drawLine(x,y,x,y);
	}
	
}
