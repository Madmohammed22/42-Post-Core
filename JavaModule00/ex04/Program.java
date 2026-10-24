package JavaModule00.ex04;

import java.util.Arrays;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        final int MAXVALUE = 65536;
        System.out.print("-> ");
        Scanner scanner = new Scanner(System.in);
        int[] frequencies = new int[MAXVALUE];
        char[] arr;

        String input = scanner.nextLine();
        arr = input.toCharArray();
        for (char c : arr)
            frequencies[c]++;

        int uniqueCount = 0;
        for (int i = 0; i < MAXVALUE; i++){
            if (frequencies[i] > 0)
                uniqueCount++;
        }

        char[] uniqueChars = new char[uniqueCount];
        int[] uniqueFreqs = new int[uniqueCount];
        int index = 0;

        for (int i = 0; i < MAXVALUE; i++)
        {
            if (frequencies[i] > 0){
                uniqueChars[index] = (char) i;

                uniqueFreqs[index] = frequencies[i];
                index++;
            }
        }

        int limit = uniqueCount < 10 ? uniqueCount : 10;

        for (int i = 0; i < limit; i++)
        {
            int maxIndex = i;
            for (int j = i + 1; j < uniqueCount; j++) {
                // Strict '>' ensures stable sorting, preserving the original alphabetical order on a tie
                if (uniqueFreqs[j] > uniqueFreqs[maxIndex]) {
                    maxIndex = j;
                }
            }

            // Swap the frequencies
            int tempFreq = uniqueFreqs[i];
            uniqueFreqs[i] = uniqueFreqs[maxIndex];
            uniqueFreqs[maxIndex] = tempFreq;

            // Swap the corresponding characters to maintain parallel alignment
            char tempChar = uniqueChars[i];
            uniqueChars[i] = uniqueChars[maxIndex];
            uniqueChars[maxIndex] = tempChar;
        }

        // If the input was empty or uniqueCount is 0, we have nothing to print
        if (limit > 0) {
            int maxFreq = uniqueFreqs[0]; // The top element always holds the maximum frequency

            // Create an array to hold the calculated heights for our top elements
            int[] scaledHeights = new int[limit];
            for (int i = 0; i < limit; i++) {
                // Multiply first before dividing to preserve accuracy using integer math
                scaledHeights[i] = (uniqueFreqs[i] * 10) / maxFreq;
            }

            // Render from Row 11 (Max elevation for numerical labels) down to Row 0
            for (int row = 11; row >= 0; row--) {
                for (int i = 0; i < limit; i++) {

                    if (row == 0) {
                        // Row 0: Print the character labels
                        System.out.print(uniqueChars[i]);
                    } else if (row == scaledHeights[i] + 1) {
                        // Print the raw frequency number exactly one level above its highest '#' block
                        System.out.print(uniqueFreqs[i]);
                    } else if (row <= scaledHeights[i]) {
                        // Print the histogram bars
                        System.out.print("#");
                    } else {
                        // Clear sky area above numbers
                        System.out.print(" ");
                    }

                    // Formatting: Print a trailing space between items, except for the last column
                    if (i < limit - 1) {
                        System.out.print("  ");
                    }
                }
                // Move to the next line down
                System.out.println();
            }
        }

    }
}


/*
2. For each line containing a weekly class rule (e.g., "2 MO"), split it into an hour integer (2) and a weekday string ("MO").
3. Save them into your classHours and classDays arrays, and increment weeklyClassCount.
 */
