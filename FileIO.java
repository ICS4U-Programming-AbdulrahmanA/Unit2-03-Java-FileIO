import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Reads numbers from input.txt and saves their total in output.txt.
 */
public final class FileIO {

    /**
     * This class only contains the program entry point.
     */
    private FileIO() {
    }

    /**
     * Reads the file, checks each number, and adds valid values.
     *
     * @param args Command line arguments
     */
    public static void main(final String[] args) throws IOException {
        // Open the files so we can read numbers and save the results.
        Scanner scanner = new Scanner(new File("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        // Start at zero and add each valid number to this total.
        int sum = 0;

        // Keep going until there are no lines left in the input file.
        while (scanner.hasNextLine()) {
            // Trim extra spaces so blank lines are easy to recognize.
            String line = scanner.nextLine().trim();

            // A blank line has no numbers to split.
            if (!line.isEmpty()) {
                // Commas and spaces can separate the numbers.
                String[] numbers = line.split("[,\\s]+");

                // Check each number before moving to the next line.
                for (String value : numbers) {
                    try {
                        // File values are Strings, so convert each one first.
                        int number = Integer.parseInt(value);

                        // Only valid integers go into the running total.
                        sum += number;
                    } catch (NumberFormatException e) {
                        // Record bad input, then continue with the next value.
                        writer.println("Error: invalid input");
                    }
                }
            }
        }

        // Write the total and close both files when finished.
        writer.println(sum);
        scanner.close();
        writer.close();
    }
}
