package application;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RunService {

    public void runActionListener(JButton runButton, PointPanel p) {

        runButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*System.out.println("Running");*/
                String d=JOptionPane.showInputDialog(p,"Enter Eucledian distance :");
                if(d != null) {
                    try {
                        int distance = Integer.parseInt(d);
                        System.out.println(distance + " is a valid integer");
                        dbScan(p,distance);
                    }
                    catch (NumberFormatException e1){
                        JOptionPane.showMessageDialog(p,d + " is not a valid integer");
                    }
                }
            }
        });
    }

    public double distance(Point x, Point y) {
        double x1 = x.getX();
        double x2 = y.getX();
        double y1 = x.getY();
        double y2 = y.getY();
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }


    public void dbScan(PointPanel p, int d) {

        List<Point> points = p.getPoints();
        List<Point> markedPoints = p.getMarked();

        while(points.size() > 0) {
            markedPoints.add(points.get(0));
            while(markedPoints.size() > 0) {
                Point x = markedPoints.get(0);
                markedPoints.remove(x);
                points.remove(x);
                System.out.println(x.getX() + " " + x.getY());

                p.getVisited().add(x);


                for(Point y:points) {
                    if(distance(y,x) < d) {
                        if(!p.getVisited().contains(y)) {
                            p.getGraphics().drawLine(x.getX(), x.getY(), y.getX(), y.getY());
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        p.getVisited().add(y);
                        markedPoints.add(y);
                    }
                }
                p.setPoints(points);
                p.setMarked(markedPoints);

            }
        }
    }
}
