package programmers.level3;

public class 풍선_터트리기 {

	public static void main(String[] args) {
		int[] a = {-16,27,65,66,67,68,69,70,71,72};
		int answer = solution(a);
		System.out.println(answer);
	}
	
	public static int solution(int[] a) {
		int answer = a.length;
		
		int left = a[0];
		int right = 1000000000;
		
		for(int i=2; i<a.length; i++) right = Math.min(right, a[i]);
		
		for(int i=1; i<a.length-1; i++) {
			int value = a[i];
			
			left = Math.min(left, a[i-1]);
			
			if(left<value)	{
				right = 1000000000;
				for(int j=i+1; j<a.length; j++) right = Math.min(right, a[j]);

				if(value>right)	answer--;
			}
		}
		
		return answer;
	}
}
