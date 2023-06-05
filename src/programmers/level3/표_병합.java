package programmers.level3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 표_병합 {
    public static void main(String[] args) {
        String[] commands = {"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"};
        String[] answer = solution(commands);
        System.out.println(Arrays.toString(answer));
    }

    public static String[] solution(String[] commands) {
        List<String> answer = new LinkedList<>();
        String[][] array = new String[max][max];

        for(String command : commands){
            String[] temp = command.split(" ");

            String action = temp[0];

            if(!isNumber(temp[1])){
                array = Arrays.stream(array).map(i -> Arrays.stream(i).map(j -> {
                    if(j==null) return null;
                    return j.replace(temp[1], temp[2]);
                }).toArray(String[]::new)).toArray(String[][]::new);
                continue;
            }

            int x = Integer.parseInt(temp[1]);
            int y = Integer.parseInt(temp[2]);

            switch (action) {
                case "UPDATE":
                    array[x][y] = temp[3];
                    break;
                case "MERGE":
                    int mergeX = Integer.parseInt(temp[3]);
                    int mergeY = Integer.parseInt(temp[4]);

                    mergeFunction(array, mergeX, mergeY, array[x][y], array[x][y]);
                    array[mergeX][mergeY] = array[x][y];
                    break;
                case "UNMERGE":
                    mergeFunction(array, x, y, array[x][y], null);
                    break;
                case "PRINT":
                    answer.add(array[x][y] == null ? "EMPTY" : array[x][y]);
                    break;
            }
        }

        return answer.toArray(String[]::new);
    }

    private static final int max = 51;
    private static final int[][] distance = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static boolean isNumber(String s) {
        return s!=null && s.matches("[0-9]+");
    }

    private static void mergeFunction(String[][] array, int x, int y, String s, String replace) {
        boolean[][] visit = new boolean[max][max];
        visit[x][y] = true;

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(x, y));

        while(!queue.isEmpty()){
            Info info = queue.poll();

            for(int[] d : distance){
                int moveX = info.x+d[0];
                int moveY = info.y+d[1];

                if(visit[moveX][moveY]) continue;
                visit[moveX][moveY] = true;

                if(s.equals(array[moveX][moveY])){
                    array[moveX][moveY] = replace;
                    queue.add(new Info(moveX, moveY));
                }
            }
        }

    }

    static class Info{
        int x;
        int y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
