package programmers.level2;

import java.util.*;

public class 무인도_여행 {
    public static void main(String[] args){
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        int[] answer = solution(maps);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        boolean[][] visit = new boolean[maps.length][maps[0].length()];

        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[i].length(); j++){
                if(visit[i][j]) continue;
                visit[i][j] = true;

                if(maps[i].charAt(j)!='X'){
                    list.add(bfs(maps, new Point(i, j), visit));
                }
            }
        }

        if(list.size()>0){
            list.sort(null);
            return list.stream().mapToInt(i -> i).toArray();
        }else{
            return new int[] {-1};
        }
    }

    private static int bfs(String[] maps, Point point, boolean[][] visit) {
        int sum = 0;

        Queue<Point> queue = new LinkedList<>();
        queue.add(point);

        int[][] d = {{0,1}, {1,0}, {0, -1}, {-1, 0}};

        while(!queue.isEmpty()){
            Point temp = queue.poll();

            Arrays.stream(d)
                    .map(i -> new Point(i[0]+temp.startX, i[1]+temp.startY))
                    .filter(i -> -1<i.startX && i.startX<maps.length && -1<i.startY && i.startY<maps[i.startX].length())
                    .filter(i -> !visit[i.startX][i.startY] && maps[i.startX].charAt(i.startY)!='X')
                    .forEach(i -> {
                        visit[i.startX][i.startY] = true;
                        queue.add(i);
                    });

            sum += Integer.parseInt(String.valueOf(maps[temp.startX].charAt(temp.startY)));
        }

        return sum;
    }

    static class Point{
        int startX;
        int startY;

        public Point(int startX, int startY) {
            this.startX = startX;
            this.startY = startY;
        }
    }
}