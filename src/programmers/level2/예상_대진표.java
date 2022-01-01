package programmers.level2;

public class 예상_대진표 {

	public static void main(String[] args) {
		int N = 8;
		int A = 4;
		int B = 7;
		int answer = solution(N, A, B);
		System.out.println(answer);
		
		int N1 = 8;
		int A1 = 4;
		int B1 = 7;
		int answer1 = solution1(N1, A1, B1);
		System.out.println(answer1);
	}

	public static int solution(int n, int a, int b) {
		int count=1;
		
		a = (a+1)/2;
		b = (b+1)/2;

		while(true) {
			if(a==b) {
				break;
			}
			count++;
			a = (a+1)/2;
			b = (b+1)/2;
		}
		
		return count;
	}
	
	// 다른 사람의 풀이 참고
	public static int solution1(int n, int a, int b) {
		return Integer.toBinaryString((a-1)^(b-1)).length();
	}
}
