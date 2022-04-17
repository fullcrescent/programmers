package programmers.level3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
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
		
		Map<Integer, Integer> map = new HashMap<>();		// 속도를 위해서 추가
		
		for(String operation : operations) {
			String[] temp = operation.split(" ");
			
			int input = Integer.parseInt(temp[1]);
			
			if(temp[0].equals("I")) {
				pq.add(input);
				reverse_pq.add(input);
				
				map.put(input, map.getOrDefault(input, 0)+1);
			}else if(temp[0].equals("D")) {
				if(input==1) {
					remove(reverse_pq, map);
				}else {
					remove(pq, map);
				}
			}
		}
		
		if(map.keySet().size()==0) return new int[2]; 	// 키가 하나도 안 들어오는 경우 처리
		
		int max = Collections.min(map.keySet());
		int min = Collections.max(map.keySet());
		int size = 0;
		
		for(int key : map.keySet()) {
			int temp = map.get(key);
			
			if(temp>=1) {
				max = Math.max(max, key);
				min = Math.min(min, key);
				size++;
			}
		}
		
		int[] answer = new int[2];
		
		if(size!=0) {
			answer[0] = max;
			answer[1] = min;
		}
		
		return answer;
	}

	private static void remove(Queue<Integer> queue, Map<Integer, Integer> map) {
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			if(map.getOrDefault(temp, 0)==0) continue;			// 0일 경우 다음 숫자로 넘어감
			
			map.put(temp, map.get(temp)-1);
			break;
		}
	}
}
