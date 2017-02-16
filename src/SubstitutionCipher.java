
import java.util.*;

public class SubstitutionCipher {
	//Algorithm for character occurance approach inspired by http://javaconceptoftheday.com/how-to-count-occurrences-of-each-character-in-string-in-java/
	//Changed the approach slightly so it will work with the overall problem
	//The cipher code and everything else is my idea, only counting the character occurance was from outside assistance
	
	private static final char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O',
			'P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	public static void main(String[] args) {
		//create hashmap that takes in a character and keeps track of how many occurances of the character
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		HashMap<Character,Character> hmChar = new HashMap<Character,Character>();
		
		//Takes the ciphertext as user input
		boolean stop = false;
		Scanner scan = new Scanner(System.in);
		
		String cipherText = "";
		String key = "";
		String validKey = "";
		
		
		while(!stop) {
			System.out.println("Enter the cipherText");
			cipherText = scan.nextLine().toUpperCase();
			System.out.println("Enter the key representation for A-Z respectively");
			key = scan.nextLine().toUpperCase();
			//Check whether the key is valid and then stop the loop
			if (key.length() == 26) {
				//check whether every letter is unique in the key. 
				key.trim();
				//use a hashset to check whether it exists in the hashset already and if it does, it will not create a duplicate
				HashSet<Character> hs = new HashSet<Character>();
		        for(char element: key.toUpperCase().toCharArray()){
		        	//if the character is a letter, then it will add it in the hashset.
		            if(Character.isLetter(element))
		            //adding into the hashset will not add a duplicate copy of the same element
		            hs.add(element);
		        }
		        if(hs.size() == 26) {
		        	validKey = key;
		        	stop = true;
		        }
		       
		            
		        
			}
		}
		/*
		 * 
		 * 
		 * Working with the ciphertext
		 * 
		 * 
		 */
		char[] characterArray = cipherText.toCharArray();
		
		for (char character: characterArray) {
			//check if the hashmap contains the character. The character is the hashkey
			if (hm.containsKey(character)) {
				hm.put(character, hm.get(character) + 1);
			}
			else {
				//if it is not there, then start the integer count to 1
				hm.put(character, 1);
			}
		}
		
		//Map the key to the respective letters
		for (int i = 0 ; i < alphabet.length; i++) {
				hmChar.put(validKey.charAt(i),alphabet[i]);
		}
		
		//display plaintext
		
		//first get the ciphertext, then replace each instance of the text with the letter it corresponds to
		
		StringBuilder plainText = new StringBuilder(cipherText);
		//iterate through to replace the ciphertext with the values in the hashmap
		
		for (int j = 0 ; j < plainText.length() ; j++) {
			if (hmChar.containsKey(plainText.charAt(j))) {
				plainText.setCharAt(j, hmChar.get(plainText.charAt(j)));
			}
		}
		
		System.out.println("The number of occurances for each letter: " + hm);
		System.out.println("The key defined by the user: " +  hmChar);
		System.out.println("PlainText: " + plainText);
		
		
		
		
	}
}
