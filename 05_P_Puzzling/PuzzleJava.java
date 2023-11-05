import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {

    Random randomMachine = new Random();
    
    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> randomNumbers = new ArrayList<Integer>();

        for (int i = 1; i <= 10; i++) {
            // Generate a random number between 1 and 20 (inclusive)
            int randomNumber = randomMachine.nextInt(20) + 1;
            randomNumbers.add(randomNumber);
        }
        return randomNumbers;
    }

    public char getRandomLetter() {
        // Create an ArrayList containing all 26 letters of the alphabet
        ArrayList<Character> alphabet = new ArrayList<>();
        for (char letter = 'a'; letter <= 'z'; letter++) {
            alphabet.add(letter);
        }

        // Generate a random index between 0 and 25
        int randomIndex = randomMachine.nextInt(26);

        // Return the random letter at the generated index
        return alphabet.get(randomIndex);
    }

    // create a random string of eight characters and return that string
    public String generatePassword() {
        StringBuilder randomString = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            randomString.append(getRandomLetter());
        }

        return randomString.toString();
    }

    // create an array of random eight-character words
    public ArrayList<String> getNewPasswordSet(int length) {
        ArrayList<String> passwords = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            String randomPassword = generatePassword();
            passwords.add(randomPassword);
        }

        return passwords;
    }

    // Take an array and mixe up all the values in a pseudo-random way
    public void shuffleArray(ArrayList<String> list) {
        int size = list.size();

        for (int i = size - 1; i > 0; i--) {
            int j = randomMachine.nextInt(i + 1);

            // Swap elements at index i and j
            String temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    } 
}
