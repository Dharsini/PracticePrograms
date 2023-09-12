package mandatoryHomeWork.DSA;

/*input string
 * output string
 * 
 * Test data:
 * ----------
 * 
 * heloo
 * heloo
 * 
 * ice
 * ec
 * 
 * iabcdefi
 * fedcba
 * 
 * 
 * 
 * Pesudocode:
 * -----------
 * for each character in in the string S
 * if the character is i,
 * set the reverse to true
 * else
 * if the reverse is true
 * add the character to the beginning of the result 
 * else add the character to the end of the result 
 * return result 
 * 
 * Time Complexity:
 * ------------------
 * O(N)
 * 
 * 
 */


import org.junit.Assert;
import org.junit.Test;




public class FaultyKeyboard_Sep11 {
	
	
	@Test
	public void test1() {
	String actual = faultyKeyboard("abcidef");
	Assert.assertEquals("cbadef" , actual);
	}
	

	public String faultyKeyboard(String s)
	{
        StringBuilder result = new StringBuilder();
        boolean reverse = false;
        
        for (char ch : s.toCharArray()) {
            if (ch == 'i') 
            {
                reverse = true;
            } 
            else
            {
                if (reverse)
                {
                    result.insert(0, ch); 
                } 
                else
                {
                    result.append(ch); 
                }
            }
        }
        
        return result.toString();

}}
