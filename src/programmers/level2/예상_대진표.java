package programmers.level2;

public class 예상_대진표 {

	public static void main(String[] args) {
		int N = 8;
		int A = 4;
		int B = 7;
		int answer = solution(N, A, B);
		System.out.println(answer);
	}

	public static int solution(int n, int a, int b) {
		int count=1;
		
		a = (a+1)/2;
		b = (b+1)/2;
		if(a==b) {
			return 1;
		}
		while(true) {
			if(a-b==1 || a-b==-1) {
				break;
			}
			count++;
			a = (a+1)/2;
			b = (b+1)/2;
		}
		
		count++;
		
		if(a<b && a%2 ==0) {
			count++;
		}else if(b<a && b%2==0) {
			count++;
		}
		
		return count;
	}

}
