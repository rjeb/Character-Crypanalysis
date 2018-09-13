import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main {

	public static void main(String [] args) {
		String ciphertext;
		String plaintext;
		
		ArrayList<Character> chars = new ArrayList<Character>(
				Arrays.asList('a','b','c','d','e','f','g','h',
					'i','j','k','l','m','n','o','p','q','r',
					's','t','u','v','w','x','y','z'));
		ArrayList<Character> mostUsedChars = new ArrayList<Character>(
				Arrays.asList('e','t','a','o','i','n','s','r',
					'h','l','d','c','u','m','f','p','g','w',
					'y','b','v','k','x','j','q','z'));
		
		//creates a treemap of frequencies and initializes them all to 0
		TreeMap<Character, Integer> characterFrequencies = new TreeMap<Character, Integer>();
		for (int i = 0; i < 26; i++) {
			characterFrequencies.put(chars.get(i), 0);
		}
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a ciphertext:");
		ciphertext = scanner.nextLine().toLowerCase();
		
		//adjusts frequency treemap based on what characters are in the ciphertext
		for (int i = 0; i < ciphertext.length(); i++) {
			Character value = ciphertext.charAt(i);
			characterFrequencies.put(value, (characterFrequencies.get(value)+1));
		}
		
		System.out.println("Character Frequencies:");
		for (Map.Entry<Character, Integer> c : characterFrequencies.entrySet()) {
			if (c.getValue()>0) {
				System.out.println(c + ": " + c.getValue());
			}
		}
		
		
		scanner.close();
	}
	
}
