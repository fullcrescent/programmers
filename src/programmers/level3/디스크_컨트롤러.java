package programmers.level3;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디스크_컨트롤러 {

	public static void main(String[] args) {
		int[][] jobs = {{0, 3}, {1,9}, {2,6}};
		int answer = solution(jobs);
		System.out.println(answer);
		
		int[][] jobs1 = {{0, 3}, {1,9}, {2,6}};
		int answer1 = solution1(jobs1);
		System.out.println(answer1);
	}
	
	public static int solution(int[][] jobs) {
		int answer = 0;
		
		Arrays.sort(jobs, (i1, i2)->{
			if(i1[0]!=i2[0]) return Integer.compare(i1[0], i2[0]);

			return Integer.compare(i1[1], i2[1]);
		});
		
		Queue<int[]> queue = new PriorityQueue<>((i1, i2) -> Integer.compare(i1[1], i2[1]));
		int index = 0;
		
		queue.add(jobs[index]);
		
		int time = jobs[index][0];
		
		while(index<jobs.length) {
			if(!queue.isEmpty()) {
				int[] temp = queue.poll();
				
				time += temp[1];
				answer += time - temp[0];
				
				while(index+1<jobs.length && jobs[index+1][0]<time) {
					queue.add(jobs[++index]);
				}
			}else if(index+1<jobs.length) {
				index++;
				time = jobs[index][0];
				queue.add(jobs[index]);
			}else {
				break;
			}
		}
		
		return answer/jobs.length;
	}
	
	// 다른 사람의 풀이 참고
	public static int solution1(int[][] jobs) {
		int answer = 0;
		
		Arrays.sort(jobs, (i1, i2)->{
			if(i1[0]!=i2[0]) return Integer.compare(i1[0], i2[0]);

			return Integer.compare(i1[1], i2[1]);
		});
		
		Queue<int[]> queue = new PriorityQueue<>((i1, i2) -> Integer.compare(i1[1], i2[1]));
		int index = 0;
		
		queue.add(jobs[index]);
		
		int time = jobs[index][0];
		
		while(index++<jobs.length) {
			if(!queue.isEmpty()) {
				int[] temp = queue.poll();
				
				time += temp[1];
				answer += time - temp[0];
				
				while(index<jobs.length && jobs[index][0]<time) {
					queue.add(jobs[index++]);
				}
				
				index--;
			}else if(index<jobs.length) {
				time = jobs[index][0];
				queue.add(jobs[index]);
			}
		}
		
		return answer/jobs.length;
	}
}
