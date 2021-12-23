package programmers.level2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 수식_최대화 {
	public static void main(String args[]) {
		String expression = "100-200+100*200-500*300-300";
		long answer = solution(expression);
		System.out.println(answer);
	}
	
	public static long solution(String expression) {
		Pattern patternPrev = Pattern.compile("[^*+-][0-9]*$");
		Pattern patternNext= Pattern.compile("^[-]?[0-9]*[^*+-]");
		
		String operationSelect = "";
		if(expression.contains("-")) {
			operationSelect += "-";
		}
		if(expression.contains("+")) {
			operationSelect += "+";
		}
		if(expression.contains("*")) {
			operationSelect += "*";
		}
		
		boolean[] visited = new boolean[operationSelect.length()];
		
		permutation(expression, operationSelect, visited, patternPrev, patternNext, operationSelect.length(), 0, new StringBuffer("   "));
		
		return max;
	}
	
	private static long max=0; 
	
	private static void permutation(String expression, String operationSelect, boolean[] visited, Pattern patternPrev, Pattern patternNext, int count, int index, StringBuffer operations) {
		if(index == count) {
			String value = split(expression, operations.toString().trim(), 0, patternPrev, patternNext);
			max = Math.max(max, Math.abs(Long.parseLong(value)));
			return;
		}
		
		for(int i=0; i<operationSelect.length(); i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			
			operations.replace(index, index+1, String.valueOf(operationSelect.charAt(i))); 
			
			permutation(expression, operationSelect, visited, patternPrev, patternNext, count, index+1, operations);
			
			visited[i] = false;
		}
		
		
	}
	
	private static String split(String expression, String operations, int index, Pattern patternPrev, Pattern patternNext) {
		if(operations.length() == index) {
			return expression;
		}
		
		String[] splitArray = expression.split("\\" + String.valueOf(operations.charAt(index)));
		
		expression = "";
		
		Matcher matcherPrev;
		Matcher matcherNext;
		
		long count =0;
		
		for(int i=0; i<splitArray.length-1; i++) {
			matcherPrev = patternPrev.matcher(splitArray[i]);
			matcherPrev.find();
			splitArray[i] = splitArray[i].substring(0, splitArray[i].length() - matcherPrev.group().length());

			matcherNext = patternNext.matcher(splitArray[i+1]);
			matcherNext.find();
			splitArray[i+1] = splitArray[i+1].substring(matcherNext.group().length(), splitArray[i+1].length());
			
			if(operations.charAt(index) == '-' && splitArray[i].length() >0 && splitArray[i].charAt(splitArray[i].length()-1)=='-') {
				count = opertaion(Long.valueOf(matcherPrev.group()), Long.valueOf(matcherNext.group()), '+');
			}else if(operations.indexOf('-') < operations.indexOf('+') && operations.charAt(index) == '+' && splitArray[i].length() >0 && splitArray[i].charAt(splitArray[i].length()-1)=='-') {
				count = opertaion(Long.valueOf(matcherPrev.group()), Long.valueOf(matcherNext.group()), '-');
			}else {
				count = opertaion(Long.valueOf(matcherPrev.group()), Long.valueOf(matcherNext.group()), operations.charAt(index));
			}
			
			splitArray[i+1] = splitArray[i] + count + splitArray[i+1];
		}
		
		if(splitArray[splitArray.length-1].contains("--")) {
			splitArray[splitArray.length-1] = splitArray[splitArray.length-1].replaceAll("--", "");
		}
		
		return split(splitArray[splitArray.length-1], operations, index+1, patternPrev, patternNext);
	}

	private static long opertaion(long number1, long number2, char operation) {
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
