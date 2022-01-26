package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 교점에_별_만들기 {

	public static void main(String[] args) {
		int[][] line = {{1, 0, 4}, {0, 1, 4}, {0, 1, -4}, {1, 0, -4}};
		String[] answer = solution(line);
		System.out.println(Arrays.toString(answer));
	}
	
	public static String[] solution(int[][] line) {
		Queue<Star> queue = new LinkedList<>();
		
		int maxX = 0;
		int minX = 0;
		
		int maxY = 0;
		int minY = 0;
		
		boolean flag = false;
		
		for(int i=0; i<line.length-1; i++) {
			for(int j=i+1; j<line.length; j++) {
				int A = line[i][0];
				int B = line[i][1];
				int C = line[i][2];
				
				int D = line[j][0];
				int E = line[j][1];
				int F = line[j][2];
				
				int numeratorX = B*F-C*E;
				int numeratorY = C*D-A*F;
				int denominator = A*E-B*D;
				
				if(denominator==0) {
					continue;
				}
				
				if(numeratorX%denominator==0 && numeratorY%denominator==0) {
					int X = numeratorX/denominator;
					int Y = numeratorY/denominator;
					
					queue.add(new Star(X, Y));
					
					if(flag) {
						maxX = Math.max(maxX, X);
						minX = Math.min(minX, X);
						maxY = Math.max(maxY, Y);
						minY = Math.min(minY, Y);
					}else{
						flag = true;
						maxX = minX = X;
						maxY = minY = Y;
					}
					
				}
			}
		}
		
		String[] answer = new String[maxY-minY+1];

		for(int i=0; i<=maxY-minY; i++) {
			String temp = "";
			for(int j=0; j<=maxX-minX; j++) {
				temp += ".";
			}
			answer[i] = temp;
		}
        
		while(!queue.isEmpty()) {
			Star temp = queue.poll();
			int replaceX = temp.x - minX;
			int replaceY = maxY - temp.y ;
			
			answer[replaceY] = answer[replaceY].substring(0, replaceX) + "*" + answer[replaceY].substring(replaceX+1);
		}
		
        return answer;
    }
	
	static class Star{
		int x; 
		int y;
		
		public Star(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}


