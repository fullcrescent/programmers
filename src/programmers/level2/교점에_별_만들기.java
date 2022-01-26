package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 교점에_별_만들기 {

	public static void main(String[] args) {
		int[][] line = {{1, -1, 0}, {2, -1, 0}};
		String[] answer = solution(line);
		System.out.println(Arrays.toString(answer));
	}
	
	public static String[] solution(int[][] line) {
		Queue<Star> queue = new LinkedList<>();
		
		long maxX = 0;
		long minX = 0;
		
		long maxY = 0;
		long minY = 0;  
		
		boolean flag = false;
		
		for(int i=0; i<line.length-1; i++) {
			for(int j=i+1; j<line.length; j++) {
				long A = line[i][0];
				long B = line[i][1];
				long C = line[i][2];
				
				long D = line[j][0];
				long E = line[j][1];
				long F = line[j][2];
				
				long numeratorX = B*F-C*E;
				long numeratorY = C*D-A*F;
				long denominator = A*E-B*D;
				
				if(denominator==0) {
					continue;
				}
				
				if(numeratorX%denominator==0 && numeratorY%denominator==0) {
					long X = numeratorX/denominator;
					long Y = numeratorY/denominator;
					
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
		
		String[] answer = new String[(int) (maxY-minY+1)];

		for(int i=0; i<=maxY-minY; i++) {
			String temp = "";
			for(int j=0; j<=maxX-minX; j++) {
				temp += ".";
			}
			answer[i] = temp;
		}
        
		while(!queue.isEmpty()) {
			Star temp = queue.poll();
			long replaceX = temp.x - minX;
			long replaceY = maxY - temp.y;
			
			answer[(int) replaceY] = answer[(int) replaceY].substring(0, (int) replaceX) + "*" + answer[(int) replaceY].substring((int) (replaceX)+1);
		}
		
        return answer;
    }
	
	static class Star{
		long x; 
		long y;
		
		public Star(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
}


