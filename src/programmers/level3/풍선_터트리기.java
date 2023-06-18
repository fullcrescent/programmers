package programmers.level3;

import java.util.Arrays;

public class 풍선_터트리기 {

	public static void main(String[] args) {
		int[] a = {9, -1, -5};
		int answer = solution(a);
		System.out.println(answer);
	}
	
	public static int solution(int[] a) {
		int leftIndex = 0;
		int rightIndex = a.length-1;

		int minLeft = a[leftIndex++];
		int minRight = a[rightIndex--];

		while(leftIndex<rightIndex){
			if(a[leftIndex]<minLeft){
				minLeft = a[leftIndex++];
			}else if(a[rightIndex]<minRight){
				minRight = a[rightIndex--];
			}else{
				break;
			}
		}

		int filter = Math.max(a[leftIndex-1], a[rightIndex+1]);

		return a.length-(rightIndex-leftIndex+1) + (int) Arrays.stream(a, leftIndex, rightIndex + 1).filter(i -> i<filter).count();
	}
}
