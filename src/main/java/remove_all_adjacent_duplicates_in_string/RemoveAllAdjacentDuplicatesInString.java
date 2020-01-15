package remove_all_adjacent_duplicates_in_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.eclipsesource.json.JsonArray;

public class RemoveAllAdjacentDuplicatesInString {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			String S = stringToString(line);

			String ret = new RemoveAllAdjacentDuplicatesInString().removeDuplicates(S);

			String out = (ret);

			System.out.print(out);
		}
	}

	@SuppressWarnings("deprecation")
	public static String stringToString(String input) {
		return JsonArray.readFrom("[" + input + "]").get(0).asString();
	}

	public String removeDuplicates(String S) {
		String[] str = S.split("");
		List<String> strList = new ArrayList<>(Arrays.asList(str));
		boolean isEnd = false;
		String result = "";

		while (!isEnd) {
			if (strList.size() == 0)
				break;

			for (int i = 0; i < strList.size(); i++) {
				if (strList.size() > 2 && i != strList.size()-1) {
					if (strList.get(i).equals(strList.get(i + 1))) {
						strList.remove(i);
						strList.remove(i);
						break;
					}
				} else {
					if(strList.size() == 2) {
						if (strList.get(i).equals(strList.get(i + 1))) strList.removeAll(strList);
					} 
					
					isEnd = true;
					break;
				}
			}
		}

		for (String val : strList) {
			result += val;
		}

		return result;
	}
}
