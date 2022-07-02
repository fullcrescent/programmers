package programmers.level3;

import java.util.Stack;

public class 표_편집 {

	public static void main(String[] args) {
		int n = 8;
		int k = 2;
		String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
		String answer = solution(n, k, cmd);
		System.out.println(answer);
	}
	
	public static String solution(int n, int k, String[] cmd) {
		Stack<Integer> stack = new Stack<>();
		boolean[] remove = new boolean[n];
		
		int start = k;
		
		for(String temp : cmd) {
			int value = 0;
			if(temp.length()>1) {
				value = Integer.valueOf(temp.split(" ")[1]);
			}
			
			int move = 0;
			
			switch(temp.charAt(0)) {
				case 'U' :
					while(move!=value){
						start--;

						if(remove[start]) {
							continue;
						}
						
						move++;
					}
					
					break;
				case 'D' : 
					while(move!=value){
						start++;
						
						if(remove[start]) {
							continue;
						}
						
						move++;
					}
					
					break;
				case 'C' :
					stack.add(start);
					remove[start] = true;
					
					int index = start+1;
					
					while(index<n) {
						if(!remove[index]) break;
						
						index++;
					}
					
					if(index==n) {
						index = start-1;
						
						while(index>-1) {
							if(!remove[index]) break;
							
							index--;
						}
					}	
					
					start = index; 
					
					break;
				case 'Z' : 
					remove[stack.pop()] = false;
					
					if(start==-1) {
						start = stack.pop();
					}
					
					break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			if(remove[i])	sb.append("X");
			else 			sb.append("O");
		}
		
		return sb.toString();
	}
}
