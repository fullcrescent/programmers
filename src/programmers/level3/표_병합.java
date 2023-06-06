package programmers.level3;

import java.util.*;

public class 표_병합 {
    public static void main(String[] args) {
        String[] commands = {"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"};
        String[] answer = solution(commands);
        System.out.println(Arrays.toString(answer));
    }

    public static String[] solution(String[] commands) {
        List<String> answer = new LinkedList<>();
        List<Info> infoList = new ArrayList<>();
        Info[][] array = new Info[max][max];

        for(String command : commands){
            String[] temp = command.split(" ");

            String action = temp[0];

            if(!isNumber(temp[1])){
                infoList.stream().filter(i -> i.value.equals(temp[1])).forEach(i -> i.value=temp[2]);
                continue;
            }

            int x = Integer.parseInt(temp[1]);
            int y = Integer.parseInt(temp[2]);

            Info info;

            switch (action) {
                case "UPDATE":
                    info = new Info(temp[3]);
                    info.addPoint(new Point(x, y));
                    array[x][y] = info;

                    infoList.add(info);

                    break;
                case "MERGE":
                    int mergeX = Integer.parseInt(temp[3]);
                    int mergeY = Integer.parseInt(temp[4]);

                    if(array[mergeX][mergeY]!=null){
                        array[mergeX][mergeY].list.forEach(i -> array[i.x][i.y]=array[x][y]);
                    }else{
                        array[mergeX][mergeY] = array[x][y];
                    }
                    array[x][y].addPoint(new Point(mergeX, mergeY));

                    break;
                case "UNMERGE":
                    info = new Info(array[x][y].value);
                    info.addPoint(new Point(x, y));

                    infoList.remove(array[x][y]);
                    array[x][y].list.forEach(i -> array[i.x][i.y]=null);

                    array[x][y] = info;

                    break;
                case "PRINT":
                    answer.add(array[x][y] == null ? "EMPTY" : array[x][y].value);

                    break;
            }
        }

        return answer.toArray(String[]::new);
    }

    private static final int max = 51;
    private static boolean isNumber(String s) {
        return s!=null && s.matches("[0-9]+");
    }

    static class Info{
        private String value;

        private final List<Point> list;

        public Info(String value) {
            this.value = value;
            this.list = new ArrayList<>();
        }

        public void addPoint(Point point){
            list.add(point);
        }
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
