package programmers.level3;

import java.util.ArrayList;
import java.util.List;

public class 풍선_터트리기 {

	public static void main(String[] args) {
		int[] a = {-16,27,65,66,67,68,69,70,71,72};
		int answer = solution(a);
		System.out.println(answer);
	}
	
	public static int solution(int[] a) {
		List<Integer> list = new ArrayList<>();
		
		int answer = a.length;
		
		int left = a[0];
		
		for(int i=2; i<a.length; i++) {
			list.add(a[i]);
		}
		
		list.sort(null);
		
		for(int i=1; i<a.length-1; i++) {
			int temp = 0;
			int value = a[i];
			int right = list.get(0);
			
			left = Math.min(left, a[i-1]);
			
			list.remove((Integer)a[i+1]);
			
			if(left<value)	temp++;
			else 			continue;
			
			if(value>right)	temp++;
			else			continue;
			
			
			if(temp==2) answer--;
		}
		
		return answer;
	}
}
