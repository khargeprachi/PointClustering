

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFileChooser;
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
	private List<Point> unDraw = new LinkedList<Point>();


	public void addPoints(Point point) {
		points.add(point);
		this.repaint();
	}
	
	public void loadFile() {
		FileInputStream fi;
		JFileChooser fileChooser = new JFileChooser();
		File selectedFile;
		
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            String path= selectedFile.getAbsolutePath();
			
		try {
			
			fi = new FileInputStream(new File(path));
			ObjectInputStream oi = new ObjectInputStream(fi);
			Object obj = null;
			unDraw = points;
			points = new LinkedList<Point>();
			while ((obj = oi.readObject()) != null) {
				points.add((Point) obj);
			}
			oi.close();
			fi.close();
			this.repaint();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
			this.repaint();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}
	}
	
	
	@Override
	public void paint(Graphics g) {
		for(Point p : points) {
			p.draw(g);
		}
	
	}
}
