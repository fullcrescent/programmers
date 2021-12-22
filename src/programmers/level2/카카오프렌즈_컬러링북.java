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
}
