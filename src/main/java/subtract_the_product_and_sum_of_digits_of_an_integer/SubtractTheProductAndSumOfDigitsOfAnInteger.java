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
		int number = n;
		int product = 0, sum = 0, result = 0;
		String temp = Integer.toString(number);
		int[] digits = new int[temp.length()];

		for (int i = 0; i < temp.length(); i++) {
			digits[i] = temp.charAt(i) - '0';
		}

		for (int i = 0; i <= digits.length; i++) {
			// 첫 숫자 셋팅
			if (i == 0) {
				product = digits[i];
				sum = digits[i];
				continue;
			}

			if (i == digits.length) {
				// 곱한 값 - 더한 값
				result = product - sum;
				break;
			}

			// 곱하기
			product = product * digits[i];
			// 더하기
			sum = sum + digits[i];

		}
		return result;
	}
}