package n_repeated_element_in_size_2n_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class NRepeatedElementInSize2nArray {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			int[] A = stringToIntegerArray(line);

			int ret = new NRepeatedElementInSize2nArray().repeatedNTimes(A);

			String out = String.valueOf(ret);

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
	
    public int repeatedNTimes(int[] A) {
    	Set<Integer> set = new HashSet<>();
    	
    	for(int val : A) {
    		if(!set.add(val)) return val;
    	}
    	return -1;   
    }
}
