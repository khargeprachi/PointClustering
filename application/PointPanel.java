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

	public void saveFile() {
		FileOutputStream f;
		try {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Specify a file to save");
			if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				File file= fileChooser.getSelectedFile();
				String path= file.getAbsolutePath();
				f = new FileOutputStream(new File(path));
				ObjectOutputStream o = new ObjectOutputStream(f);

				for(Point c : points) {
					o.writeObject(c);
				}
				o.close();
				f.close();
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
	}


}

