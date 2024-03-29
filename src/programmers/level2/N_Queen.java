package programmers.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class N_Queen {
    public static void main(String[] args) throws CloneNotSupportedException {
        int n = 4;
        int answer = solution(n);
        System.out.println(answer);

        int n1 = 4;
        int answer1 = solution1(n1);
        System.out.println(answer1);
    }

    public static int solution(int n) throws CloneNotSupportedException {
        int answer = 0;

        f = i -> -1<i && i<n;
        boolean[] visit = new boolean[n];

        for(int i=0; i<n; i++){
            List<Info> list = new ArrayList<>();

            visit[i] = true;
            moveLine(i, f, list);
            answer += recursiveFunction(visit, list, 1, n);
            visit[i] = false;
        }

        return answer;
    }

    static Function<Integer, Boolean> f;

    private static int recursiveFunction(boolean[] visit, List<Info> list, int count, int end) throws CloneNotSupportedException {
        int answer = 0;

        if(count==end)    return 1;

        Loop :
        for(int i = 0; i<visit.length; i++){
            if(visit[i])    continue;

            for(Info info : list){
                if(info.value==i) continue Loop;
            }

            List<Info> tempList = new ArrayList<>();
            for(Info info : list){
                tempList.add(info.clone());
            }

            tempList.stream().filter(info -> f.apply(info.value)).forEach(Info::move);

            moveLine(i, f, tempList);
            visit[i] = true;
            answer += recursiveFunction(visit, tempList, count+1, end);
            visit[i] = false;
        }

        return answer;
    }


    private static void moveLine(int i, Function<Integer, Boolean> f, List<Info> list) {
        if(f.apply(i-1)) list.add(new Info(Direction.North, i-1));
        if(f.apply(i+1)) list.add(new Info(Direction.South, i+1));
    }

    static class Info implements Cloneable{
        Direction direction;
        int value;

        public Info(Direction direction, int value) {
            this.direction = direction;
            this.value = value;
        }

        public void move(){
            if (this.direction == Direction.North) {
                this.value--;
            } else {
                this.value++;
            }
        }

        @Override
        protected Info clone() throws CloneNotSupportedException {
            return (Info) super.clone();
        }
    }

    enum Direction{
        North, South
    }

    /*다른 사람의 풀이 참고*/
    public static int solution1(int n){
        return backTracking(0, new int[n], n);
    }

    private static int backTracking(int row, int[] cols, int n) {
        int sum = 0;

        if(row==n) return 1;

        for(int i=0; i<n; i++){
            cols[row] = i;
            if(validate(row, cols)){
                sum += backTracking(row+1, cols, n);
            }
        }

        return sum;
    }

    private static boolean validate(int row, int[] cols) {
        for(int i=0; i<row; i++){
            if(cols[i]==cols[row] || Math.abs(row-i)==Math.abs(cols[i]-cols[row])){
                return false;
            }
        }
        return true;
    }
}
