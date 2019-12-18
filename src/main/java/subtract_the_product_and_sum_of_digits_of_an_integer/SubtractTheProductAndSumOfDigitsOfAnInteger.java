package subtract_the_product_and_sum_of_digits_of_an_integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubtractTheProductAndSumOfDigitsOfAnInteger {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			int n = Integer.parseInt(line);

			int ret = new SubtractTheProductAndSumOfDigitsOfAnInteger().subtractProductAndSum(n);

			String out = String.valueOf(ret);

			System.out.print(out);
		}
	}

	public int subtractProductAndSum(int n) {
		int product = 1, sum = 0, tmp;
		String temp = Integer.toString(n);

		for (int i = 0; i < temp.length(); i++) {
			tmp = temp.charAt(i) - '0';
			product *= tmp;
			sum += tmp;
		}
		return product - sum;
	}
}