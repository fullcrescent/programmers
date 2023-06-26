package programmers.level3;

public class 파괴되지_않는_건물 {
    public static void main(String[] args) {
        int[][] board = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] skill = {{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}};
        int answer = solution(board, skill);
        System.out.println(answer);
    }

    public static int solution(int[][] board, int[][] skill) {




        return 0;
    }

    static class skill{
        SkillType skillType;
        int r1;
        int c1;
        int r2;
        int c2;
        int degree;

    }

    enum SkillType{
        ATTACK("attack")
        ,RECOVERY("recovery");

        private final String type;

        SkillType(String type){
            this.type = type;
        }
    }
}
