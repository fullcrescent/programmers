package programmers.level3;

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
		boolean[] remove = new boolean[n];
		
		int start = k;
		
		int left = 0;
		int right = 0;
		int mid = 0;
		int count = 0;
		int index = 0;
		
		for(String temp : cmd) {
			int value = 1;
			if(temp.length()>1) {
				value = Integer.valueOf(temp.split(" ")[1]);
			}
			
			switch(temp.charAt(0)) {
				case 'U' :
					index = start-1;
					left = 0;
					right = start-1; 
					
					while(left<=right){
						count = 0;
						
						mid = (left+right)/2;
						
						for(int i=index; i>=mid; i--) {
							if(!remove[i]) count++;
							
							if(count==value) break;
						}
						
						if(count==value) {
							start = mid;
							left = mid+1;
						}else {
							right = mid-1;
						}
					}
					
					break;
				case 'D' : 
					index = start+1;
					left = start+1;
					right = n; 
					
					while(left<=right){
						count = 0;
						
						mid = (left+right)/2;
						
						for(int i=index; i<=mid; i++) {
							if(!remove[i]) count++;
							
							if(count==value) break;
						}
						
						if(count==value) {
							start = mid;
							right = mid-1;
						}else {
							left = mid+1;
						}
					}
					
					break;
				case 'C' :
					stack.add(start);
					remove[start] = true;
					
					index = start+1;
					left = start+1;
					right = n; 
					
					Loop1 :
					while(left<=right){
						count = 0;
						
						mid = (left+right)/2;
						
						for(int i=index; i<=mid; i++) {
							if(i==remove.length) {
								start = remove.length;
								break Loop1;
							}
							
							if(!remove[i]) {
								start = mid;
								right = mid-1;
								continue Loop1;
							}
						}
						
						left = mid+1;
					}
					
					if(start==remove.length) {
						index = start-1;
						left = 0;
						right = start-1; 
						
						Loop2 : 
						while(left<=right){
							count = 0;
							
							mid = (left+right)/2;
							
							for(int i=index; i>=mid; i--) {
								if(!remove[i]) {
									start = mid;
									left = mid+1;
									continue Loop2;
								}
							}
							
							right = mid-1;
						}
					}
					
					break;
				case 'Z' : 
					remove[stack.pop()] = false;
					
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

//	private static int binarySearch(boolean[] array, int left, int right, int value) {
//		int mid = 0, index = 0, weight = 0, answer = 0;
//		
//		if(left==0) {
//			index = right-1;
//			weight = -1;
//		}
//		else{
//			index = left+1;
//			weight = 1;
//		}
//		
//		while(left<=right){
//			int count = 0;
//			
//			mid = (left+right)/2;
//			
//			for(int i=index; i!=mid+weight; i += weight) {
//				if(i==array.length) return array.length;
//				
//				if(!array[i]) count++;
//				
//				if(count==value) break;
//			}
//			
//			if(weight==1) {
//				if(count==value) {
//					answer = mid;
//					right = mid-1;
//				}else {
//					left = mid+1;
//				}
//			}else {
//				if(count==value) {
//					answer = mid;
//					left = mid+1;
//				}else {
//					right = mid-1;
//				}
//			}
//		}
//		
//		return answer;
//	}
}
