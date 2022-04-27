package PointClustering;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class SaveFileService {

   //TODO: uncomment after integration
    /*
        save.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            saveCircles();
        }
    }
    */
    public static void saveFile(String filePath) throws IOException {
//        File tempDirectory = new File(System.getProperty("java.io.tmpdir"));
//
//        File fileWithAbsolutePath = new File(tempDirectory.getAbsolutePath() + "/testFile.txt");
//        filePath=tempDirectory.getAbsolutePath() + "/testFile.txt";
//        Files.deleteIfExists(Path.of(filePath));
//        Path path = Files.createFile(Path.of(tempDirectory.getAbsolutePath() + "/testFile.txt"));
//        System.out.println("File stored at "+ path);



    }

    public void saveCircles() {
        JTextField textField = null;
        FileReader reader;
        FileWriter writer;
        BufferedReader br;
        BufferedWriter bw;


        {
            JFileChooser FileChooser = new JFileChooser();
            FileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

//            FileChooser.showOpenDialog(null);
//            File f= FileChooser.getSelectedFile();
//            String path= f.getAbsolutePath();
            try
            {
//                reader = new FileReader(path);
//                br = new BufferedReader(reader);
//                textField.read(br, null);
//                br.close();
//                textField.requestFocus();
//
                File selectedFile;
                //...
                selectedFile = null;
                if (FileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    selectedFile = FileChooser.getSelectedFile();
                    String path= selectedFile.getAbsolutePath();

                    FileOutputStream f;
                    try {
                        f = new FileOutputStream(new File(path));
                        ObjectOutputStream o = new ObjectOutputStream(f);

                        for(Circle c : circles) {
                            o.writeObject(c);
                        }
                        o.close();
                        f.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found");
                    } catch (IOException e) {
                        System.out.println("Error initializing stream");
                    }

//                    textField.setText(path);
                }




//              if (selectedFile != null) {
//
//                  try {
//                      Files.copy(
//                          selectedFile.toPath(),
//                          new File("E:/new.txt").toPath(),
//                          StandardCopyOption.REPLACE_EXISTING);
//                  } catch (IOException ex) {
//                      ex.printStackTrace();
//                  }
//
//              }
            }
            catch(Exception e1)
            {
                JOptionPane.showMessageDialog(null, e1);
                //  Check Later
                JOptionPane.showMessageDialog(FileChooser, e1);
            }
        }
    }
}
}
