import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main {

	public static TreeMap<Character, Integer> sortMapByValue(TreeMap<Character, Integer> in) {
		
		
		return in;
	}
	
	public static void main(String [] args) {
		String ciphertext;
		String plaintext;
		ArrayList<Character> cipherKey = new ArrayList<Character>();
		
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
		
		ArrayList<Map.Entry<Character, Integer>> usedCharacters = new ArrayList<Map.Entry<Character, Integer>>();
		
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
				usedCharacters.add(c);
			}
		}
		//comparator to sort entries of Map by their value(Integer) in decreasing order
		Comparator<Map.Entry<Character, Integer>> valueComparator = new Comparator<Map.Entry<Character, Integer>>() {
		    public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
		        int result = entry2.getValue().compareTo(entry1.getValue());

		        if (result == 0) {
		        	//sorts entries by decreasing value
		            return entry2.getValue() - entry1.getValue();
		        }
		        
		        return result;

		    }
		};

		
		usedCharacters.sort(valueComparator);
		
		for (int i = 0; i < usedCharacters.size(); i++) {
			cipherKey.add(usedCharacters.get(i).getKey());
		}
		
		Cipher textCipher = new Cipher(cipherKey);
		
		System.out.println("Plaintext estimate using statistics of most used letters: \n" + textCipher.decrypt(ciphertext));
		
		scanner.close();
	}
	
}
