import java.util.ArrayList;
import java.util.Arrays;

public class Cipher {
	
	ArrayList<Character> key;
	
	ArrayList<Character> chars = new ArrayList<Character>(
			Arrays.asList('a','b','c','d','e','f','g','h',
				'i','j','k','l','m','n','o','p','q','r',
				's','t','u','v','w','x','y','z'));
	ArrayList<Character> mostUsedChars = new ArrayList<Character>(
			Arrays.asList('e','t','a','o','i','n','s','r',
				'h','l','d','c','u','m','f','p','g','w',
				'y','b','v','k','x','j','q','z'));
	
	
	public Cipher() {
		this.key = (ArrayList<Character>)chars.clone();
	}
	
	public Cipher(ArrayList<Character> input) {
		if (input.size()<26) {
			this.key = (ArrayList<Character>)input.clone();
			//deletes all used chars (duplicates) from char list
			for(int i = 0; i < input.size(); i++){
				if (chars.contains(input.get(i))) {
					chars.remove(i);
				}
			}
			for (int i = 0; i < chars.size(); i++) {
				this.key.add(chars.get(i));
			}
		}
		//if string input is 26 characters, it is a full key for simple substitution cipher
		else {
			this.key = input;
		}
	}
	
	public String decrypt(String cipherText) {
		String returnString = "";
		for (int i = 0; i < cipherText.length(); i++) {
			returnString += mostUsedChars.get(key.indexOf(cipherText.charAt(i)));
		}
		return returnString;
	}
	
}
