package midpoint;

import java.awt.Color;
import java.awt.Graphics;

import basics.Ponto;

/**
 * Esta classe representa um segmento de reta (linha) e corresponde a primitiva
 * gr�fica para cria��o e desenho de linhas. 
 * Nesta vers�o � implementada o Algoritmo do Ponto M�dio para tra�ado de linhas.
 * 
 * @author Leandro Fernandes
 */
public class Linha {

	private Ponto inicio, fim;
	private Color cor;

	/**
	 * Construtor padr�o.
	 * Cria uma nova linha com in�cio e fim na origem, na cor padr�o (azul).
	 */
	public Linha() {
		this(new Ponto(), new Ponto(), Color.BLUE);
	}

	/**
	 * Cria uma nova linha com extremidades nos pontos informados, na cor padr�o.
	 * @param inicio ponto de in�cio do segmento.
	 * @param fim ponto de t�rmino do segmento.
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
	 * Recupera o ponto de in�cio do segmento de reta.
	 * @return ponto de in�cio.
	 */
	public Ponto getPontoDeInicio() {
		return inicio;
	}

	/**
	 * Define o ponto de in�cio para o segmento de reta.
	 * @param p ponto de in�cio.
	 */
	public void setPontoDeInicio(Ponto p) {
		this.inicio = p;
	}

	/**
	 * Recupera o ponto de t�rmino do segmento de reta.
	 * @return ponto de t�rmino.
	 */
	public Ponto getPontoDeFim() {
		return fim;
	}

	/**
	 * Define o ponto de t�rmino para o segmento de reta.
	 * @param p ponto de t�rmino.
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
	 * M�todo respons�vel por desenhar a linha no elemento gr�fico informado.
	 * @param g elemento gr�fico onde ser� desenhado a primitiva.
	 */
	public void draw(Graphics g) {
		MIDPOINT_LINE(inicio.getX(), inicio.getY(), fim.getX(), fim.getY(), g);
	}

	/**
	 * M�todo que desenha cada um dos pontos do segmento de reta no elemento
	 * gr�fico empregando o algoritmo do ponto m�dio.
	 * @param x0,y0 coordenadas do ponto inicial do segmento.
	 * @param x1,y1 coordenadas do ponto final do segmento.
	 * @param g elemento gr�fico onde ser�o desenhados os pontos da primitiva.
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
