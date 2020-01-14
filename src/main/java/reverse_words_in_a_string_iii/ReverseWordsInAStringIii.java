package reverse_words_in_a_string_iii;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.eclipsesource.json.JsonArray;

public class ReverseWordsInAStringIii {
	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            
            String ret = new ReverseWordsInAStringIii().reverseWords(s);
            
            String out = (ret);
            
            System.out.print(out);
        }
    }
    
    @SuppressWarnings("deprecation")
	public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public String reverseWords(String s) {
    	String[] str = s.split(" ");
    	String result = "";
    	
    	for(int idx = 0; idx < str.length; idx++) {
    		String[] target = str[idx].split("");
    		
    		String con = "";
    		for(int i = target.length-1; i >=0; i--) {
    			con += target[i];
    		}
    		
    		if(idx == str.length-1) result += con;
    		else 					result += con + " ";
    	}
    		
		return result;    
    }
}
