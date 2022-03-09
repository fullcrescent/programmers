package programmers.level3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 이중우선순위큐 {

	public static void main(String[] args) {
		String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
		int[] answer = solution(operations);
		System.out.println(Arrays.toString(answer));
	}
	
	public static int[] solution(String[] operations) {
		Deque<Integer> deque = new ArrayDeque<>();
		
		for(String operation : operations) {
			String[] temp = operation.split(" ");
			
			if(temp[0].equals("I")) {
				int value = Integer.parseInt(temp[1]);
				deque.add(value);
			}else if(temp[0].equals("D")) {
				if(deque.isEmpty()) continue;
				
				if(temp[1].equals("1")) {
					deque.pollLast();
				}else {
					deque.pollFirst();
				}
			}
		}
		
		int[] answer = new int[2];
		
		if(!deque.isEmpty()) {
			answer[0] = deque.pollFirst();
			answer[1] = deque.pollLast();
		}
		
		return answer;
	}
}
