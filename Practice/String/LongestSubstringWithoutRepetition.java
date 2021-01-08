import java.util.HashMap;

public class LongestSubstringWithoutRepetition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abbcdb";
		System.out.println("Longest substring without repeting characters of string: " + s + "is " + lengthOfLongestSubstring(s));
	}
	
    public static int lengthOfLongestSubstring(String s) {
    	int longestSubstringlength = 0, currentLength = 0, startingIndex = 0;
    	int stringLength = s.length();
    	HashMap<Character, Integer> charMap = new HashMap<>();
    	
    	for(int i = 0; i < stringLength; i++) {
    		if (charMap.containsKey(s.charAt(i))) {
                startingIndex = Math.max(startingIndex, charMap.get(s.charAt(i)));
    		} else {
                startingIndex = Math.max(startingIndex, 0);
            }
    			currentLength = i - startingIndex + 1;
    			longestSubstringlength = Math.max(longestSubstringlength, currentLength);
    		charMap.put(s.charAt(i), i+1);
    	}
    	
    	return longestSubstringlength;      
    }

}
