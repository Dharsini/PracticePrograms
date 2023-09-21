package mandatoryHomeWork.DSA;

/* input array, int 
 * output int
 * 
 * nums = [1, 2, 3, 4, 5]
   diff = 2
   0
   
   nums = [0, 1, 4, 6, 7, 10]
   diff = 3
   2
   
   nums = [-3, -1, 1, 3, 5]
   diff = 2
   0
   
   nums = [1, 2, 3, 4, 5, 6, 7]
   diff = 1
   4


   
 * Two pointer 
 * 
 * 
    Initialize a variable count 
    Traverse through array from the first element to the element which is third from the last
    Set j to be the next element after i
    Set k to be the next element after j --> i , j, k 
    While k is within the array
    If the difference between nums[j] and nums[i] equals diff 
    and the difference between nums[k] and nums[j] equals diff
    Increment the count by 1
    Move j and k to explore more potential triplets
    Else if the differences are smaller
    Move k to find larger differences
    else Move j to find smaller differences
    Return the final count of unique arithmetic triplets
    
    

 * Time Complexity : O(nsquare)
 * Space complexity : O(1)
 */

public class ArithmeticTriplets 
{
    public int countArithmeticTriplets(int[] nums, int diff) 
    {
       
        int count = 0;
        
        for (int i = 0; i < nums.length - 2; i++)
        {
            int j = i + 1;
            int k = i + 2;
            
            while (k < nums.length)
            {
                if (nums[j] - nums[i] == diff && nums[k] - nums[j] == diff)
                {
                    count++;
                    j++;
                    k++;
                } 
                else if (nums[j] - nums[i] < diff||nums[k]-nums[j]<diff) 
                {
                    k++;
                } 
                else
                {
                    j++;
                }
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) 
    
    {
        ArithmeticTriplets soln = new ArithmeticTriplets();
        int[] nums1 = {0, 1, 4, 6, 7, 10};
        int diff1 = 3;
        int result1 = soln.countArithmeticTriplets(nums1, diff1);
        System.out.println( result1); 
    }
}

