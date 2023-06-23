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
			char temp = command.charAt(0);

			int value = 1;
			if(command.length()>1) {
				value = Integer.parseInt(command.split(" ")[1]);
			}

			int count = 0;

			switch(temp) {
				case 'U' :
					while(count<value){
						count++;
						k--;
						if(remove[k]) count--;
					}

					break;
				case 'D' :
					while(count<value){
						count++;
						k++;
						if(remove[k]) count--;
					}

					break;
				case 'C' :
					stack.add(k);
					remove[k] = true;
					k++;

					if(k==n){
						k--;
						while(remove[k]){
							k--;
						}
					}

					break;
				case 'Z' :
					remove[stack.pop()] = false;

					break;
			}
		}

		StringBuilder sb = new StringBuilder();

		for(int i=0; i<n; i++) {
			if(remove[i])	sb.append("X");
			else 			sb.append("O");
		}

		return sb.toString();
	}
}
