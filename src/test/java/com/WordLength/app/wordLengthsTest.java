package com.WordLength.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class wordLengthsTest {
    wordLengths scanning = new wordLengths();
    String exampleText = "src/main/resources/example.txt";
    String exampleMidText = "src/main/resources/exampleMed.txt";
    String exampleLargeText = "src/main/resources/bibleExample.txt";

    @Test
    @DisplayName("Example input shown in the pdf should work as expected")
    void testExamples() {
        Assertions.assertEquals("Word count: 9\n" +
                        "Average word length = 4.556\n" +
                        "Number of words of length 1 is 1\n" +
                        "Number of words of length 2 is 1\n" +
                        "Number of words of length 3 is 1\n" +
                        "Number of words of length 4 is 2\n" +
                        "Number of words of length 5 is 2\n" +
                        "Number of words of length 7 is 1\n" +
                        "Number of words of length 10 is 1\n" +
                        "The most frequently occurring word length is 2, for word lengths of 4 & 5\n",
                scanning.readDataFile(exampleText));

    }

    @Test
    @DisplayName("The test should work regardless of how many lines and " +
            "special characters are in it")
    void testWithMultipleBlankLines() {
        Assertions.assertEquals("Word count: 15\n" +
                        "Average word length = 4.400\n" +
                        "Number of words of length 1 is 3\n" +
                        "Number of words of length 2 is 2\n" +
                        "Number of words of length 3 is 1\n" +
                        "Number of words of length 4 is 2\n" +
                        "Number of words of length 5 is 2\n" +
                        "Number of words of length 6 is 1\n" +
                        "Number of words of length 7 is 2\n" +
                        "Number of words of length 8 is 1\n" +
                        "Number of words of length 10 is 1\n" +
                        "The most frequently occurring word length is 3, for word lengths of 1\n",
                scanning.readDataFile(exampleMidText));
    }

    @Test
    @DisplayName("The test should work with large files and everything previously tested")
    void testWithLargeFile() {
        Assertions.assertEquals("Word count: 792942\n" +
                        "Average word length = 4.090\n" +
                        "Number of words of length 0 is 1930\n" +
                        "Number of words of length 1 is 18127\n" +
                        "Number of words of length 2 is 130631\n" +
                        "Number of words of length 3 is 220403\n" +
                        "Number of words of length 4 is 174765\n" +
                        "Number of words of length 5 is 96239\n" +
                        "Number of words of length 6 is 53097\n" +
                        "Number of words of length 7 is 40018\n" +
                        "Number of words of length 8 is 25346\n" +
                        "Number of words of length 9 is 16921\n" +
                        "Number of words of length 10 is 7739\n" +
                        "Number of words of length 11 is 4138\n" +
                        "Number of words of length 12 is 1893\n" +
                        "Number of words of length 13 is 1002\n" +
                        "Number of words of length 14 is 434\n" +
                        "Number of words of length 15 is 154\n" +
                        "Number of words of length 16 is 55\n" +
                        "Number of words of length 17 is 23\n" +
                        "Number of words of length 18 is 16\n" +
                        "Number of words of length 19 is 3\n" +
                        "Number of words of length 20 is 5\n" +
                        "Number of words of length 21 is 1\n" +
                        "Number of words of length 27 is 2\n" +
                        "The most frequently occurring word length is 220403, for word lengths of 3\n",
                scanning.readDataFile(exampleLargeText));
    }
}