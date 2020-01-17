package fizz_buzz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            
            List<String> ret = new FizzBuzz().fizzBuzz(n);
            
            String out = stringListToString(ret);
            
            System.out.print(out);
        }
    }
    
    public List<String> fizzBuzz(int n) {
    	List<String> resultList = new ArrayList<>();
    	
    	for(int i = 1; i < n+1; i++) {
    		if(i % 3 == 0 && i % 5 == 0) {
    			resultList.add("FizzBuzz");
    		} else if(i % 3 == 0) {
    			resultList.add("Fizz");
    		} else if(i % 5 == 0) {
    			resultList.add("Buzz");
    		} else {
    			resultList.add(Integer.toString(i));
    		}
    	}
    	
		return resultList;
    }
    
    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }
    
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
}
