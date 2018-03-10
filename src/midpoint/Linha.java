package midpoint;

import java.awt.Color;
import java.awt.Graphics;

import basics.Ponto;

/**
 * Esta classe representa um segmento de reta (linha) e corresponde a primitiva
 * gráfica para criação e desenho de linhas. 
 * Nesta versão é implementada o Algoritmo do Ponto Médio para traçado de linhas.
 * 
 * @author Leandro Fernandes
 */
public class Linha {

	private Ponto inicio, fim;
	private Color cor;

	/**
	 * Construtor padrão.
	 * Cria uma nova linha com início e fim na origem, na cor padrão (azul).
	 */
	public Linha() {
		this(new Ponto(), new Ponto(), Color.BLUE);
	}

	/**
	 * Cria uma nova linha com extremidades nos pontos informados, na cor padrão.
	 * @param inicio ponto de início do segmento.
	 * @param fim ponto de término do segmento.
	 */
	public Linha(Ponto inicio, Ponto fim) {
		this(inicio, fim, Color.BLUE);
	}
	
	public Linha(Ponto inicio, Ponto fim, Color cor) {
		this.inicio = inicio;
		this.fim = fim;
		this.cor = cor;
	}

	/**
	 * Recupera o ponto de início do segmento de reta.
	 * @return ponto de início.
	 */
	public Ponto getPontoDeInicio() {
		return inicio;
	}

	/**
	 * Define o ponto de início para o segmento de reta.
	 * @param p ponto de início.
	 */
	public void setPontoDeInicio(Ponto p) {
		this.inicio = p;
	}

	/**
	 * Recupera o ponto de término do segmento de reta.
	 * @return ponto de término.
	 */
	public Ponto getPontoDeFim() {
		return fim;
	}

	/**
	 * Define o ponto de término para o segmento de reta.
	 * @param p ponto de término.
	 */
	public void setPontoDeFim(Ponto p) {
		this.fim = p;
	}
	
	/**
	 * Recupera a cor do segmento de reta.
	 * @return cor da linha.
	 */
	public Color getCor() {
		return cor;
	}

	/**
	 * Define a cor do segmento de reta.
	 * @param cor valor correspondente a cor da linha.
	 */
	public void setCor(Color cor) {
		this.cor = cor;
	}

	/**
	 * Método responsável por desenhar a linha no elemento gráfico informado.
	 * @param g elemento gráfico onde será desenhado a primitiva.
	 */
	public void draw(Graphics g) {
		MIDPOINT_LINE(inicio.getX(), inicio.getY(), fim.getX(), fim.getY(), g);
	}

	/**
	 * Método que desenha cada um dos pontos do segmento de reta no elemento
	 * gráfico empregando o algoritmo do ponto médio.
	 * @param x0,y0 coordenadas do ponto inicial do segmento.
	 * @param x1,y1 coordenadas do ponto final do segmento.
	 * @param g elemento gráfico onde serão desenhados os pontos da primitiva.
	 */
	private void MIDPOINT_LINE(int x0, int y0, int x1, int y1, Graphics g) {
		int dx = x1 - x0;
		int dy = y1 - y0;
		int d = 2 * dy - dx;
		int incrE = 2 * dy;
		int incrNE = 2 * (dy - dx);

		int x = x0;
		int y = y0;
		for (; x <= x1; x++) {
			new Ponto(x, y, cor).draw(g);
			if (d > 0) {
				d = d + incrNE;
				y++;
			} else
				d = d + incrE;
		}
	}
}
