package mandatoryHomeWork.DSA;
/*
 * input string
 * output string
 * 
 * based on the space, split the input string and assign to string array.
 * traverse thorugh the array
 * reverse the characters within the word.
 * now join the reversed words together with space
 * and thats the result 
 * 
 * Time Complexity
 * -----------------
 * 
 * O(N)
 */



public class ReverseWordsInString_Sep13 
{
    public static String reverseWords(String s) 
    
    {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words)
        {
            StringBuilder reversedWord = new StringBuilder(word);
            reversedWord.reverse();
            result.append(reversedWord).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args)
    
    {
        String input1 = "Let's take LeetCode contest";
        String input2 = "God Ding";

        System.out.println(reverseWords(input1)); 
        System.out.println(reverseWords(input2)); 
    }
}


