package DrawArea;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;

import Strokes.AbstractStrokes;
import Strokes.CircleStroke;

public class CircleDrawArea extends JComponent implements AbstractDrawArea {

	private int currentX, currentY, oldX, oldY, radius, xOffset, yOffset;

    private Graphics2D g2;
    private Image image;
    private Color color = Color.black;
    
    private AbstractStrokes stroke;
    
    public CircleDrawArea() {
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
                double distanceX, distanceY;
                
                if (currentX >= 200){
                    distanceX = currentX - 200;
                } else {
                    distanceX = 200 - currentX;
                }
                
                if (currentY >= 200){
                    distanceY = currentY - 200;
                } else {
                    distanceY = 200 - currentY;
                }
                
                double distance = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
                
                if (g2 != null && distance <= (radius/2 - 5)) {
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

    protected int getRadius() {
        // Determines the radius based on the smaller of the width
        // or height, so we stay symmetrical
        return Math.min(getWidth(), getHeight());
    }

    @Override
    public Insets getInsets() {
        radius = getRadius();
        xOffset = (getWidth() - radius) / 2;
        yOffset = (getHeight() - radius) / 2;
        // These are magic numbers, you might like to calculate
        // your own values based on your needs
        Insets insets = new Insets(
                radius / 6,
                radius / 6,
                radius / 6,
                radius / 6);
        return insets;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (image == null){
            radius = getRadius();
            xOffset = (getWidth() - radius) / 2;
            yOffset = (getHeight() - radius) / 2;

            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.white);
            g2.fillOval(xOffset, yOffset, radius, radius);
            g2.setColor(Color.black);
            g2.setStroke(this.stroke.getStroke());
            //sg2.drawOval(xOffset, yOffset, radius, radius);
        }
        
        //g2.dispose();
        g.drawImage(image, 0, 0, null);
    }

	@Override
	public void clear() {
		g2.setPaint(Color.white);
		g2.fillOval(xOffset, yOffset, radius, radius);
		g2.setPaint(this.color);
		repaint();
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
		g2.setColor(this.color);
	}

	public void setWidth(int width) {
		System.out.println("width circle");
		this.stroke = new CircleStroke(width);
	}

	@Override
	public void createStroke(AbstractStrokes stroke) {
		this.stroke = stroke;
	}

}
