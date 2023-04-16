package programmers.level2;

public class 혼자서_하는_틱택토 {
    public static void main(String[] args){
        String[] board =  {"O.X", ".O.", "..X"};
        int answer = solution(board);
        System.out.println(answer);

        String[] board1 =  {"O.X", ".O.", "..X"};
        int answer1 = solution1(board1);
        System.out.println(answer1);
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

    /*다른 사람의 풀이 참고*/
    public static int solution1(String[] board) {
        int prevCount = 0;
        int nextCount = 0;

        for(String temp : board){
            prevCount += temp.chars().filter(i -> i=='O').count();
            nextCount += temp.chars().filter(i -> i=='X').count();
        }

        boolean prevWin = valid1(board, 'O');
        boolean nextWin = valid1(board, 'X');

        if(prevWin){
            return nextWin ? 0 : prevCount==nextCount+1 ? 1 : 0;
        }else if(nextWin){
            return prevCount==nextCount ? 1: 0;
        }else{
            return prevCount==nextCount || prevCount==nextCount+1 ? 1 : 0;
        }
    }

    private static boolean valid1(String[] board, char c){
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
