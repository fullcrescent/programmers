package programmers.level2;

public class 리코쳇_로봇 {
    public static void main(String[] args){
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        int answer = solution(board);
        System.out.println(answer);
    }

    public static int solution(String[] board) {
        int[][] distance = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] count = new int[board[0].length()][board.length];
        int[] start = new int[2];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length(); j++){
                if(board[i].charAt(j)=='R') start = new int[] {i, j};
            }
        }

        for(int[] temp : distance){

        }

        return 0;
    }
}
