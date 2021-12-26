package programmers.level2;

import java.util.Arrays;

public class 가장_큰_수 {

	public static void main(String[] args) {
		int[] numbers = {90,908,89,898,10,101,1,8,9};
		String answer = solution(numbers);
		System.out.println(answer);
	}

	public static String solution(int[] numbers) {
		String[] numbersToString = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
		sort(numbersToString);
		
		String answer = "";
		
		for(String string : numbersToString) {
			if(answer.equals("0") && string.equals("0")) {
				continue;
			}
			answer += string;
		}
		
		return answer;
	}
	
	private static void sort(String[] numbers) {
		int start = 1;
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
                			temp1 += temp1.substring(0,1);
                		}else {
                			temp2 += temp2.substring(0,1);
                		}
                	}
                }
                
                if (temp1.compareTo(temp2) < 0) {
                    right = mid;
                }else if (temp1.compareTo(temp2) == 0) {
                	int index=0;
                	
                	while(temp1.charAt(index) == (temp1.charAt(temp1.length()-1)) ){
                		if(index == temp1.length()-1) {
                			break;
                		}
                		index++;
                	}
                	
                	if((temp1.charAt(index) > (temp1.charAt(temp1.length()-1)) && numbers[mid].length() > pivot.length())
                			|| (temp1.charAt(index) < (temp1.charAt(temp1.length()-1)) && numbers[mid].length() < pivot.length()) ){
                		right = mid;
                	}else {
                		left = mid + 1;
                	}
                }else {
                	left = mid + 1;
                }
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
	
}
