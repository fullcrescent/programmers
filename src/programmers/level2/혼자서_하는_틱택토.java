package programmers.level2;

public class 혼자서_하는_틱택토 {
    public static void main(String[] args){
        String[] board =  {"O.X", ".O.", "..X"};
        int answer = solution(board);
        System.out.println(answer);
    }

    public static int solution(String[] board) {
        int prevCount = 0;
        int nextCount = 0;

        for(String temp : board){
            prevCount += temp.chars().filter(i -> i=='O').count();
            nextCount += temp.chars().filter(i -> i=='X').count();
        }

        if(valid(board, 'O') && !valid(board, 'X')){
            return prevCount==nextCount+1 ? 1 : 0;
        }else if(valid(board, 'O') && valid(board, 'X')){
            return 0;
        }else if(valid(board, 'X')){
            return prevCount==nextCount ? 1: 0;
        }else{
            return prevCount==nextCount || prevCount==nextCount+1 ? 1 : 0;
        }
    }

    private static boolean valid(String[] board, char c){
        for (String s : board) {
            int count = 0;

            for (int j = 0; j < board[0].length(); j++) {
                if (c == s.charAt(j)) count++;
            }

            if (count == 3) return true;
        }

        for(int i=0; i<board[0].length(); i++){
            int count = 0;

            for (String s : board) {
                if (c == s.charAt(i)) count++;
            }

            if(count==3) return true;
        }

        int[][][] cross = {{{0,0}, {1,1}, {2,2}}, {{0,2}, {1,1}, {2,0}}};

        for(int[][] crossArray : cross){
            int count = 0;

            for(int[] temp : crossArray){
                if(c==board[temp[0]].charAt(temp[1]))   count++;
            }

            if(count==3) return true;
        }

        return false;
    }
}
