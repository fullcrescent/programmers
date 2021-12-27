package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 가장_큰_수 {

	public static void main(String[] args) {
		int[] numbers = {90,908,89,898,10,101,1,8,9};
		String answer = solution(numbers);
		System.out.println(answer);
		
		int[] numbers1 = {90,908,89,898,10,101,1,8,9};
		String answer1 = solution1(numbers1);
		System.out.println(answer1);
		
		int[] numbers2 = {90,908,89,898,10,101,1,8,9};
		String answer2 = solution1(numbers2);
		System.out.println(answer2);
		
		int[] numbers3 = {90,908,89,898,10,101,1,8,9};
		String answer3 = solution1(numbers3);
		System.out.println(answer3);
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
	
	// 다른 사람의 풀이 참고
	public static String solution1(int[] numbers) {
		String answer = Arrays.stream(numbers).mapToObj(String::valueOf).sorted((s1, s2) -> -s1.concat(s2).compareTo(s2.concat(s1))).reduce("", (s1, s2) -> s1.concat(s2));
		
		return answer.charAt(0) != '0' ? answer : "0";
	}
	
	public static String solution2(int[] numbers) {
		String[] numbersToString = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
		
		Arrays.sort(numbersToString , new Comparator<String>() {
			public int compare(String s1, String s2) {
				return -s1.concat(s2).compareTo(s2.concat(s1));
			}
		});
		
		String answer = Arrays.stream(numbersToString).reduce("", (s1, s2) -> s1.concat(s2));
		
		return answer.charAt(0) != '0' ? answer : "0";
	}
	
	public static String solution3(int[] numbers) {
		List<String> stringList = new ArrayList<>(Arrays.asList(Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new)));
		
		Collections.sort(stringList, (s1,s2) ->{
			return s2.concat(s1).compareTo(s1.concat(s2));
		});
		
		StringBuilder sb = new StringBuilder();
		for(String s : stringList) {
			sb.append(s);
		}
		
		String answer = sb.toString();
		
		return answer.charAt(0) != '0' ? answer : "0";
	}
}
