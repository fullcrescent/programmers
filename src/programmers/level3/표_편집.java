package programmers.level3;

import java.util.Stack;

public class 표_편집 {

	public static void main(String[] args) {
		int n = 8;
		int k = 2;
		String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
		String answer = solution(n, k, cmd);
		System.out.println(answer);
	}
	
	public static String solution(int n, int k, String[] cmd) {
		Stack<Integer> stack = new Stack<>();
		boolean[] remove = new boolean[n];

		for(String command : cmd) {
			Character temp = command.charAt(0);

			switch(temp) {
				case 'U' :

					break;
				case 'D' :

					break;
				case 'C' :

					break;
				case 'Z' :

					break;
			}
		}

		return null;
	}
}
