package programmers.level3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 이중우선순위큐 {

	public static void main(String[] args) {
		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		int[] answer = solution(operations);
		System.out.println(Arrays.toString(answer));
		
		String[] operations1 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		int[] answer1 = solution1(operations1);
		System.out.println(Arrays.toString(answer1));
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
			Object[] array = toArray();			// 현재 저장된 배열을 받음
			
			Arrays.sort(array);
			
			clear();							// 현재 저장된 배열을 삭제 
			
			for(Object temp : array) {
				this.add((Integer) temp);
			}
		}
	}
	
	// 다른 사람의 풀이 참고
	public static int[] solution1(String[] operations) {
		Queue<Integer> pq = new PriorityQueue<Integer>();
		Queue<Integer> reverse_pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(String operation : operations) {
			String[] temp = operation.split(" ");
			
			if(temp[0].equals("I")) {
				pq.add(Integer.parseInt(temp[1]));
				reverse_pq.add(Integer.parseInt(temp[1]));
			}else if(temp[0].equals("D")) {
				if(!pq.isEmpty()) {
					if(temp[1].equals("1")) {
						pq.remove(reverse_pq.poll());
					}else {
						reverse_pq.remove(pq.poll());
					}
				}
			}
		}
		
		int[] answer = new int[2];
		
		if(!pq.isEmpty()) {
			answer[0] = reverse_pq.poll();
			answer[1] = pq.poll();
		}
		
		return answer;
	}
}
