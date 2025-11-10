package project1;

import java.util.LinkedList;
import java.util.List;

public class NumbersOutOfOrder {

	static List<Integer> findOutOfOrder(int[] input) {
		List<Integer> output = new LinkedList<>();

		for (int i = 0; i < input.length; i++) {
			if (i == 0) {
				if (input[i] > input[i + 1])
					output.add(i);
			}

			else if (i == input.length - 1) {
				if (input[i] < input[i - 1]) {

					output.add(i);
					break;
				}
			}

			else if (input[i] > input[i + 1] || input[i] < input[i - 1]) {
				output.add(i);
				if (output.size() == 2)
					break;
			}

		}

		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = { 1, 10, 3, 6, 7, 2, 12 };

		List<Integer> output = findOutOfOrder(input);
		System.out.println(output);

	}

}
