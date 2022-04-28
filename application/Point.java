

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
public class Point implements Serializable{
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillOval(x, y, 5, 5);
	}
	
	public void unDraw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, 5, 5);
	}
	@Override
	public String toString() {
		return "x:" + this.x + "\ty: " + this.y + "\n";
	}
}
