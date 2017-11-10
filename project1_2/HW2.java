package project1_2;
/*
 * Andrew Liao
 * This HW2 class lets us manipulate strings in certain ways.
*/
public class HW2 {
	
	//optional method just for me to test my code
	public static void main(String[] args) {
		
		
		//Testing the capitalizeSentences method
		//the Test 0 case
		System.out.println(HW2.capitalizeSentences(""));
		//the Test 1 case
		System.out.println(HW2.capitalizeSentences("a"));
		//the Test many case
		System.out.println(HW2.capitalizeSentences("asdf !sdf ?asdf .asdf Abfc"));
		
		//Test First
		System.out.println(HW2.capitalizeSentences("asdf"));
		//Test Last
		System.out.println(HW2.capitalizeSentences("Asdf !Asdf ?a"));
		//Test Middle
		System.out.println(HW2.capitalizeSentences("!?.abc"));
		
		
		
		
		//Testing the subSequence method
		//the Test 0 case
		System.out.println(HW2.subSequence("", "asdf"));
		System.out.println(HW2.subSequence("a", ""));
		System.out.println(HW2.subSequence("", ""));
		//the Test 1 case
		System.out.println(HW2.subSequence("a", "bad"));
		System.out.println(HW2.subSequence("bad", "a"));
		//the Test many case
		System.out.println(HW2.subSequence("bad", "badiscool"));
		System.out.println(HW2.subSequence("badiscool", "bad"));
	
		
		//Test First
		System.out.println(HW2.subSequence("ba", "bad"));
		//Test Last
		System.out.println(HW2.subSequence("ba", "sddsfsdfba"));
		//Test Middle
		System.out.println(HW2.subSequence("ba", "asdfba sdfdsf"));
		
		
		
		
		//Testing the indexWord method
		//the Test 0 case
		System.out.println(HW2.indexWord("EHL ORT!.?", ""));
		//the Test 1 case
		System.out.println(HW2.indexWord("EHL ORT!.?", "1"));
		//the Test many case
		System.out.println(HW2.indexWord("EHL ORT!.?", "102243610509"));
					
		//Test First
		System.out.println(HW2.indexWord("EHL ORT!.?", "0"));
		//Test Last
		System.out.println(HW2.indexWord("EHL ORT!.?", "9"));
		//Test Middle
		System.out.println(HW2.indexWord("EHL ORT!.?", "4"));
		

		
		
		
		//Testing the removeExtraSpaces method
		//the Test 0 case
		System.out.println(HW2.removeExtraSpaces(""));
		//the Test 1 case
		System.out.println(HW2.removeExtraSpaces(" "));
		System.out.println(HW2.removeExtraSpaces("a"));
		//the Test many case
		System.out.println(HW2.removeExtraSpaces("  How about 	that    ?     "));
					
						
		//Test First
		System.out.println(HW2.removeExtraSpaces(" a"));
		//Test Last
		System.out.println(HW2.removeExtraSpaces("asd  "));
		//Test Middle
		System.out.println(HW2.removeExtraSpaces("ba    ad"));
		
		
		
		
		//Testing the removeEveryKthWord method
		//the Test 0 case
		System.out.println(HW2.removeEveryKthWord("Four score and seven years ago our fore fathers", 0));
		//the Test 1 case
		System.out.println(HW2.removeEveryKthWord ("Four score and seven years ago our fore fathers", 1));
		//the Test many case
		System.out.println(HW2.removeEveryKthWord("Four score and seven years ago our fore fathers", 3));
		System.out.println(HW2.removeEveryKthWord("Four score and seven years ago our fore fathers", -5));
				
		//Test First
		System.out.println(HW2.removeEveryKthWord("apple and oranges", 1));
		//Test Last
		System.out.println(HW2.removeEveryKthWord("apple and oranges", 3));
		//Test Middle
		System.out.println(HW2.removeEveryKthWord("apple and oranges", 2));
		

		
		
		
		//Testing the containsWord method
		//the Test 0 case
		System.out.println(HW2.containsWord("", "asdf"));
		System.out.println(HW2.containsWord("a", ""));
		//the Test 1 case
		System.out.println(HW2.containsWord("a", "a"));
		System.out.println(HW2.containsWord("asdfw", "w"));
		//the Test many case
		System.out.println(HW2.containsWord("asdf", "asdfsdf"));
			
				
		//Test First
		System.out.println(HW2.containsWord("tqwer", "t x a"));
		//Test Last
		System.out.println(HW2.containsWord("asd", "z s a"));
		//Test Middle
		System.out.println(HW2.containsWord("vqwe", "c v b"));
	
		
		
	}
	
