package programmers.level2;

import java.math.BigInteger;
import java.util.Arrays;

public class k진수에서_소수_개수_구하기 {

	public static void main(String[] args) {
		int n = 437670;
		int k = 3;
		int answer = solution(n, k);
		System.out.println(answer);
		
		int n1 = 437670;
		int k1 = 3;
		int answer1 = solution1(n1, k1);
		System.out.println(answer1);
	}
	
	public static int solution(int n, int k) {
		String s = Integer.toString(n, k);
		StringBuilder sb = new StringBuilder();
		
		int answer = 0;
		
		for(int i=0; i<s.length(); i++) {
			char temp = s.charAt(i);
			
			if(temp=='0') {
				if(isPrime(sb.toString())) {
					answer++;
				}
				sb.delete(0, sb.length());
			}else {
				sb.append(temp);
			}
		}
		
		if(sb.length()!=0) {
			if(isPrime(sb.toString())) {
				answer++;
			}
		}
		
		return answer;
	}

	private static boolean isPrime(String string) {
		if(string.equals("") || string.equals("1")) {
			return false;
		}
		
		long number = Long.parseLong(string);
		
		for(int i=2; i<=Math.sqrt(number); i++) {
			if(number%i==0) {
				return false;
			}
		}
		
		return true;
	}
	
	//다른 사람의 풀이 참고
	public static int solution1(int n, int k) {
		String s = Integer.toString(n, k);
		return (int) Arrays.stream(s.split("0")).filter(
				p-> !p.isEmpty() 
					&& !p.equals("1") 
					&& isPrime1(BigInteger.valueOf(Long.parseLong(p)))
//					&& (s.contains("0${p}0")
//		            || s.contains("${p}0")
//		            || s.contains("0${p}")
//		            || s.contains(p))		
				).count();
	}

	private static boolean isPrime1(BigInteger value) {
		for(long i=2; i<=Math.sqrt(value.longValue()); i++) {
			if(value.remainder(BigInteger.valueOf(i))==BigInteger.ZERO) {
				return false;
			}
		}
		
		return true;
	}
}
