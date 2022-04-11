/**
 * The aim of this class is to read a file, check if the input is valid and if it is
 * take it and count the word lengths and all of the individual words
 * It is assumed that the reader understands basic java syntax so some of the "straightforward" code
 * if left uncommented
 * It is assumed that some of the most common punctuation is not considered a word, more details
 * below
 *
 * @author: Sadik
 */
package com.WordLength.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class wordLengths {
    double average = 0;
    int temp = 0; // For the highest frequent word count
    int count = 0;
    String word = "";       // concatenates all of the input in order to avoid
    StringBuilder frequentLens = new StringBuilder(" for word lengths of ");
    String output = "";      // For the return method, required in order to return String
    HashMap<Integer, Integer> wordLengths = new HashMap<>();        // Speeds up the reading of the files


    /**
     *
     * @param input the file contents
     * @return output
     */
    public String readDataFile(Scanner input) {

        /**
         * This method consists of replacing most of the punctuation of each line and then
         * append it to the word variable, it is assumed that most of the punctuation
         * such as: . , ; : * and blank lines are not considered words, this assumption was made after
         * iterating through some online texts and the bible linked in the pdf. However,
         * & / \ - _ are considered words as they can be used for dates e.g. 12/01/2020 or 12/01/2020
         * where & can have the meaning "and" as such those expections where made
         *
         */
        while (input.hasNextLine()) {
            word += input.nextLine().replace(".", "")
                    .replace(",", "").replace(";", "")
                    .replace(":", "").replace("*", "")
                    .replace("\n", "");

        }
        /**
         * Simple Scanner input and line splitting, by splitting in white gaps
         * words array will be able to store each and every word, make them accessible
         */
        Scanner line = new Scanner(word);
        String[] words = line.nextLine().split(" ");

        /**
         * For loop goes through all of the words in the array
         * then if the word length does not exist in the hashmap, add it to
         * the hashmap, otherwise add + 1 if it already exists
         */
        for (String s : words) {
            average += s.length();

            if (!wordLengths.containsKey(s.length())) {
                wordLengths.put(s.length(), 1);
            } else {
                wordLengths.replace(s.length(), wordLengths.get(s.length()),
                        wordLengths.get(s.length()) + 1);
            }
        }

        output += "Word count: " + words.length + "\n" +
                "Average word length = " + String.format("%.3f", average / words.length) + "\n";

        for (Integer j : wordLengths.keySet()) {

            output += "Number of words of length " + j + " is " + wordLengths.get(j) + "\n";

            /**
             * Makes temp the highest length
             */
            if (wordLengths.get(j) > temp) {
                temp = wordLengths.get(j);
            }
        }

        /**
         * This for loop, loops through the i in the keyset, then everytime temp exists in the
         * current key value, add +1 to the counter.
         *
         */
        for (Integer i : wordLengths.keySet()) {

            if (wordLengths.get(i) == temp) {
                count++;
            }

            /**
             * everytime counter is 2, adds & and sets it back to one to prevent outputs such as
             * " 4 & 5 &"
             */
            if (count > 1) {
                frequentLens.append(" & ");
                count--;
            }

            /**
             * appends the current value to the frequency lengths
             */
            if (wordLengths.get(i) == temp) {
                frequentLens.append(i);
            }
        }

        output += "The most frequently occurring word length is " + temp + ","
                + frequentLens + "\n";

        input.close();
        System.out.println(output);
        return output;
    }

    /**
     * Method to read the file and return the output of words from this file. The
     * program should handle the file not found exception here and shut down the
     * program if the file does not exist.
     *
     * @param filename
     *            the name of the file
     * @return the String after parsing through the Scanner
     */
    public String readDataFile(String filename) {
        File input = new File(filename);

        Scanner in = null;

        try {
            in = new Scanner(input);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);                // Exits the system if file is not found
        }

        return readDataFile(in);
    }

}
