package sort_array_by_parity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortArrayByParity {
	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] A = stringToIntegerArray(line);
            
            int[] ret = new SortArrayByParity().sortArrayByParity(A);
            
            String out = integerArrayToString(ret);
            
            System.out.print(out);
        }
    }
    
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public int[] sortArrayByParity(int[] A) {
    	int[] result = new int[A.length];
    	int[] even	 = new int[A.length];
    	int[] odd	 = new int[A.length];
    	int evenCnt	 = 0, oddCnt = 0;
    	
    	for(int i = 0; i < A.length; i++) {
    		if(A[i] % 2 == 0) {
    			even[evenCnt] = A[i];
    			evenCnt++;
    		} else {
    			odd[oddCnt] = A[i];
    			oddCnt++;
    		}
    	}
    	
    	for(int i = 0; i < even.length; i++) {
    		if(even[i] == 0) continue;
    		result[i] = even[i];
    	}
    	
    	for(int i = 0; i < odd.length; i++) {
    		if(odd[i] == 0) continue;
    		result[evenCnt] = odd[i];
    		evenCnt++;
    	}
    	
		return result;
    }
    
    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
}
