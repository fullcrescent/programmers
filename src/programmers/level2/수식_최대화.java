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
		Pattern patternPrev = Pattern.compile("^[-]?[0-9]*[^*+-]");
		Pattern patternNext= Pattern.compile("[^*+-][0-9]*$");
		
		String operationSelect = "";
		if(expression.contains("+")) {
			operationSelect += "+";
		}
		if(expression.contains("-")) {
			operationSelect += "-";
		}
		if(expression.contains("*")) {
			operationSelect += "*";
		}
		
		boolean[] visited = new boolean[operationSelect.length()];
		
		permutation(expression, operationSelect, visited, patternPrev, patternNext, operationSelect.length(), 0, new StringBuffer("   "));
		
		return max;
	}
	
	private static int max=0; 
	
	private static void permutation(String expression, String operationSelect, boolean[] visited, Pattern patternPrev, Pattern patternNext, int count, int index, StringBuffer operations) {
		if(index == count) {
			String value = split(expression, operations.toString().trim(), 0, patternPrev, patternNext);
			max = Math.max(max, Math.abs(Integer.parseInt(value)));
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
			if(expression.chars().filter(c -> c == '-').count()%2==0) {
				expression = expression.replaceAll("-", "");
			}
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
					splitArray[i+1] = count + splitArray[i+1];
				}else if(!splitArray[i+1].equals("") || i+2 == splitArray.length) {
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
