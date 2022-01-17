package programmers.level2;

import java.util.Arrays;

public class 두개_이하로_다른_비트 {

	public static void main(String[] args) {
		long[] numbers = {5, 11};
		long[] answer = solution(numbers);
		System.out.println(Arrays.toString(answer));
	}
	
	public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        int index=0;
        
        for(long number : numbers) {
        	int zeroIndex=0;
        	while(true) {
        		zeroIndex++;
        		if(number%2==1) {
        			number = number-1;
        			if(number==0) {
        				answer[index] = (long) (numbers[index++]+Math.pow(2, zeroIndex-1));
        				break;
        			}
        		}else {
        			answer[index] = (long) (numbers[index++]+Math.pow(2, zeroIndex-1)-(zeroIndex>1 ? Math.pow(2, zeroIndex-2) : 0));
        			break;
        		}
        		number /= 2;
        	}
        }
        
        return answer;
    }
	
}
