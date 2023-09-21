package mandatoryHomeWork.DSA;

/* input string
 * output int 
 * 
 * s = "abcdefg"
 * 0
 * 
 * s = "abcdeabc"
 * 1
 * 
 * s = "a_b_c"
 * 1
 * 
 * s = "aaaaaabbbcccc"
 * 10
 * 
 * Sliding Window
 * 
 * Create an array for counting the  occurrences of a,b,c
 * Count of substrings with a,b,c
 * Traverse through the array with right pointer from left to right 
 * Increment the count of the current character
 * While we have at least one occurrence of all three characters, a,b,c
 * Remove the left character from the window
 * Move the left pointer to the right to find the next substring
 * Increment the count of substrings ending at the current right pointer position

 * time complexity - O(n)
 * space complexity - O(1)
 */

public class SubstringsABC 

	{
	
    public int numberOfSubstrings(String s) 
    {
        int[] count = new int[3]; 
        int left = 0;
        int countOfABC = 0; 
        

        for (int right = 0; right < s.length(); right++)
        	
        {
            count[s.charAt(right) - 'a']++; 

            
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) 
            	
            {
                count[s.charAt(left) - 'a']--; 
                left++; 
                countOfABC += s.length() - right;
            }
        }

        return countOfABC;
    }

    public static void main(String[] args)
    
    {
        SubstringsABC solution = new SubstringsABC();

        
        System.out.println(solution.numberOfSubstrings("abcabc")); 
        System.out.println(solution.numberOfSubstrings("aaacb"));  
        System.out.println(solution.numberOfSubstrings("abc"));  
    }
}

