package programmers.level2;

public class 피보나치_수 {

	public static void main(String[] args) {
		int n = 3;
		int answer = solution(n);
		System.out.println(answer);
	}
	
	public static int solution(int n) {
		f = new int[n];
		return fibonacci(n);
	}
	
	static int[] f;
	
	public static int fibonacci(int n) {
		if(n==0) {
			return 0;
		}else if(n==1) {
			return 1;
		}
		
		if(f[n-1]==0) {
			f[n-1] = fibonacci(n-1)%1234567;
		}
		
		if(f[n-2]==0) {
			f[n-2] = fibonacci(n-2)%1234567;
		}
		
		return f[n-1] + f[n-2];
	}
}
