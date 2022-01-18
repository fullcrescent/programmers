package programmers.level2;

import java.util.Arrays;

public class 두개_이하로_다른_비트 {

	public static void main(String[] args) {
		long[] numbers = {5, 7};
		long[] answer = solution(numbers);
		System.out.println(Arrays.toString(answer));
		
		long[] numbers1 = {3, 7};
		long[] answer1 = solution1(numbers1);
		System.out.println(Arrays.toString(answer1));
		
		long[] numbers2 = {3, 7};
		long[] answer2 = solution2(numbers2);
		System.out.println(Arrays.toString(answer2));
	}
	
	public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        int index=0;
        
        for(long number : numbers) {
        	// 0의 위치
        	int zeroIndex=0;
        	while(true) {
        		zeroIndex++;
        		if(number%2==1) {
        			// 1이 나올 때의 작업
        			number = number-1;			// 필요없는 작업
        			if(number==0) {
        				// 1만으로 구성될 때
        				answer[index] = (long) (numbers[index++]+Math.pow(2, zeroIndex-1));
        				break;
        			}
        		}else {
        			// 0이 하나라도 나올 때 0의 자리를 1로 채우고 그 아래 숫자를 0으로 채움
        			answer[index] = (long) (numbers[index++]+Math.pow(2, zeroIndex-1)-(zeroIndex>1 ? Math.pow(2, zeroIndex-2) : 0));
        			break;
        		}
        		number /= 2;
        	}
        }
        
        return answer;
    }
	
	// 다른 사람의 풀이 참고
	public static long[] solution1(long[] numbers) {
		long[] answer = numbers.clone();
		
		for(int i=0; i<answer.length; i++) {
			// 1을 더할경우 뒤에서부터 가장 가까운 0을 채움.
			answer[i]++;
			// 가장 가까운 0을 채운 2진수와 XOR할 경우 그 자릿수 포함 1로 구성하고 그것을 오른쪽 쉬프트 두번한 값을 구함
			// 해당 값과 1을 더할 경우 0 이전의 1의 값을 한번더 더한것과 같은 값을 구할수 있음.
			answer[i] += (answer[i]^numbers[i])>>>2;
		}
		
		return answer;
    }
	
	public static long[] solution2(long[] numbers) {
        long[] answer = numbers.clone();
        
        int index=0;
        
        for(long number : numbers) {
        	// 0의 위치
        	int zeroIndex=-1;
        	while(number%2!=0) {
        		zeroIndex++;
        		number /= 2;
        	}
        	
        	long temp = (long) Math.pow(2, zeroIndex);
        	
        	answer[index++] += temp!=0 ? temp : 1; 
        }
        
        return answer;
    }
	
}
