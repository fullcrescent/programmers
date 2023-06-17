package programmers.level3;

public class 풍선_터트리기 {

	public static void main(String[] args) {
		int[] a = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
		int answer = solution(a);
		System.out.println(answer);
	}
	
	public static int solution(int[] a) {
		int minLeft = 1000000000;
		int minRight = 1000000000;

		int leftIndex = 0;
		int rightIndex = a.length-1;

		while(leftIndex<rightIndex){
			if(a[leftIndex]<minLeft){
				minLeft = a[leftIndex++];
			}else if(a[rightIndex]<minRight){
				minRight = a[rightIndex--];
			}else{
				break;
			}
		}

		return a.length-(rightIndex-leftIndex+1);
	}
}
