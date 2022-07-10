package programmers.level3;

public class 금과_은_운반하기 {

	public static void main(String[] args) {
		int a = 90;
		int b = 500;
		int[] g = {70,70,0};
		int[] s = {0,0,500};
		int[] w = {100,100,2};
		int[] t = {4,8,1};
		long result = solution(a, b, g, s, w, t);
		System.out.println(result);
	}
	
	public static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
		long answer = 0;
		long left = 0;
//		long right = 100000000000000L;
		long right = 100;
		
		int cityCount = g.length;
		
		long mid;
		
		while(left<=right) {
			mid = (left+right)/2;
			
			int tempA = a;
			int tempB = b;
			
			for(int i=0; i<cityCount; i++) {
				long count = mid/t[i];
				
				long sum = w[i] * count;
				
				// 적절한 분배 필요
				
			}
			
			if(true==true) {
				answer = mid;
				right = mid-1;
			}else {
				left = mid+1;
			}
		}
		
		
		return 0;
	}

}