	/* This method capitalizes the first character of a sentence. (has to be a letter) */
	public static String capitalizeSentences(String input) {
		//variable to store all the values of the final output string
		StringBuilder endString = new StringBuilder();
		//need to make sure that it is false and it will change to true once a capitalized character is made
		boolean found = false;
		
		/* it checks if it has not yet capitalized a character yet and if the character is actually a letter. If it is 
		 * it will add the upperCase and change the condition to true until if finds a whitespace, period, question mark,
		 * or an exclamation point which marks a potential beginning to a new sentence. Everything else is added to the 
		 * new output String. The precondition for this loop is that the input is at least one.
		*/
		for(int i = 0; i < input.length(); i++) {
			if(!found && Character.isLetter(input.charAt(i))) {
				endString.append(Character.toUpperCase(input.charAt(i)));
				found = true;
			} else if (Character.isWhitespace(input.charAt(i)) || input.charAt(i) == '.' || input.charAt(i) == '?' || input.charAt(i) == '!') {
				endString.append(input.charAt(i));
				found = false;
			} else {
				endString.append(input.charAt(i));
			}
		}
		
		return endString.toString();	
	}
	
	/* this method checks if the first string is a subsequence of the second string */
	public static boolean subSequence(String input1, String input2) {
		//the length of input1
		int lengthOfFirst = input1.length();
		//the length of input2
		int lengthOfSecond = input2.length();
		//declare the iterating variables i(which is for the input1), and j(for input2)
		int i = 0, j = 0;
		/*
		 * this loop checks if all the characters of the first string is a equal to any of the characters 
		 * in the second string. The goal is to count up to the point where each letter in the first string
		 * is found in the second string. We only increment up if the letter is found in the second string. The
		 * subgoal of the loop is seeing if the char is found at any specific point in the second string. The
		 * precondition is that lengthOfFirst and lengthOfSecond is at least one.
		 */
		for(; i < lengthOfFirst && j < lengthOfSecond; j++) {
			if(input1.charAt(i) == input2.charAt(j)) {
				i++;
			}
		}
		
		//we return the comparison of the length of first input and the point of where i reaches up to
		return (i == lengthOfFirst);
	}
	
	/* this method  will print out the letter from the first input using the index on each successive number from the second string input */
	public static String indexWord(String scramble, String index) {
		//used for producing the output string
		StringBuilder output = new StringBuilder();
		/*
		 * This loop's goal is to create the output string using the index given by the second string to find the 
		 * character in the first string. The precondition of this loop is that we are given 10 digit first string.
		 * The subgoal of each round is to add a character from the first string into the output string. The precondition
		 * is thatindex is at least a length of 1.
		 */
		for(int i = 0; i < index.length() ; i++) {
			//this stores the character of the number from the index String
			char indexChar= index.charAt(i);
			//this stores the number of indexChar
			int numberOfIndex = Character.getNumericValue(indexChar);
			output.append(scramble.charAt(numberOfIndex));
		}
		
		return output.toString();
	}
	
