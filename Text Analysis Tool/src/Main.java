import java.util.*;
/**
 * This class provides methods for analyzing text input, including counting characters and words,
 * finding the most common character, and calculating the frequency of characters and words.
 *
 * <p>
 * This program prompts the user to enter text and then provides various analysis options such as
 * counting characters, words, finding the most common character, and calculating the frequency
 * of specific characters and words.
 * </p>
 *
 * <p><strong>Author:</strong> Thuta Tun</p>
 * <p><strong>Date:</strong> February 4, 2024</p>
 */
public class Main {
    /**
     * Finds the most common character in the text.
     *
     * @param text The text to analyze.
     * @return The most common character.
     */
    public static char mostCommonCharacter(String text) {
        text = text.toLowerCase();
        int[] freq = new int[26];  // for 26 lowercase English letters
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                freq[c - 'a']++;
            }
        }
        int maxFreqIndex = 0;
        for (int i = 1; i < 26; i++) {
            if (freq[i] > freq[maxFreqIndex]) {
                maxFreqIndex = i;
            }
        }
        return (char) (maxFreqIndex + 'a');
    }

    /**
     * Counts the frequency of a character in the text.
     *
     * @param text The text to analyze.
     * @param c    The character to count.
     * @return The frequency of the character.
     */
    public static int countCharacterFrequency(String text, char c) {
        text = text.toLowerCase();
        c = Character.toLowerCase(c);
        int count = 0;
        for (char ch : text.toCharArray()) {
            if (ch == c) {
                count++;
            }
        }
        return count;
    }

    /**
     * Counts the frequency of a word in the text.
     *
     * @param text The text to analyze.
     * @param word The word to count.
     * @return The frequency of the word.
     */
    public static int countWordFrequency(String text, String word) {
        text = text.toLowerCase();
        word = word.toLowerCase();
        String[] words = text.split("\\s+");
        int count = 0;
        for (String w : words) {
            if (w.equals(word)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Counts the number of unique words in the text.
     *
     * @param words The words to analyze.
     * @return The number of unique words.
     */
    public static int countUniqueWords(String[] words) {
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word.toLowerCase());
        }
        return uniqueWords.size();
    }

    /**
     * Asks the user if they want to continue.
     *
     * @return true if the user wants to continue, false otherwise.
     */
    public static boolean askToContinue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to continue? (Yes/No)");
        try {
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                return true;
            } else if (choice.equalsIgnoreCase("no")) {
                System.out.println("Exiting program...");
                System.exit(0);
            } else {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter only 'Yes' or 'No'.");
            return askToContinue();
        }
        return false;
    }

    /**
     * Calling the Main method
     */
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            analyzeText();
            exit = !askToContinue();
        }
    }


    /**
     * Analyzes the text input provided by the user.
     */
    public static void analyzeText() {
        Scanner scanner = new Scanner(System.in);


        try {
            // User Input
            System.out.println("Please enter your text:");
            String text = scanner.nextLine();

            // Character Count
            int charCount = text.length();
            System.out.println("Character Count: " + charCount);

            // Word Count
            String[] words = text.split("\\s+");
            int wordCount = words.length;
            System.out.println("Word Count: " + wordCount);

            // Most Common Character
            char mostCommonChar = mostCommonCharacter(text);
            System.out.println("Most Common Character: " + mostCommonChar);

            // Character Frequency
            System.out.println("Please enter a character to check its frequency:");
            char c = scanner.next().charAt(0);
            int charFrequency = countCharacterFrequency(text, c);
            System.out.println("Frequency of '" + c + "': " + charFrequency);

            // Word Frequency
            System.out.println("Please enter a word to check its frequency:");
            scanner.nextLine();  // clear the buffer
            String word = scanner.nextLine();
            int wordFrequency = countWordFrequency(text, word);
            System.out.println("Frequency of '" + word + "': " + wordFrequency);

            // Unique Words
            int uniqueWords = countUniqueWords(words);
            System.out.println("Number of Unique Words: " + uniqueWords);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}




