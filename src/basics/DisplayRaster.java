package basics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DisplayRaster extends JPanel {

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.LIGHT_GRAY);
		for (int x = 1; x <= getWidth(); x += 10)
			g.drawLine(x, 0, x, getHeight());
		for (int y =-1; y <= getHeight(); y += 10)
			g.drawLine(0, y, getWidth(), y);
	}

}
