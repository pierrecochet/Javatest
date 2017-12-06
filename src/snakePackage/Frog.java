package snakePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class Frog extends Box {

	private final static Random RND = new Random();

	private int angle;

	public Frog() {
		super(getRandomX(), getRandomY());
	}

	private static int getRandomX() {
		return RND.nextInt(COLUMNS_NUMBER);
	}

	private static int getRandomY() {
		return RND.nextInt(LINES_NUMBER);
	}

	public void newFrog() {
		setXIndex(getRandomX());
		setYIndex(getRandomY());
		this.angle = 0;
	}

	public void calculation() {
		// Creation of the rotation of 4 degres
		this.angle += 4;
	}

	public void display(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		AffineTransform tr = g2.getTransform();
		g.setColor(Color.RED);
		// rotation
		g2.setTransform(AffineTransform.getRotateInstance(
				Math.toRadians(this.angle), getX() + (getWidth() / 2), getY()
						+ (getHight() / 2)));
		g.fillRect(getX() + 2, getY() + 2, getWidth() - 4, getHight() - 4);
		// stop the rotation
		g2.setTransform(tr);
	}

}
