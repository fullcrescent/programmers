package programmers.level2;

import java.math.BigInteger;

public class 멀리_뛰기 {

	public static void main(String[] args) {
		int n = 1999;
		long answer = solution(n);
		System.out.println(answer);

		int n1 = 1999;
		long answer1 = solution1(n1);
		System.out.println(answer1);
	}
	
	public static long solution(int n) {
		BigInteger answer = BigInteger.ZERO;
		
		BigInteger[] fac = new BigInteger[n+1];
		fac[0] = BigInteger.ONE;
		fac[1] = BigInteger.ONE;
		
		for(int i=2; i<n+1; i++)	fac[i] = fac[i-1].multiply(BigInteger.valueOf(i));
		
		int count = 0;
		
		while(n>=count) {
			answer = answer.add((fac[n].divide(fac[n-count].multiply(fac[count]))));
			n--;
			count++;
		}
		
		return answer.mod(BigInteger.valueOf(1234567)).longValue();
	}

	/*다른 사람의 풀이 참고 - 변경X*/
	public static long solution1(int n) {
		BigInteger answer = BigInteger.ZERO;

		BigInteger[] fac = new BigInteger[n+1];
		fac[0] = BigInteger.ONE;
		fac[1] = BigInteger.ONE;

		for(int i=2; i<n+1; i++)	fac[i] = fac[i-1].multiply(BigInteger.valueOf(i));

		int count = 0;

		while(n>=count) {
			answer = answer.add((fac[n].divide(fac[n-count].multiply(fac[count]))));
			n--;
			count++;
		}

		return answer.mod(BigInteger.valueOf(1234567)).longValue();
	}
}
