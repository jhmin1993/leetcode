package n_repeated_element_in_size_2n_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
    	int N = A.length / 2;
    	int[] tmp = new int[A.length];
    	
    	int resultInt = 0;
   
    	for(int i = 0; i < A.length; i++) {
    		int repeatCnt = 0;
    		for(int j = 0; j < A.length; j++) {
    			if(A[i] == A[j]) repeatCnt++;
    		}	
    		tmp[i] = repeatCnt;
    	}
    	
    	for(int index = 0; index < tmp.length; index++) {
    		if(N == tmp[index]) {
	    		for(int i = 0; i < A.length; i++) {
	    			if(index == i) resultInt = A[i];
	    			if(resultInt != 0) break;
	    		}
    		}
    	}
    	
		return resultInt;    
    }
}
