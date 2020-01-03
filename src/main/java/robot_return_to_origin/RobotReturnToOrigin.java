package robot_return_to_origin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.eclipsesource.json.JsonArray;

public class RobotReturnToOrigin {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			String moves = stringToString(line);

			boolean ret = new RobotReturnToOrigin().judgeCircle(moves);

			String out = booleanToString(ret);

			System.out.print(out);
		}
	}

	@SuppressWarnings("deprecation")
	public static String stringToString(String input) {
		return JsonArray.readFrom("[" + input + "]").get(0).asString();
	}

	private boolean judgeCircle(String moves) {
		int rl = 0, ud = 0;

		String[] act = moves.split("");

		for (int i = 0; i < act.length; i++) {
			switch (act[i]) {
			case "R": rl++; break;
			case "L": rl--; break;
			case "U": ud++; break;
			case "D": ud--; break;
			}
		}

		if (rl == 0 && ud == 0) return true;

		return false;
	}

	public static String booleanToString(boolean input) {
		return input ? "True" : "False";
	}
}
