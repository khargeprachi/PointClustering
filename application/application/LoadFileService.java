package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFileChooser;

public class LoadFileService {
	 public void loadActionListener(JButton loadButton, PointPanel p) {

	        loadButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                /*System.out.println("Saving");*/
	                loadFile(p);
	            }
	        });

	    }
	 
	 
	 public void loadFile(PointPanel p) {
		 
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
				 p.setUnDraw(p.getPoints());
					// unDraw = p.getPoints();
				 p.setPoints( new LinkedList<Point>());
				
				while ((obj = oi.readObject()) != null) {
					p.getPoints().add((Point) obj);
				}
				oi.close();
				fi.close();
				p.repaint();
			} catch (FileNotFoundException e) {
				System.out.println("File not found");
			} catch (IOException e) {
				System.out.println("Error initializing stream");
				p.repaint();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			}
	 }
}
