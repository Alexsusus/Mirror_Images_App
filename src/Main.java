
import java.io.File;

import java.util.Arrays;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

public class Main {

    public static void main(String[] args) {

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Multiple file and directory selection:");
        jfc.setMultiSelectionEnabled(true);
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File[] files = jfc.getSelectedFiles();
            System.out.println("Files Found\n");
            Arrays.asList(files).forEach(x -> {
                if (x.isFile()) {
                    System.out.println(x.getName());
                }
            });

            String pathNewDirectory = files[0].toString();
            pathNewDirectory = pathNewDirectory.replace(Arrays.asList(files).get(0).getName(),
                    "Mirror result");
            File newDirectory = new File(pathNewDirectory);
            System.out.println();
            System.out.println(newDirectory.mkdir());

            for (int i = 0; i < files.length; i++) {
                File input = new File(files[i].toString());
                File output = new File(
                        pathNewDirectory + "\\" + i + ".jpg");
                Image.flip(input, output);
            }
        }
        JOptionPane.showMessageDialog(null,"Mirroring done");
    }
}