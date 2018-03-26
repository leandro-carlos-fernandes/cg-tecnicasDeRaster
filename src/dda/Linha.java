package dda;

import java.awt.Color;
import java.awt.Graphics;

import basics.Ponto;

/**
 * Esta classe representa um segmento de reta (linha) e corresponde a primitiva
 * gr�fica para cria��o e desenho de linhas. 
 * Nesta vers�o � implementada a t�cnica conhecida como Algoritmo Incremental ou
 * Digital Differential Analyzer - DDA
 * 
 * @author Leandro Fernandes
 */
public class Linha {

	private Ponto inicio, fim;	// pontos de inicio e fim do segmento de reta
	private Color cor;			// cor do segmento

	/**
	 * Construtor padr�o.
	 * Cria uma nova linha com in�cio e fim na origem, na cor vermelha (padr�o).
	 */
	public Linha() {
		this(new Ponto(), new Ponto(), Color.RED);
	}

	/**
	 * Cria uma nova linha com extremidades nos pontos informados, na cor padr�o.
	 * @param inicio ponto de in�cio do segmento.
	 * @param fim ponto de t�rmino do segmento.
	 */
	public Linha(Ponto inicio, Ponto fim) {
		this(inicio, fim, Color.RED);
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
	 * M�todo respons�vel por desenhar a linha no dispositivo ou componente
	 * gr�fico informado.
	 * @param g elemento gr�fico onde ser� desenhado a primitiva.
	 */
	public void draw(Graphics g) {
		DDA(inicio.getX(), inicio.getY(), fim.getX(), fim.getY(), g);
	}
	
	/**
	 * M�todo que desenha cada um dos pontos do segmento de reta no elemento
	 * gr�fico empregando o algoritmo incremental. 
	 * @param x0,y0 coordenadas do ponto inicial do segmento.
	 * @param x1,y1 coordenadas do ponto final do segmento.
	 * @param g elemento gr�fico onde ser�o desenhados os pontos da primitiva.
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
