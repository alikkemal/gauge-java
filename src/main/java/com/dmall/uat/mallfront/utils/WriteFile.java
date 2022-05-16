package com.dmall.uat.mallfront.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class WriteFile {

    public static void writeToFile(Collection<String> txtFile) {
        File file = new File("src/main/resources/file.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(txtFile.toString() + "\n");
            bw.close();
        } catch (IOException e) {
            System.out.println("Cannot write to file" + txtFile);
        }
    }

    public static void writeFile(String fileName, ArrayList<String> data) {
        try {
            FileWriter fw = new FileWriter(fileName);
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < data.size(); i++) {
                pw.println(data.get(i));
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Cannot write to file " + fileName);
        }
    }
}
