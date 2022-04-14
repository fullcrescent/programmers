package programmers.level3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디스크_컨트롤러 {

	public static void main(String[] args) {
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		int answer = solution(jobs);
		System.out.println(answer);
	}
	
	public static int solution(int[][] jobs) {
		int answer = 0;
		
		List<int[]> list = new ArrayList<>();
		
		for(int[] temp : jobs) {
			int[] tempArray = new int[3];
			tempArray[0] = temp[0];
			tempArray[1] = temp[1];
			list.add(tempArray);
		}
		
		Queue<int[]> queue = new PriorityQueue<>((i1, i2) -> Integer.compare(i1[1], i2[1]));
		
		list.get(0)[2] = list.get(0)[1]-list.get(0)[0];
		queue.add(list.get(0));
		list.remove(0);
		
		
		while(!queue.isEmpty()) {
			int[] value = queue.poll();
			answer += value[2]-value[0];
			
			Iterator<int[]> iter = list.iterator();
			
			while(iter.hasNext()){
				int[] temp = iter.next();
				
				if(temp[0]<=value[1]) {
					queue.add(temp);
					iter.remove();
				}
			}
			
			iter = queue.iterator();
			while(iter.hasNext()){
				int[] temp = iter.next();
				temp[2] = temp[1]+value[2];
			}
		}
		
		return answer/jobs.length;
	}
}
