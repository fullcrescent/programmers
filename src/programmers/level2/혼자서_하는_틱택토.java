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

        if(prevCount<nextCount){
            return 0;
        }

        return 1;
    }

    private static boolean valid(){
        return true;
    }
}
