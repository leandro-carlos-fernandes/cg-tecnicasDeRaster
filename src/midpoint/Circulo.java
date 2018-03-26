package midpoint;

import java.awt.Color;
import java.awt.Graphics;

import basics.Ponto;

/**
 * Esta classe representa uma circunfer�ncia e corresponde a primitiva gr�fica
 * para cria��o e desenho de c�rculos. 
 * Nesta vers�o � implementado o algoritmo do Ponto M�dio para tra�ado de c�rculos.
 * 
 * @author Leandro Fernandes
 */
public class Circulo {
	
	private Ponto centro;
	private int raio;
	private Color cor;

	/**
	 * Construtor padr�o.
	 * Cria uma nova circunfer�ncia com centro na origem, na cor padr�o (azul).
	 */
	public Circulo() {
		this(new Ponto(), 10);
	}
	
	/**
	 * Cria uma nova linha com extremidades nos pontos informados, na cor padr�o.
	 * @param centro ponto que determina o centro da circunfer�ncia.
	 * @param raio valor correspondente ao comprimento do raio.
	 */
	public Circulo(Ponto centro, int raio) {
		this(centro, raio, Color.MAGENTA);
	}
	
	/**
	 * Cria uma nova circunfer�ncia com centro no ponto informado, raio igual ao
	 * comprimento dado e com a cor padr�o especificada.
	 * @param centro ponto que determina o centro da circunfer�ncia.
	 * @param raio valor correspondente ao comprimento do raio.
	 */
	public Circulo(Ponto centro, int raio, Color cor) {
		super();
		this.centro = centro;
		this.raio = raio;
		this.cor = cor;
	}

	public void setCentro(Ponto centro) {
		this.centro = centro;		
	}

	public void setRaio(int raio) {
		this.raio = raio;
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
	 * M�todo respons�vel por desenhar o c�rculo no elemento gr�fico informado.
	 * @param g elemento gr�fico onde ser� desenhado a primitiva.
	 */
	public void draw(Graphics g) {
		MIDPOINT_CIRCLE_ALGORITHM(raio, g);
	}
	
	/**
	 * M�todo que desenha cada um dos pontos do segmento de uma se��o do circulo
	 * no dispositivo gr�fico empregando o algoritmo do ponto m�dio e simetria.
	 * @param raio valor ou tamanho do raio da circunfer�ncia.
	 * @param g elemento gr�fico onde ser�o desenhados os pontos da primitiva.
	 */
	private void MIDPOINT_CIRCLE_ALGORITHM(int raio, Graphics g) {
		int x = 0;
		int y = raio;
		int d = 1 - raio;
		
		SIMETRIA_DE_ORDEM_8(x, y, g);
		while (y > x) {
			if (d < 0) {	// seleciona E
				d = d + 2*x + 3;
				x++;
			}
			else {			// seleciona SE
				d = d + 2*(x-y) + 5;
				x++; y--;
			}
			SIMETRIA_DE_ORDEM_8(x, y, g);
		}
	}
	
	/**
	 * Desenha o ponto desejado e seus correspondentes em cada uma das oito
	 * se��es do circulo, de acordo com a sua correspond�ncia sim�trica.
	 * @param x coordenada X do pixel
	 * @param y coordenada Y do pixel
	 * @param g dispositivo ou componente gr�fico onde ser� desenhado o ponto.
	 */
	private void SIMETRIA_DE_ORDEM_8(int x, int y, Graphics g) {
		new Ponto( x + centro.getX(), y + centro.getY(), cor).draw(g);
		new Ponto( y + centro.getX(), x + centro.getY(), cor).draw(g);
		new Ponto( y + centro.getX(),-x + centro.getY(), cor).draw(g);
		new Ponto( x + centro.getX(),-y + centro.getY(), cor).draw(g);
		new Ponto(-x + centro.getX(),-y + centro.getY(), cor).draw(g);
		new Ponto(-y + centro.getX(),-x + centro.getY(), cor).draw(g);
		new Ponto(-y + centro.getX(), x + centro.getY(), cor).draw(g);
		new Ponto(-x + centro.getX(), y + centro.getY(), cor).draw(g);
	}
	
}
