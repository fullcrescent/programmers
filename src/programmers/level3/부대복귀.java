package programmers.level3;

import java.util.*;

public class 부대복귀 {
    public static void main(String[] args) {
        int n = 5;
        int[][] roads = {{1,2}, {1,4}, {2,4}, {2,5}, {4,5}};
        int[] sources = {1, 3, 5};
        int destination = 5;
        int[] answer = solution(n, roads, sources, destination);
        System.out.println(Arrays.toString(answer));

        int n1 = 5;
        int[][] roads1 = {{1,2}, {1,4}, {2,4}, {2,5}, {4,5}};
        int[] sources1 = {1, 3, 5};
        int destination1 = 5;
        int[] answer1 = solution1(n1, roads1, sources1, destination1);
        System.out.println(Arrays.toString(answer1));
    }

    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        Map<Integer, List<Integer>> roadMap = new HashMap<>();

        for(int[] road : roads){
            List<Integer> list;

            list = roadMap.getOrDefault(road[0], new ArrayList<>());
            list.add(road[1]);
            roadMap.put(road[0], list);

            list = roadMap.getOrDefault(road[1], new ArrayList<>());
            list.add(road[0]);
            roadMap.put(road[1], list);
        }

        Map<Integer, Integer> map = new HashMap<>();

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(destination, 0));

        boolean[] visit = new boolean[n+1];

        while(!queue.isEmpty()){
            Info temp = queue.poll();

            if(visit[temp.source])  continue;
            visit[temp.source] = true;

            map.put(temp.source, temp.count);

            List<Integer> tempList = roadMap.getOrDefault(temp.source, new ArrayList<>());
            for(int value : tempList){
                if(visit[value]) continue;

                queue.add(new Info(value, temp.count+1));
                map.put(value, temp.count+1);
            }
        }

        return Arrays
                .stream(sources)
                .map(i -> map.getOrDefault(i, -1))
                .toArray();
    }

    static class Info{
        int source;
        int count;

        public Info(int source, int count) {
            this.source = source;
            this.count = count;
        }
    }

    /*다른 사람의 풀이 참고*/
    public static int[] solution1(int n, int[][] roads, int[] sources, int destination) {
        int[] distance = new int[n+1];
        Map<Integer, Info> map = new HashMap<>();

        Arrays.fill(distance, Integer.MAX_VALUE);

        for(int[] road : roads){
            map.put(road[0], new Info(road[1], 1));
            map.put(road[1], new Info(road[0], 1));
        }

        return null;
    }
}
