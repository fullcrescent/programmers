package programmers.level3;

import java.util.Arrays;
import java.util.Comparator;

public class 입국심사 {

	public static void main(String[] args) {
		int n = 12;
		int[] times = {7, 10,12};
		long answer = solution(n, times);
		System.out.println(answer);
	}
	
	public static long solution(int n, int[] times) {
		long lcm = 1;
		int count = n;
		for(long time : times) {
			lcm = lcm(lcm, time);
		}
		
		long[] ratioArray = new long[times.length];
		long sum = 0;
		
		for(int i=0; i<times.length; i++) {
			long temp = lcm/(long)times[i];
			ratioArray[i] = temp;
			sum += temp;
		}
		
		Object[] array = new Object[times.length];
		
		for(int i=0; i<times.length; i++) {
			Object[] temp = new Object[3];
			double time = (double)((long)n*ratioArray[i])/sum;
			
			temp[0] = (long)times[i];
			temp[1] = (long)time;
			count -= (long)time;
			temp[2] = time - (long)time;
			
			array[i] = temp;
		}
		
		Arrays.sort(array, new Comparator<Object>() {
			@Override
			public int compare(Object i1, Object i2) {
				Object[] temp1 = (Object[]) i1;
				Object[] temp2 = (Object[]) i2;
				
				return Long.compare((long)temp1[0] * ((long)temp1[1]+1), (long)temp2[0] * ((long)temp2[1]+1));
			}
		});
		
		long answer = 0;
		
		Object[] temp = (Object[]) array[(count-1)%times.length];
		answer =  (long)temp[0] * ((long)temp[1]+1);
		
		return answer;
	}

	private static long lcm(long i1, long i2) {
		return i1*i2/gcd(i1, i2);
	}

	private static long gcd(long i1, long i2) {
		while(i2!=0) {
			long remainder = i1%i2;
			i1 = i2;
			i2 = remainder;
		}
		
		return i1;
	}
}
