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
		//Test Middle
		System.out.println(HW2.capitalizeSentences("!?.abc"));
		//Test Last
		System.out.println(HW2.capitalizeSentences("Asdf !Asdf ?a"));
		
		System.out.println(HW2.subSequence("" , "" ));
		
		System.out.println(HW2.indexWord("EHL ORT!.?", "102243610509") );
		
		/*
		//Testing the subSequence method
		//the Test 0 case
		System.out.println(HW2.subSequence("a", ""));
		System.out.println(HW2.subSequence("", "a"));
		System.out.println(HW2.subSequence("", ""));
		//the Test 1 case
		System.out.println(HW2.subSequence("", ""));
		System.out.println(HW2.subSequence("", ""));
		System.out.println(HW2.subSequence("", ""));
		System.out.println(HW2.subSequence("", ""));
		//the Test many case
		System.out.println(HW2.subSequence("", ""));
		System.out.println(HW2.subSequence("", ""));
		System.out.println(HW2.subSequence("", ""));
		System.out.println(HW2.subSequence("", ""));
		
		//Test First
		System.out.println(HW2.subSequence("", ""));
		System.out.println(HW2.subSequence("", ""));
		System.out.println(HW2.subSequence("", ""));
		System.out.println(HW2.subSequence("", ""));
		//Test Middle
		System.out.println(HW2.subSequence("", ""));
		System.out.println(HW2.subSequence("", ""));
		System.out.println(HW2.subSequence("", ""));
		System.out.println(HW2.subSequence("", ""));
		//Test Last
		System.out.println(HW2.subSequence("", ""));
		System.out.println(HW2.subSequence("", ""));
		System.out.println(HW2.subSequence("", ""));
		*/
		
		System.out.println(HW2.containsWord("My what a lovely day", "hate      love"));
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
		for(int i = 0; i < index.length() ; i++) {
			//this stores the character of the number from the index String
			char indexChar= index.charAt(i);
			//this stores the number of indexChar
			int numberOfIndex = Character.getNumericValue(indexChar);
			output.append(scramble.charAt(numberOfIndex));
		}
		
		return output.toString();
	}
	
	public static String removeExtraSpaces(String str){
        int space = 0;
        boolean firstCharFound = false;
        StringBuilder sb = new StringBuilder();
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
	
	public static String removeEveryKthWord(String input, int k) {
		//check if the k is negative
		if(k < 0) {
			return input;
		} else {
			int space = 0;
			boolean firstCharFound = false;
			StringBuilder output = new StringBuilder();
			StringBuilder removed = new StringBuilder();
			int counter = 1;
			for(int i = 0; i < input.length(); i++) {
				if(input.charAt(i) != ' '){
	            		
					firstCharFound = true;
					if(counter == k) {
						removed.append(input.charAt(i));
					} else {
						output.append(input.charAt(i));  // add character
					}
					
	                space = 0;
				}else{
					space++;
					if(space == 1 && firstCharFound){    // add 1st space
						if(counter == k) {
							if(input.charAt(i) == ' ') {
								counter = 1; // check if it is a space
							}
						} else {
							output.append(" ");
							counter++;
						}
						
					}
				}
			}
			return output.toString();
		}
	}
	
	public static boolean containsWord(String input1, String input2) {
		boolean found = false;
		boolean firstCharFound = false;
		StringBuilder word = new StringBuilder();
		//go through the entire input2 
		for(int i = 0; i < input2.length(); i++) {
			if(input2.charAt(i) != ' ' ) {
				if(!firstCharFound) {
					firstCharFound = true;
				}
				word.append(input2.charAt(i));
				//test the output if it is finished
				if(i == input2.length() -1) {
					boolean wordMatches = true;
					int count = 0;
					//test the word compared to input1
					for(int j = 0; j < word.toString().length(); j++) {
						for(int k = 0; k < input1.length(); k++) {
							if(word.toString().charAt(j) == input1.charAt(k)){
								count++;
							}
						}
						if (count < 1) {
							wordMatches = false;
						}
						count = 0;
					}
					return wordMatches;
				}
				
			} else {
				if(firstCharFound) {
					boolean wordMatches = true;
					int count = 0;
					//test the word compared to input1
					for(int j = 0; j < word.toString().length(); j++) {
						for(int k = 0; k < input1.length(); k++) {
							if(word.toString().charAt(j) == input1.charAt(k)){
								count++;
							}
						}
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
		return found;
	}
}

