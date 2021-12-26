package programmers.level2;

import java.util.Arrays;

public class 가장_큰_수 {

	public static void main(String[] args) {
		int[] numbers = {1,2,39998,4,5,6,7,8,80, 9,10, 39999};
		String answer = solution(numbers);
		System.out.println(answer);
	}

	public static String solution(int[] numbers) {
		String[] numbersToString = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
		sort(numbersToString);
		
		String answer = "";
		
		for(String string : numbersToString) {
			answer += string;
		}
		
		return answer;
	}
	
	private static void sort(String[] numbers) {
		int start = 0;
        while(start < numbers.length) {
        	String pivot = numbers[start];
        	
            int left = 0;
            int right = start;
            
            while (left < right) {
                int mid = (left + right)/2;
                String temp1 = numbers[mid];
            	String temp2 = pivot;
               	
                if(temp1.startsWith(temp2) || temp2.startsWith(temp1)) {
                	
                	while(temp1.length() != temp2.length()) {
                		if(temp1.length() < temp2.length()) {
                			temp1 += temp1.substring(temp1.length()-1);
                		}else {
                			temp2 += temp2.substring(temp2.length()-1);
                		}
                	}
                }
                
                if (temp1.compareTo(temp2) < 0 || (temp1.compareTo(temp2) ==0 &&numbers[mid].compareTo(pivot) <0))
                    right = mid;
                else
                    left = mid + 1;
            }

            switch (start - left) {
                case 2:  numbers[left + 2] = numbers[left + 1];
                case 1:  numbers[left + 1] = numbers[left];
                         break;
                default: System.arraycopy(numbers, left, numbers, left + 1, start - left);
            }
            numbers[left] = pivot;
            
            start++;
        }
    }
	
	
//	private static Long max =0L;
//	
//	private static void permutaion(int[] numbers, int index, boolean[] visit, Long value) {
//		if(index == numbers.length) {
//			max = Math.max(max, Long.valueOf(value));
//			return;
//		}
//
//		for(int i=0; i<numbers.length; i++) {
//			if(visit[i]) continue;
//			visit[i] = true;
//			permutaion(numbers, index+1, visit, (long) (value + (Math.pow(10, value.toString().length()) * numbers[i])));
//			visit[i] = false;
//		}
//	}
}
