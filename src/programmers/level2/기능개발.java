package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class 기능개발 {

	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		int[] answer = solution(progresses, speeds);
		System.out.println(Arrays.toString(answer));
		
		int[] progresses1 = {93, 30, 55};
		int[] speeds1 = {1, 30, 5};
		int[] answer1 = solution1(progresses1, speeds1);
		System.out.println(Arrays.toString(answer1));
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
		Stack<Integer> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		
		int count = progresses.length;
		int startCount = 0;
		int answerCount = 0;
		
		while(count>startCount) {
			answerCount = 0;
			
			for(int i=startCount; i<count; i++) {
				if(progresses[i]<100) {
					progresses[i] += speeds[i]; 
				}
			}
			
			for(int j=count-1; j>=startCount; j--) {
				stack.add(progresses[j]);
			}
			
			while(!stack.isEmpty()&&stack.peek()>=100) {
				stack.pop();
				answerCount++;
				startCount++;
			}
			
			if(answerCount!=0) {
				list.add(answerCount);
			}
		}
		
		return list.stream().mapToInt(i->i).toArray();
	}
	
	// 다른 사람의 풀이 참고
	public static int[] solution1(int[] progresses, int[] speeds) {
		Map<Integer, Integer> map = new HashMap<>();
		int day = 0;
		
		for(int i=0; i<progresses.length; i++) {
			while(progresses[i] + (day*speeds[i])<100) {
				day++;
			}
			
			map.put(day, map.get(day)==null? 1 : map.get(day)+1);
		}
		
		List<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list);
		
		List<Integer> answer = new LinkedList<>();
		for(int key : list) {
			answer.add(map.get(key));
		}
		
		return answer.stream().mapToInt(i->i).toArray();
	}
}
