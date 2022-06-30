package programmers.level3;

import java.util.ArrayList;
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
		String answer = "";
		
		Set<Character> set = new TreeSet<>();
		
		for(String temp : board) {
			for(char tempChar : temp.toCharArray()) {
				set.add(tempChar);
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
					index = 0;
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
					index = 0;
					continue;
				}
			}
		}
		
		if(set.size()!=answer.length()) {
			return "IMPOSSIBLE";
		}
		
		return answer;
	}
}
