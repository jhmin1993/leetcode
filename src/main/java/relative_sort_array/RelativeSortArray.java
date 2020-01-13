package relative_sort_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RelativeSortArray {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			int[] arr1 = stringToIntegerArray(line);
			line = in.readLine();
			int[] arr2 = stringToIntegerArray(line);

			int[] ret = new RelativeSortArray().relativeSortArray(arr1, arr2);

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
		for (int index = 0; index < parts.length; index++) {
			String part = parts[index].trim();
			output[index] = Integer.parseInt(part);
		}
		return output;
	}

	public int[] relativeSortArray(int[] arr1, int[] arr2) {
    	int[] result = new int[arr1.length];
    	int resultCnt = 0;
    	Set<Integer> set = new HashSet<>();
    	
    	for(int arr2Num : arr2) {
    		for(int arr1Num : arr1) {
    			if(arr2Num == arr1Num) {
    				result[resultCnt++] = arr1Num;
    			}
    		}
    		set.add(arr2Num);
    	}
    	
    	Arrays.sort(arr1);
    	
    	for(int num : arr1) {
    		if(set.contains(num)) continue;
    		else result[resultCnt++] = num;
    	}
    	
		return result;
    }

	public static String integerArrayToString(int[] nums, int length) {
		if (length == 0) {
			return "[]";
		}

		String result = "";
		for (int index = 0; index < length; index++) {
			int number = nums[index];
			result += Integer.toString(number) + ", ";
		}
		return "[" + result.substring(0, result.length() - 2) + "]";
	}

	public static String integerArrayToString(int[] nums) {
		return integerArrayToString(nums, nums.length);
	}
}
