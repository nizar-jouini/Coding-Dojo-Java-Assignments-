import java.util.ArrayList;
import java.util.Random;

public class TestPuzzleJava {
    
	public static void main(String[] args) {
        // Create an Instance of PuzzleJava named generator
		PuzzleJava generator = new PuzzleJava();

        // Get an ArrayList containing 10 random numbers using getTenRolls
        System.out.println("\n----- Get Ten Rolls Test -----");
		ArrayList<Integer> randomRolls = generator.getTenRolls();
		System.out.println(randomRolls);

        // Get random letter with random index
        System.out.println("\n----- Get Random Letter Test -----");
        char randomLetter = generator.getRandomLetter();
        System.out.println("Random letter: " + randomLetter);

        // Generate radom string
        System.out.println("\n----- Generate Password Test -----");
        String randomString = generator.generatePassword();
        System.out.println("Random string: " + randomString); 

        // Get New Password Set
        System.out.println("\n----- Get New Password Set Test -----");
        int length = 5; // Change this to the desired length of the ArrayList
        ArrayList<String> randomPasswords = generator.getNewPasswordSet(length);

        System.out.println("Random Passwords: " + randomPasswords);
        // for (String password : randomPasswords) {
        //     System.out.println(password);
        // }

        // Shuffle ArrayList
        System.out.println("\n----- Shuffle Array Test -----");
        ArrayList<String> randomArray = generator.getNewPasswordSet(length);

        System.out.println("Original List: " + randomArray);

        // Shuffle the ArrayList
        generator.shuffleArray(randomArray);

        System.out.println("Shuffled List: " + randomArray);
	}
}
