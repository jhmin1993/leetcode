package number_complement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class NumberComplement {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			int num = Integer.parseInt(line);

			int ret = new NumberComplement().findComplement(num);

			String out = String.valueOf(ret);

			System.out.print(out);
		}
	}

	public int findComplement(int num) {
		String binary = Integer.toBinaryString(num);
		int bNum[] = Stream.of(String.valueOf(binary).split("")).mapToInt(Integer::parseInt).toArray();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < bNum.length; i++) {
			switch (bNum[i]) {
				case 0: bNum[i] = 1; break;
				case 1: bNum[i] = 0; break;
			}
		}
		
		for(int n : bNum) {
			sb.append(n);
		}

		return Integer.parseInt(sb.toString(), 2);
	}
}
