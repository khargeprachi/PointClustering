package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;


public class ClearFileService {
	
    public void clearActionListener(JButton clearButton, PointPanel p) {

    	clearButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
           	/*System.out.println("Clearing");*/
        	   clearPoints(p);
           }
       });
    }
	
    
    
    public void clearPoints(PointPanel p) {
    	
        p.setUnDraw(p.getPoints());
		// unDraw = p.getPoints();
		p.setPoints( new LinkedList<Point>());
	//	System.out.println("should be removed" +  unDraw.size());
		p.repaint();
    	
    	
    }
}
