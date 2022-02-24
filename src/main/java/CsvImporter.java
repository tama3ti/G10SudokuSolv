import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CsvImporter {
    private CsvImporter() {}


    public static int[][] run() throws FileNotFoundException {
        File file = null;
        Scanner myObj = new Scanner(System.in);

        try {
            System.out.println("Input file path >");
            file = new File(myObj.nextLine()); //Input dir
            System.out.println("Loading file... " + file);  // Output user input

        } catch (IllegalArgumentException iae) {
            System.out.println("File Not Found");
        }

        return getMatrixFromArray(getArrayFromString(getFileString(file)));
    }


    /*
    Takes out the data from the file submitted by the user
    */
    public static String getFileString(File path) throws FileNotFoundException {
        //No need for a try-cache since it checks for it above
        Scanner myReader = new Scanner(path);
        String data = myReader.nextLine();
        return data;
    }

    /*
    Goes through the String and adds every integer into an arraylist
    */
    public static ArrayList<Integer> getArrayFromString(String data){
        ArrayList<Integer> testArray = new ArrayList<>();

        for (int i = 0; i < data.length(); i++) {
            if (Character.isDigit(data.charAt(i))){
                testArray.add(Integer.parseInt(String.valueOf(data.charAt(i))));
            }
        }
        return testArray;
    }

    /*
    Makes an matrix out of a number arraylist using math
     */
    public static int[][] getMatrixFromArray(ArrayList<Integer> data){
        int[][] matrix = new int[9][9];

        for (int i = 0; i < 9; i++) {
           for (int j = 0; j < 9; j++) {
               matrix[j][i] = data.get(j*9 + i);
           }
        }
        return matrix;
    }
}
