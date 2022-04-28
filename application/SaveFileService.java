package application;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SaveFileService {

    public void saveActionListener(JButton saveButton, PointPanel p) {

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*System.out.println("Saving");*/
                saveFile(p);
            }
        });

    }

    public void saveFile(PointPanel p) {
        FileOutputStream f;
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Specify a file to save");
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file= fileChooser.getSelectedFile();
                String path= file.getAbsolutePath();
                f = new FileOutputStream(new File(path));
                ObjectOutputStream o = new ObjectOutputStream(f);

                for(Point c : p.getPoints()) {
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
