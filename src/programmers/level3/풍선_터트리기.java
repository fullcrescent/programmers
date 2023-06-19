package programmers.level3;

public class 풍선_터트리기 {

	public static void main(String[] args) {
		int[] a = {9, -1, 5};
		int answer = solution(a);
		System.out.println(answer);
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
				minRight=a[rightIndex];
			}else if(minRight<minLeft){
				while(a[leftIndex]>minLeft){
					leftIndex++;
				}
				minLeft=a[leftIndex];
			}

			if(minLeft==minRight) count--;

			count++;
		}

		return count;
	}
}
