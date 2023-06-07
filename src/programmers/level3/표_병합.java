package programmers.level3;

import java.util.*;

public class 표_병합 {
    public static void main(String[] args) {
        String[] commands = {"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"};
        String[] answer = solution(commands);
        System.out.println(Arrays.toString(answer));
    }

    public static String[] solution(String[] commands) {
        List<String> answer = new LinkedList<>();
        Info[][] array = new Info[max][max];

        for(int x=0; x<array.length; x++){
            for(int y=0; y<array[x].length; y++){
                array[x][y] = new Info(null);
                array[x][y].addPoint(new Point(x, y));
            }
        }

        for(String command : commands){
            String[] temp = command.split(" ");

            String action = temp[0];

            if(action.equals("UPDATE")&&temp.length==3){
                Arrays.stream(array).forEach(i -> Arrays.stream(i).filter(j -> temp[1].equals(j.value)).forEach(j -> j.value=temp[2]));

                continue;
            }

            int x = Integer.parseInt(temp[1]);
            int y = Integer.parseInt(temp[2]);

            switch (action) {
                case "UPDATE":
                    array[x][y].value = temp[3];

                    break;
                case "MERGE":
                    int mergeX = Integer.parseInt(temp[3]);
                    int mergeY = Integer.parseInt(temp[4]);

                    if(array[mergeX][mergeY]!=array[x][y]){
                        array[mergeX][mergeY].list.forEach(i -> array[x][y].addPoint(new Point(i.x, i.y)));
                        array[mergeX][mergeY].list.forEach(i -> array[i.x][i.y]=array[x][y]);
                    }

                    break;
                case "UNMERGE":
                    String value = array[x][y].value;

                    array[x][y].list.forEach(i -> {
                        array[i.x][i.y]=new Info(null);
                        array[i.x][i.y].addPoint(new Point(i.x, i.y));
                    });

                    array[x][y].value = value;

                    break;
                case "PRINT":
                    answer.add(array[x][y].value == null ? "EMPTY" : array[x][y].value);

                    break;
            }
        }

        return answer.toArray(String[]::new);
    }

    private static final int max = 51;

    static class Info{
        String value;

        List<Point> list;

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
