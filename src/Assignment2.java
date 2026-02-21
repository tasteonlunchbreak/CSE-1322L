import java.util.ArrayList;
import java.util.Scanner;

public class Assignment2 {
    public static int calculateEditDistance(String s1, String s2) {
        int[][] table = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            table[i][0] = i;
        }
        for (int j = 0; j <= s2.length(); j++) {
            table [0][j] = j;
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1];
                } else {
                    int left = table[i][j - 1];
                    int up = table[i - 1][j];
                    int diag = table[i - 1][j - 1];
                    table[i][j] = Math.min(Math.min(left,up), diag) + 1;

                }
            }
        }

        return table[s1.length()][s2.length()];
    }
    public static void updateCandidates(ArrayList<Word> candidates, Word newWord) {
        int index = 0;

        while (index < candidates.size() && candidates.get(index).editDistance < newWord.editDistance) {
            index++;
        }
        candidates.add(index, newWord);

        if (candidates.size() > 5) {
            candidates.remove(5);
        }
    }
    public static void spellCheckSentence(ArrayList<String> dictionary, String sentence, Scanner input) {
        sentence = sentence.toLowerCase();
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];

            if (dictionary.contains(currentWord)) {
                continue;
            }

            ArrayList<Word> candidates = new ArrayList<>();

            for (String dictWord : dictionary) {
                int distance = calculateEditDistance(currentWord, dictWord);
                Word w = new Word(currentWord, dictWord, distance);
                updateCandidates(candidates, w);
            }
            System.out.println();
            System.out.println("'" + currentWord + "' not in dictionary. Pick an option: ");

            for (int j = 0; j < candidates.size(); j++) {
                System.out.println(j + ". Replace with '" + candidates.get(j).candidateWord + "'");
            }
            System.out.println("5. Add '" + currentWord + "' to dictionary");

            int choice = input.nextInt();
            input.nextLine();

            if (choice == 5) {
                dictionary.add(currentWord);
                System.out.println("'" + currentWord + "' added to dictionary");
            } else {
                String replacement = candidates.get(choice).candidateWord;
                words[i] = replacement;
                System.out.println("Replaced '" + currentWord + "' with '" + replacement + "'");
            }
        }
        System.out.print("\nThe final sentence is: ");
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i]);
            if ( i < words.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("'\n");
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> dictionary = Dictionary.getDictionary();

        System.out.println("[Spell Checker]\n");

        while (true) {
            System.out.print("Enter a sentence to spell-check, or nothing to quit: ");
            String sentence = input.nextLine();

            System.out.println("\nYou've entered '" + sentence + "'\n");

            if (sentence.isEmpty()) {
                System.out.println("Shutting off...");
                break;
            }
            spellCheckSentence(dictionary, sentence, input);
        }
        input.close();
    }
    
}
