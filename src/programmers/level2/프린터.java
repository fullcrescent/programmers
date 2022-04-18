package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {

	public static void main(String[] args) {
		int[] priorities = {2, 1, 3, 2};
		int location = 2;
		int answer = solution(priorities, location);
		System.out.println(answer);
		
		int[] priorities1 = {2, 1, 3, 2};
		int location1 = 2;
		int answer1 = solution1(priorities1, location1);
		System.out.println(answer1);
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
	
	// 다른 사람의 풀이 참고 - 변경X
	public static int solution1(int[] priorities, int location) {
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
