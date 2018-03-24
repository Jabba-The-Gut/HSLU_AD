package ch.hslu.ad.sw05.N1.Aufg4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Eigenes Panel, welches Mouse-Listener interface implementiert, um auf
 * Maus-Clicks zu reagieren und dann Kreise zeichnet
 * 
 * @author jabbathegut
 *
 */
public class CustomPanel extends JPanel implements MouseListener {
	private static final long serialVersionUID = 1L;
	// Liste, um sich alle Kreise auf dem Jpanel zu merken
	private final List<Circle> circles;

	public CustomPanel(final int width, final int height) {
		circles = new ArrayList<>();
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(width, height));
		addMouseListener(this);

		// Zeichne alle 100ms den Inhalt auf dem JPanel neu
		Timer timer = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		timer.setRepeats(true);
		timer.setCoalesce(true);
		timer.start();
	}

	/**
	 * paint-Methode der UI, wird aufgerufen, wenn repaint()-Methode aufgerufen wird
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Update alle Kreise, welche auf dem JPanel sind
		Graphics2D g2 = (Graphics2D) g;
		for (Circle circle : circles) {
			circle.drawCircle(g2);

			// Beende den Thread des Balles, wenn er fertig ist, also unten
			if (circle.isAtTheBottom()) {
				circle.getThreadBehindBall().interrupt();
			}
		}
	}

	/**
	 * Mouse-Klick-Event. Fuegt dem JPanel einen Kreis hinzu
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		Circle circle = new Circle(e.getX(), e.getY());
		Thread thread = new Thread(circle);
		thread.start();
		circles.add(circle);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
