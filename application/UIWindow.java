

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class UIWindow extends JFrame {

	JButton save, load, generate, run, clear;
	/*JLayeredPane panel;*/
	private final JSplitPane splitPane;  // split the window in top and bottom
    private final JPanel bottomPanel;    // container panel for the bottom
    
    UIWindow(){
		splitPane = new JSplitPane();

        bottomPanel = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(700, 700));     // let's open the window with a default size of 400x400 pixels
        getContentPane().setLayout(new GridLayout());  // the default GridLayout is like a grid with 1 column and 1 row,
        getContentPane().add(splitPane);               // due to the GridLayout, our splitPane will now fill the whole window

        PointPanel p = new PointPanel();
    	p.addMouseListener(new DrawClickListener(p));
    	
		splitPane.setBackground(Color.white);
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);  // we want it to split the window vertically
        splitPane.setDividerLocation(600);  
        splitPane.setTopComponent(p);
        splitPane.setBottomComponent(bottomPanel);            // and at the bottom we want our "bottomPanel"
        
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        save = new JButton("Save");
		save.setFocusable(false);
		load = new JButton("Load");
		load.setFocusable(false);
		generate = new JButton("Generate");
		generate.setFocusable(false);
		run = new JButton("Run");
		run.setFocusable(false);
		clear = new JButton("Clear");
		clear.setFocusable(false);
		
		bottomPanel.add(save);
		bottomPanel.add(load);
		bottomPanel.add(generate);
		bottomPanel.add(run);
        bottomPanel.add(clear);               
        
        
        pack();
        validate();
		this.setVisible(true);
		this.setResizable(false);
	}

}
