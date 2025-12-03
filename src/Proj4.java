import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Proj4 {
    public static void main(String[] args) throws IOException {
        // Use command line arguments to specify the input file
        if (args.length != 2) {
            System.err.println("Usage: java TestAvl <input file> <number of lines>");
            System.exit(1);
        }

        String inputFileName = args[0];
        int numLines = Integer.parseInt(args[1]);

        // For file input
        FileInputStream inputFileNameStream = null;
        Scanner inputFileNameScanner = null;

        // Open the input file
        inputFileNameStream = new FileInputStream(inputFileName);
        inputFileNameScanner = new Scanner(inputFileNameStream);

        // ignore first line
        inputFileNameScanner.nextLine();

        // FINISH ME
        ArrayList<Player> players = new ArrayList<>();

        for (int i = 0; i < numLines; i++) {
            if (!inputFileNameScanner.hasNextLine()) {
                System.err.println("The entered numLines is greater than the number of lines in the file (" + i + " lines exist in the input file).");
                System.exit(1);
            }
            String[] line = inputFileNameScanner.nextLine().split(",");
            try {
                players.add(new Player(line));
            } catch (Exception e) {
                System.out.println("Line Number " + (i + 1) + " has an invalid format.");
            }
        }
        inputFileNameScanner.close();



    }
}
