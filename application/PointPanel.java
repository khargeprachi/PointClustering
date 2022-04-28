

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Math;  

public class PointPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Point> points = new LinkedList<Point>();

	public void addPoints(Point point) {
		points.add(point);
		this.repaint();
	}
	
	
	@Override
	public void paint(Graphics g) {
		for(Point p : points) {
			p.draw(g);
		}
	
	}
}
