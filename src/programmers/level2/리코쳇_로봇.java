package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 리코쳇_로봇 {
    public static void main(String[] args){
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        int answer = solution(board);
        System.out.println(answer);
    }

    public static int solution(String[] board) {
        int[][] distance = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] count = new int[board[0].length()][board.length];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length(); j++){
                if(board[i].charAt(j)=='R') queue.add(new int[] {i, j});
            }
        }

        while(!queue.isEmpty()){
            int[] start = queue.poll();

            for(int[] d : distance){
                int[] temp = start.clone();
                temp[0] += d[0];
                temp[1] += d[1];

                while(-1<temp[0] && temp[0]<board.length
                        && -1<temp[1] && temp[1]<board[0].length()
                        && board[temp[0]].charAt(temp[1])=='.'){
                    temp[0] += d[0];
                    temp[1] += d[1];
                }

                System.out.println(temp[0]);
                System.out.println(temp[1]);
            }
        }

        return 0;
    }
}
