package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 기능개발 {

	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		int[] answer = solution(progresses, speeds);
		System.out.println(Arrays.toString(answer));
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

}
