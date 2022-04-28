

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawClickListener extends MouseAdapter {
	
	private PointPanel panel; 
	
	
	public DrawClickListener(PointPanel panel) {
		super();
		this.panel = panel;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		panel.addPoints(new Point(e.getX(), e.getY()));
	}
}
