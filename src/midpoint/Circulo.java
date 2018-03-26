package midpoint;

import java.awt.Color;
import java.awt.Graphics;

import basics.Ponto;

/**
 * Esta classe representa uma circunferência e corresponde a primitiva gráfica
 * para criação e desenho de círculos. 
 * Nesta versão é implementado o algoritmo do Ponto Médio para traçado de círculos.
 * 
 * @author Leandro Fernandes
 */
public class Circulo {
	
	private Ponto centro;
	private int raio;
	private Color cor;

	/**
	 * Construtor padrão.
	 * Cria uma nova circunferência com centro na origem, na cor padrão (azul).
	 */
	public Circulo() {
		this(new Ponto(), 10);
	}
	
	/**
	 * Cria uma nova linha com extremidades nos pontos informados, na cor padrão.
	 * @param centro ponto que determina o centro da circunferência.
	 * @param raio valor correspondente ao comprimento do raio.
	 */
	public Circulo(Ponto centro, int raio) {
		this(centro, raio, Color.MAGENTA);
	}
	
	/**
	 * Cria uma nova circunferência com centro no ponto informado, raio igual ao
	 * comprimento dado e com a cor padrão especificada.
	 * @param centro ponto que determina o centro da circunferência.
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
	 * Método responsável por desenhar o círculo no elemento gráfico informado.
	 * @param g elemento gráfico onde será desenhado a primitiva.
	 */
	public void draw(Graphics g) {
		MIDPOINT_CIRCLE_ALGORITHM(raio, g);
	}
	
	/**
	 * Método que desenha cada um dos pontos do segmento de uma seção do circulo
	 * no dispositivo gráfico empregando o algoritmo do ponto médio e simetria.
	 * @param raio valor ou tamanho do raio da circunferência.
	 * @param g elemento gráfico onde serão desenhados os pontos da primitiva.
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
	 * seções do circulo, de acordo com a sua correspondência simétrica.
	 * @param x coordenada X do pixel
	 * @param y coordenada Y do pixel
	 * @param g dispositivo ou componente gráfico onde será desenhado o ponto.
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
