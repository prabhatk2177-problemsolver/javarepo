package project1;

import java.util.Stack;

public class NextGreaterElement {

	static void nge(int[] arr) {
		Stack<Integer> s = new Stack();
		int n = arr.length;
		int index = n - 1;
		while (index >= 0) {

			if (s.isEmpty()) {
				System.out.println("-1");

			} else {
				while (s.peek() < arr[index]) {
					s.pop();
				}
				if (s.isEmpty())
					System.out.println("-1");
				else
					System.out.println(s.peek());

			}
			s.push(arr[index]);

			index--;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 3, 2, 4 };
		nge(arr);

	}

}
