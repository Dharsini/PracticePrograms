package mandatoryHomeWork.DSA;

/*
 * input int array
 * output int
 * 
 * Test data:
 * -------------
 * 
 *i/p- [1, 1, 1, 1, 1]
 *o/p- 0
 *
 *i/p-[5, 4, 3, 2, 1]
 *o/p-5
 *
 *i/p-[1, 5, 4, 2, 6, 3]
 *o/p-3
 *
 * 
 * 
 * Copy the input array heights to the array expected
 * sort the heights array in ascendhing order
 * compare each  element of both arrays and if the elements are not equal the increment the count
 * return the count. 
 * 
 * Time Complexity:
 * -----------------
 * O(NlogN)
 */

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class HeightChecker_Sep11 {
	
	@Test
	public void test1() {
	int actual = heightChecker(new int[] {1,1,4,2,1,3});
	Assert.assertEquals(3 , actual);
	}
	
	@Test
	public void test2() {
	int actual = heightChecker(new int[] {5,1,2,3,4});
	Assert.assertEquals(5 , actual);
	}
	
	
	
	
	public static int heightChecker(int[] heights) 
	{
		
		int count = 0;
		
		int[] expected = new int[heights.length];
		for ( int i = 0; i < heights.length; i++)
		{
			expected[i]=heights[i];
		}
		
		Arrays.sort(heights);
		
		for ( int i = 0; i < heights.length ; i ++)
		{
			if(expected[i]!=heights[i])
			{
				count++;
			}
		}
		
		
		return count;
	

	}}
