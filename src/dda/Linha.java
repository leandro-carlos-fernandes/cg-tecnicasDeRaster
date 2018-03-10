package dda;

import java.awt.Color;
import java.awt.Graphics;

import basics.Ponto;

/**
 * Esta classe representa um segmento de reta (linha) e corresponde a primitiva
 * gráfica para criação e desenho de linhas. 
 * Nesta versão é implementada a técnica conhecida como Algoritmo Incremental ou
 * Digital Differential Analyzer - DDA
 * 
 * @author Leandro Fernandes
 */
public class Linha {

	private Ponto inicio, fim;
	private Color cor;

	public Linha() {
		this(new Ponto(), new Ponto(), Color.RED);
	}

	public Linha(Ponto inicio, Ponto fim, Color cor) {
		this.inicio = inicio;
		this.fim = fim;
		this.cor = cor;
	}

	public Ponto getPontoDeInicio() {
		return inicio;
	}

	public void setPontoDeInicio(Ponto p) {
		this.inicio = p;
	}

	public Ponto getPontoDeFim() {
		return fim;
	}

	public void setPontoDeFim(Ponto p) {
		this.fim = p;
	}
	
	public Color getCor() {
		return cor;
	}

	public void setCor(Color cor) {
		this.cor = cor;
	}

	/**
	 * Método responsável por desenhar a linha no dispositivo ou componente
	 * gráfico informado.
	 * @param g elemento gráfico onde será desenhado a primitiva.
	 */
	public void draw(Graphics g) {
		DDA(inicio.getX(), inicio.getY(), fim.getX(), fim.getY(), g);
	}
	
	/**
	 * 
	 * @param x0,y0 coordenadas do ponto inicial do segmento.
	 * @param x1,y1 coordenadas do ponto final do segmento.
	 * @param g elemento gráfico onde serão desenhados os pontos da primitiva.
	 */
	private void DDA(int x0, int y0, int x1, int y1, Graphics g) {
		int dx = x1 - x0;
		int dy = y1 - y0;
		float m = (float) dy / dx;

		int x = x0;
		float y = y0;
		for (; x <= x1; x++) {
			new Ponto(x, Math.round(y), cor).draw(g);
			y = y + m;
		}
	}
}
