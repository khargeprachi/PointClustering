package application;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;


import java.lang.Math;

public class PointPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Point> points = new LinkedList<Point>();
	private List<Point> unDraw = new LinkedList<Point>();

	public List<Point> getUnDraw() {
		return unDraw;
	}


	public void setUnDraw(List<Point> unDraw) {
		this.unDraw = unDraw;
	}


	public void addPoints(Point point) {
		points.add(point);
		this.repaint();
	}
	
	
	@Override
	public void paint(Graphics g) {
		for(Point p : points) {
			p.draw(g);
		}
		for(Point c: unDraw) {
			c.unDraw(g);
		}
		unDraw.clear();
	}


	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	
}

