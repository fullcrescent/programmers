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
    }

    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int[] road : roads){
            List<Integer> list;

            list = map.getOrDefault(road[0], new ArrayList<>());
            list.add(road[1]);
            map.put(road[0], list);

            list = map.getOrDefault(road[1], new ArrayList<>());
            list.add(road[0]);
            map.put(road[1], list);
        }

        return Arrays.stream(sources)
                .map(i -> search(i, n, destination, map))
                .toArray();
    }

    private static int search(int i, int n, int destination, Map<Integer, List<Integer>> map) {
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(i, 0));

        boolean[] visit = new boolean[n+1];

        while(!queue.isEmpty()){
            Info temp = queue.poll();

            if(temp.source==destination)    return temp.count;

            if(visit[temp.source])  continue;

            visit[temp.source] = true;

            List<Integer> tempList = map.getOrDefault(temp.source, new ArrayList<>());
            for(int value : tempList){
                queue.add(new Info(value, temp.count+1));
            }
        }

        return -1;
    }

    static class Info{
        int source;
        int count;

        public Info(int source, int count) {
            this.source = source;
            this.count = count;
        }
    }
}
