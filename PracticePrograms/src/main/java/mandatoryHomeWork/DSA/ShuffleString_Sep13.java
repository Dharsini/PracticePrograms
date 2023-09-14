package mandatoryHomeWork.DSA;

/*
 * input string , int array
 * output string
 * 
 * Create a char array of same length as input aray
 * traverse through the string
 * return the string created from the char array
 * 
 * Time Complexity
 *----------------
 *
 *O(N)
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShuffleString_Sep13 {

    public String restoreString(String s, int[] indices)
    {
        char[] result = new char[s.length()];

        for (int i = 0; i < s.length(); i++)
        {
            result[indices[i]] = s.charAt(i);
        }

        return new String(result);
    }

    @Test
    public void testExample1()
    {
        String s = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
        String expected = "leetcode";
        assertEquals(expected, restoreString(s, indices));
    }

    @Test
    public void testExample2()
    {
        String s = "abc";
        int[] indices = {0, 1, 2};
        String expected = "abc";
        assertEquals(expected, restoreString(s, indices));
    }

   
}

