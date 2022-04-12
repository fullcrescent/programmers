package programmers.level3;

import java.util.Arrays;
import java.util.Comparator;

public class 입국심사 {

	public static void main(String[] args) {
		int n = 13;
		int[] times = {7, 10,12};
		long answer = solution(n, times);
		System.out.println(answer);
	}
	
	public static long solution(int n, int[] times) {
		long lcm = 1;
		
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
			long[] temp = new long[2];
			double time = (double)((long)n*ratioArray[i])/sum;
			
			temp[0] = times[i];
			temp[1] = (long)time;
			n -= temp[1];
			
			array[i] = temp;
		}
		
		long answer = 0;
		
		if(n==0) {
			Arrays.sort(array, new Comparator<Object>() {
				@Override
				public int compare(Object i1, Object i2) {
					long[] temp1 = (long[]) i1;
					long[] temp2 = (long[]) i2;
					
					return Long.compare(temp1[0] * temp1[1], temp2[0] * temp2[1]);
				}
			});
			
			long[] temp = (long[]) array[array.length-1];
			answer =  temp[0] * temp[1];
			
		}else {
			Arrays.sort(array, new Comparator<Object>() {
				@Override
				public int compare(Object i1, Object i2) {
					long[] temp1 = (long[]) i1;
					long[] temp2 = (long[]) i2;
					
					return Long.compare(temp1[0] * (temp1[1]+1), temp2[0] * (temp2[1]+1));
				}
			});
			
			int index=0;
			int count = 1;
			
			while(n>0) {
				n--;
				
				long[] temp1 = (long[]) array[index];
				long[] temp2 = (long[]) array[index+1];
				
				long value1 = temp1[0] * (temp1[1]+count);
				long value2 = temp2[0] * (temp2[1]+1);
				
				if(value1<value2) {
					count++;
					answer = value1;
				}else {
					index++;
					count=1;
					answer = value2;
				}
			}
		}
		
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
