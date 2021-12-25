package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class 수식_최대화 {
	public static void main(String args[]) {
		String expression = "100-200*300-500+20";
		long answer = solution(expression);
		System.out.println(answer);
		
		String expression1 = "100-200*300-500+20";
		long answer1 = solution1(expression1);
		System.out.println(answer1);
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
			
			// --가 나오면 바로 + 변환해 줘야함.
			if(splitArray[i+1].contains("--")) {
				splitArray[i+1] = splitArray[i+1].replaceAll("--", "");
			}
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
	
	// 참고
	public static long solution1(String expression) {
		// asList는 arrayList 반환 -> 삽입 삭제 빈번할 경우 LinkedList 유리
		// 프로그래머스에서 import시 Collectors는 import java.util.stream.*; 까지 적어줘야함.
		List<String> temp = new LinkedList<>(Arrays.asList(expression.split("[+,\\-,*]")));
		List<Long> numbersList = temp.stream().map(Long::parseLong).collect(Collectors.toList());
		List<Character> opertaionsList = new LinkedList<>(expression.replaceAll("[0-9]", "").chars().mapToObj(c -> (char)c).collect(Collectors.toList()));
		
		permutation1(new int[3], 0, numbersList, opertaionsList);
		
		return max1;
	}
	
	private static Long max1 = 0L;
	
	private static void permutation1(int[] visit, int index, List<Long> numbersList, List<Character> opertaionsList) {
		if(index==4) {
			operation(visit, numbersList, opertaionsList);
			return;
		}
		
		for(int i=0; i<visit.length; i++) {
			if(visit[i]==0) {
				visit[i] = index;
				permutation1(visit, index+1, numbersList, opertaionsList);
				visit[i] = 0;
			}
		}
	}

	private static void operation(int[] visit, List<Long> numbersList, List<Character> opertaionsList) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('+', visit[0]);
		map.put('-', visit[1]);
		map.put('*', visit[2]);
		
		Long tempValue = 0L;
		
		List<Long> tempNumbersList = new LinkedList<>();
		List<Character> tempOpertaionsList = new LinkedList<>();
		
		for(Long temp : numbersList ) {
			tempNumbersList.add(temp);
		}
		for(Character temp : opertaionsList ) {
			tempOpertaionsList.add(temp);
		}
		
		for(int i=1; i<visit.length+1;i++) {
			for(int j=0; j<tempOpertaionsList.size(); j++) {
				char operation = tempOpertaionsList.get(j);
				if(map.get(operation)==i) {
					tempValue = calculate(tempNumbersList.get(j), tempNumbersList.get(j+1), operation);
					
					tempNumbersList.remove(j);
					tempNumbersList.remove(j);
					tempNumbersList.add(j, tempValue);
					
					tempOpertaionsList.remove(j);

					j--;
				}
			}
		}
		
		max1 = Math.max(max1, Math.abs(tempNumbersList.get(0)));
	}

	private static Long calculate(Long number1, Long number2, char operation) {
		if(operation == '+') {
			return number1 + number2;
		}
		if(operation == '-') {
			return number1 - number2;
		}
		if(operation == '*') {
			return number1 * number2;
		}
		return 0L;
	}
	
}
