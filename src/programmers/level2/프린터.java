package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {

	public static void main(String[] args) {
		int[] priorities = {2, 1, 3, 2};
		int location = 2;
		int answer = solution(priorities, location);
		System.out.println(answer);
	}

	public static int solution(int[] priorities, int location) {
		int answer = 0;
		int work;
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=0; i<priorities.length; i++) {
			queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			work = queue.poll();
			
			for(int i=0; i<priorities.length; i++) {
				if(priorities[work]<priorities[i]) {
					queue.add(work);
					break;
				}
				
				if(i==priorities.length-1) {
					answer++;
					if(work==location) {
						return answer;
					}
					priorities[work] = 0;
				}
			}
		}
		
		return -1;
	}
}
