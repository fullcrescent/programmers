package programmers.level3;

import java.util.*;

public class 길_찾기_게임 {
    public static void main(String[] args) {
        int[][] nodeInfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        int[][] answer = solution(nodeInfo);
        Arrays.stream(answer)
                .forEach(i -> System.out.println(Arrays.toString(i)));
    }

    public static int[][] solution(int[][] nodeInfo) {
        Map<Integer, List<Info>> map = new HashMap<>();

        for(int i=0; i<nodeInfo.length; i++){
            List<Info> temp = map.getOrDefault(nodeInfo[i][1], new ArrayList<>());

            temp.add(new Info(nodeInfo[i][0], i+1));
            map.put(nodeInfo[i][1], temp);
        }



        function(nodeInfo, 0, 0, 100001);

        return nodeInfo;
    }

    private static void function(int[][] nodeInfo, int i, int start, int end) {
    }

    static class Info{
        int x;
        int value;

        public Info(int x, int value) {
            this.x = x;
            this.value = value;
        }
    }
}