	//This method removes the extra spaces between words and before the first word, 
	//but keeps the last space after the last word
	public static String removeExtraSpaces(String str){
        //used to check if the empty space in the string occurs right after a word or 
		//if it is leading spaces before the first word
		int space = 0;
        //to check if the first char of the next word is found yet
        boolean firstCharFound = false;
        //used to create the output string without the extra spaces
        StringBuilder sb = new StringBuilder();
        /*
         * This loop goal is to append to the output StrinBuilder a string without the additional spaces attached."
         * The precondition is that the string has at least a length of 1. The subgoal of each round is to see 
         * if the character at the instance is a space or not, and if isn't we append it to the stringbuilder. 
         * Otherwise we see if that space is right after a character that is found. 
         */
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != ' '){
            		firstCharFound = true;
                sb.append(str.charAt(i));  // add character
                space = 0;
            }else{
                space++;
                if(space == 1 && firstCharFound){       // add 1st space
                    sb.append(" ");
                }
            }
        }
        return new String(sb.toString());
    }
	
	//this method takes in a string input and removes every kth instance a word appears in the input
	public static String removeEveryKthWord(String input, int k) {
		//check if the k is negative
		if(k <= 0) {
			//if the input of the integers i negative we return the string
			return input;
		} else {
			//to count t
			int space = 0;
			//test if the first character of the next word is found yet
			boolean firstCharFound = false;
			//a stringbuilder in order to return the the newest string
			StringBuilder output = new StringBuilder();
			//a stringbuilder to store the removed words from the input string
			StringBuilder removed = new StringBuilder();
			//a counter to check which word we are on
			int counter = 1;
			/*
			 * The goal of the loop is to append a new string to the output stringbuilder. While that happens,
			 * we also have to remove the kth value which we will store in the stringbuilder removed. This stringbuilder 
			 * won't return a value, it is only there to store the unnecessary words. The precondition for this 
			 * loop is that input length of the string is at least 1. The subgoal of the loop is to add the character
			 * either to the output or the removed stringbuilder.  
			 */
			for(int i = 0; i < input.length(); i++) {
				if(input.charAt(i) != ' '){ //used to test if the character at i is a space or not
	            		
					firstCharFound = true; //if it is not a space we say it is the start of a word
					if(counter == k) {
						removed.append(input.charAt(i));//if value is equal to k we add it to the removed stringbuilder
					} else {
						output.append(input.charAt(i));  // otherwise we add it to the output stringbuilder
					}
					
	                space = 0;//we set the space equal to 0
				}else{
					space++;
					if(space == 1 && firstCharFound){    // add 1st space
						if(counter == k) {
							if(input.charAt(i) == ' ') {
								counter = 1; // check if it is a space and if is not we can start counting words
							}
						} else {
							output.append(" ");//append a space after the word in output
							counter++;
						}
						
					}
				}
			}
			return output.toString();
		}
	}
	
	//this method checks if the input 2 string is able to be found in the input 1 string
	public static boolean containsWord(String input1, String input2) {
		//boolean variable to see if it is the start of a word
		boolean firstCharFound = false;
		//a stringbuilder variable to store the word created from comparing the values of both string inputs
		StringBuilder word = new StringBuilder();
		/*
		 * This outer for loop goal is iterate through the length of input2. We want to make sure that we can test 
		 * every single word of input2 and see if that word in input2 can be made from the characters of the string
		 * input 1. The precondition is that input2 actually has a length of at least one. The subgoal of this loop
		 * is iterating through each character of input2 and seeing if it is a word or not.
		 */
		for(int i = 0; i < input2.length(); i++) {
			if(input2.charAt(i) != ' ' ) { 
				if(!firstCharFound) {
					firstCharFound = true;
				}
				word.append(input2.charAt(i));
				
				//test the output if we reach the end of input2
				if(i == input2.length() -1) {
					boolean wordMatches = true;
					int count = 0;
					/*
					 * This loop goal is to iterate through the entire length of word create. We want to find out 
					 * if the word can be created from input 1 string. The subgoal is that we go through each
					 * letter of the word and see if it exist at any point in input 1. The precondition is that word 
					 * has at least a length of 1. 
					 */
					for(int j = 0; j < word.toString().length(); j++) {
						/*
						 * This inner loop goal is to see if the char at j for the word is the same as any character in
						 * the input 1 string. The subgoal of this loop is to see if we can get it to match with at least 
						 * one occurrence inside input 1. If it does we can increment count by one. 
						 */
						for(int k = 0; k < input1.length(); k++) {
							if(word.toString().charAt(j) == input1.charAt(k)){
								count++;
							}
						}
						//if it count is not one, it means the character is not found and we set wordMatches to false
						if (count < 1) {
							wordMatches = false;
						}
						count = 0;
					}
					return wordMatches;
				}
				
			} else {
				if(firstCharFound) {
					//boolean to store if the word created matches
					boolean wordMatches = true;
					//integer to store the 
					int count = 0;
					/*
					 * This loop goal is to iterate through the entire length of word create. We want to find out 
					 * if the word can be created from input 1 string. The subgoal is that we go through each
					 * letter of the word and see if it exist at any point in input 1. The precondition is that word 
					 * has at least a length of 1. 
					 */
					for(int j = 0; j < word.toString().length(); j++) {
						/*
						 * This inner loop goal is to see if the char at j for the word is the same as any character in
						 * the input 1 string. The subgoal of this loop is to see if we can get it to match with at least 
						 * one occurrence inside input 1. If it does we can increment count by one. 
						 */
						for(int k = 0; k < input1.length(); k++) {
							if(word.toString().charAt(j) == input1.charAt(k)){
								count++;
							}
						}
						//if it count is not one, it means the character is not found and we set wordMatches to false
						if (count < 1) {
							wordMatches = false;
						}
						count = 0;
					}
					//if the word matches return true, otherwise go on to the next input word
					if(wordMatches) {
						return true;
					} else {
						firstCharFound = false;
						//create a new StringBuilder to store the next word
						word = new StringBuilder();
					}
				}
				
			}
		}
		//we return false if a word from input2 cannot be created from input 1
		return false;
	}
}

