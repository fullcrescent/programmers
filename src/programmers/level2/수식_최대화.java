package programmers.level2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 수식_최대화 {
	public static void main(String args[]) {
		String expression = "50*6-3*2";
		long answer = solution(expression);
		System.out.println(answer);
	}
	
	public static long solution(String expression) {
		Pattern patternPrev = Pattern.compile("^[0-9]*[^*+-]");
		Pattern patternNext= Pattern.compile("[^*+-][0-9]*$");
		
		String s = split(expression, "-*", 0, patternPrev, patternNext);
		System.out.println(s);
		return 0;
	}
	
	private static int max; 
	
	
	private static String split(String expression, String operations, int index, Pattern patternPrev, Pattern patternNext) {
		if(operations.length() == index) {
			return expression;
		}
		
		String[] splitArray = expression.split("\\" + String.valueOf(operations.charAt(index)));
		
		expression = "";
		
		Matcher matcherPrev;
		Matcher matcherNext;
		
		int count =0;
		
		for(int i=0; i<splitArray.length-1; i++) {
			matcherNext = patternPrev.matcher(splitArray[i+1]);
			matcherNext.find();
			splitArray[i+1] = splitArray[i+1].substring(matcherNext.group().length(), splitArray[i+1].length());
			
			if(splitArray[i].equals("")) {
				count = opertaion(count, Integer.valueOf(matcherNext.group()), operations.charAt(index));
				if(!splitArray[i+1].equals("")) {
					expression += count;
					if(i+2 == splitArray.length) {
						expression += splitArray[i+1];
					}
				}else if(i+2 == splitArray.length) {
					expression += count;
				}
			}else {
				matcherPrev = patternNext.matcher(splitArray[i]);
				matcherPrev.find();
				
				splitArray[i] = splitArray[i].substring(0, splitArray[i].length() - matcherPrev.group().length());
				
				count = opertaion(Integer.valueOf(matcherPrev.group()), Integer.valueOf(matcherNext.group()), operations.charAt(index));
				if(splitArray[i].equals("")) {
					continue;
				}
				
				if(!splitArray[i+1].equals("") || i+2 == splitArray.length) {
					expression += splitArray[i] + count + splitArray[i+1];
				}else {
					expression += splitArray[i];
				}
				
			}
			
		}
		
		return split(expression, operations, index+1, patternPrev, patternNext);
		
	}

	private static int opertaion(int number1, int number2, char operation) {
		if(operation == '+') {
			return number1 + number2;
		}
		if(operation == '-') {
			return number1 - number2;
		}
		if(operation == '*') {
			return number1 * number2;
		}
		return 0;
	}
	
}
