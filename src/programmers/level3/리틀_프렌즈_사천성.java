package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class 리틀_프렌즈_사천성 {

	public static void main(String[] args) {
		int m = 5;
		int n = 5; 
		String[] board = {"FGHEI", "BAB..", "D.C*.", "CA..I", "DFHGE"};
		String answer = solution(m, n, board);
		System.out.println(answer);
		
		int m1 = 5;
		int n1 = 5; 
		String[] board1 = {"FGHEI", "BAB..", "D.C*.", "CA..I", "DFHGE"};
		String answer1 = solution1(m1, n1, board1);
		System.out.println(answer1);
	}
	
	public static String solution(int m, int n, String[] board) {
		String answer = "";
		String tempAnswer = null;
		
		while(answer!=tempAnswer) {
			tempAnswer = answer;
			
			char temp = 64;
			
			while(temp++<91) {
				int startX = -1, startY = -1, endX = -1, endY = -1;
				
				Loop :
				for(int i=0; i<m; i++) {
					for(int j=0; j<n; j++) {
						if(board[i].charAt(j)==temp) {
							if(startX==-1) {
								startX = i;
								startY = j;
							}else if(endX==-1){
								endX = i;
								endY = j;
								break Loop;
							}
						}
					}
				}
				
				if(endX==-1) continue;
				
				int i = startX<endX ? 1 : -1;
				int j = startY<endY ? 1 : -1;
				
				if(startX!=endX) {
					int tempX = startX;
					int tempY = startY;
					
					boolean flag = true;
					
					while(tempX!=endX) {
						tempX += i;
						
						if(board[tempX].charAt(startY)!='.') {
							flag = false;
							break;
						}
					}
					
					if(flag) {
						while(tempY!=endY) {
							tempY += j;
							
							if(board[tempX].charAt(tempY)!='.') {
								break;
							}
						}
					}
					
					if(tempX==endX && tempY==endY) {
						answer += temp;
						board[startX] = board[startX].replace(temp, '.');
						board[endX] = board[endX].replace(temp, '.');	
						temp = 64;
						continue;
					}
				}
				
				if(startY!=endY) {
					int tempX = startX;
					int tempY = startY;
					
					boolean flag = true;
					
					while(tempY!=endY) {
						tempY += j;
						
						if(board[startX].charAt(tempY)!='.') {
							flag = false;
							break;
						}
					}
					
					if(flag) {
						while(tempX!=endX) {
							tempX += i;
							
							if(board[tempX].charAt(tempY)!='.') {
								break;
							}
						}
					}
					
					if(tempX==endX && tempY==endY) {
						answer += temp;
						board[startX] = board[startX].replace(temp, '.');
						board[endX] = board[endX].replace(temp, '.');
						temp = 64;
						continue;
					}
				}
			}
		}
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(board[i].charAt(j)>64 && board[i].charAt(j)<91){
					return "IMPOSSIBLE";
				}
			}
		}
		
		return answer;
	}
	
	// 다른 사람의 풀이 참고
	public static String solution1(int m, int n, String[] board) {
		StringBuilder answer = new StringBuilder();
		
		Set<Character> set = new TreeSet<>();
		
		String[] board2 = new String[board[0].length()];
		Arrays.fill(board2, "");
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length(); j++) {
				char temp = board[i].charAt(j);
				set.add(temp);
				board2[j] += temp;
			}
		}
		
		set.remove('*');
		set.remove('.');
		
		List<Character> list = new ArrayList<>(set);
		
		int index = 0;
		
		while(index<list.size()) {
			char temp = list.get(index++);

			int startX = -1, startY = -1, endX = -1, endY = -1;
			
			Loop :
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					if(board[i].charAt(j)==temp) {
						if(startX==-1) {
							startX = i;
							startY = j;
						}else if(endX==-1){
							endX = i;
							endY = j;
							break Loop;
						}
					}
				}
			}
			
			if(endX==-1) continue;
			
			if(validate(board, startX, startY, endX, endY) || validate(board2, startY, startX, endY, endX)) {
				board[startX] = board[startX].replace(temp, '.');
				board[endX] = board[endX].replace(temp, '.');
				
				board2[startY] = board2[startY].replace(temp, '.');
				board2[endY] = board2[endY].replace(temp, '.');	
				
				answer.append(temp);
				index = 0;
				continue;
			}
		}
		
		if(set.size()!=answer.length()) {
			return "IMPOSSIBLE";
		}
		
		return answer.toString();
	}

	private static boolean validate(String[] board, int start1, int start2, int end1, int end2) {
		int i = start1<end1 ? 1 : -1;
		int j = start2<end2 ? 1 : -1;
		
		if(start1!=end1) {
			int temp1 = start1;
			int temp2 = start2;
			
			boolean flag = true;
			
			while(temp1!=end1) {
				temp1 += i;
				
				if(board[temp1].charAt(start2)!='.') {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				while(temp2!=end2) {
					temp2 += j;
					
					if(board[temp1].charAt(temp2)!='.') {
						break;
					}
				}
			}
			
			if(temp1==end1 && temp2==end2)	return true;
		}
		
		return false;
	}
}
