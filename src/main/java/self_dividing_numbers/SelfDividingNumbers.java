package self_dividing_numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SelfDividingNumbers {
	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int left = Integer.parseInt(line);
            line = in.readLine();
            int right = Integer.parseInt(line);
            
            List<Integer> ret = new SelfDividingNumbers().selfDividingNumbers(left, right);
            
            String out = integerArrayListToString(ret);
            
            System.out.print(out);
        }
    }
    
    public List<Integer> selfDividingNumbers(int left, int right) {
    	List<Integer> resultList = new ArrayList<Integer>();
    	boolean isSelf = false;
    	
    	for(int i = left; i <= right; i++) {
    		if(i < 10 && i % i == 0) {
    			resultList.add(i);
    		} else {
    			int[] numbers = Stream.of(String.valueOf(i).split("")).mapToInt(Integer::parseInt).toArray();
    			
    			for(int num : numbers) {
    				if(num != 0 && i % num == 0) {
    					isSelf = true;
    				} else {
    					isSelf = false;
    				}
    				
    				if(!isSelf) break;    				
    			}
    			
    			if(isSelf) {
    				resultList.add(i);
    			}
     		}
    	}
		return resultList;
    }
    
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }
}
