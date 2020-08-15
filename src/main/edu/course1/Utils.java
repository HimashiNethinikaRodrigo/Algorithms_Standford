package main.edu.course1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Utils {
    public  static int[] readInputFile (String file, int size){
        Scanner fileOut = null;
        int[] numbers = new int[size];
        try {
            fileOut = new Scanner(new FileReader(new File(file)));
            int i= 0;
            while (fileOut.hasNext()) {
                numbers[i]= fileOut.nextInt();
                i++;
            }
        }catch (FileNotFoundException fileNotFoundException) {
            System.out.println(file+ " cannot find specified file");
        } finally {
            if (fileOut != null)
                fileOut.close();
        }
        return numbers;
    }
}
