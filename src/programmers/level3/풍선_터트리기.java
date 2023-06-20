package programmers.level3;

import java.util.HashSet;
import java.util.Set;

public class 풍선_터트리기 {

	public static void main(String[] args) {
		int[] a = {9, -1, 5};
		int answer = solution(a);
		System.out.println(answer);

		int[] a1 = {9, -1, 5};
		int answer1 = solution1(a1);
		System.out.println(answer1);
	}
	
	public static int solution(int[] a) {
		int count = 2;

		int leftIndex = 0;
		int rightIndex = a.length-1;

		int minLeft = a[leftIndex++];
		int minRight = a[rightIndex--];

		while(leftIndex<=rightIndex){
			if(a[leftIndex]<minLeft){
				minLeft = a[leftIndex++];
			}else if(a[rightIndex]<minRight){
				minRight = a[rightIndex--];
			}else if(minLeft<minRight){
				while(a[rightIndex]>minRight){
					rightIndex--;
				}
				minRight=a[rightIndex--];
			}else if(minRight<minLeft){
				while(a[leftIndex]>minLeft){
					leftIndex++;
				}
				minLeft=a[leftIndex++];
			}

			if(minLeft==minRight) count--;

			count++;
		}

		return count;
	}

	/*다른 사람의 풀이 참고*/
	public static int solution1(int[] a) {
		Set<Integer> set = new HashSet<>();

		int minLeft = Integer.MAX_VALUE;
		int minRight = Integer.MAX_VALUE;

		for(int i=0; i<a.length; i++){
			minLeft = Math.min(minLeft, a[i]);
			minRight = Math.min(minRight, a[a.length-1-i]);

			set.add(minLeft);
			set.add(minRight);
		}

		return set.size();
	}
}
