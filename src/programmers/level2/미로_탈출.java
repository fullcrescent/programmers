package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 미로_탈출 {
    public static void main(String[] args){
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        int answer = solution(maps);
        System.out.println(answer);

        String[] maps1 = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        int answer1 = solution1(maps1);
        System.out.println(answer1);
    }

    public static int solution(String[] maps) {
        int row = maps.length;
        int column = maps[0].length();

        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                if(maps[i].charAt(j)=='S'){
                    return find(maps, find(maps, new int[] {i, j, 0}, 'L'), 'E')[2];
                }
            }
        }

        return -1;
    }

    private static int[] find(String[] maps, int[] array, char find) {
        if(array[2]==-1) return new int[] {0, 0, -1};

        int row = maps.length;
        int column = maps[0].length();
        int max = 100*100;

        int[][] countArray = new int[row][column];
        for(int i=0; i<row; i++){
            Arrays.fill(countArray[i], max);
        }
        countArray[array[0]][array[1]] = array[2];

        int[][] distance = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {array[0], array[1]});

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int count = countArray[temp[0]][temp[1]];

            for(int[] d : distance){
                int dx = temp[0] + d[0];
                int dy = temp[1] + d[1];

                if(dx>-1 && dx<row
                        && dy>-1 && dy<column
                        && maps[dx].charAt(dy)!='X'
                        && countArray[dx][dy]>count+1){
                    countArray[dx][dy] = count+1;
                    queue.add(new int[] {dx, dy});

                    if(maps[dx].charAt(dy)==find){
                        return new int[] {dx, dy, count+1};
                    }
                }
            }
        }

        return new int[] {0, 0, -1};
    }

    /*다른 사람의 풀이 참고 - 변경X*/
    public static int solution1(String[] maps) {
        int row = maps.length;
        int column = maps[0].length();

        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                if(maps[i].charAt(j)=='S'){
                    return find1(maps, find1(maps, new int[] {i, j, 0}, 'L'), 'E')[2];
                }
            }
        }

        return -1;
    }

    private static int[] find1(String[] maps, int[] array, char find) {
        if(array[2]==-1) return new int[] {0, 0, -1};

        int row = maps.length;
        int column = maps[0].length();
        int max = 100*100;

        int[][] countArray = new int[row][column];
        for(int i=0; i<row; i++){
            Arrays.fill(countArray[i], max);
        }
        countArray[array[0]][array[1]] = array[2];

        int[][] distance = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {array[0], array[1]});

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int count = countArray[temp[0]][temp[1]];

            for(int[] d : distance){
                int dx = temp[0] + d[0];
                int dy = temp[1] + d[1];

                if(dx>-1 && dx<row
                        && dy>-1 && dy<column
                        && maps[dx].charAt(dy)!='X'
                        && countArray[dx][dy]>count+1){
                    countArray[dx][dy] = count+1;
                    queue.add(new int[] {dx, dy});

                    if(maps[dx].charAt(dy)==find){
                        return new int[] {dx, dy, count+1};
                    }
                }
            }
        }

        return new int[] {0, 0, -1};
    }
}
