package programmers.etc;

public class 체육대회 {
    public static void main(String[] args) {
        int[][] ability = {{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}};
        int answer = solution(ability);
        System.out.println(answer);
    }

    public static int solution(int[][] ability) {
        function(0, 0, ability, new boolean[ability.length]);
        return max;
    }

    static int max = 0;

    public static void function(int sum, int step, int[][] ability, boolean[] visit){
        if(step==ability[0].length) {
            max = Math.max(max, sum);
            return;
        }

        for(int i=0; i<ability.length; i++){
            if(visit[i])    continue;

            visit[i] = true;
            function(sum+ability[i][step], step+1, ability, visit);
            visit[i] = false;
        }
    }
}
