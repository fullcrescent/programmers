package programmers.level3;

public class 풍선_터트리기 {

	public static void main(String[] args) {
		int[] a = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
		int answer = solution(a);
		System.out.println(answer);
	}
	
	public static int solution(int[] a) {
		int answer = a.length;
		
		int left = a[0];
		int right = 1000000000;
		
		for(int i=0; i<a.length; i++) {
			right = Math.min(right, a[i]);
		}
		
		for(int i=1; i<a.length-1; i++) {
			int temp = 0;
			
			left = Math.min(left, a[i-1]);
			
			if(left<a[i])	temp++;
			
			if(a[i]>right)	temp++;
			
			if(right==a[i+1]) {
				right = 1000000000;
				for(int j=i+2; j<a.length; j++) {
					right = Math.min(right, a[j]);
				}
			}
			
			if(temp==2) {
				answer--;
			}
		}
		
		return answer;
	}
}
