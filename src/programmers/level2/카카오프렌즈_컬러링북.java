package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class 카카오프렌즈_컬러링북 {
	public static void main(String args[]) {
		int m = 6;
		int n = 4;
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		int[] answer = solution(m, n, picture);
		System.out.println(Arrays.toString(answer));
		
		int m1 = 6;
		int n1 = 4;
		int[][] picture1 = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		int[] answer1 = solution1(m1, n1, picture1);
		System.out.println(Arrays.toString(answer1));
	}
  
	public static int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		int sizeOfOneArea = 0;
		int color;
		
		int[][] tempPicture = new int[m][n];
		for(int i=0; i<m;i++) {
			for(int j=0; j<n; j++) {
				tempPicture[i][j]= picture[i][j];
			}
		}
		
		int x; 
		int y;
		
		Queue<Integer> mQueue= new LinkedList<>();
		Queue<Integer> nQueue= new LinkedList<>();
		
		for(int i = 0; i<m; i++){
		    for(int j=0; j<n; j++){
		        if(tempPicture[i][j] !=0){
		            numberOfArea++;
		            color = tempPicture[i][j];
		            
		            mQueue.add(i);
		            nQueue.add(j);
		            tempPicture[i][j] = 0;
		            
		            while(!mQueue.isEmpty()&& !nQueue.isEmpty()){
		               x = mQueue.poll();
		               y = nQueue.poll();
		               sizeOfOneArea++;
		               
		               if(x-1 > -1 && tempPicture[x-1][y] == color) {
		            	   mQueue.add(x -1);
		            	   nQueue.add(y);
		            	   tempPicture[x-1][y] = 0;
		               }
		               if(y-1 > -1 && tempPicture[x][y-1] == color) {
		            	   mQueue.add(x);
		            	   nQueue.add(y-1);
		            	   tempPicture[x][y-1] = 0;
		               }
		               if(x+1 < m && tempPicture[x+1][y] == color) {
		            	   mQueue.add(x+1);
		            	   nQueue.add(y);
		            	   tempPicture[x+1][y] = 0;
		               }
		               if(y+1 < n && tempPicture[x][y+1] == color) {
		            	   mQueue.add(x);
		            	   nQueue.add(y+1);
		            	   tempPicture[x][y+1] = 0;
		               }
		            }
		        }
		        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sizeOfOneArea);
		        sizeOfOneArea=0;
		    }
		}
		
		
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	// 다른 사람의 풀이 참고
	public static int[] solution1(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
	    
		boolean[][] visit = new boolean[picture.length][picture[0].length];
	    
		for(int i=0; i<picture.length; i++) {
			for(int j=0; j<picture[i].length; j++) {
				if(picture[i][j]==0 || visit[i][j]) continue;
				numberOfArea ++;
				
				int area = getArea(i, j, visit, picture)+1;
				
				if(maxSizeOfOneArea<area) maxSizeOfOneArea = area;
			}
		}
		
		int[] answer = new int[2];
		
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		
		return answer;
	}
	
	private static int getArea(int x, int y, boolean[][] visit, int[][] picture) {
		visit[x][y] = true;
		
		int answer = 0;
		int color = picture[x][y];
		
		if(x>0 						&& color==picture[x-1][y] && !visit[x-1][y]) answer += getArea(x-1, y, visit, picture)+1;
		if(x<picture.length-1 		&& color==picture[x+1][y] && !visit[x+1][y]) answer += getArea(x+1, y, visit, picture)+1;
		if(y>0 						&& color==picture[x][y-1] && !visit[x][y-1]) answer += getArea(x, y-1, visit, picture)+1;
		if(y<picture[x].length-1 	&& color==picture[x][y+1] && !visit[x][y+1]) answer += getArea(x, y+1, visit, picture)+1;
		
		return answer;
	}
}
