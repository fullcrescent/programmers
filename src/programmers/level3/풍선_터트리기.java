package programmers.level3;

public class 풍선_터트리기 {

	public static void main(String[] args) {
		int[] a = {9,-1,-5};
		int answer = solution(a);
		System.out.println(answer);
	}
	
	public static int solution(int[] a) {
		int answer = 1;
		
		int left = 1000000000;
		
		for(int i=0; i<a.length-1; i++) {
			int temp = 0;
			
			left = Math.min(left, a[i]);
			
			for(int j=i+1; j<a.length; j++) {
				if(a[i]>a[j]) {
					temp++;
					break;
				}
			}
			
			if(left<a[i+1])	temp++;
			
			if(temp<2) answer++;
		}
		
		return answer;
	}
}
