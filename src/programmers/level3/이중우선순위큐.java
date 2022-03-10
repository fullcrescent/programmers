package programmers.level3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;

public class 이중우선순위큐 {

	public static void main(String[] args) {
		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		int[] answer = solution(operations);
		System.out.println(Arrays.toString(answer));
	}
	
	public static int[] solution(String[] operations) {
		PriorityDeque<Integer> deque = new PriorityDeque<Integer>();
		
		for(String operation : operations) {
			String[] temp = operation.split(" ");
			
			if(temp[0].equals("I")) {
				int value = Integer.parseInt(temp[1]);
				deque.offer(value);
				deque.sort(null);
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
			answer[0] = deque.pollLast();
			answer[1] = deque.pollFirst();
		}
		
		return answer;
	}
	
	static class PriorityDeque<T> extends ArrayDeque<Integer>{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void sort(Comparator<Integer> c) {
			Object[] array = toArray();
			
			Arrays.sort(array);
			
			clear();
			
			for(Object temp : array) {
				this.add((Integer) temp);
			}
		}
	}
}
