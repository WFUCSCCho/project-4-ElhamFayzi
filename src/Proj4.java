import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Proj4 {
    private static ArrayList<Player> players;
    private static SeparateChainingHashTable<Player> hashTable;

    public static double measureRuntime(String operation) {
        long startTime;
        long endTime;
        double result;

        switch (operation.toLowerCase()) {
            case "insert" -> {
                startTime = System.nanoTime();
                for (Player p : players) {
                    hashTable.insert(p);
                }
                endTime = System.nanoTime();
            }

            case "search" -> {
                startTime = System.nanoTime();
                for (Player p : players) {
                    hashTable.contains(p);
                }
                endTime = System.nanoTime();
            }

            case "delete" -> {
                startTime = System.nanoTime();
                for (Player p : players) {
                    hashTable.remove(p);
                }
                endTime = System.nanoTime();

            }

            default -> {
                throw new IllegalArgumentException();
            }
        }
        result = (endTime - startTime) / 1_000_000.0;
        return result;
    }

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
        players = new ArrayList<>();

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

        // =============================
        // Initialize runtime and hashTable
        // =============================
        hashTable = new SeparateChainingHashTable<>();
        long startTime;
        long endTime;
        // Each array contains 3 doubles which are insertion, searching, and deletion operations times, respectively.
        double[] runtimeSorted = new double[3];
        double[] runtimeShuffled = new double[3];
        double[] runtimeReversed = new double[3];

        // =============================
        // Measure running times for sorted list
        Collections.sort(players);
        //1) Insertion
        runtimeSorted[0] = measureRuntime("insert");
        //2) Search
        runtimeSorted[1] = measureRuntime("search");
        //3) Deletion
        runtimeSorted[2] = measureRuntime("delete");

        // =============================
        // Measure running times for shuffled list=
        Collections.shuffle(players);
        //1) Insertion
        runtimeShuffled[0] = measureRuntime("insert");
        //2) Search
        runtimeShuffled[1] = measureRuntime("search");
        //3) Deletion
        runtimeShuffled[2] = measureRuntime("delete");

        // =============================
        // Measure running times for reversed list
        Collections.sort(players, Collections.reverseOrder());
        //1) Insertion
        runtimeReversed[0] = measureRuntime("insert");
        //2) Search
        runtimeReversed[1] = measureRuntime("search");
        //3) Deletion
        runtimeReversed[2] = measureRuntime("delete");

        // =============================


        // Append runtime analysis to analysis.txt
        File file = new File("analysis.txt");
        boolean fileExists = file.exists();

        FileOutputStream fos = new FileOutputStream(file, true);
        PrintWriter writer = new PrintWriter(fos);

        if (!fileExists) {
            writer.println("NumLines" + "," + "SortedInsertion" + "," + "SortedSearch" + "," + "SortedDeletion" + "," + "ShuffledInsertion" + "," + "ShuffledSearch" + "," + "ShuffledDeletion" + "," + "ReversedInsertion" + "," + "ReversedSearch" + "ReversedDeletion" );
        }
        writer.print(numLines + "," + runtimeSorted[0] + "," + runtimeSorted[1] + "," + runtimeSorted[2] + "," + runtimeShuffled[0] + "," + runtimeShuffled[1] + "," + runtimeShuffled[2] + "," + runtimeReversed[0] + "," + runtimeReversed[1] + "," + runtimeReversed[2]);
        writer.println();
        writer.flush();
        writer.close();

        // Print results to console
        System.out.println("============================================");
        System.out.println("Runtimes in milliseconds for " + numLines + " lines");
        System.out.println(" – Already-sorted list: ");
        System.out.println("   -- insert: " + runtimeSorted[0]);
        System.out.println("   -- search: " + runtimeSorted[1]);
        System.out.println("   -- delete: " + runtimeSorted[2]);
        System.out.println(" – Randomly-shuffled list: ");
        System.out.println("   -- insert: " + runtimeShuffled[0]);
        System.out.println("   -- search: " + runtimeShuffled[1]);
        System.out.println("   -- delete: " + runtimeShuffled[2]);
        System.out.println(" – Reversed list: ");
        System.out.println("   -- insert: " + runtimeReversed[0]);
        System.out.println("   -- search: " + runtimeReversed[1]);
        System.out.println("   -- delete: " + runtimeReversed[2]);
        System.out.println("============================================");
    }
}
