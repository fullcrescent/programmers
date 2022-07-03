package programmers.level3;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 표_편집 {

	public static void main(String[] args) {
		int n = 8;
		int k = 2;
		String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
		String answer = solution(n, k, cmd);
		System.out.println(answer);
	}
	
	public static String solution(int n, int k, String[] cmd) {
		Stack<Integer> stack = new Stack<>();
		List<Integer> list = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			list.add(i);
		}
		
		int start = k;
		
		for(String temp : cmd) {
			int value = 0;
			if(temp.length()>1) {
				value = Integer.valueOf(temp.split(" ")[1]);
			}
			
			switch(temp.charAt(0)) {
				case 'U' :
					start = start-value;
					break;
				case 'D' : 
					start = start+value;
					break;
				case 'C' :
					stack.add(list.get(start));
					list.remove(start);
					
					start = list.size()<=start ? start-1 : start;
					
					break;
				case 'Z' :
					int stackValue = stack.pop();
					
					if(stackValue<=start) start++;
					
					if(stackValue<=list.size())	list.add(stackValue, stackValue);
					else						list.add(list.size(), stackValue);
					
					break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			sb.append("O");
		}
		
		while(!stack.isEmpty()) {
			int index = stack.pop();
			sb.replace(index, index+1, "X");
		}
		
		return sb.toString();
	}
}
