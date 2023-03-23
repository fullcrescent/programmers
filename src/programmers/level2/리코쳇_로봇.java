package programmers.level2;

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
        int[][] countArray = new int[board.length][board[0].length()];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length(); j++){
                if(board[i].charAt(j)=='R') {
                    queue.add(new int[] {i, j});
                    countArray[i][j] = 1;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] start = queue.poll();
            int count = countArray[start[0]][start[1]];

            for(int[] d : distance){
                int[] temp = start.clone();
                add(temp, d, 1);

                while(-1<temp[0] && temp[0]<board.length
                        && -1<temp[1] && temp[1]<board[0].length()
                        && board[temp[0]].charAt(temp[1])!='D'){
                    add(temp, d, 1);
                }

                add(temp, d, -1);

                if(countArray[temp[0]][temp[1]]==0) {
                    if(board[temp[0]].charAt(temp[1])=='G') return count;

                    countArray[temp[0]][temp[1]] = count + 1;
                    queue.add(new int[]{temp[0], temp[1]});
                }
            }
        }

        return -1;
    }

    private static void add(int[] value, int[] d, int mul) {
        value[0] += d[0]*mul;
        value[1] += d[1]*mul;
    }
}
