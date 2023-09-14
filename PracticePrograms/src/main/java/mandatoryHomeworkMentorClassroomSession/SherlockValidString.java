package mandatoryHomeworkMentorClassroomSession;

/*
 * input string
 * output boolean
 * 
 * Test data:
 * ------------
 * 
 * s =abc -> yes
 * abcc -> yes
 * abccc - > no
 * aabbcc -> yes
 * 
 * 
 * Pseudocode:
 * ------------
 * 
 * Count the frequency of each character in the string
 * Count the frequencies of frequencies
 * Count the number of unique frequencies
 * If there is only one unique frequency, the string is valid
 * If there are exactly two unique frequencies and one of them is 1, the string is valid
 * 
 * 
 */




import java.util.HashMap;
import java.util.Map;

public class SherlockValidString
{
    
    static String isValid(String s)
    {
        Map<Character, Integer> charCount = new HashMap<Character, Integer>();
        
        Map<Integer, Integer> freqCount = new HashMap<Integer, Integer>();
        
        
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        
        for (int count : charCount.values()) 
        {
            freqCount.put(count, freqCount.getOrDefault(count, 0) + 1);
        }
        
        
        int uniqueFrequencies = freqCount.size();
        
        
        if (uniqueFrequencies == 1) 
        {
            return "YES";
        }
        
        
        if (uniqueFrequencies == 2)
        {
            int[] frequencies = new int[2];
            int index = 0;
            
            for (int freq : freqCount.keySet())
            {
                frequencies[index++] = freq;
            }
            
            int freq1 = frequencies[0];
            int freq2 = frequencies[1];
            
            if ((freqCount.get(freq1) == 1 && (freq1 == 1 || Math.abs(freq1 - freq2) == 1)) ||
                (freqCount.get(freq2) == 1 && (freq2 == 1 || Math.abs(freq2 - freq1) == 1))) {
                return "YES";
            }
        }
        
        return "NO";
    }

    public static void main(String[] args) {
        
        System.out.println(isValid("aabbcc")); 
        System.out.println(isValid("aabbccc")); 
        System.out.println(isValid("abc")); 
        System.out.println(isValid("aab"));
        System.out.println(isValid("aabbccddeefghi")); 
    }
}


