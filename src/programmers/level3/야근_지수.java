package programmers.level3;

import java.util.Arrays;

public class 야근_지수 {

	public static void main(String[] args) {
		int n = 3;
		int[] works = {5, 1, 7};
		long answer = solution(n, works);
		System.out.println(answer);
		
		int n1 = 3;
		int[] works1 = {5, 1, 7};
		long answer1 = solution1(n1, works1);
		System.out.println(answer1);
	}
	
	public static long solution(int n, int[] works){
		Integer[] temp = new Integer[works.length];
		for(int i=0; i<works.length; i++) {
			temp[i] = works[i];
		}
		
		Arrays.sort(temp, (i1, i2)-> -Integer.compare(i1, i2));

		int index = 1;
		
		while(index<temp.length) {
			long sum = 0;
			
			for(int i=0; i<index; i++) {
				sum += temp[i];
			}
			
			long diff = sum-(temp[index]*index);
			
			if(diff<n) {
				for(int i=0; i<index; i++) {
					n -= temp[i]-temp[index];
					temp[i] = temp[index];
				}
			}else {
				break;
			}
			
			index++;
		}
		
		while(n>0) {
			for(int i=0; i<index; i++) {
				if(n<=0) break;
				
				temp[i]--;
				n--;
			}
		}
		
		long answer = 0;
		
 		for(int work : temp) {
 			if(work>0) answer += Math.pow(work, 2);
		}
		
		return answer;
	}
	
	// 다른 사람의 풀이 참고 - 변경X
	public static long solution1(int n, int[] works){
		Integer[] temp = new Integer[works.length];
		for(int i=0; i<works.length; i++) {
			temp[i] = works[i];
		}
		
		Arrays.sort(temp, (i1, i2)-> -Integer.compare(i1, i2));

		int index = 1;
		
		while(index<temp.length) {
			long sum = 0;
			
			for(int i=0; i<index; i++) {
				sum += temp[i];
			}
			
			long diff = sum-(temp[index]*index);
			
			if(diff<n) {
				for(int i=0; i<index; i++) {
					n -= temp[i]-temp[index];
					temp[i] = temp[index];
				}
			}else {
				break;
			}
			
			index++;
		}
		
		while(n>0) {
			for(int i=0; i<index; i++) {
				if(n<=0) break;
				
				temp[i]--;
				n--;
			}
		}
		
		long answer = 0;
		
 		for(int work : temp) {
 			if(work>0) answer += Math.pow(work, 2);
		}
		
		return answer;
	}
}
