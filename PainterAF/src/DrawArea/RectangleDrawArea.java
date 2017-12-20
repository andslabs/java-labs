package DrawArea;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;

import Strokes.AbstractStrokes;
import Strokes.RectangleStroke;

public class RectangleDrawArea extends JComponent implements AbstractDrawArea {

	// Image in which we're going to draw
	private Image image;

	// Graphics2D object ==> used to draw on
	private Graphics2D g2;
	private AbstractStrokes stroke;
	private Color color = Color.black;

	// Mouse coordinates
	private int currentX, currentY, oldX, oldY;

	public RectangleDrawArea() {
		setDoubleBuffered(false);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				oldX = e.getX();
				oldY = e.getY();
			}

		});

		addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				currentX = e.getX();
				currentY = e.getY();

				if (g2 != null) {
					g2.drawLine(oldX, oldY, currentX, currentY);
					repaint();
					oldX = currentX;
					oldY = currentY;
				}
			}

		});
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(400, 400);
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (image == null) {
			// image == null ==> create
			image = createImage(getSize().width, getSize().height);
			g2 = (Graphics2D) image.getGraphics();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setStroke(this.stroke.getStroke());
			clear();
		}

		g.drawImage(image, 0, 0, null);
	}

	// creating exposed methods
	@Override
	public void clear() {
		g2.setPaint(Color.white);
		g2.fillRect(0, 0, getSize().width, getSize().height);
		g2.setPaint(this.color);
		repaint();
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
		g2.setColor(this.color);
	}

	public void setWidth(int width) {
		System.out.println("width rec");
		this.stroke = new RectangleStroke(width);
	}

	@Override
	public void createStroke(AbstractStrokes stroke) {
		this.stroke = stroke;
	}

}
